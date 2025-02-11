<!DOCTYPE html>
<?php
const URL = 'http://www.helmo.be/page/35498';

?>
<html lang="fr">

<head>
    <meta charset="utf-8" />
    <title>Exe ressource</title>
</head>

<body>
<h1>Fonctions et chaines, Exe ressource</h1>
<p><?php echo "Url : " . URL; ?></p>

<?php
    $start = microtime(true); // Start time

    $ref = substr(URL, - strpos(strrev(URL), "/"));

    $end = microtime(true); // End time
    $executionTime = $end - $start;
    echo "Substr time: " . number_format($executionTime, 6) . " seconds";

    echo "<p> Dernière partie : $ref </p>";


    $start = microtime(true); // Start time
    $test = explode("/", URL);
    $end = microtime(true); // End time

    $executionTime = $end - $start;
    echo "Explode Time: " . number_format($executionTime, 6) . " seconds";
    $index = count($test) - 1;
    echo "<p>Dernière partie : $test[$index] </p>";

    ?>

</body>

</html>

