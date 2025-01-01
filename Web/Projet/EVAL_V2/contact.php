<?php
session_start();
?>

<!DOCTYPE html>
<html lang="fr">

<?php
$title = "Contact";
require_once("inc/head.inc.php");
?>

<body>
    <?php require_once("inc/header.inc.php"); ?>

    <main class="max-width">
        <h1>Contact</h1>
        <form action="#" method="post" id="contact_form" class="boite">

            <label for="sujet">Sujet *</label>
            <input type="text" name="sujet" id="sujet" required placeholder="Entrez le sujet de votre message">

            <label for="email">Email *</label>
            <input type="email" name="email" id="email" required placeholder="Entrez votre email">

            <label for="message">Message *</label>
            <textarea name="message" id="message" rows="17" cols="75" required placeholder="Entrez votre message"></textarea>

            <button type="submit" name="submit">Envoyer</button>
        </form>
    </main>

    <?php require_once("inc/footer.inc.php"); ?>

</body>
</html>