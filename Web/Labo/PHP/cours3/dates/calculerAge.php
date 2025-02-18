<?php
echo "today : " . date('d-m-Y');
echo "<br>annif : " . date('d-m-Y', strtotime('12-03-1984'));
echo "secondes depuis 1970 : " . date('d-m-Y');

$age = strtotime(date('d-m-Y H:i')) - strtotime('12-03-1984 11:30');

$years = floor($age / 60 / 60 / 24 / 365.25);
$rest = $age % (60 * 60 * 24 * 365.25);

$days = floor($rest / (60 * 60 * 24));
$rest = $rest % (60 * 60 * 24);

$hours = floor($rest / (60 * 60));
$rest %= (60 * 60);

$minutes = floor($rest / 60);
$seconds = $rest % 60;

//echo "<br>age : " . $age / (60 * 60 *24 * 365.25);
echo "<br>age : $years ans, $days jours, $hours heures, $minutes minutes et $seconds secondes";

echo "<br><br>TEST : secondes depuis 1970 : " . strtotime('30-12-1969');