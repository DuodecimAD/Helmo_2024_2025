<?php

$array = [
            "Belgique" => "Bruxelles",
            "Italie" => "Rome",
            "France" => "Paris",
            "Espagne" => "Madrid",
            "Allemagne" => "Berlin"
        ];

?>

    <ul>

    <?php

        foreach ($array as $key => $value) {
            if(in_array(substr($key,0,1), ['A','E','Y','U','I','O'])){
                $det = "l'";
            }else {
                $det = "la ";
            }
            echo "<li>$value est la capitale de $det".strtoupper($key)."</li>";
        }
    ?>

    </ul>
