<?php

require_once 'etudiant.php';
require_once 'personnel.php';

use Helmo\DevWeb\Etudiant\Personne as Etudiant;
use Helmo\DevWeb\Personnel\Personne as Membre;

$tableau = [$jean, $marc, $antony];

echo '<h2>tableau non-trié</h2>';
foreach ($tableau as $personne) {
    echo $personne->getPersonne();
}

usort($tableau, function ($a, $b) {
    return strcmp($a->getPersonne(), $b->getPersonne());
});

echo '<h2>tableau trié</h2>';
foreach ($tableau as $personne) {
    echo $personne->getPersonne();
}
