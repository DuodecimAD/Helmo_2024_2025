<?php


require_once $_SERVER['DOCUMENT_ROOT'] . '/php/login.controller.php';

?>
<!DOCTYPE html>
<html lang="fr">

<?php
$title = "Me connecter";
require_once("inc/head.inc.php");
?>

<body>
<?php require_once("inc/header.inc.php"); ?>

<main class="max-width">
    <h1>Me connecter</h1>
    <form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']) ?>" method="post" id="login_form" class="boite" style="position: relative;">
        <div>
            <label for="email">Email *</label>
            <input type="email" name="email" id="email" required placeholder="Entrez votre email"
                <?php if(isset($errorMessage) && $errorMessage === "Votre mot de passe est incorrect."){ ?> value="<?php echo htmlspecialchars($_SESSION['user']['courriel']) ?>"<?php } ?>>

            <label for="password">Mot de passe *</label>
            <input type="password" name="password" id="password" class="mdp" required placeholder="Entrez votre mot de passe">

            <button type="submit" name="submit">Me connecter</button>
            <a href="reinitialisationmdp.php" id="mdpForgot">Mot de passe oublié ?</a>
        </div>

        <div style="all: revert;background-color: #f68d8d; padding: 1.25rem; border: solid red 0.15rem; position: absolute; top: 0.3rem; right: -11.25rem;">
            <p><b>Admin</b></p>
            <p>admin@admin.aa</p>
            <p>admin</p>
            <br>
            <p><b>Brocanteur</b></p>
            <p>broc@broc.aa</p>
            <p>broc</p>

        </div>
        <?php if(isset($errorMessage)) {
            echo '<p style="height: 1.56rem;display: block;margin: auto;width: fit-content;padding: 0.62rem;background-color: #f68d8d;">' . htmlspecialchars($errorMessage) . '</p>';
            unset($errorMessage);
        }?>
    </form>
</main>

<?php require_once("inc/footer.inc.php"); ?>

</body>
</html>