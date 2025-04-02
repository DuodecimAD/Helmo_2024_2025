<?php require_once $_SERVER['DOCUMENT_ROOT'] . '/php/controller.objet.php'; ?>
<!DOCTYPE html>
<html lang="fr">
<?php $title = "Objet"; include_once $_SERVER['DOCUMENT_ROOT'] . '/inc/head.inc.php'; ?>
<body>
    <?php include_once $_SERVER['DOCUMENT_ROOT'] . '/inc/header.inc.php'; ?>

    <main id="Objet" class="max-width" style="min-height: 30em;">

        <section id="ObjetProfil" class="boite">
            <div>
                <img src="<?php if(isset($image)){ echo $image;} ?>" alt="<?php if(isset($intitule)){ echo $intitule;} ?>">
            </div>

            <div>
                <h1><?php if(isset($intitule)){ echo $intitule;} ?></h1>
                <p>Vendeur : <?php if(isset($userFullName)){ echo $userFullName;} ?></p>
                <p>Emplacement : <?php if(isset($codeEmplacement)){ echo $codeEmplacement;} ?></p>
                <p>Zone : <?= $zone ?></p>
                <p>Code : ID <?php if(isset($oid)){ echo $oid;} ?></p>
                <p>Catégorie : <?php if(isset($categorie)){ echo $categorie;} ?></p>
                <p style="text-align: justify">Description : <?php if(isset($description)){ echo $description;} ?></p>
            </div>
        </section>

    </main>

    <?php include_once $_SERVER['DOCUMENT_ROOT'] . '/inc/footer.inc.php'; ?>

</body>
</html>