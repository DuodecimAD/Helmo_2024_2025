<?php foreach ($zones as $zone) { ?>
    <h2><?= nettoyage_from_db($zone['nom']) . ' - ' . nettoyage_from_db($zone['description']) ?></h2>

    <?php foreach ($brocanteurs as $brocanteur) {
        if($zone['nom'] === $brocanteur['zone'] && $brocanteur['visible']) {
            include $_SERVER['DOCUMENT_ROOT'] . '/inc/brocanteursFiltered.inc.php';
        }
    }
 }
