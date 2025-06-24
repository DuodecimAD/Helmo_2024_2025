<?php

namespace Blog\php;

require_once 'config.php';

use PDO;
use PDOException;

class db
{
    /**
     * Se connecte à la db.
     *
     * @return PDO|null retourne un objet PDO si succès, sinon retourne null.
     */
    public function connect(): ?PDO
    {
        try {
            $pdo = new PDO('mysql:host='.MYHOST.';dbname='.MYDB.';charset=utf8', MYUSER, MYPASS);
            $pdo->setAttribute(PDO::ATTR_CASE, PDO::CASE_LOWER);
            $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        } catch (PDOException $e) {
            $pdo = false;
        }
        return $pdo;
    }

    /**
     * Déconnexion de la base de données.
     *
     * ?PDO permet d'accepter null pour éviter un message d'erreur inutile.
     *
     */
    public function disconnect(?PDO &$pdo): void
    {
        $pdo = null;
    }
}