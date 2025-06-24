<?php

require_once './php/utils.php';
require_once './php/Crud.php';

use Blog\php\Crud;

if(isset($_POST['delete'])){
    $id = filter_var(nettoyage_to_db($_POST['id']) ?? '', FILTER_VALIDATE_INT);

    $crud = new Crud();
    $result = $crud->delete($id);

    if($result === 'ok'){
        $message = 'success';
    }
}

?>

<?php $title = "delete"; include_once 'inc/head.inc.php'; ?>

<?php include_once 'inc/header.inc.php'; ?>

    <?php if(isset($message)){ ?>

        <p>L'article a bien été supprimé.</p>

    <?php } else { ?>

        <form action="<?= nettoyage_from_db($_SERVER["PHP_SELF"]) ?>" method="post">

            <input type="hidden" name="id" value="<?= $_GET['id'] ?? '' ?>">
            <p>Voulez-vous vraiment supprimer cet article ?</p>
            <a href="index.php">Annuler</a>
            <button type="submit" name="delete">Supprimer</button>

        </form>
    <?php }?>

<?php include_once 'inc/head.inc.php'; ?>