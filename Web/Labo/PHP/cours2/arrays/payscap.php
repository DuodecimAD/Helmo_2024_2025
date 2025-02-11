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
            echo "<li>$key : $value</li>";
        }
    ?>

    </ul>
