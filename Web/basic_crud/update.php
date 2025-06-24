<?php

require_once './php/utils.php';
require_once './php/Crud.php';

use Blog\php\Crud;

if(isset($_GET['id'])){
    $id = filter_var(nettoyage_to_db($_GET['id']) ?? '', FILTER_VALIDATE_INT);

    if($id){

        $crud = new Crud();
        $result = $crud->getById($id);

        $id            = nettoyage_from_db($result[0]['id']);
        $articleName   = nettoyage_from_db($result[0]['articlename']);
        $authorName    = nettoyage_from_db($result[0]['authorname']);
        $categoryName  = nettoyage_from_db($result[0]['categoryname']);
        $email         = nettoyage_from_db($result[0]['email']);
        $description   = nettoyage_from_db($result[0]['description']);
        $imageName     = nettoyage_from_db($result[0]['imagename']);
        $link          = nettoyage_from_db($result[0]['link']);
    }

}

if($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['update'])){
    $id             = filter_var(nettoyage_to_db($_POST['id']) ?? '', FILTER_VALIDATE_INT);
    $articleName    = nettoyage_to_db($_POST['articleName']) ?? '';
    $authorName     = nettoyage_to_db($_POST['authorName']) ?? '';
    $categoryName   = nettoyage_to_db($_POST['categoryName']) ?? '';
    $email          = filter_var(nettoyage_to_db($_POST['email']) ?? '', FILTER_VALIDATE_EMAIL);
    $description    = nettoyage_to_db($_POST['description']) ?? '';
    $imageName      = nettoyage_to_db($_POST['imageName']) ?? '';
    $link           = nettoyage_to_db($_POST['link']) ?? '';


    if ($articleName === '') {
        $modifErrorMessage = "articleName n'est pas valide.";
    } elseif ($authorName === '') {
        $modifErrorMessage = "authorName n'est pas valide.";
    } elseif ($categoryName === '') {
        $modifErrorMessage = "categoryName n'est pas valide.";
    } elseif (!$email) {
        $modifErrorMessage = "email n'est pas valide.";
    } elseif ($description === '') {
        $modifErrorMessage = "description n'est pas valide.";
    } elseif ($imageName === '') {
        $modifErrorMessage = "imageName n'est pas valide.";
    } elseif ($link === '') {
        $modifErrorMessage = "link n'est pas valide.";
    }  elseif (!$id) {
        $modifErrorMessage = "id n'est pas valide.";
    } else {
        $crud = new Crud();
        $result = $crud->update($id,$articleName,$authorName, $categoryName,$email,$description,$imageName,$link);

        if($result !== 'ok'){
            $modifErrorMessage = $result;
        }
    }


}


?>

<?php $title = "update"; include_once 'inc/head.inc.php'; ?>

<?php include_once 'inc/header.inc.php'; ?>

   <?php if(isset($result) && $result === 'ok'){ ?>
        
        <p>L'article a bien été modifié.</p>

   <?php  } else { ?>

        <form action="<?= nettoyage_from_db($_SERVER["PHP_SELF"]) ?>" method="POST">

            <input type="hidden" name="id" value="<?= $id ?? '' ?>">

            <label for="articleName">articleName</label>
            <input type="text" name="articleName" id="articleName" placeholder="articleName" value="<?= isset($modifErrorMessage) || isset($id) ? $articleName : '' ?>" required>

            <label for="authorName">authorName</label>
            <input type="text" name="authorName" id="authorName" placeholder="authorName" value="<?= isset($modifErrorMessage) || isset($id)  ? $authorName : '' ?>" required>

            <label for="categoryName">categoryName</label>
            <input type="text" name="categoryName" id="categoryName" placeholder="categoryName" value="<?= isset($modifErrorMessage) || isset($id)  ? $categoryName : '' ?>" required>

            <label for="email">email</label>
            <input type="email" name="email" id="email" placeholder="email" value="<?= isset($modifErrorMessage) || isset($id)  ? $email : '' ?>" required>

            <label for="description">description</label>
            <input type="text" name="description" id="description" placeholder="description" value="<?= isset($modifErrorMessage) || isset($id)  ? $description : '' ?>" required>

            <label for="imageName">imageName</label>
            <input type="text" name="imageName" id="imageName" placeholder="imageName" value="<?= isset($modifErrorMessage) || isset($id)  ? $imageName : '' ?>" required>

            <label for="link">link</label>
            <input type="text" name="link" id="link" placeholder="link" value="<?= isset($modifErrorMessage) || isset($id)  ? $link : '' ?>" required>

            <button type="submit" name="update">Modifier</button>

        </form>
    <?php } ?>

<?php if(isset($modifErrorMessage)){ ?>
    <div style="background-color:indianred;height:100px;width:100px;margin:auto;"><?= nettoyage_from_db($modifErrorMessage) ?></div>
<?php } ?>

<?php include_once 'inc/head.inc.php'; ?>