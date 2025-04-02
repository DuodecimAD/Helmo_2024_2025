<?php
session_start();
require_once $_SERVER['DOCUMENT_ROOT'] . '/php/utils.php';
require_once $_SERVER['DOCUMENT_ROOT'] . '/php/model.User.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $email = filter_var(nettoyage_to_db($_POST['email']) ?? '', FILTER_VALIDATE_EMAIL);
    $password = nettoyage_to_db($_POST['password']) ?? '';

    $user = new User();


    if (!$email) {
        $errorMessage = "Votre email n'est pas valide.";
    } else if (!$user->getUserByEmail($email)) {
        $errorMessage = "Votre email n'existe pas.";
    } else if ($user->getMotPasse() !== $password) {
        $email = nettoyage_to_db($_POST['email']);
        $errorMessage = "Votre mot de passe est incorrect.";
    } else {

        $user->loadUserIntoSession($user);
        unset($errorMessage);
        header("Location: " . ($_SESSION['user']['est_administrateur'] ? "espaceAdmin.php" : "espaceBrocanteur.php"));
        exit;
    }

}