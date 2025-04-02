<?php require_once $_SERVER['DOCUMENT_ROOT'] . '/php/controller.reinitialisationmdp.php'; ?>

<!DOCTYPE html>
<html lang="fr">
<?php $title = "Réinitialiser mot de passe"; include_once $_SERVER['DOCUMENT_ROOT'] . '/inc/head.inc.php'; ?>
<body>

    <?php include_once $_SERVER['DOCUMENT_ROOT'] . '/inc/header.inc.php'; ?>

    <main class="max-width">
        <h1>Réinitialiser mot de passe</h1>
        <form action="#" method="post" id="reinitialisationmdp_form" class="boite" style="margin-bottom: 15em;">

            <section>
                <label for="email">Email *</label>
                <input type="email" name="email" id="email" required placeholder="Entrez votre email">
            </section>

            <section>
                <a href="index.php" class="annuler">Annuler</a>
                <button type="submit" name="submit" onclick="event.preventDefault(); alert('Pas encore implémenté')">Réinitialiser</button>
            </section>

        </form>
    </main>

    <?php include_once $_SERVER['DOCUMENT_ROOT'] . '/inc/footer.inc.php'; ?>

</body>
</html>