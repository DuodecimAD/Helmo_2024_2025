<?php
session_start();
if (!isset($_SESSION['user']['loggedIn'])) {
    header("Location: login.php");
    exit;
}

require_once $_SERVER['DOCUMENT_ROOT'] . '/php/utils.php';
require_once $_SERVER['DOCUMENT_ROOT'] . '/php/model.Emplacement.php';
require_once $_SERVER['DOCUMENT_ROOT'] . '/php/model.User.php';
require_once $_SERVER['DOCUMENT_ROOT'] . '/php/model.Objet.php';
$user = new User();
$emplacement = new Emplacement();
$objet = new Objet();

if ($_SERVER['REQUEST_METHOD'] === 'POST' && (isset($_POST["visibilite"]))) {
    $user->isNowVisible($_SESSION['user']['bid']);
    $_SESSION['user']['est_visible'] = true;
}

if($_SERVER['REQUEST_METHOD'] === 'GET' && isset($_GET['modif']) && isset($_GET['oid'])){
    $objetID = nettoyage_to_db($_GET['oid']);
    $objetData = $objet->getObjet($objetID);

    $intitule       = nettoyage_from_db($objet->getIntitule() ?? '');
    $description    = nettoyage_from_db($objet->getDescription() ?? '');
    $cid            = nettoyage_from_db($objet->getCid() ?? '');
    $bid            = $_SESSION['user']['bid'];
    $oid            = nettoyage_from_db($objet->getOid() ?? '');
    $image          = nettoyage_from_db($objet->getImage() ?? '');
}

if ($_SERVER['REQUEST_METHOD'] === 'POST' && (isset($_POST["ajouter"]) || isset($_POST["modifier"]))) {

    $intitule       = nettoyage_to_db($_POST['intitule'] ?? '') ;
    $description    = nettoyage_to_db($_POST['description'] ?? '') ;
    $cid            = nettoyage_to_db($_POST['categorie'] ?? '');
    $bid            = $_SESSION['user']['bid'];

    if(isset($_POST['oid'])){
        $oid = nettoyage_to_db($_POST['oid']) ?? '';
    }

    if ($intitule === '') {
        $errorMessage = "Le titre semble incorrect.";
    } else if ($description === '') {
        $errorMessage = "La description semble incorrect.";
    } else if ($cid === '') {
        $errorMessage = "La catégorie n'est pas valide.";
    } else if ($_FILES["image"]['name'] !== "") {
        if($_FILES["image"]["error"] !== UPLOAD_ERR_OK){
            $errorMessage = 'Erreur image upload : ' . $_FILES["image"]["error"];
        } else if (!getimagesize($_FILES["image"]["tmp_name"])) {
            $errorMessage = "Format image incorrect.";
        } else if ($_FILES["image"]["size"] > 2000000 ) {
            $errorMessage = "L'image est trop grande. 2MB max.";
        }
    }

    if(!isset($errorMessage)){
        if($_FILES["image"]['name'] !== ""){
            $date = date("dmYHis");
            $randomString = substr(str_shuffle("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"), 0, 10);

            $imageFileType = pathinfo($_FILES["image"]["name"], PATHINFO_EXTENSION);
            $newFileName = "{$randomString}_{$date}.{$imageFileType}";
            $image  = "uploads/" . $newFileName;

            if (isset($_POST["ajouter"])){
                $errorMessage = $objet->insertObjet($intitule, $image, $description, $cid, $bid);
            } else if(isset($_POST["modifier"])){
                $errorMessage = $objet->updateObjetWithImage($oid, $intitule, $image, $description, $cid);
            }
            move_uploaded_file($_FILES["image"]["tmp_name"], $image);
        } else {
            if(isset($_POST["ajouter"])){
                $image  = "uploads/default_image.jpg";
                $errorMessage = $objet->insertObjet($intitule, $image, $description, $cid, $bid);
            } else if(isset($_POST["modifier"])){
                $errorMessage = $objet->updateObjetWithoutImage($oid, $intitule, $description, $cid);
            }
        }

        if($errorMessage === ""){
            header("Location: espaceBrocanteur.php");
            exit;
        }
    }
}

$objetsFromUser = $objet->getAllObjetsFromUser($_SESSION['user']['bid']);
$categories = $objet->getCategories();