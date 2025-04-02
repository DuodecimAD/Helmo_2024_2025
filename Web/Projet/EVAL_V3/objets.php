<?php require_once $_SERVER['DOCUMENT_ROOT'] . '/php/controller.objets.php'; ?>
<!DOCTYPE html>
<html lang="fr">
<?php $title = "Objets"; include_once $_SERVER['DOCUMENT_ROOT'] . '/inc/head.inc.php';?>
<body>
    <?php include_once $_SERVER['DOCUMENT_ROOT'] . '/inc/header.inc.php'; ?>

    <main id="Objets" class="max-width">
        <h1>Objets</h1>

        <form action="<?= nettoyage_from_db($_SERVER['PHP_SELF']) ?>" method="GET" id="Objets_search">
            <input type="search" name="search" placeholder="Chercher objet">
            <div>
            <?php foreach($categories as $categorie){ ?>
                <label>
                    <input type="checkbox" name="oCats[]" value="<?= $categorie['intitule'] ?>">
                    <?= $categorie['intitule'] ?>
                </label>
            <?php } ?>
            </div>

            <div>
                <button type="submit">Rechercher</button>
                <a href="<?= nettoyage_from_db($_SERVER['PHP_SELF']) ?>">Réinitialiser</a>
            </div>
        </form>

        <section id="Objets_list" class="boite" style="margin-top: 2em;">
            <?php foreach($categories as $categorie){

                if (!empty($oCats) && !in_array($categorie['intitule'], $oCats)) {
                    continue;
                }
                ?>
                <h2><?= $categorie['intitule'] ?></h2>
                <?php

                foreach ($objets as $eachObjet) {
                    $isSearchExist = empty($_GET['search']) || stripos($eachObjet['intitule'], $_GET['search']) !== false || stripos($eachObjet['description'], $_GET['search']) !== false;
                    $isCategorieExist = $eachObjet['cid'] === $categorie['cid'];

                    if ($isSearchExist && $isCategorieExist) {
                        include $_SERVER['DOCUMENT_ROOT'] . '/inc/objetsList.inc.php';
                        $noObjetBool = true;
                    }
                }
            }
            if(!$noObjetBool){
                echo "<p>Aucun objet n'a été trouvé avec les paramètres de filtres fournis.</p>";
            }
            ?>

        </section>
    </main>

    <?php include_once $_SERVER['DOCUMENT_ROOT'] . '/inc/footer.inc.php'; ?>

</body>
</html>