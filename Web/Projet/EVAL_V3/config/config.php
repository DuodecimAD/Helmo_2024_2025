<?php

// lecture seule non possible, seulement à travers un require/include
if (basename($_SERVER['PHP_SELF']) == basename(__FILE__)) {
    //die("Access denied");
    header("HTTP/1.1 404 Not Found");
    header("Location: /404.php"); // Redirects to a custom 404 page
    exit;
}

const MYHOST = '192.168.132.203'; //url serveur MySQL
const MYUSER = 'Q240183'; //votre nom d'utilisateur de base de donnée
const MYPASS = '9f2cd88c11ddf62b271992148c915a3f3b51ff46';     //votre mot de passe associé
const MYDB   = 'Q240183'; //le nom de votre base de donnée qui, à HELMo, est identique à votre matricule

?>