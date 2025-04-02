<?php
session_start();

require_once $_SERVER['DOCUMENT_ROOT'] . '/php/utils.php';
require_once $_SERVER['DOCUMENT_ROOT'] . '/php/model.Emplacement.php';
require_once $_SERVER['DOCUMENT_ROOT'] . '/php/model.User.php';
require_once $_SERVER['DOCUMENT_ROOT'] . '/php/model.Objet.php';

if($_SERVER['REQUEST_METHOD'] === 'GET' && isset($_GET['oid'])){

    $oid = nettoyage_to_db($_GET['oid']);

    $objet = new Objet();
    $objet->getObjet($oid);

    $intitule    = nettoyage_from_db($objet->getIntitule());
    $image       = nettoyage_from_db($objet->getImage());
    $description = nettoyage_from_db($objet->getDescription());
    $cid         = nettoyage_from_db($objet->getCid());
    $bid         = nettoyage_from_db($objet->getBid());
    $codeEmplacement = nettoyage_from_db($objet->getCode());
    $zone        = nettoyage_from_db($objet->getZone());
    $categorie   = nettoyage_from_db($objet->getCategorie());
    $bprenom     = nettoyage_from_db($objet->getBprenom());
    $bnom        = nettoyage_from_db($objet->getBnom());
    $userFullName = $bprenom . ' ' . $bnom ;

}