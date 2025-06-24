<?php
function nettoyage_to_db($data): string
{
    return htmlspecialchars(trim($data), ENT_QUOTES, 'UTF-8');
}

function nettoyage_from_db($data): string
{
    return htmlspecialchars_decode(trim($data), ENT_QUOTES);
}