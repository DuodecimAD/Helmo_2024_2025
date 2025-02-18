<?php
$email = "test@example.com";
var_dump(filter_var($email, FILTER_VALIDATE_EMAIL));

$email = "test@example";
var_dump(filter_var($email, FILTER_VALIDATE_EMAIL));