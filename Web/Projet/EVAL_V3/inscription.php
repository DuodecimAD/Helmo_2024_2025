<?php
session_start();

$emailExist = ['admin@admin.aa', 'broc@broc.aa'];

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $nom        = trim($_POST['nom'] ?? '');
    $prenom     = trim($_POST['prenom'] ?? '');
    $email      = filter_var(trim($_POST['email']) ?? '', FILTER_VALIDATE_EMAIL);
    $password   = trim($_POST['password'] ?? '');
    $passwordVerif   = trim($_POST['passwordVerif'] ?? '');
    $avatar     = $_FILES['avatar'] ?? null;
    $description = trim($_POST['description'] ?? '');
    $visible = $_POST['visible'] ?? 0;

    if ($nom === '') {
        $errorMessage = "Le nom semble incorrect.";
    } else if ($prenom === '') {
        $errorMessage = "Le prénom semble incorrect.";
    } else if (!$email) {
        $errorMessage = "Votre email n'est pas valide.";
    } else if (isset($emailExist[$email])){
        $errorMessage = "Cet email existe déjà.";
    } else if ($password !== $passwordVerif) {
        $errorMessage = "Votre mot de passe est différent.";
    } else if (!isset($_FILES['avatar']) || $_FILES['avatar']['error'] !== UPLOAD_ERR_OK) {
        $errorMessage = "Avatar semble incorrect.";


    } else {

        $tmpName = $_FILES['avatar']['tmp_name'];
       /* $fileExtension = pathinfo($_FILES['image']['name'], PATHINFO_EXTENSION);
        $newFileName = strtolower($nom . '_' . $prenom . '_avatar_' . mt_rand(1,9999) . '.' . $fileExtension);
        $uploadDir = 'images/avatars/';
        $uploadPath = $uploadDir . $newFileName;*/

        // Validate and move the file
        /*if (move_uploaded_file($tmpName, $uploadPath)) {
            echo "File uploaded successfully: $uploadPath";
        } else {
            echo "Error uploading file.";
        }*/

        $_SESSION = [
            'loggedin' => true,
            'email'    => $email,
            'avatar'   => '../images/inconnu.jpg',
            'role'     => 'broc'
        ];

        header("Location: espaceBrocanteur.php");
        exit;
    }
}
?>
<!DOCTYPE html>
<html lang="fr">

<?php
$title = "M'inscrire";
require_once("inc/head.inc.php");
?>

<body>
    <?php require_once("inc/header.inc.php"); ?>

    <main class="max-width">
        <h1>M'inscrire</h1>
        <form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']) ?>" enctype="multipart/form-data" method="post" id="inscription_form" class="boite">



            <div>
                <label for="nom">Nom *</label>
                <input type="text" name="nom" id="nom" required placeholder="Entrez votre nom"
                    <?php if(isset($nom)){ ?> value="<?php echo htmlspecialchars($nom) ?>"<?php } ?> >
                <!-- pattern="^[a-zA-Z'-]+$" title="Only letters, apostrophes, and hyphens are allowed." -->

                <label for="prenom">Prénom *</label>
                <input type="text" name="prenom" id="prenom" required placeholder="Entrez votre prénom"
                    <?php if(isset($prenom)){ ?> value="<?php echo htmlspecialchars($prenom) ?>"<?php } ?>
                >

                <label for="email">Email *</label>
                <input type="email" name="email" id="email" required placeholder="Entrez votre email"
                    <?php if(isset($email)){ ?> value="<?php echo htmlspecialchars($email) ?>"<?php } ?>
                >
            </div>

            <div>
                <img src="assets/images/inconnu.jpg" id="previewAvatar" alt="ajouter photo">
                <input type="file" name="avatar" id="avatar" accept="image/*" onchange="previewImage(event)">
            </div>

            <div>
                <div>
                    <label for="password">Mot de passe *</label>
                    <input type="password" name="password" id="password" class="mdp" required placeholder="Entrez votre mot de passe"
                        <?php if(isset($password)){ ?> value="<?php echo htmlspecialchars($password) ?>"<?php } ?>
                    >
                </div>
                <div>
                    <label for="passwordVerif">Vérification mot de passe *</label>
                    <input type="password" name="passwordVerif" id="passwordVerif" class="mdp" required placeholder="Répétez votre mot de passe"
                        <?php if(isset($passwordVerif)){ ?> value="<?php echo htmlspecialchars($passwordVerif) ?>"<?php } ?>
                    >
                </div>
            </div>

            <div>
                <label for="description">Description *</label>
                <textarea name="description" id="description" rows="17" cols="64" placeholder="Entrez votre description">
                    <?php if(isset($description)){ echo htmlspecialchars($description); } ?>
                </textarea>
            </div>

            <div>
                <label for="visible">Souhaiter-vous être visible sur le site, permettant ainsi aux
                    visiteurs de visualiser votre profil, ainsi que vos objets ?</label>
                <input type="checkbox" name="visible" id="visible" checked>
            </div>

            <div>
                <a href="index.php" class="annuler">Annuler</a>
                <button type="submit" name="submit">Valider</button>
                <a href="login.php" id="dejaCompte">Déjà un compte ?</a>
            </div>

            <?php if(isset($errorMessage)) {
                echo '<p style="height: 1.56rem;display: block;margin: auto;width: fit-content;padding: 0.62rem;background-color: #f68d8d;">' . htmlspecialchars($errorMessage) . '</p>';
                unset($errorMessage);
            }?>

        </form>
    </main>

    <?php require_once("inc/footer.inc.php"); ?>

</body>
</html>