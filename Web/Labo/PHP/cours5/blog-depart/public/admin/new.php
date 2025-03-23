<?php

require_once '../../php/new.inc.php';

include_once '../../inc/head.inc.php';
include_once '../../inc/header.inc.php';

?>

<main class="centrage boxOmbre">

    <h1><?= $id ? 'Modifier' : 'Nouvel' ?> Article</h1>
    <ul class="containerFlex">
        <li><i class="fa fa-arrow-left"></i> <a href="<?= BASE_URL ?>"> vers la liste des articles</a></li>
    </ul>
    <form action="new.php" method="post" class="formAdmin">
        <h2><?= $id ? 'Modifier' : 'Nouvel' ?> Article</h2>

        <?php
        if (!empty($message)) {
            afficherAlerte($message, 'success');
        }

        if (!empty($erreurs)) {
            afficherAlerte($erreurs);
        }
        ?>
        <?php if($id){ ?>
            <input type="hidden" name="id" value="<?= $id ?>">
        <?php } ?>
        <label for id="titre">Titre *<br><small>100 caractères max</small></label>
        <input type="text" size="50" maxlength="100" id="titre" name="titre" value="<?= $titre ?>">
        <label for id="contenu">Contenu *</label>
        <textarea name="contenu" id="contenu"><?= $contenu ?></textarea>

        <input type="submit" class="btn btn-theme" name="btn_article" value="<?= $id ? 'Modifier' : 'Ajouter' ?>">
    </form>
</main>
<?php include  '../../inc/footer.inc.php' ?>