<?php

require_once $_SERVER['DOCUMENT_ROOT'] . '/php/model.DB.php';

class User
{
    private int $bid;
    private string $nom;
    private string $prenom;
    private string $courriel;
    private string $mot_passe;
    private ?string $photo;
    private string $description;
    private bool $visible;
    private bool $est_administrateur;
    private bool $a_paye;
    private ?int $eid;
    private ?PDO $dbLink;
    private ?string $code;
    private ?string $zone;

    public function __construct()
    {
        $db = new database();
        $this->dbLink = $db->connect();

        if (!$this->dbLink) {
            throw new Exception("Database connection failed.");
        }

    }

    public function getBid(): int
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

    public function aPaye(): bool
    {
        return $this->a_paye;
    }

    public function isVisible(): bool
    {
        return $this->visible;
    }

    public function isEstAdministrateur(): bool
    {
        return $this->est_administrateur;
    }

    public function isAPaye(): bool
    {
        return $this->a_paye;
    }

    public function getCode(): ?string
    {
        return $this->code;
    }

    public function getZone(): ?string
    {
        return $this->zone;
    }

    public function getUserByEmail(string $courriel): ?bool
    {
        try {
            $stmt = $this->dbLink->prepare("SELECT * FROM Brocanteur WHERE courriel = :courriel");
            $stmt->bindValue(':courriel', $courriel);
            $stmt->execute();
            $userData = $stmt->fetch(PDO::FETCH_ASSOC);
        } catch (\Exception $e) {
            insertLog($stmt, $e->getMessage());
        }

        if ($userData) {
            $this->mapDataToUser($userData);
            return true;
        }
        return false;
    }

