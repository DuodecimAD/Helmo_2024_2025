<?php

$date = mktime(11, 30, 0, 03, 12, 1984);

echo "<strong>" . date('l', $date) . "</strong>";
if (date('w', $date) == 0 || date('w', $date) == 6) {
    echo " : Jour de week-end";
} else {
    echo " : Jour de semaine";
}