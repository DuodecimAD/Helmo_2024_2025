<?php require_once $_SERVER['DOCUMENT_ROOT'] . '/php/controller.espaceBrocanteur.php'; ?>
<!DOCTYPE html>
<html lang="fr">
<?php $title = "Espace Brocanteur"; include_once $_SERVER['DOCUMENT_ROOT'] . '/inc/head.inc.php'; ?>

<body>
    <?php include_once $_SERVER['DOCUMENT_ROOT'] . '/inc/header.inc.php'; ?>

    <main id="espaceBroc" class="max-width">

        <h1>Espace Brocanteur</h1>

        <?php if(!$_SESSION['user']['a_paye']){ ?>
            <div class="boite errorMessage" style="margin-bottom: 15em;">
                <p>Vous n'avez pas encore payé votre redevance d'emplacement.</p>
                <p>Pour voir les informations de paiement, veuillez vous rendre sur la page suivante : </p>
                <a href="paiement.php" style="width: 12em; margin: 1.25em auto; ">Procéder au paiement</a>
            </div>
        <?php } else if($_SESSION['user']['emplacement'] === null){ ?>
            <div class="boite errorMessage" style="margin-bottom: 15em;">
                <p>Un emplacement ne vous a pas encore été attribué.</p>
                <p>Veuillez patienter le temps que l'admin vous en appointe un. Ce n'est pas moi qui le dis, c'est le cahier des charges préférant un système manuel.</p>
            </div>
        <?php } else { ?>

            <?php if(!$_SESSION['user']['est_visible']) { ?>
                <form action="<?= nettoyage_to_db($_SERVER['PHP_SELF']) ?>" method="post" class="boite errorMessage">
                    <p>Votre status est invisible.<br>Vos objets ne seront pas montrés aux visiteurs de ce site.</p>
                    <button type="submit" name="visibilite" style="background-color: #c4f7c1;margin: 1em auto;">Me rendre visible</button>
                </form>
            <?php } ?>

            <section id="brocanteurDonnees" class="sectionLeft boite">
                <h2>Vos données</h2>
                <ul>
                    <li>Nom : <?= nettoyage_from_db($_SESSION['user']['nom']) ?></li>
                    <li>Prenom : <?= nettoyage_from_db($_SESSION['user']['prenom']) ?></li>
                    <li>Courriel : <?= nettoyage_from_db($_SESSION['user']['courriel']) ?></li>
                </ul>
                <img src="<?= nettoyage_from_db($_SESSION['user']['photo']) ?>" alt="ma_photo">
                <div class="invisibleMagicBox"></div>
                <p><span style="line-height: 3em;">Description : </span><br> <?= nettoyage_from_db($_SESSION['user']['description']) ?></p>
                <div class="invisibleMagicBox"></div>
                <a href="#" onclick="event.preventDefault(); alert('Pas encore implémenté')">Modifier</a>
                <div class="invisibleMagicBox"></div>
                <a href="reinitialisationmdp.php" onclick="event.preventDefault(); alert('Pas encore implémenté')">changer mot de passe ?</a>

            </section>

            <div class="sectionRight boite">
                <p id="brocanteurEmplacement">L'emplacement<br><?= $emplacement->getCodeById($_SESSION['user']['emplacement']) ?><br>vous est attribué.</p>
            </div>

            <section id="Objets_list" class="sectionLeft boite">
                <h2>Vos objets</h2>
                <?php foreach($objetsFromUser AS $eachObjet){ ?>
                <?php include $_SERVER['DOCUMENT_ROOT'] . '/inc/objetsList.inc.php'; ?>
                <?php } ?>
            </section>


            <form action="<?= nettoyage_to_db($_SERVER['PHP_SELF']) ?>" enctype="multipart/form-data" method="post" class="sectionRight boite" <?php if(isset($errorMessage)) {?>style="max-height: 60em;"<?php } ?>>
                <?php if(isset($_GET['modif']) || isset($_POST['modifier'])) { ?>
                    <h2>Modifier objet</h2>
                    <input type="hidden" name="oid" value="<?php if(isset($oid)){ echo $oid; } ?>">

                <?php } else { ?>
                    <h2>Ajouter objet</h2>
                <?php } ?>

                <img src="<?= $image ?? 'uploads/default_image.jpg'; ?>" id="previewImage" alt="ajouter photo">
                <input type="file" name="image" id="image" accept="image/*"
                        onchange="const f = this.files[0]; if (f) { const r = new FileReader(); r.onload = (e) => document.getElementById('previewImage').src = e.target.result; r.readAsDataURL(f); }"
                        >

                <label for="intitule">Titre *</label>
                <input type="text" id="intitule" name="intitule" placeholder="Titre de l'objet"
                     value="<?php if(isset($intitule)){ echo $intitule; } ?>" required>

                <label for="categorie">Catégorie *</label>
                <select	name="categorie" title="categorie" id="categorie" required>
                    <option value="">-- Sélectionnez une catégorie --</option>
                    <?php foreach ($categories as $cat) {?>
                        <option value="<?= nettoyage_from_db($cat['cid']) ?>" <?=
                        isset($cid) && $cid == $cat['cid'] ? 'selected' : ''; ?>>
                        <?= nettoyage_from_db($cat['intitule'])?></option>
                    <?php } ?>

                </select>

                <label for="description">Description *</label>
                <textarea name="description" id="description" rows="10" maxlength="450" placeholder="Entrez votre description" required><?php
                    if(isset($description)){ echo $description; }
                    ?></textarea>
                <?php if(isset($_GET['modif']) || isset($_POST['modifier'])) { ?>
                <button type="submit" name="modifier">Modifier</button>
                <?php } else { ?>
                <button type="submit" name="ajouter">Ajouter</button>
                <?php } ?>

                <?php if(isset($errorMessage)) { ?>
                    <p class="errorMessage"><?= nettoyage_from_db($errorMessage) ?><br>Veuillez fournir à nouveau une image si vous en souhaitez une.</p>
                <?php  }?>
            </form>

        <?php } ?>
    </main>

    <?php include_once $_SERVER['DOCUMENT_ROOT'] . '/inc/footer.inc.php'; ?>
</body>
</html>
