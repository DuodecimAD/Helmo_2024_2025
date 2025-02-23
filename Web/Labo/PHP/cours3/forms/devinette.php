<?php

session_start();

// variables init
const MAX_TRIES = 10;

if ($_SERVER["REQUEST_METHOD"] == "POST") {

    if (isset($_POST['new_game'])){
        newGame();
    } else if (isset($_POST['btn_submit'])){
        $nombre = isset($_POST['nombre'])  && $_POST['nombre'] !== '' ? filter_var(trim($_POST['nombre']), FILTER_VALIDATE_INT, ['options' => ['min_range' => 1, 'max_range' => 100]]) : false;
        if ($nombre !== false) {
            if (isset($_SESSION['tries'])){

                $existe = false;
                foreach ($_SESSION['tries'] as $key => $value) {
                    if ($nombre === $value) {
                        $existe = true;
                        break;
                    }
                }

                if ($existe) {
                    $_SESSION['message'] = "Vous avez déjà utilisé ce nombre !";

                } else {
                    $_SESSION['tries'][] = $nombre;
                    $_SESSION['countdown']--;

                    if ($nombre === $_SESSION['magic_number'] && $_SESSION['countdown'] >= 0) {
                        $_SESSION['message'] = '<strong>Bravo ! Vous avez trouvé le nombre mystère : ' . $_SESSION['magic_number'] . '</strong>';
                        $_SESSION['game_over'] = true;
                    } else if ($_SESSION['countdown'] <= 0) {
                        $_SESSION['message'] = 'Dommage, vous n\'avez pas trouvé le numéro mystère <strong>"' .$_SESSION['magic_number'].'"</strong> avant le nombre d\'essais maximum (' . MAX_TRIES . ").";
                        $_SESSION['game_over'] = true;
                    } else if ($nombre > $_SESSION['magic_number']){
                        $_SESSION['message'] = "Le nombre mystère est plus petit que $nombre";
                    } else if ($nombre < $_SESSION['magic_number']){
                        $_SESSION['message'] = "Le nombre mystère est plus grand que $nombre";
                    }
                }

            } else {
                $_SESSION['tries'][] = $nombre;
                $_SESSION['countdown']--;

                if ($nombre === $_SESSION['magic_number']){
                    $_SESSION['message'] = '<strong>Bravo ! Vous avez trouvé le nombre mystère : ' . $_SESSION['magic_number'] . '</strong>';
                    $_SESSION['game_over'] = true;
                } else if ($nombre > $_SESSION['magic_number']){
                    $_SESSION['message'] = "Le nombre mystère est plus petit que $nombre";
                } else if ($nombre < $_SESSION['magic_number']){
                    $_SESSION['message'] = "Le nombre mystère est plus grand que $nombre";
                }
            }
        }
    }

}

function newGame(): void {
    $_SESSION = [];
    $_SESSION['countdown'] = MAX_TRIES;
    $_SESSION['magic_number'] = mt_rand(1,100);
    $_SESSION['game_over'] = false;
    $_SESSION['tries'] = [];
}

/*
echo '<br>';
var_dump($_SESSION);
echo '<br>';

// reset button -- debug
if (isset($_POST['reset'])) {
    $_SESSION = [];
    resetPage();
}
*/
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Devinette</title>
</head>

<body>
    <header>
        <h1>Devinette</h1>
    </header>

    <main>
        <section>
            <?php

                if (isset($_SESSION['countdown'])){

                    if (!empty($_SESSION['tries'])){
                        $last_number = $_SESSION['tries'][count($_SESSION['tries'])-1];

                        echo '<p>' . $_SESSION['message'] . '</p>';
                        if ($_SESSION['game_over']){
                            echo '<br>';
                            echo '<form action="' . htmlspecialchars($_SERVER['PHP_SELF']) . '" method="POST">';
                            echo '<input type="submit" name="new_game" value="Nouvelle partie" />';
                            echo '</form>';
                        } else {
                            echo '<form action="' . htmlspecialchars($_SERVER['PHP_SELF']) . '" method="POST">';
                            echo '<label for="nombre">Entrez un nombre : </label>';
                            echo '<input type="text" id="nombre" name="nombre" placeholder="Nombre" autofocus value="" />';
                            echo '<input type="submit" name="btn_submit" value="Jouer" />';
                            echo '</form>';

                            echo '<p>Tentatives précédentes : ';
                            /*foreach ($_SESSION['tries'] as $key => $value) {
                                echo $value;
                                if ($key != array_key_last($_SESSION['tries'])) {
                                    echo ", ";
                                }
                            }*/
                            echo implode(", ", $_SESSION['tries']) ;
                            echo '</p>';

                            echo '<p>' . $_SESSION['countdown'] . ' tentatives restantes</p>';
                        }

                    } else {
                        echo "<p>Commencez la partie en entrant un nombre entre 1 et 100 ci-dessous.</p>";

                        echo '<form action="' . htmlspecialchars($_SERVER['PHP_SELF']) . '" method="POST">';
                        echo '<label for="nombre">Entrez un nombre : </label>';
                        echo '<input type="text" id="nombre" name="nombre" placeholder="Nombre" autofocus value="" />';
                        echo '<input type="submit" name="btn_submit" value="Jouer" />';
                        echo '</form>';
                    }

                } else{
                    echo '<form action="' . htmlspecialchars($_SERVER['PHP_SELF']) . '" method="POST">';
                        echo '<input type="submit" name="new_game" value="Nouvelle partie" />';
                    echo '</form>';
                }

            ?>

        </section>

        <!--
        <form method="post">
            <button type="submit" name="reset">Reset</button>
        </form>
        -->
    </main>
</body>

</html>
