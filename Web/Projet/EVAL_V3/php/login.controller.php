<?php
session_start();
require_once $_SERVER['DOCUMENT_ROOT'] . '/models/User.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $email = filter_var(trim($_POST['email']) ?? '', FILTER_VALIDATE_EMAIL);
    $password = trim($_POST['password'] ?? '');

    $user = new User();
    $user_data = $user->findUser($email, $message);

    if (!$email) {
        $errorMessage = "Votre email n'est pas valide.";
    } else if ($user_data === null) {
        $errorMessage = "Votre email n'existe pas.";
    } else if ($user_data->getMotPasse() !== $password) {
        $_SESSION['user'] = [
            'courriel'      => $user_data->getCourriel()
        ];
        $errorMessage = "Votre mot de passe est incorrect.";
    } else {

        $_SESSION['user'] = [
            'loggedIn'      => true,
            'nom'           => $user_data->getNom(),
            'prenom'        => $user_data->getPrenom(),
            'courriel'      => $user_data->getCourriel(),
            'photo'         => $user_data->getPhoto(),
            'description'   => $user_data->getDescription(),
            'est_Visible'   => $user_data->estVisible(),
            'emplacement'   => $user_data->getEid(),
            'est_administrateur' => $user_data->estAdministrateur()
        ];

        unset($errorMessage);
        header("Location: " . ($_SESSION['user']['est_administrateur'] ? "espaceAdmin.php" : "espaceBrocanteur.php"));
        exit;
    }

}