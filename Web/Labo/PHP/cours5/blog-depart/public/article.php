<?php

require_once '../php/article.inc.php';

include_once '../inc/head.inc.php';
include_once '../inc/header.inc.php';

?>

<main class="centrage boxOmbre">
    <ul class="containerFlex">
        <li><i class="fa fa-arrow-left"></i> <a href="<?= BASE_URL ?>"> vers la liste des articles</a></li>
    </ul>

    <?php if (isset($article) && $article) { ?>
        <h1><?= nettoyage($article->titre) ?></h1>
        <p><?= nl2br(nettoyage($article->contenu)) ?></p>
    <?php } else { ?>
        <div class="error-message">
            <p><?= nettoyage($messageErreur) ?></p>
        </div>
    <?php } ?>
</main>


<?php include '../inc/footer.inc.php' ?>