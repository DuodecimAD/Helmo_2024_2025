<?php

redirectTo404();

function nettoyage_to_db($data)
{
    return htmlspecialchars(trim($data), ENT_QUOTES, 'UTF-8');
}

function nettoyage_from_db($data)
{
    return htmlspecialchars_decode(trim($data), ENT_QUOTES);
}

function insertLog($stmt, $params = null): void
{
    $dbLink = new database();
    $bdd = $dbLink->connect();

    if ($bdd) {
        if ($stmt instanceof \PDOStatement) {
            $query = $stmt->queryString;

            if (is_array($params)) {
                foreach ($params as $key => $value) {
                    $query = str_replace(":$key", nettoyage_to_db($value), $query);
                }
            } else {
                $query .= ' => ' . $params;
            }
        } else if (is_string($stmt) ) {
            $query = $stmt;
        }

        // adding logs to database about queries
        $logStmt = $bdd->prepare("INSERT INTO query_logs (query_text) VALUES (:query)");
        $logStmt->bindValue(':query', $query);
        $logStmt->execute();

    }

    $dbLink->disconnect($bdd);

    /*
    CREATE TABLE query_logs (
        id INT AUTO_INCREMENT PRIMARY KEY,
        query_text TEXT,
        executed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );
    */
}

function redirectTo404(): void
{
// lecture seule non possible, seulement à travers un require/include
    if (basename($_SERVER['PHP_SELF']) == basename(__FILE__)) {
        //die("Access denied");
        header("HTTP/1.1 404 Not Found");
        header("Location: /404.php"); // Redirects to a custom 404 page
        exit;
    }
}


/**
 * Affiche un message sous forme d'alerte
 * Gère aussi bien un message simple qu'un tableau d'erreurs sous forme de liste
 *
 * @param string|array $message Contenu du message à afficher (chaîne ou tableau d'erreurs)
 * @param string $type Type du message : 'success' ou 'danger' (par défaut)
 */
function afficherAlerte($message, $type = 'danger')
{
    if (!empty($message)) {
        echo '<div class="box-alert color-' . nettoyage_from_db($type) . '">';

        if (is_array($message)) {
            echo '<ul>';
            foreach ($message as $erreur) {
                echo '<li>' . nettoyage_from_db($erreur) . '</li>';
            }
            echo '</ul>';
        } else {
            echo nettoyage_from_db($message);
        }

        echo '</div>';
    }
}
