<?php
session_start();
?>

<!DOCTYPE html>
<html lang="fr">

<?php
$title = "BrocanteurA";
require_once("inc/head.inc.php");
?>

<body>
    <?php require_once("inc/header.inc.php"); ?>

    <main id="Brocanteur" class="max-width">
        <section id="BrocanteurProfil" class="boite">
            <div>
                <img src="images/brocanteur.jpg" alt="brocanteurA">
            </div>

            <div>
                <h1>Brocanteur A</h1>
                <p>Emplacement : 0013 - Zone A</p>
                <p>Expérience : 12 ans</p>
                <p>Participations : 25</p>
                <p style="text-align: justify">"Brocanteur A considère la vente de distributeurs PEZ
                    comme un rêve devenu réalité. Toujours en quête de pièces
                    rares, il perçoit cette activité comme une véritable chasse
                    au trésor, lui permettant de rester dynamique tout en gagnant
                    sa vie."</p>
            </div>
        </section>

        <h2>Objets référencés par Brocanteur A</h2>

        <?php require_once ("inc/objetsList.inc.php"); ?>
    </main>

    <?php require_once("inc/footer.inc.php"); ?>

</body>
</html>