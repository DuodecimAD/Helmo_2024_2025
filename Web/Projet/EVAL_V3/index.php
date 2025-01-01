<?php
session_start();
?>

<!DOCTYPE html>
<html lang="fr">

<?php
$title = "Accueil";
require_once("inc/head.inc.php");
?>

<body>

    <?php require_once("inc/header.inc.php"); ?>
    <main id="Home_main">
        <div id="Home_img">
            <img src="images/62ed5a2fc5f4b.jpeg" alt="Grande image de distributeurs PEZ">
        </div>

        <section id="Home_who">
            <div class="max-width">
                <h1>Qui sommes-nous</h1>
                <p>Notre foire aux puces est consacrée à la vente et à la revente de distributeurs PEZ,
                    très prisés par les collectionneurs en tout genre à la recherche de pièces manquantes dans
                    leur collection.</p>
            </div>
        </section>

        <!--
        J'utilise seulement javascript:void(0); afin d'éviter de remonter la page non-stop.
        -->
        <section id="Home_ex" class="max-width">

                <h2>Exemples de distributeurs PEZ vendus par nos brocanteurs</h2>
                <article class="boite">
                    <img src="images/D-09636-0001.jpg" alt="Lampo" height="150">
                    <h3>Lampo</h3>
                    <p>En vente chez Brocanteur A</p>
                    <a href="objet.php">Voir</a>
                </article>

                <article class="boite">
                    <img src="images/D-09816-0001.jpg" alt="Grumpy Bear" height="150">
                    <h3>Grumpy Bear</h3>
                    <p>En vente chez Brocanteur B</p>
                    <a href="objet.php">Voir</a>
                </article>

                <article class="boite">
                    <img src="images/D-06911-0001.jpg" alt="Red Bird" height="150">
                    <h3>Red Bird</h3>
                    <p>En vente chez Brocanteur C</p>
                    <a href="objet.php">Voir</a>
                </article>

        </section>
    </main>

    <?php require_once("inc/footer.inc.php"); ?>

</body>
</html>