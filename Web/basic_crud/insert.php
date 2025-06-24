<?php

require_once './php/utils.php';
require_once './php/Crud.php';

use Blog\php\Crud;

if($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['insert'])){
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
    } else {
        $crud = new Crud();
        $result = $crud->insert($articleName,$authorName, $categoryName,$email,$description,$imageName,$link);

        if($result !== 'ok'){
            $modifErrorMessage = $result;
        }
    }


}


?>

<?php $title = "index"; include_once 'inc/head.inc.php'; ?>

<?php include_once 'inc/header.inc.php'; ?>

    <form action="<?= nettoyage_from_db($_SERVER["PHP_SELF"]) ?>" method="post">

        <label for="articleName">articleName</label>
        <input type="text" name="articleName" id="articleName" placeholder="articleName" value="<?= isset($modifErrorMessage) ? $articleName : '' ?>" required>

        <label for="authorName">authorName</label>
        <input type="text" name="authorName" id="authorName" placeholder="authorName" value="<?= isset($modifErrorMessage) ? $authorName : '' ?>" required>

        <label for="categoryName">categoryName</label>
        <input type="text" name="categoryName" id="categoryName" placeholder="categoryName" value="<?= isset($modifErrorMessage) ? $categoryName : '' ?>" required>

        <label for="email">email</label>
        <input type="email" name="email" id="email" placeholder="email" value="<?= isset($modifErrorMessage) ? $email : '' ?>" required>

        <label for="description">description</label>
        <input type="text" name="description" id="description" placeholder="description" value="<?= isset($modifErrorMessage) ? $description : '' ?>" required>

        <label for="imageName">imageName</label>
        <input type="text" name="imageName" id="imageName" placeholder="imageName" value="<?= isset($modifErrorMessage) ? $imageName : '' ?>" required>

        <label for="link">link</label>
        <input type="text" name="link" id="link" placeholder="link" value="<?= isset($modifErrorMessage) ? $link : '' ?>" required>

        <button type="submit" name="insert">Ajouter</button>

    </form>

<?php if(isset($modifErrorMessage)){ ?>
    <div style="background-color:indianred;height:100px;width:100px;margin:auto;"><?= nettoyage_from_db($modifErrorMessage) ?></div>
<?php } ?>

<?php include_once 'inc/head.inc.php'; ?>