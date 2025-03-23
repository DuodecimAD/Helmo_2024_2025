<?php

require_once '../../php/gestion.inc.php';

include_once '../../inc/head.inc.php';
include_once '../../inc/header.inc.php';

?>
<main class="centrage ">

    <h1>Gestion des Articles</h1>

    <a href="new.php" class="btn color-theme">Ajouter un article</a>

    <?php
    if (!empty($message)) {
        afficherAlerte($message, 'success');
    }

    if (!empty($messageErreur)) {
        afficherAlerte($messageErreur);
    }
    ?>

<?php if ($afficherConfirmation) { ?>
    <div class="modal">
        <div class="modal-content">
            <h2>Confirmer la suppression</h2>
            <p>Voulez-vous vraiment supprimer l'article X ? Cette action est irréversible.</p>
            <form method="post" action='<?= htmlspecialchars($_SERVER["PHP_SELF"]); ?>'>
                <input type="hidden" name="idToDelete" value="<?= $idToDelete; ?>">
                <button type="submit" name="confirm-delete" class="btn color-danger">Oui, supprimer</button>
                <a href="<?= htmlspecialchars($_SERVER["PHP_SELF"]); ?>" class="btn color-theme">Annuler</a>
            </form>
        </div>
    </div>
<?php } ?>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Titre</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <?php
        if (!empty($message)) {
            ?>
        <tr>
            <td>
                <?php echo $message; ?>
            </td>
        </tr>
        <?php
        } else {
            foreach ($articles as $article) { ?>
                <tr>
                    <td><?= nettoyage($article->id) ?></td>
                    <td><?= nettoyage($article->titre) ?></td>
                    <td>
                        <a href="new.php?id=<?= nettoyage($article->id) ?>" class="btn color-theme">Modifier</a>
                        <a href="gestion.php?action=d&id=<?= nettoyage($article->id) ?>" class="btn color-danger">Supprimer</a>
                    </td>
                </tr>
            <?php  }
        }
        ?>
        </tbody>
    </table>
</main>


<?php include  '../../inc/footer.inc.php' ?>