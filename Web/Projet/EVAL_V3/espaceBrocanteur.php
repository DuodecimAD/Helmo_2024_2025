<?php
session_start();
if (!isset($_SESSION['loggedin']) || $_SESSION['role'] !== 'broc') {
    header("Location: login.php");
    exit;
}
?>

<!DOCTYPE html>
<html lang="fr">

<?php
$title = "Espace Brocanteur";
require_once("inc/head.inc.php");
?>

<body>
    <?php require_once("inc/header.inc.php"); ?>

    <main id="espaceBroc" class="max-width">
        <h1>Espace Brocanteur</h1>

        <div id="attributionMessage" class="boite">
            <p>Zone de message d'attribution d'un emplacement. ("n°xxx" si attribué sinon "en attente d'attribution")</p>
        </div>

        <h2>Données</h2>

        <div class="boite" style="width: 800px; height: 300px;">

        </div>

        <h2>Ajouter objet</h2>

        <div class="boite" style="width: 800px; height: 300px;">

        </div>
    </main>

    <?php require_once("inc/footer.inc.php"); ?>
</body>
</html>
