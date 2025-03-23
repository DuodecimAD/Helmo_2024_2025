<?php
session_start();
if (!isset($_SESSION['user']['loggedIn']) || $_SESSION['user']['est_administrateur'] !== true) {
    header("Location: login.php");
    exit;
}
?>

<!DOCTYPE html>
<html lang="fr">

<?php
    $title = "Espace Administrateur";
    require_once("inc/head.inc.php");
?>

<body>
    <?php require_once("inc/header.inc.php"); ?>

    <main id="espaceAdmin" class="max-width">
        <h1>Espace Administrateur</h1>

        <div id="espaceAdmin_menu" class="boite">
            <a href="">Status inscriptions</a>
            <a href="">Autre ?</a>
        </div>


        <section id="espaceAdmin_list" class="boite">
            <h2>Pas d'emplacement attribué</h2>
            <article>
                <div>
                    <img src="assets/images/brocanteur.jpg" alt="brocanteurA">
                </div>
                <div>
                    <h3>Brocanteur A</h3>
                    <p>Numéro d'identification : xxxxxxx</p>
                    <p>Emplacement : aucun</p>
                </div>
                <div>
                    <a href="">Accepter</a>
                    <a href="">Refuser</a>
                </div>
            </article>

            <article>
                <div>
                    <img src="assets/images/brocanteur.jpg" alt="brocanteurA">
                </div>
                <div>
                    <h3>Brocanteur A</h3>
                    <p>Numéro d'identification : xxxxxxx</p>
                    <p>Emplacement : aucun</p>
                </div>
                <div>
                    <a href="">Accepter</a>
                    <a href="">Refuser</a>
                </div>
            </article>

            <article>
                <div>
                    <img src="assets/images/brocanteur.jpg" alt="brocanteurA">
                </div>
                <div>
                    <h3>Brocanteur A</h3>
                    <p>Numéro d'identification : xxxxxxx</p>
                    <p>Emplacement : aucun</p>
                </div>
                <div>
                    <a href="">Accepter</a>
                    <a href="">Refuser</a>
                </div>
            </article>

            <article>
                <div>
                    <img src="assets/images/brocanteur.jpg" alt="brocanteurA">
                </div>
                <div>
                    <h3>Brocanteur A</h3>
                    <p>Numéro d'identification : xxxxxxx</p>
                    <p>Emplacement : aucun</p>
                </div>
                <div>
                    <a href="">Accepter</a>
                    <a href="">Refuser</a>
                </div>
            </article>

            <h2>Emplacement attribué</h2>

            <article>
                <div>
                    <img src="assets/images/brocanteur.jpg" alt="brocanteurA">
                </div>
                <div>
                    <h3>Brocanteur A</h3>
                    <p>Numéro d'identification : xxxxxxx</p>
                    <p>Emplacement : 0013 - Zone C</p>
                </div>
                <div>
                    <a href="">Accepter</a>
                    <a href="">Refuser</a>
                </div>
            </article>

            <article>
                <div>
                    <img src="assets/images/brocanteur.jpg" alt="brocanteurA">
                </div>
                <div>
                    <h3>Brocanteur A</h3>
                    <p>Numéro d'identification : xxxxxxx</p>
                    <p>Emplacement : 0013 - Zone C</p>
                </div>
                <div>
                    <a href="">Accepter</a>
                    <a href="">Refuser</a>
                </div>
            </article>

            <article>
                <div>
                    <img src="assets/images/brocanteur.jpg" alt="brocanteurA">
                </div>
                <div>
                    <h3>Brocanteur A</h3>
                    <p>Numéro d'identification : xxxxxxx</p>
                    <p>Emplacement : 0013 - Zone C</p>
                </div>
                <div>
                    <a href="">Accepter</a>
                    <a href="">Refuser</a>
                </div>
            </article>

            <article>
                <div>
                    <img src="assets/images/brocanteur.jpg" alt="brocanteurA">
                </div>
                <div>
                    <h3>Brocanteur A</h3>
                    <p>Numéro d'identification : xxxxxxx</p>
                    <p>Emplacement : 0013 - Zone C</p>
                </div>
                <div>
                    <a href="">Accepter</a>
                    <a href="">Refuser</a>
                </div>
            </article>

            <article>
                <div>
                    <img src="assets/images/brocanteur.jpg" alt="brocanteurA">
                </div>
                <div>
                    <h3>Brocanteur A</h3>
                    <p>Numéro d'identification : xxxxxxx</p>
                    <p>Emplacement : 0013 - Zone C</p>
                </div>
                <div>
                    <a href="">Accepter</a>
                    <a href="">Refuser</a>
                </div>
            </article>

        </section>

    </main>

    <?php require_once("inc/footer.inc.php"); ?>


</body>
</html>
