<?php
// Get the requested path
$path = parse_url($_SERVER["REQUEST_URI"], PHP_URL_PATH);
$fullPath = __DIR__ . $path;

// If the path is a directory, list the contents
if (is_dir($fullPath)) {
    $files = scandir($fullPath);
    echo "<h1>Index of $path</h1><ul>";
    foreach ($files as $file) {
        if ($file !== "." && $file !== "..") {
            echo "<li><a href=\"$path/$file\">$file</a></li>";
        }
    }
    echo "</ul>";
    exit;
}

// If the file exists, serve it
if (file_exists($fullPath)) {
    return false; // Let PHP handle the request
}

// Otherwise, return a 404
http_response_code(404);
echo "404 Not Found";
?>
