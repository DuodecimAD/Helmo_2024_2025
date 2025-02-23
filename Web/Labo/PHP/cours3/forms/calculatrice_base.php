<?php

session_start();


if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (isset($_POST['btn_submit'])) {

        $nbr1 = isset($_POST['nbr1']) ? filter_var(trim($_POST['nbr1']), FILTER_VALIDATE_INT) : false;
        $nbr2 = isset($_POST['nbr2']) ? filter_var(trim($_POST['nbr2']), FILTER_VALIDATE_INT) : false;
        $operation = isset($_POST["operation"]) ? htmlspecialchars(trim($_POST["operation"]), ENT_QUOTES) : '';

        echo "<br>";
        echo '$nbr1 : ' . $nbr1 . ', type : ' . gettype($nbr1);
        echo "<br>";
        echo '$nbr2 : ' . $nbr2 . ', type : ' . gettype($nbr2);
        echo "<br>";
        echo $operation;
        echo "<br>";

        // Store valid values in session (for form persistence)
        $_SESSION['nbr1_ok'] = $nbr1 !== false ? $nbr1 : '';
        $_SESSION['nbr2_ok'] = $nbr2 !== false ? $nbr2 : '';

        $result = calculer($nbr1, $nbr2, $operation);
    }
}

/**
 * Calcul du résultat
 * @param int $nbr1 : premier nombre
 * @param int $nbr2 : deuxième nombre
 * @param string $operation : opération à effectuer
 * @return float|string résultat de l'opération ou message d'erreur
 */
function calculer($nbr1, $nbr2, $operation): float|string
{
    if ($nbr1 === false) {
        return "Veuillez remplir un nombre valide pour le nombre 1";
    }
    if ($nbr2 === false) {
        return "Veuillez remplir un nombre valide pour le nombre 2";
    }
    if ($nbr2 === 0 && $operation === '/') {
        return "Division par 0 impossible.";
    }

    switch ($operation) {
        case '+':
            return $nbr1 + $nbr2;
        case '-':
            return $nbr1 - $nbr2;
        case '*':
            return $nbr1 * $nbr2;
        case '/':
            return $nbr1 / $nbr2;
        default:
            return "Invalid operation";
    }
}

var_dump($_POST);

?>

<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculatrice Simple</title>
</head>

<body>
<header>
    <h1>Calculatrice Simple</h1>
</header>
<main>
    <section>
        <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post">
            <input type="text" name="nbr1" placeholder="Nombre 1" value="<?php echo isset($_SESSION['nbr1_ok']) ? $_SESSION['nbr1_ok'] : ''; ?>" />
            <select name="operation">
                <option value="+" <?php if(isset($operation) && $operation == "+") echo "selected"; ?>>+</option>
                <option value="-" <?php if(isset($operation) && $operation == "-") echo "selected"; ?>>-</option>
                <option value="*" <?php if(isset($operation) && $operation == "*") echo "selected"; ?>>*</option>
                <option value="/" <?php if(isset($operation) && $operation == "/") echo "selected"; ?>>/</option>
            </select>
            <input type="text" name="nbr2" placeholder="Nombre 2" value="<?php echo isset($_SESSION['nbr2_ok']) ? $_SESSION['nbr2_ok'] : ''; ?>" />
            <input type="submit" name="btn_submit" value="Calculer" />
        </form>
    <p>Résultat = <?php if(isset($result)){ echo $result; } ?></p>

    </section>
</main>
</body>

</html>