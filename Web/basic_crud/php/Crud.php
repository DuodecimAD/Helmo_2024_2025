<?php

namespace Blog\php;

use PDO;

require_once 'db.php';

class Crud
{
    public function insert($articleName,$authorName,$categoryName,$email,$description,$imageName,$link): String
    {
        try {
            $db = new db();
            $dbLink = $db->connect();
            $stmt = $dbLink->prepare("INSERT INTO Blog (articleName,authorName,categoryName,email,description,imageName,link) 
                                                values(:articleName,:authorName,:categoryName,:email,:description,:imageName,:link)");
            $stmt->bindValue(':articleName', $articleName);
            $stmt->bindValue(':authorName', $authorName);
            $stmt->bindValue(':categoryName', $categoryName);
            $stmt->bindValue(':email', $email);
            $stmt->bindValue(':description', $description);
            $stmt->bindValue(':imageName', $imageName);
            $stmt->bindValue(':link', $link);
            $stmt->execute();
        } catch (\Exception $e) {
            return $e->getMessage();
        }

        $db->disconnect($dbLink);
        return 'ok';
    }

    public function update($id,$articleName,$authorName,$categoryName,$email,$description,$imageName,$link): String
    {
        try {
            $db = new db();
            $dbLink = $db->connect();
            $stmt = $dbLink->prepare("UPDATE Blog 
                                            SET articleName     = :articleName,
                                                authorName      = :authorName,
                                                categoryName    = :categoryName,
                                                email           = :email,
                                                description     = :description,
                                                imageName       = :imageName,
                                                link            = :link
                                            WHERE id = :id;
                                           ");
            $stmt->bindValue(':id', $id);
            $stmt->bindValue(':articleName', $articleName);
            $stmt->bindValue(':authorName', $authorName);
            $stmt->bindValue(':categoryName', $categoryName);
            $stmt->bindValue(':email', $email);
            $stmt->bindValue(':description', $description);
            $stmt->bindValue(':imageName', $imageName);
            $stmt->bindValue(':link', $link);
            $stmt->execute();
        } catch (\Exception $e) {
            return $e->getMessage();
        }

        $db->disconnect($dbLink);
        return 'ok';
    }

    public function delete($id): String
    {
        try {
            $db = new db();
            $dbLink = $db->connect();
            $stmt = $dbLink->prepare("DELETE FROM Blog WHERE id = :id;");
            $stmt->bindValue(':id', $id);
            $stmt->execute();
        } catch (\Exception $e) {
            return $e->getMessage();
        }

        $db->disconnect($dbLink);
        return 'ok';
    }

    public function getAll(): array
    {
        try {
            $db = new db();
            $dbLink = $db->connect();
            $stmt = $dbLink->prepare("SELECT * FROM Blog ORDER BY id ASC");

            $stmt->execute();
            $result = $stmt->fetchAll(PDO::FETCH_ASSOC);
        } catch (\Exception $e) {
            $result = $e->getMessage();
        }

        if($result){
            return $result;
        }
        return [];
    }

    public function getById($id): array
    {
        try {
            $db = new db();
            $dbLink = $db->connect();
            $stmt = $dbLink->prepare("SELECT * FROM Blog WHERE id = :id");
            $stmt->bindValue(':id', $id);
            $stmt->execute();
            $result = $stmt->fetchAll(PDO::FETCH_ASSOC);
        } catch (\Exception $e) {
            $result = $e->getMessage();
        }

        if($result){
            return $result;
        }
        return [];
    }

}