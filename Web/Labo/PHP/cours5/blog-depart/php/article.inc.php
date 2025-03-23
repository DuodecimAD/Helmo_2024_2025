<?php

require_once '../php/utils.inc.php';
require_once '../php/db_posts.inc.php';

use Blog\ArticleRepository;

$id = filter_input(INPUT_GET, 'id', FILTER_VALIDATE_INT);
if ($id !== false && $id !== null) {
    //traitement
    $articleRepository = new ArticleRepository();
    $article = $articleRepository->getArticleById($id, $messageErreur);
    if (!$article) {
        /*L'opérateur ternaire vérifie si $messageErreur est vide.
        Si c'est le cas, il attribue à $messageErreur le message d'erreur par défaut.
        Sinon, il conserve la valeur déjà présente dans $messageErreur. */
        $messageErreur = empty($messageErreur) ? "Erreur : L'article demandé n'existe pas." : $messageErreur;
    }
}else {
    $messageErreur = "Erreur : L'identifiant de l'article est invalide.";
}