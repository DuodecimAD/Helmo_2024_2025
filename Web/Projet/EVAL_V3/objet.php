<?php
session_start();
?>

<!DOCTYPE html>
<html lang="fr">

<?php
$title = "Objet";
require_once("inc/head.inc.php");
?>

<body>
<?php require_once("inc/header.inc.php"); ?>

<main id="Objet" class="max-width">
    <section id="ObjetProfil" class="boite">
        <div>
            <img src="assets/images/D-09636-0001.jpg" alt="objet D-09636-0001">
        </div>

        <div>
            <h1>Lampo</h1>
            <p>Vendeur : Brocanteur A (c'est le Nom Prénom, pour le moment) </p>
            <p>Emplacement : 13 - Zone A</p>
            <p>Code : D-09636-0001</p>
            <p>Prix : 249,99 €</p>
            <p>Catégorie : Rare</p>
            <p>Quantité : 25</p>
            <p style="text-align: justify">
                "Ce distributeur PEZ a vu le jour en 2020 avec la sortie
                de la collection <b>44 cats</b>. Son indice de rareté
                est considéré comme <b>rare</b> par la communauté."
            </p>
        </div>
    </section>

    <h2>Autres objets référencés par Brocanteur A</h2>

    <?php require_once ("inc/objetsList.inc.php"); ?>


</main>

<?php require_once("inc/footer.inc.php"); ?>

</body>
</html>