    public function getUserById(string $bid): ?bool
    {
        try {
            $stmt = $this->dbLink->prepare("SELECT b.bid, b.nom, b.prenom, b.courriel, b.mot_passe, b.photo, 
                                                        b.description, b.visible, b.est_administrateur, b.eid, b.a_paye,
                                                        e.code as code, z.nom as zone
                                                    FROM Brocanteur b
                                                    JOIN Emplacement e ON b.eid = e.eid
                                                    JOIN Zone z ON e.zid = z.zid
                                                    WHERE bid = :bid");
            $stmt->bindValue(':bid', $bid);
            $stmt->execute();
            $userData = $stmt->fetch(PDO::FETCH_ASSOC);
        } catch (\Exception $e) {
            insertLog($stmt, $e->getMessage());
        }

        if ($userData) {
            $this->mapDataToUser($userData);
            return true;
        }
        return null;
    }

    private function mapDataToUser(array $data): void
    {
        $this->bid              = $data['bid'];
        $this->nom              = $data['nom'];
        $this->prenom           = $data['prenom'];
        $this->courriel         = $data['courriel'];
        $this->mot_passe        = $data['mot_passe'];
        $this->photo            = $data['photo'] ?? null;
        $this->description      = $data['description'];
        $this->visible          = (bool) $data['visible'];
        $this->est_administrateur = (bool) $data['est_administrateur'];
        $this->eid              = $data['eid'] ?? null;
        $this->a_paye           = (bool) $data['a_paye'];
        $this->code             = $data['code'] ?? null;
        $this->zone             = $data['zone'] ?? null;
    }

    public function checkIfUserEmailExists(string $courriel): bool
    {
        try {
            $stmt = $this->dbLink->prepare("SELECT EXISTS(SELECT 1 FROM Brocanteur WHERE courriel = :courriel)");
            $stmt->bindValue(':courriel', $courriel);
            $stmt->execute();
            return (bool) $stmt->fetchColumn();
        } catch (\Exception $e) {
            insertLog($stmt, $e->getMessage());
        }
        return false;
    }

    public function insertUser(string $nom, string $prenom, string $courriel, string $mot_passe, string $photo, string $description, int $visible): string
    {
        $error = "";
        try {
            $stmt = $this->dbLink->prepare("INSERT INTO Brocanteur (nom, prenom, courriel, mot_passe, photo, description, visible ) VALUES (:nom, :prenom, :courriel, :mot_passe, :photo, :description, :visible)");
            $stmt->bindValue(':nom', $nom);
            $stmt->bindValue(':prenom', $prenom);
            $stmt->bindValue(':courriel', $courriel);
            $stmt->bindValue(':mot_passe', $mot_passe);
            $stmt->bindValue(':photo', $photo);
            $stmt->bindValue(':description', $description);
            $stmt->bindValue(':visible', $visible);

            $stmt->execute();

            $params = ['nom' => $nom, 'prenom' => $prenom, 'courriel' => $courriel, 'mot_passe' => $mot_passe,'photo' => $photo, 'description' => $description, 'visible' => $visible ];
            insertLog($stmt, $params);
        } catch (\Exception $e) {
            $error = "L'insert dans la db ne s'est pas fait.";
            insertLog($stmt, $e->getMessage());
        }
        return $error;
    }

    public function getAllUsers(): array
    {
        try {
            $stmt = $this->dbLink->prepare("SELECT * FROM Brocanteur ORDER BY nom ASC");

            $stmt->execute();
            $usersData = $stmt->fetchAll(PDO::FETCH_ASSOC);
        } catch (\Exception $e) {
            insertLog($stmt, $e->getMessage());
        }

        if ($usersData) {
            return $usersData;
        }
        return [];
    }

    public function updateUserEmplacement(int $bid, string $code): string
    {
        try {
            $stmt = $this->dbLink->prepare("UPDATE Brocanteur SET eid = (SELECT eid FROM Emplacement WHERE code = :code) WHERE bid = :bid");
            $stmt->bindValue(':bid', $bid);
            $stmt->bindValue(':code', $code);
            $stmt->execute();

            $params = ['bid' => $bid, 'code' => $code];
            insertLog($stmt, $params);
            return "success";

        } catch (\Exception $e) {
            insertLog($stmt, $e->getMessage());
        }
        return $code;
    }

    public function isDonePaying(int $bid): string
    {
        try {
            $stmt = $this->dbLink->prepare("UPDATE Brocanteur SET a_paye = 1 WHERE bid = :bid");
            $stmt->bindValue(':bid', $bid);
            $stmt->execute();

            $params = ['bid' => $bid];
            insertLog($stmt, $params);
            return "success";

        } catch (\Exception $e) {
            insertLog($stmt, $e->getMessage());
        }
        return "";
    }

    public function isNowVisible(int $bid): string
    {
        try {
            $stmt = $this->dbLink->prepare("UPDATE Brocanteur SET visible = 1 WHERE bid = :bid");
            $stmt->bindValue(':bid', $bid);
            $stmt->execute();

            $params = ['bid' => $bid];
            insertLog($stmt, $params);
            return "success";

        } catch (\Exception $e) {
            insertLog($stmt, $e->getMessage());
        }
        return "";
    }

    public function deleteUser(int $bid): string
    {
        try {
            $stmt = $this->dbLink->prepare("DELETE FROM Brocanteur WHERE bid = :bid");
            $stmt->bindValue(':bid', $bid);
            $stmt->execute();

            $params = ['bid' => $bid];
            insertLog($stmt, $params);
            return "success";
        } catch (\Exception $e) {
            insertLog($stmt, $e->getMessage());
        }
        return 'fail => $bid : ' . $bid;
    }

    public function getAllUsersNotNullWithZones(): array
    {
        try {
            $stmt = $this->dbLink->prepare("SELECT bid, nom, prenom, photo, description, visible,
                                                        (SELECT code FROM Emplacement WHERE b.eid = eid) as code,
                                                        (SELECT nom FROM Zone WHERE zid = (SELECT zid FROM Emplacement WHERE b.eid = eid)) as zone,
                                                        (SELECT description FROM Zone WHERE zid = (SELECT zid FROM Emplacement WHERE b.eid = eid)) as zoneDescription
                                                   FROM Brocanteur b
                                                   WHERE eid IS NOT NULL
                                                   ORDER BY nom ASC");
            $stmt->execute();
            $datas = $stmt->fetchAll(PDO::FETCH_ASSOC);

        } catch (\Exception $e) {
            insertLog($stmt, $e->getMessage());
        }

        if ($datas) {
            foreach ($datas as $value) {
                $values[] = $value;
            }
            return $values;
        }
        return [];
    }

    function loadUserIntoSession(User $user): void
    {
        $_SESSION['user'] = [
            'loggedIn' => true,
            'bid' => $user->getBid(),
            'nom' => $user->getNom(),
            'prenom' => $user->getPrenom(),
            'courriel' => $user->getCourriel(),
            'photo' => $user->getPhoto(),
            'description' => $user->getDescription(),
            'est_visible' => $user->estVisible(),
            'emplacement' => $user->getEid(),
            'est_administrateur' => $user->estAdministrateur(),
            'a_paye' => $user->aPaye()
        ];
    }

    public function emplacementsTaken()
    {
        try {
            $stmt = $this->dbLink->prepare("SELECT count(eid) as totalused FROM Brocanteur");
            $stmt->execute();
            $emplacementsUsed = $stmt->fetch(PDO::FETCH_ASSOC);
        } catch (\Exception $e) {
            insertLog($stmt, $e->getMessage());
        }
        if($emplacementsUsed){
            return $emplacementsUsed['totalused'];
        }
        return -1;
    }

}