<?php

require_once $_SERVER['DOCUMENT_ROOT'] . '/config/database.php';
use DB\DBLink;

class User
{
    private ?int $bid;
    private string $nom;
    private string $prenom;
    private string $courriel;
    private string $mot_passe;
    private ?string $photo;
    private string $description;
    private bool $visible;
    private bool $est_administrateur;
    private ?int $eid;
    private ?PDO $dbLink;

    public function __construct()
    {
        $db = new DBLink();
        $this->dbLink = $db->connect();

        if (!$this->dbLink) {
            throw new Exception("Database connection failed.");
        }
    }

    public function findUser(string $courriel, &$message): ?User
    {
        try {
            $stmt = $this->dbLink->prepare("SELECT * FROM Brocanteur WHERE courriel = :courriel");
            $stmt->bindValue(':courriel', $courriel);
            if ($stmt->execute()) {
                // fetchObject ne fonctionne pas avec champs privés
                //$user = $stmt->fetchObject('User');
                $userData = $stmt->fetch(PDO::FETCH_ASSOC);
            } else {
                $message .= 'Une erreur système est survenue.<br> 
                    Veuillez essayer à nouveau plus tard ou contactez l\'administrateur du site. 
                    (Code erreur: ' . $stmt->errorCode() . ')<br>';
            }
        } catch (\Exception $e) {
            $message .= $e->getMessage() . '<br>';
        }


        if ($userData) {
            return $this->mapDataToUser($userData);
        }
        return null;
    }

    private function mapDataToUser(array $data): User
    {
        $this->bid = $data['bid'];
        $this->nom = $data['nom'];
        $this->prenom = $data['prenom'];
        $this->courriel = $data['courriel'];
        $this->mot_passe = $data['mot_passe'];
        $this->photo = $data['photo'] ?? null;
        $this->description = $data['description'];
        $this->visible = (bool) $data['visible'];
        $this->est_administrateur = (bool) $data['est_administrateur'];
        $this->eid = $data['eid'] ?? null;

        return $this;
    }

    public function getBid(): ?int
    {
        return $this->bid;
    }

    public function getNom(): string
    {
        return $this->nom;
    }

    public function getPrenom(): string
    {
        return $this->prenom;
    }

    public function getCourriel(): string
    {
        return $this->courriel;
    }

    public function getMotPasse(): string
    {
        return $this->mot_passe;
    }

    public function getPhoto(): ?string
    {
        return $this->photo;
    }

    public function getDescription(): string
    {
        return $this->description;
    }

    public function estVisible(): bool
    {
        return $this->visible;
    }

    public function estAdministrateur(): bool
    {
        return $this->est_administrateur;
    }

    public function getEid(): ?int
    {
        return $this->eid;
    }

    public function getDbLink(): ?PDO
    {
        return $this->dbLink;
    }






}