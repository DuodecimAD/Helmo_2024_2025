<!DOCTYPE html>
<html lang="fr">
<head>

    <meta charset="utf-8">
    <title>base2</title>

</head>

<body>
    <ul>
        <?php

        for ($i = 0; $i <= 100; $i+=2) {
            echo '<li>' . $i . '</li>';
        }

        ?>
    </ul>
</body>
</html>