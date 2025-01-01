<?php
session_start();
?>
<!DOCTYPE html>
<html lang="fr">

<?php
$title = "M'inscrire";
require_once("inc/head.inc.php");
?>

<body>
    <?php require_once("inc/header.inc.php"); ?>

    <main class="max-width">
        <h1>M'inscrire</h1>
        <form action="#" method="post" id="inscription_form" class="boite">

            <div>
                <a href="javascript:void(0);"><img src="images/inconnu.jpg" alt="ajouter photo"></a>
                <a href="javascript:void(0);" id="inscription_photo">Ajouter photo +</a>
            </div>

            <div>
                <label for="nom">Nom *</label>
                <input type="text" name="nom" id="nom" required placeholder="Entrez votre nom">
                <!-- pattern="^[a-zA-Z'-]+$" title="Only letters, apostrophes, and hyphens are allowed." -->

                <label for="prenom">Prénom *</label>
                <input type="text" name="prenom" id="prenom" required placeholder="Entrez votre prénom">

                <label for="email">Email *</label>
                <input type="email" name="email" id="email" required placeholder="Entrez votre email">
            </div>

            <div>
                <div>
                    <label for="password">Mot de passe *</label>
                    <input type="password" name="password" id="password" class="mdp" required placeholder="Entrez votre mot de passe">
                </div>
                <div>
                    <label for="passwordVerif">Vérification mot de passe *</label>
                    <input type="password" name="passwordVerif" id="passwordVerif" class="mdp" required placeholder="Répétez votre mot de passe">
                </div>
            </div>

            <div>
                <label for="description">Description *</label>
                <textarea name="message" id="description" rows="17" cols="56" placeholder="Entrez votre description"></textarea>
            </div>

            <div>
                <label for="visible">Souhaiter-vous être visible sur le site, permettant ainsi aux
                    visiteurs de visualiser votre profil, ainsi que vos objets ?</label>
                <input type="checkbox" name="visible" id="visible">
            </div>

            <div>
                <a href="index.php" class="annuler">Annuler</a>
                <button type="submit" name="submit">Valider</button>
                <a href="login.php" id="dejaCompte">Déjà un compte ?</a>
            </div>

        </form>
    </main>

    <?php require_once("inc/footer.inc.php"); ?>

</body>
</html>