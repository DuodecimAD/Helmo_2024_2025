<?php

Class Ville{
    private $nom;
    private $departement;

    public function __construct($nom, $departement){
        $this->nom = $nom;
        $this->departement = $departement;
    }

    function afficher(){
        echo "<p>La ville de $this->nom est dans le département $this->departement</p>";
    }


}

$bruxelles = new Ville('Bruxelles', 'Bruxelles-Capitale');
$bruxelles->afficher();

$liege = new Ville('Liege', 'Liege');
$liege->afficher();

$mons = new Ville('Mons', 'Hainaut');
$mons->afficher();
