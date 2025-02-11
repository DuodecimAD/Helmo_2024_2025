<?php

    $array = ["juste@gmail.com", "leblanc@hotmail.com", "harry@outlook.com",
                "auguste@hotmail.com", "leopold@gmail.com", "luc@gmail.com"];

    $count = [];
    for ($i = 0; $i < count($array); $i++) {
        $email = substr($array[$i], strpos($array[$i],"@"));
        if(!isset($count[$email])) {
            $count[$email] = 1;
        } else {
            $count[$email]++;
        }
    }

    echo "<ul>";
    foreach ($count as $key => $value) {
        echo "<li>$key : $value </li>";
    }   
    echo "</ul>";