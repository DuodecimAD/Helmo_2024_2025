<?php

//foreach ($_POST as $key => $value) {
//    unset($_POST[$key]);
//}

//$_POST = [];

var_dump($_POST);


if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (isset($_POST['btn_submit'])) {

        $nbr1 = isset($_POST['nbr1']) ? filter_var(trim($_POST['nbr1']), FILTER_VALIDATE_INT) : false;
        $nbr2 = isset($_POST['nbr2']) ? filter_var(trim($_POST['nbr2']), FILTER_VALIDATE_INT) : false;
        $operation = isset($_POST["operation"]) ? htmlspecialchars(trim(($_POST["operation"])), ENT_QUOTES) : '';
        echo "<pre>";
        echo $nbr1;
        echo $nbr2;
        echo $operation;
        echo "</pre>";

        if($nbr1 == false){
            $result = "veuillez remplir un nombre valide pour le nombre 1";
        } else if ($nbr2 == false) {
            $result = "veuillez remplir un nombre valide pour le nombre 2";
        } else if ($nbr2 == '0' && $$operation == '/'){
            $result = "Division par 0 impossible.";
        } else {
            $result = calculer($nbr1, $nbr2, $operation);
        }

    }
}

function calculer($nbr1, $nbr2, $operation) {
    switch ($operation) {
        case '+':
            return $nbr1 + $nbr2;
        case '-':
            return $nbr1 - $nbr2;
        case '*':
            return $nbr1 * $nbr2;
        case '/':
            if ($nbr2 != 0) {
                return $nbr1 / $nbr2;
            } else {
                return "Error: Division by zero";
            }
        default:
            return "Invalid operation";
    }
}

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
        <div>

        </div>
        <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post">
            <input type="text" name="nbr1" placeholder="Nombre 1" value="" />
            <select name="operation">
                <option value="+">+</option>
                <option value="-">-</option>
                <option value="X">X</option>
                <option value="/">/</option>
            </select>
            <input type="text" name="nbr2" placeholder="Nombre 2" value="" />
            <input type="submit" name="btn_submit" value="Calculer" />
        </form>
    <p>Résultat = <?php echo $result; ?></p>

    </section>
</main>
</body>

</html>