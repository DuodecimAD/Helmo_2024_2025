<?php
session_start();

if (isset($_SESSION['user']['loggedIn'])) {
    header("Location: 404.php");
    exit;
}
require_once $_SERVER['DOCUMENT_ROOT'] . '/php/utils.php';
require_once $_SERVER['DOCUMENT_ROOT'] . '/php/model.User.php';

$user = new User();
$emplacementsTaken = $user->emplacementsTaken();
const MAX_EMPLACEMENTS = 60;

if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST["submit"])) {

    $nom            = nettoyage_to_db($_POST['nom']) ?? '';
    $prenom         = nettoyage_to_db($_POST['prenom']) ?? '';
    $email          = filter_var(nettoyage_to_db($_POST['email']) ?? '', FILTER_VALIDATE_EMAIL);
    $password       = nettoyage_to_db($_POST['password']) ?? '';
    $passwordVerif  = nettoyage_to_db($_POST['passwordVerif']) ?? '';
    $description    = nettoyage_to_db($_POST['description']) ?? '';
    $visible        = isset($_POST['visible']) ? 1 : 0;


    if ($nom === '') {
        $errorMessage = "Le nom semble incorrect.";
    } else if ($prenom === '') {
        $errorMessage = "Le prénom semble incorrect.";
    } else if ($email === '') {
        $errorMessage = "Votre email n'est pas valide.";
    } else if ($password !== $passwordVerif) {
        $errorMessage = "Votre mot de passe est différent.";
    } else {

        if ($user->checkIfUserEmailExists($email)) {
            $errorMessage = "Cet email existe déjà";
        } else {

            if (isset($_FILES["avatar"]) && $_FILES["avatar"]["error"] === 0) {
                $date = date("dmYHis");
                $randomString = substr(str_shuffle("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"), 0, 5);

                $imageFileType = pathinfo($_FILES["avatar"]["name"], PATHINFO_EXTENSION);
                $newFileName = "{$prenom}_{$nom}_{$date}_{$randomString}.{$imageFileType}";
                $avatar  = "uploads/" . $newFileName;

                if (!getimagesize($_FILES["avatar"]["tmp_name"])) {
                    $errorMessage = "Format image incorrect.";
                } else if ($_FILES["avatar"]["size"] > 2000000 ) {
                    $errorMessage = "L'image est trop grande. 2MB max.";
                }

            } else {
                $avatar = 'uploads/default_avatar.jpg';
            }

            if(($errorMessage = $user->insertUser($nom, $prenom, $email, $password, $avatar, $description, $visible)) === ""){

                if($user->getUserByEmail($email)){
                    if($avatar !== 'uploads/default_avatar.jpg'){
                        if(!move_uploaded_file($_FILES["avatar"]["tmp_name"], $avatar)){
                            $errorMessage = "L'image n'a pas pu être uploadée. Essayez une autre.";
                        }
                    }

                    if(empty($errorMessage)){
                        $user->loadUserIntoSession($user);

                        header("Location: paiement.php?inscription");
                        exit;
                    }
                }
            }
        }
    }
}

