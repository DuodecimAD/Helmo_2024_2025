<?php

const PHRASE = "Aujourd'hui, nous allons faire du kayak sur la Lesse avec Anna.";

/**
 * retourne si mot est un palindrome (= son inverse ex: kayak)
 *
 * @param $mot mot à check
 * @return bool est un palindrome ou non
 */
function isPalindrome($mot) {
    if($mot == strrev($mot)) {
        return true;
    } else {
        return false;
    }
}

/**
 *
 * affiche les mots d'une phrase qui sont des palindromes
 * @param $phrase phrase dans laquelle rechercher les palindromes
 * @return void affiche les palindromes trouvés
 */
function motExtractor($phrase) {
    $mots = explode(" ", str_replace([',', '.'],"", $phrase));
    $full = "";
    for ($i = 0; $i < count($mots); $i++) {
        if(isPalindrome(strtolower($mots[$i]))) {
            if($full != ""){
                $full .= " et ";
            }
            $full .= $mots[$i] . " ";
        }
    }
    echo $full;
}

motExtractor(PHRASE);

