<!DOCTYPE html>
<html lang="fr">
<head>

    <meta charset="utf-8">
    <title>Defi</title>
    <style>
        body {
            width: 960px;
            display: flex;
            gap: 10px;
            flex-wrap: wrap;
            margin: 50px auto;
            justify-content: space-between
        }
        figure{
            width: 11%;
            margin: 0;
            text-align: center;
            font: italic 0.8em sans-serif;
        }
        .color{
            width: 100%;
            height: 50px;
            border: 1px solid black;
        }
    </style>
</head>

<body>

    <?php
    const MAX_COLOR = 225;
    const STEP_COLOR = 75;

    $index_color = 1;
    $color = "";

    for($r = 0; $r < MAX_COLOR+1; $r=$r+STEP_COLOR){
            if($r == MAX_COLOR) {
                $r = 255;
            }
            for($g = 0; $g < MAX_COLOR+1; $g=$g+STEP_COLOR){
                if($g == MAX_COLOR) {
                    $g = 255;
                }
                for($b = 0; $b < MAX_COLOR+1; $b=$b+STEP_COLOR){
                    if($b == MAX_COLOR) {
                        $b = 255;
                    }
                    $color = sprintf("#%02x%02x%02x", $r, $g, $b);
                    echo '<figure>';
                    echo '<div class="color" style="background-color: ' . $color . ';"></div>';
                    echo '<figcaption>Ref: #'. $index_color .'</figcaption>';
                    echo '</figure>';
                    $index_color++;
                }
        }
    }


    ?>

</body>
</html>