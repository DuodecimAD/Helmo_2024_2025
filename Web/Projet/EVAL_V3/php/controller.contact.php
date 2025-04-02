<?php
session_start();

require_once $_SERVER['DOCUMENT_ROOT'] . '/php/utils.php';

if($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['submit'])){

    // à remplir, déjà test avec mon email
    $adminEmail = 'no-reply@pezbroc.aa';

    $sujetEmail = filter_var(nettoyage_to_db($_POST['email'] ?? ''), FILTER_VALIDATE_EMAIL);
    $sujet      = nettoyage_to_db($_POST['sujet'] ?? '') ;
    $content    = nettoyage_to_db($_POST['message'] ?? '') ;

    if (!$sujetEmail) {
        $errorMessage = "L'email semble incorrect.";
    } else if ($sujet === '') {
        $errorMessage = "Le sujet semble incorrect.";
    } else if ($content === '') {
        $errorMessage = "Le message semble incorrect.";
    } else {

        $to      = $adminEmail;
        $subject = "Re: $sujetEmail" ;
        $message = "
                    <html>
                    <head>
                        <title>HTML email</title>
                    </head>
                    <body>
                        <div style='padding: 20px;'>
                            <p>---------------------------</p>
                            <h1>En provenance de la page contact de PEZBroc</h1>
                            <p>From : $sujetEmail</p>
                            <p>---------------------------</p>
                            <p>Message :</p>
                            <p>$content</p>
                        </div>
                    </body>
                    </html>
                    ";

        $headers = "MIME-Version: 1.0" . "\r\n";
        $headers .= "Content-type:text/html;charset=UTF-8" . "\r\n";
        $headers .= "From: no-reply@helmo.be" . "\r\n";
        $headers .= 'Cc: ' . $sujetEmail . "\r\n";
        $headers .= "Reply-To: no-reply@helmo.be" . "\r\n";
        $headers .= 'X-Mailer: PHP/' . phpversion() . "\r\n";

        if(mail($to, $subject, $message, $headers)){
            $success = true;
        } else {
            $errorMessage = "Votre mail n'a pas pu être envoyé. Contactez un administrateur ...";
        }
    }
}