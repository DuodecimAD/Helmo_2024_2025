<?php
session_start();

require_once $_SERVER['DOCUMENT_ROOT'] . '/php/utils.php';
require_once $_SERVER['DOCUMENT_ROOT'] . '/php/model.Emplacement.php';
require_once $_SERVER['DOCUMENT_ROOT'] . '/php/model.User.php';
require_once $_SERVER['DOCUMENT_ROOT'] . '/php/model.Objet.php';

$objet = new Objet();
$objets = $objet->getAllObjetsFromVisibleBrocanteurs();
$categories = $objet->getCategories();

$noObjetBool = false;

$oCats = $_GET['oCats'] ?? [];
