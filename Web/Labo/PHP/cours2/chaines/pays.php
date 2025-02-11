<?php
const NBR_PAYS = 4;
$pays1 = 'Belgique';
$capitale1 = 'Bruxelles';
$pays2 = 'France';
$capitale2 = 'Paris';
$pays3 = 'Italie';
$capitale3 = 'Rome';
$pays4 = 'Allemagne';
$capitale4 = 'Berlin';
?>
<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="utf-8" />
    <title>Pays</title>
</head>

<body>
<h1>Fonctions et chaines : pays / ville</h1>
    <?php

    for ($i = 1; $i <= NBR_PAYS; $i++) {
        $pays = 'pays'.$i;
        $capitale = 'capitale'.$i;
        echo "Ville : ". $$pays ." / Capitale : ". $$capitale ." <br>";
    }

    ?>
</body>

</html>