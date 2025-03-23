<?php
session_start();
?>

<!DOCTYPE html>
<html lang="fr">

<?php
$title = "Brocanteurs";
require_once("inc/head.inc.php");
?>

<body>
    <?php require_once("inc/header.inc.php"); ?>

    <main id="Brocanteurs" class="max-width">

        <h1>Brocanteurs</h1>
        <div id="Brocanteurs_search">
            <input type="search" name="search" placeholder="Chercher brocanteur">

            <select	name="zone" title="zone">
                <option value="" disabled selected hidden>Zone</option>
                <option value="A">Zone A</option>
                <option value="B">Zone B</option>
                <option value="C">Numéro 0013 - Zone A</option>
            </select>

            <button type="button" name="brocanteur">Rechercher</button>
            <button type="button" name="reset">Réinitialiser</button>
        </div>

        <section id="Brocanteurs_list" class="boite">
            <h2>Zone A</h2>
            <article>
                <div>
                    <img src="assets/images/brocanteur.jpg" alt="brocanteurA">
                </div>
                <div>
                    <h3>Brocanteur A</h3>
                    <p>Numéro 0013 - Zone A</p>
                    <p>XX objets en ventes</p>
                </div>
                <div>
                    <a href="brocanteur.php">Voir</a>
                </div>
            </article>

            <article>
                <div>
                    <img src="assets/images/brocanteur.jpg" alt="brocanteurA">
                </div>
                <div>
                    <h3>Brocanteur B</h3>
                    <p>Numéro 0018 - Zone A</p>
                    <p>XX objets en ventes</p>
                </div>
                <div>
                    <a href="brocanteur.php">Voir</a>
                </div>
            </article>

            <article>
                <div>
                    <img src="assets/images/brocanteur.jpg" alt="brocanteurA">
                </div>
                <div>
                    <h3>Brocanteur C</h3>
                    <p>Numéro 0025 - Zone A</p>
                    <p>XX objets en ventes</p>
                </div>
                <div>
                    <a href="brocanteur.php">Voir</a>
                </div>
            </article>

            <h2>Zone B</h2>

            <article>
                <div>
                    <img src="assets/images/brocanteur.jpg" alt="brocanteurA">
                </div>
                <div>
                    <h3>Brocanteur W</h3>
                    <p>Numéro 0003 - Zone B</p>
                    <p>XX objets en ventes</p>
                </div>
                <div>
                    <a href="brocanteur.php">Voir</a>
                </div>
            </article>

            <article>
                <div>
                    <img src="assets/images/brocanteur.jpg" alt="brocanteurA">
                </div>
                <div>
                    <h3>Brocanteur M</h3>
                    <p>Numéro 0010 - Zone B</p>
                    <p>XX objets en ventes</p>
                </div>
                <div>
                    <a href="brocanteur.php">Voir</a>
                </div>
            </article>

            <article>
                <div>
                    <img src="assets/images/brocanteur.jpg" alt="brocanteurA">
                </div>
                <div>
                    <h3>Brocanteur A</h3>
                    <p>Numéro 0013 - Zone A</p>
                    <p>XX objets en ventes</p>
                </div>
                <div>
                    <a href="brocanteur.php">Voir</a>
                </div>
            </article>

            <article>
                <div>
                    <img src="assets/images/brocanteur.jpg" alt="brocanteurA">
                </div>
                <div>
                    <h3>Brocanteur A</h3>
                    <p>Numéro 0013 - Zone A</p>
                    <p>XX objets en ventes</p>
                </div>
                <div>
                    <a href="brocanteur.php">Voir</a>
                </div>
            </article>

            <article>
                <div>
                    <img src="assets/images/brocanteur.jpg" alt="brocanteurA">
                </div>
                <div>
                    <h3>Brocanteur A</h3>
                    <p>Numéro 0013 - Zone A</p>
                    <p>XX objets en ventes</p>
                </div>
                <div>
                    <a href="brocanteur.php">Voir</a>
                </div>
            </article>

            <article>
                <div>
                    <img src="assets/images/brocanteur.jpg" alt="brocanteurA">
                </div>
                <div>
                    <h3>Brocanteur A</h3>
                    <p>Numéro 0013 - Zone A</p>
                    <p>XX objets en ventes</p>
                </div>
                <div>
                    <a href="brocanteur.php">Voir</a>
                </div>
            </article>

            <article>
                <div>
                    <img src="assets/images/brocanteur.jpg" alt="brocanteurA">
                </div>
                <div>
                    <h3>Brocanteur A</h3>
                    <p>Numéro 0013 - Zone A</p>
                    <p>XX objets en ventes</p>
                </div>
                <div>
                    <a href="brocanteur.php">Voir</a>
                </div>
            </article>

            <article>
                <div>
                    <img src="assets/images/brocanteur.jpg" alt="brocanteurA">
                </div>
                <div>
                    <h3>Brocanteur A</h3>
                    <p>Numéro 0013 - Zone A</p>
                    <p>XX objets en ventes</p>
                </div>
                <div>
                    <a href="brocanteur.php">Voir</a>
                </div>
            </article>

            <article>
                <div>
                    <img src="assets/images/brocanteur.jpg" alt="brocanteurA">
                </div>
                <div>
                    <h3>Brocanteur A</h3>
                    <p>Numéro 0013 - Zone A</p>
                    <p>XX objets en ventes</p>
                </div>
                <div>
                    <a href="brocanteur.php">Voir</a>
                </div>
            </article>

        </section>

    </main>

    <?php require_once("inc/footer.inc.php"); ?>

</body>
</html>