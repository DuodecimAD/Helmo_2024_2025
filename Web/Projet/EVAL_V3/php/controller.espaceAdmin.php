<?php
session_start();
if (!isset($_SESSION['user']['loggedIn']) || $_SESSION['user']['est_administrateur'] !== true) {
    header("Location: login.php");
    exit;
}

require_once $_SERVER['DOCUMENT_ROOT'] . '/php/utils.php';
require_once $_SERVER['DOCUMENT_ROOT'] . '/php/model.Emplacement.php';
require_once $_SERVER['DOCUMENT_ROOT'] . '/php/model.User.php';


$usersObject = new User();
$emplacementObject = new Emplacement();

/* Fonctionne mais fonction désactivée au cas où un petit malin viendrait tout effacer
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST["submit_delete"])) {

    $bid = filter_var(nettoyage_to_db($_POST['userId']), FILTER_VALIDATE_INT) ?? null;
    $result = $usersObject->deleteUser($bid);
    echo $result;
}
*/

if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST["submit"])) {
    $code = nettoyage_to_db($_POST['emplacements']) ?? null;
    $bid = filter_var(nettoyage_to_db($_POST['userId']), FILTER_VALIDATE_INT) ?? null;
    $usersObject->updateUserEmplacement($bid, $code);
}

$users = $usersObject->getAllUsers();
$emplacements = $emplacementObject->getAllEmplacementsNotNull();
