<?php

    $name = $_POST["name"];
    $email = $_POST["email"];
    $message = $_POST["message"];

    $EmailTo = "email@domain.com"; // Rensignez votre email pour que ça fonctionne
    $Subject = "Nouveau message reçu";

    // Préparation du mail à envoyer
    $Body .= "Nom : ";
    $Body .= $name;
    $Body .= "\n";

    $Body .= "Email : ";
    $Body .= $email;
    $Body .= "\n";

    $Body .= "Message : ";
    $Body .= $message;
    $Body .= "\n";

    // Envoi de l'email
    $success = mail($EmailTo, $Subject, $Body, "From:".$email);

    // Redirection vers la page en cas de succès ou pas
    if ($success) {
        echo "success";
    } else {
        echo "invalid";
    }

?>