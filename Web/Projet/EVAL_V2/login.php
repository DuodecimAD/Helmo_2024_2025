<?php
session_start();

$validUsers = [
    'admin@admin' => ['password' => 'admin', 'role' => 'admin', 'avatar' => 'images/inconnu.jpg'],
    'broc@broc' => ['password' => 'broc', 'role' => 'broc', 'avatar' => 'images/brocanteur.jpg']
];

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $email = $_POST['email'] ?? '';
    $password = $_POST['password'] ?? '';

    if (isset($validUsers[$email]) && $validUsers[$email]['password'] === $password) {
        $_SESSION['loggedin'] = true;
        $_SESSION['email'] = $email;
        $_SESSION['avatar'] = $validUsers[$email]['avatar'];
        $_SESSION['role'] = $validUsers[$email]['role'];

        if ($_SESSION['role'] === 'admin') {
            header("Location: espaceAdmin.php");
        } else {
            header("Location: espaceBrocanteur.php");
        }
        exit;
    } else {
        $error = "Invalid email or password.";
    }
}
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
    <form action="#" method="post" id="login_form" class="boite" style="position: relative;">
        <div>
            <label for="email">Email *</label>
            <input type="email" name="email" id="email" required placeholder="Entrez votre email">

            <label for="password">Mot de passe *</label>
            <input type="password" name="password" id="password" class="mdp" required placeholder="Entrez votre mot de passe">

            <button type="submit" name="submit">Me connecter</button>
            <a href="reinitialisationmdp.php" id="mdpForgot">Mot de passe oublié ?</a>
        </div>

        <div style="all: revert;background-color: #f68d8d; padding: 20px; border: solid red 2px; position: absolute; top: 5px; right: -150px;">
            <p><b>Admin</b></p>
            <p>admin@admin</p>
            <p>admin</p>
            <br>
            <p><b>Brocanteur</b></p>
            <p>broc@broc</p>
            <p>broc</p>

        </div>
    </form>
</main>

<?php require_once("inc/footer.inc.php"); ?>


</body>
</html>