<?php

$countries = [
    "Belgique"  => ["capitale" => "Bruxelles", "population" => 11520000, "superficie" => 30528],
    "France"    => ["capitale" => "Paris", "population" => 68400000, "superficie" => 638475],
    "Allemagne" => ["capitale" => "Berlin", "population" => 83440000, "superficie" => 357569],
    "Italie"    => ["capitale" => "Rome", "population" => 59000000, "superficie" => 302079],
];
?>


<ul>
    <?php
        foreach ($countries as $country => $info) {
            echo "<li><strong>$country</strong>";
            echo "<ul>";
                foreach ($info as $name => $value) {
                    echo "<li><em>".strtoupper(substr($name,0,1)). substr($name,1)."</em> : $value</li>";
                }
            echo "</ul>";
        }
    ?>
</ul>