<?php
require_once 'utils.inc.php';
require_once 'db_posts.inc.php';

use Blog\Article;
use Blog\ArticleRepository;

$erreurs = [];
// récuperer les valeurs des champs et les nettoyer, si elles existent
$titre = nettoyage($_POST['titre'] ?? '');
$contenu = nettoyage($_POST['contenu'] ?? '');
// Récupération de l'ID en GET

$id = filter_input(INPUT_GET, 'id', FILTER_VALIDATE_INT);

//var_dump($_POST);
echo "";
//var_dump($_GET);
//vérifier la soumission du formulaire
if (isset($_POST['btn_article'])) {

    //réaliser les vérifications
    if (empty($titre)) {
        $erreurs[] = 'Le titre ne peut pas être vide';
    } else if (strlen($titre) > 100) {
        $erreurs[] = 'Le titre ne peut pas être excéder 100 caractères.';
    }

    if (empty($contenu)) {
        $erreurs[] = 'Le contenu ne peut pas être vide';
    }

    if (empty($erreurs)) {
        $article = new Article();

        $article->titre = $titre;
        $article->contenu = $contenu;
        $articleRepository = new ArticleRepository();

        if (isset($_POST['id']) && $_POST['id'] && is_numeric($_POST['id'])) {
            // Mode modification
            $article->id = $_POST['id'];
            if ($articleRepository->updateArticle($article, $messageErreur)) {
                $message = "Article mis à jour avec succès.";
            } else {
                $erreurs[] = "Erreur technique lors de la mise à jour.";
                $erreurs[] = $messageErreur;
            }
        } else {
            // Mode ajout
            if ($articleRepository->insertArticle($article, $messageErreur)) {
                $message = "Article correctement ajouté.";
                $titre = $contenu = '';
            } else {
                $erreurs[]  = "Erreur technique. Veuillez contacter l'administrateur.";
                $erreurs[] = $messageErreur;
            }
        }
    }
}

//si modification
if ($id !== false && $id !== null) {
    // Récupération des valeurs de l'article
    $articleRepository = new ArticleRepository();
    $article = $articleRepository->getArticleById($id, $messageErreur);
    //si l'article existe
    if ($article) {
        //assigner les valeurs aux variables qui seront affichées dans le formulaire
        $titre = nettoyage_inverse($article->titre);
        $contenu = nettoyage_inverse($article->contenu);
    } else {
        $messageErreur = "Article introuvable.";
    }
}