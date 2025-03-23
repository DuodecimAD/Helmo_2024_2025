<?php
if (!isset($_SESSION['user']['loggedIn']) || !$_SESSION['user']['loggedIn']) {
    echo '<a href="login.php" id="loginButton">Me connecter</a>';
} else {
?>
    <div id="loggedin">
        <div id="userInfos">
            <img src="<?php echo $_SESSION['user']['photo']; ?>" alt="photo">

            <?php
                if($_SESSION['user']['est_administrateur'] === 0) {
                    echo "<a href=\"espaceBrocanteur.php\">" . $_SESSION['user']['courriel'] . "</a>";
                } else {
                    echo "<a href=\"espaceAdmin.php\">" . $_SESSION['user']['courriel'] . "</a>";
                }
            ?>
        </div>

        <a href="logout.php">Me déconnecter</a>
    </div>

<?php
}

//$_SESSION = [];
var_dump($_SESSION);

?>

<header id="headerPage">
    <img src="assets/images/logo.svg" alt="PEZBroc" >
</header>

<nav>
    <ul>
        <li><a href="index.php" <?php if($title == "Accueil") { echo "class=\"active\"";} ?>>Accueil</a></li>
        <li><a href="contact.php" <?php if($title == "Contact") { echo "class=\"active\"";} ?>>Contact</a></li>
        <li><a href="brocanteurs.php" <?php if($title == "Brocanteurs") { echo "class=\"active\"";} ?>>Brocanteurs</a></li>
        <li><a href="objets.php" <?php if($title == "Objets") { echo "class=\"active\"";} ?>>Objets</a></li>

        <?php
            if(!isset($_SESSION['user']['loggedIn']) || !$_SESSION['user']['loggedIn']) {
                echo "<li><a href=\"inscription.php\"";

                if ($title == "M'inscrire") {
                    echo " class=\"active\"";
                }

                echo ">M'inscrire</a></li>";
            }
        ?>
    </ul>
</nav>
