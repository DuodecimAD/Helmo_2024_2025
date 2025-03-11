<?php

namespace Helmo\DevWeb\Personnel;



Class Personne{

    const CAT = ['Maitre-Assistant', 'MFP', 'Administratif', 'Direction'];
    private $nom;
    private $prenom;
    private $matricule;
    private $email;
    private $categorie;

    public function __construct($nom, $prenom, $matricule, $email, $categorie){
        $this->nom = $nom;
        $this->prenom = $prenom;
        $this->matricule = $matricule;
        $this->email = $email;
        $this->categorie = self::CAT[$categorie];
    }

    public function getPersonne(){
        return '<p>' . $this->nom . ' ' . $this->prenom . '</p>
                <p>Matricule : ' . $this->matricule . '</p>
                <p>Email : ' . $this->email . '</p>
                <p>Categorie : ' . $this->categorie . '</p><br>';
    }

    public function setCategorie($categorie){
        $this->categorie = self::CAT[$categorie];
    }
}

$jean = new Personne('Val Jean', 'Jean', 'W230400', 'jvj@gmail.com', 1);
//echo $jean->getPersonne();
//$jean->setCategorie(0);
//echo $jean->getPersonne();
