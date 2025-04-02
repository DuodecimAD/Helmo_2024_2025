<?php
session_start();

require_once $_SERVER['DOCUMENT_ROOT'] . '/php/utils.php';
require_once $_SERVER['DOCUMENT_ROOT'] . '/php/model.Emplacement.php';
require_once $_SERVER['DOCUMENT_ROOT'] . '/php/model.User.php';

$usersObject = new User();
$emplacementObject = new Emplacement();

$zones = $emplacementObject->getZones();
$brocanteurs = $usersObject->getAllUsersNotNullWithZones();
