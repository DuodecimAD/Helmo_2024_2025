<?php
session_start();
?>

<!DOCTYPE html>
<html lang="fr">

<?php
$title = "Objets";
require_once("inc/head.inc.php");
?>

<body>
    <?php require_once("inc/header.inc.php"); ?>

    <main id="Objets" class="max-width">
        <h1>Objets</h1>

        <div id="Objets_search">
            <input type="search" name="search" placeholder="Chercher objet">

            <label>
                <input type="checkbox" name="objetCategorie" value="drole">
                Drôle
            </label>
            <label>
                <input type="checkbox" name="objetCategorie" value="legendaire">
                Légendaire
            </label>
            <label>
                <input type="checkbox" name="objetCategorie" value="mythique">
                Mythique
            </label>
            <label>
                <input type="checkbox" name="objetCategorie" value="normal">
                Normal
            </label>
            <label>
                <input type="checkbox" name="objetCategorie" value="rare">
                Rare
            </label>
            <label>
                <input type="checkbox" name="objetCategorie" value="vintage">
                Vintage
            </label>

            <button type="button" name="objets">Rechercher</button>

            <a href="objets.php">Réinitialiser</a>

        </div>

        <?php require_once ("inc/objetsList.inc.php"); ?>
    </main>

    <?php require_once("inc/footer.inc.php"); ?>

</body>
</html>