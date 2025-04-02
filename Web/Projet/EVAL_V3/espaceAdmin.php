<?php require_once $_SERVER['DOCUMENT_ROOT'] . '/php/controller.espaceAdmin.php'; ?>
<!DOCTYPE html>
<html lang="fr">
<?php $title = "Espace Administrateur";  include_once $_SERVER['DOCUMENT_ROOT'] . '/inc/head.inc.php'; ?>
<body>
    <?php include_once $_SERVER['DOCUMENT_ROOT'] . '/inc/header.inc.php'; ?>

    <main id="espaceAdmin" class="max-width">
        <h1>Espace Administrateur</h1>

        <section class="espaceAdmin_list boite">

            <?php if(isset($users)){ ?>
            <h2>Emplacement non attribué</h2>
            <?php
                foreach ($users as $index => $user){
                    // si admin -> skip
                    if ($index === 0) continue;
                    // si pas payé -> skip
                    if (!$user['a_paye']) continue;
                    // si emplacement attribué -> skip
                    if ($user['eid'] !== null) continue;
            ?>

            <article>
                <div>
                    <img src="<?= nettoyage_from_db($user['photo']) ?>" alt="<?= nettoyage_from_db($user['prenom']) . '_' . nettoyage_from_db($user['nom']) . '_avatar' ?>">
                </div>
                <div>
                    <h3><?= nettoyage_from_db($user['prenom']) . ' ' . nettoyage_from_db($user['nom']) ?></h3>
                    <p>ID <?= $user['bid'] ?></p>
                    <p>Emplacement : Non attribué</p>
                </div>

                <form action="<?= nettoyage_from_db($_SERVER['PHP_SELF']) ?>" method="post">
                    <input type="hidden" name="userId" value="<?= $user['bid'] ?>">
                    <label for="emplacements_<?= $user['bid'] ?>">Attribuer :</label>
                    <select name="emplacements" id="emplacements_<?= $user['bid'] ?>" required>
                        <option value="">-- Sélectionnez un emplacement --</option>
                        <?php foreach ($emplacements as $emplacement) {?>
                            <option value="<?= nettoyage_from_db($emplacement['code']); ?>" ><?= nettoyage_from_db($emplacement['code']); ?></option>
                        <?php } ?>
                    </select>
                    <button type="submit" name="submit">Valider</button>
                </form>
                <form style="border-left: 0.2em solid #cccccc;padding : 0 0.8em; width: 12em;" action="<?= nettoyage_to_db($_SERVER['PHP_SELF']) ?>" method="post">
                    <p style="margin: 0.3em 0;">Supprimer brocanteur</p>
                    <input type="hidden" name="userId" value="<?= $user['bid'] ?>">
                    <button type="submit" name="submit_delete" class="submit_delete" onclick="event.preventDefault(); alert('Fonctionnalité opérationnelle mais désactivée afin d\'éviter qu\'un petit malin vienne tout effacer')">Delete</button>
                </form>

            </article>
            <?php
                }
            }
            ?>
        </section>

        <section class="espaceAdmin_list boite">

            <?php if(isset($users)){ ?>
            <h2>Emplacement attribué</h2>
            <?php
                foreach ($users as $index => $user){
                    // si admin -> skip
                    if ($index === 0) continue;
                    // si pas payé -> skip
                    if (!$user['a_paye']) continue;
                    // si emplacement pas attribué -> skip
                    if ($user['eid'] === null) continue;
                    ?>

                    <article>
                        <div>
                            <img src="<?= nettoyage_from_db($user['photo']) ?>" alt="<?= nettoyage_from_db($user['prenom']) . '_' . nettoyage_from_db($user['nom']) . '_avatar' ?>">
                        </div>
                        <div>
                            <h3><?= nettoyage_from_db($user['prenom']) . ' ' . nettoyage_from_db($user['nom']) ?></h3>
                            <p>ID <?= $user['bid'] ?></p>
                            <p>Emplacement : <?= $emplacementObject->getCodeById($user['eid']); ?></p>
                        </div>

                        <form action="<?= nettoyage_from_db($_SERVER['PHP_SELF']) ?>" method="post">
                            <input type="hidden" name="userId" value="<?= $user['bid'] ?>">
                            <label for="emplacements_<?= $user['bid'] ?>">Modifier :</label>
                            <select name="emplacements" id="emplacements_<?= $user['bid'] ?>" required>
                                <option value="">-- Sélectionnez un emplacement --</option>
                                <?php foreach ($emplacements as $emplacement) {?>
                                    <option value="<?= nettoyage_from_db($emplacement['code']); ?>" ><?= nettoyage_from_db($emplacement['code']); ?></option>
                                <?php } ?>
                            </select>
                            <button type="submit" name="submit">Valider</button>
                        </form>
                        <form style="border-left: 0.2em solid #cccccc;padding : 0 0.8em;" action="<?= nettoyage_to_db($_SERVER['PHP_SELF']) ?>" method="post">
                            <p style="margin: 0.3em 0;">Supprimer brocanteur</p>
                            <input type="hidden" name="userId" value="<?= $user['bid'] ?>">
                            <button type="submit" name="submit_delete" class="submit_delete" onclick="event.preventDefault(); alert('Fonctionnalité opérationnelle mais désactivée afin d\'éviter qu\'un petit malin vienne tout effacer')">Delete</button>
                        </form>

                    </article>
                    <?php
                }
            }
            ?>

        </section>

        <section class="espaceAdmin_list boite">

            <?php if(isset($users)){ ?>
                <h2>En attente de paiement</h2>
                <?php
                foreach ($users as $index => $user){
                    // si admin -> skip
                    if ($index === 0) continue;
                    // si payé -> skip
                    if ($user['a_paye']) continue;
                    ?>

                    <article>
                        <div>
                            <img src="<?= nettoyage_from_db($user['photo']) ?>" alt="<?= nettoyage_from_db($user['prenom']) . '_' . nettoyage_from_db($user['nom']) . '_avatar' ?>">
                        </div>
                        <div>
                            <h3><?= nettoyage_from_db($user['prenom']) . ' ' . nettoyage_from_db($user['nom']) ?></h3>
                            <p>ID <?= $user['bid'] ?></p>
                            <p>Emplacement : Non attribué</p>
                        </div>

                        <form style="border-left: 0.2em solid #cccccc;padding : 0 0.8em;" action="<?= nettoyage_to_db($_SERVER['PHP_SELF']) ?>" method="post">
                            <p style="margin: 0.3em 0;">Supprimer brocanteur</p>
                            <input type="hidden" name="userId" value="<?= $user['bid'] ?>">
                            <button type="submit" name="submit_delete" class="submit_delete" onclick="event.preventDefault(); alert('Fonctionnalité opérationnelle mais désactivée afin d\'éviter qu\'un petit malin vienne tout effacer')">Delete</button>
                        </form>
                    </article>
                    <?php
                }
            }
            ?>
        </section>

    </main>

    <?php include_once $_SERVER['DOCUMENT_ROOT'] . '/inc/footer.inc.php'; ?>

</body>
</html>
