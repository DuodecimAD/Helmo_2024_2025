<?php

require_once 'php/utils.inc.php';
require_once 'php/db_posts.inc.php';

use Blog\ArticleRepository;

include_once 'inc/head.inc.php';
include_once 'inc/header.inc.php';

$message = '';
$articleRepository = new ArticleRepository();
$articles = $articleRepository->getAllArticles($message);
$message .= ($articles && $articles->rowCount() === 0) ? 'Pas d\'article pour le moment' : '';

?>

<main class="centrage">
    <h1 class="center">Nos articles</h1>
    <section class="info containeurFlex">
        <?php
        if (!empty($message)) {
            echo $message;
        } else {
            foreach ($articles as $article) { ?>
                <article class="item">
                    <p>#Article <?= nettoyage_inverse($article->id) ?></p>
                    <h3><?= nettoyage_inverse($article->titre) ?></h3>
                    <a href='<?= BASE_URL ?>public/article.php?id=<?= nettoyage_inverse($article->id) ?>'>&gt;&gt;Lire l'article</a>
                </article>
            <?php  }
        }
        ?>
    </section>

</main>


<?php include 'inc/footer.inc.php' ?>