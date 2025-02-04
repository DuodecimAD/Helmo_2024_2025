<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Posts :: Urbanic</title>
    <link rel="stylesheet" href="css/urban.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
        href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
        rel="stylesheet">
</head>

<body>
    <header>
        Mon header
    </header>
    <main class="centrage" id="conteneurMain">
        <h1>Welcome to Urbanic Design </h1>
        <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Eius architecto ad, sapiente facere
            nihil unde.Lorem ipsum dolor sit, amet consectetur adipisicing elit. Eius architecto ad, sapiente facere
            nihil unde.Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam, optio aspernatur? Odio
            accusamus incidunt exercitationem labore dolorem deleniti, autem explicabo expedita, nam eos enim maxime
            quos saepe excepturi tempore quae.</p>
        <section id="posts" class="containeurFlexWrap">
            <h2 class="basis100">All posts</h2>

            <?php
                for ($i = 1; $i < 10; $i++) {
                echo '
                    <article class="containeurFlexWrap">
                        <figure>
                            <img src="img/urban/blog-image-'.$i.'.jpg" alt="bureau">
                        </figure>
                        <div>
                            <h3>Graphic Design</h3>
                            <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Eius architecto ad, unde. </p>
                        </div>
        
                    </article>
                    ';
                }
            ?>
            
            
        </section>
    </main>
    <footer>
        @Helmo 2025
    </footer>
</body>

</html>