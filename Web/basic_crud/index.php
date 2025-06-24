<?php

require_once './php/utils.php';
require_once './php/Crud.php';

use Blog\php\Crud;

$crud = new Crud();
$result = $crud->getAll();


?>

<?php $title = "index"; include_once 'inc/head.inc.php'; ?>

<?php include_once 'inc/header.inc.php'; ?>

    <table>
        <thead>
            <tr>
                <th>articleName</th>
                <th>articleName</th>
                <th>articleName</th>
                <th>articleName</th>
                <th>articleName</th>
                <th>articleName</th>
                <th>articleName</th>
                <th>articleName</th>
                <th>articleName</th>
                <th>articleName</th>
            </tr>
        </thead>
        <tbody>
        <?php foreach ($result as $stuff) { ?>
            <tr>
                <td><?= nettoyage_from_db($stuff['id']) ?></td>
                <td><?= nettoyage_from_db($stuff['articlename']) ?></td>
                <td><?= nettoyage_from_db($stuff['authorname']) ?></td>
                <td><?= nettoyage_from_db($stuff['categoryname']) ?></td>
                <td><?= nettoyage_from_db($stuff['email']) ?></td>
                <td><?= nettoyage_from_db($stuff['description']) ?></td>
                <td><?= nettoyage_from_db($stuff['imagename']) ?></td>
                <td><?= nettoyage_from_db($stuff['link']) ?></td>
                <td><a href="update.php?id=<?= nettoyage_from_db($stuff['id']) ?>">update.php?id=<?= nettoyage_from_db($stuff['id']) ?></a></td>
                <td><a href="delete.php?id=<?= nettoyage_from_db($stuff['id']) ?>">delete.php?id=<?= nettoyage_from_db($stuff['id']) ?></a></td>
            </tr>
        <?php } ?>

        </tbody>
    </table>

    <?php if(isset($modifErrorMessage)){ ?>
        <div style="background-color:indianred;height:100px;width:100px;margin:auto;"><?= nettoyage_from_db($modifErrorMessage) ?></div>
    <?php } ?>

<?php include_once 'inc/head.inc.php'; ?>