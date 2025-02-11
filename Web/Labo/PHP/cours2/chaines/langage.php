<!DOCTYPE html>
<?php
const MOT = 'PHP';
const NOUVEAU_MOT = 'Javascript';
const PHRASE = 'Le langage PHP n\'est pas compilé, le PHP est interprété.';

$mots = explode(" ",PHRASE);
?>
<html lang="fr">

<head>
    <meta charset="utf-8" />
    <title>Langage</title>
</head>

<body>
<h1>Fonctions et chaines.</h1>
<h2>Phrase</h2>
<p><?php
    $nombre_php = 0;
    for ($i = 0; $i < count($mots); $i++) {
        if($mots[$i] == MOT){
            $nombre_php++;
        }
    }
    echo "Il y a $nombre_php occurence(s) de <em>" . MOT . "</em> dans la phrase <em>" . PHRASE;
    echo "<br>";

    $new_nombre = substr_count(PHRASE, MOT);
    echo "Avec substr_count() : Il y a $new_nombre occurence(s) de <em>" . MOT . "</em> dans la phrase <em>" . PHRASE;  ?>
</p>
<h2>Phrase transformée</h2>
<p><?php
    $nouvelleChaine = str_replace(MOT, NOUVEAU_MOT, PHRASE);
    echo $nouvelleChaine;  ?>
</p>
</body>

</html>