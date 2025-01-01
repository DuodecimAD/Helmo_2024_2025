<?php
session_start();
?>

<!DOCTYPE html>
<html lang="fr">

<?php
$title = "Réinitialiser mot de passe";
require_once("inc/head.inc.php");
?>

<body>
<?php require_once("inc/header.inc.php"); ?>

<main class="max-width">
    <h1>Réinitialiser mot de passe</h1>
    <form action="#" method="post" id="reinitialisationmdp_form" class="boite">

        <section>
            <label for="email">Email *</label>
            <input type="email" name="email" id="email" required placeholder="Entrez votre email">
        </section>

        <section>
            <a href="index.php" class="annuler">Annuler</a>
            <button type="submit" name="submit">Réinitialiser</button>
        </section>

    </form>
</main>

<?php require_once("inc/footer.inc.php"); ?>

</body>
</html>