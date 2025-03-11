<?php

namespace Helmo\DevWeb\Etudiant;
const STATUT = ['B1', 'PE', 'AD'];

Class Personne{
    private $nom;
    private $prenom;
    private $matricule;
    private $statut;

    public function __construct($nom, $prenom, $matricule, $statut){
        $this->nom = $nom;
        $this->prenom = $prenom;
        $this->matricule = $matricule;
        $this->statut = $statut;
    }

    public function getPersonne(){
        return '<p>' . $this->nom . ' ' . $this->prenom . '</p>
                <p>Matricule : ' . $this->matricule . '</p>
                <p>Status : ' . $this->statut . '</p><br>';
    }

    public function setStatut($statut){
        $this->statut = $statut;
    }
}

$antony = new Personne('Doe', 'John', 'W250123', STATUT[1]);
//echo $antony->getPersonne();
//$antony->setStatut(STATUT[0]);
//echo $antony->getPersonne();

$marc = new Personne('Hammil', 'Marc', 'W230400', STATUT[2]);
//echo $marc->getPersonne();