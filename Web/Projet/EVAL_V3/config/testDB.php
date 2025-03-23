<?php
require_once 'database.php';
use DB\DBLink;

$message = "";

$dbLink = new DBLink();
$bdd = $dbLink->connect(MYDB);

if ($bdd) {
    $message .= "Connexion à la base de données réussie!<br>";
} else {
    $message .= "Impossible d'établir la connexion à la base de données!<br>";
}
$dbLink->disconnect($bdd);

echo "<p>$message</p>";


