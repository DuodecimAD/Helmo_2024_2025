<?php

require_once '../../php/utils.inc.php';
require_once '../../php/db_posts.inc.php';
use Blog\ArticleRepository;

$afficherConfirmation = false;

$message = '';
$articleDeleted = '';

$action = $_GET['action'] ?? '';
$id = filter_input(INPUT_GET, 'id', FILTER_VALIDATE_INT);


$articleRepository = new ArticleRepository();
$articles = $articleRepository->getAllArticles($message);
$message .= ($articles && $articles->rowCount() === 0) ? 'Pas d\'article pour le moment' : '';

//affichage de la confirmation
if ($id !== false && $id !== null && $action === "d") {
    $idToDelete =  $id;
    $afficherConfirmation = true;
}

// Suppression de l'article si confirmé
if (isset($_POST['confirm-delete']) && isset($_POST['idToDelete'])) {
    $afficherConfirmation = false;
    $id = filter_input(INPUT_POST, 'idToDelete', FILTER_VALIDATE_INT);
    if ($articleRepository->deleteArticle($id, $messageErreur)) {

        $articleDeleted = "L'article a bien été supprimé.";
        $articles = $articleRepository->getAllArticles($messageErreur);
    } else {
        $messageErreur .= "Erreur lors de la suppression de l'article.";
    }
}
