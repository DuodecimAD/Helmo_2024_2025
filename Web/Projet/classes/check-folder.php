<?php
$folderPath = "../";
$files = array_diff(scandir($folderPath), array('.', '..'));
$fileDetails = [];

foreach ($files as $file) {
    $filePath = $folderPath . '/' . $file;
    $fileDetails[] = [
        'file' => $file,
        'lastModified' => filemtime($filePath),
    ];
}

echo json_encode($fileDetails);
