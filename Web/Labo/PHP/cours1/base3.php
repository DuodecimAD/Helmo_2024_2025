<!DOCTYPE html>
<html lang="fr">
<head>

    <meta charset="utf-8">
    <title>base3</title>

</head>

<body>

    <?php

    do {
        $var = rand(0, 100);
    } while ($var % 9 != 0);
    echo '<strong>' . $var . '</strong><br>';

    do {
        $var = rand(0, 100);
        echo ($var % 9 == 0) ? '<strong>' . $var . '</strong><br>' : '';

    } while ($var % 9 != 0);


    ?>

    <p>Fin du programme</p>

</body>
</html>