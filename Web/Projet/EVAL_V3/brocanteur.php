<?php require_once $_SERVER['DOCUMENT_ROOT'] . '/php/controller.brocanteur.php'; ?>
<!DOCTYPE html>
<html lang="fr">
<?php $title = "Brocanteur $prenom $nom"; include_once $_SERVER['DOCUMENT_ROOT'] . '/inc/head.inc.php'; ?>
<body>
    <?php include_once $_SERVER['DOCUMENT_ROOT'] . '/inc/header.inc.php'; ?>

    <main id="Brocanteur" class="max-width" style="min-height: 30em;">
        <section id="BrocanteurProfil" class="boite">
            <div>
                <img src="<?= $photo ?>" alt="<?= $prenom . '_' . $nom . '_avatar' ?>">
            </div>

            <div>
                <h1><?= $prenom . ' ' . $nom ?></h1>
                <p>Emplacement : <?= $codeEmplacement ?></p>
                <p>Zone : <?= $zoneName ?></p>
                <p style="text-align: justify">Description : <br><?= $description ?></p>
            </div>
        </section>

        <h2>Objets en vente chez <?= $prenom . ' ' . $nom ?></h2>
        <section id="Objets_list" class="boite">
            <?php foreach($objetsFromUser as $eachObjet){ ?>
                <?php include $_SERVER['DOCUMENT_ROOT'] . '/inc/objetsList.inc.php'; ?>
            <?php } ?>
        </section>
    </main>

    <?php include_once $_SERVER['DOCUMENT_ROOT'] . '/inc/footer.inc.php'; ?>

</body>
</html>