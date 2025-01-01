<?php
if (!isset($_SESSION['loggedin']) || $_SESSION['loggedin'] !== true) {
    echo '<a href="login.php" id="loginButton">Me connecter</a>';
} else {
?>
    <div id="loggedin">
        <div id="userInfos">
            <img src="<?php echo $_SESSION['avatar']; ?>" alt="avatar">

            <?php
                if($_SESSION['role'] === 'broc') {
                    echo "<a href=\"espaceBrocanteur.php\">" . $_SESSION['email'] . "</a>";
                } else {
                    echo "<a href=\"espaceAdmin.php\">" . $_SESSION['email'] . "</a>";
                }
            ?>
        </div>

        <a href="logout.php">Me déconnecter</a>
    </div>

<?php
}
?>

<header id="headerPage">
    <img src="images/logo.svg" alt="PEZBroc" >
</header>

<nav>
    <ul>
        <li><a href="index.php" <?php if($title == "Accueil") { echo "class=\"active\"";} ?>>Accueil</a></li>
        <li><a href="contact.php" <?php if($title == "Contact") { echo "class=\"active\"";} ?>>Contact</a></li>
        <li><a href="brocanteurs.php" <?php if($title == "Brocanteurs") { echo "class=\"active\"";} ?>>Brocanteurs</a></li>
        <li><a href="objets.php" <?php if($title == "Objets") { echo "class=\"active\"";} ?>>Objets</a></li>

        <?php
            if(!isset($_SESSION['loggedin']) || $_SESSION['loggedin'] != true) {
                echo "<li><a href=\"inscription.php\"";

                if ($title == "M'inscrire") {
                    echo " class=\"active\"";
                }

                echo ">M'inscrire</a></li>";
            }
        ?>
    </ul>
</nav>
