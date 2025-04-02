<?php
session_start();

require_once $_SERVER['DOCUMENT_ROOT'] . '/php/utils.php';
require_once $_SERVER['DOCUMENT_ROOT'] . '/php/model.Objet.php';

$objet = new Objet();
$rndObjets = $objet->get3RandomObjets();