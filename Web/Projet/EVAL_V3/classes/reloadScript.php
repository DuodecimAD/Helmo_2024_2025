<script>
    let previousHash = null;

    setInterval(async () => {
        try {
            const response = await fetch("http://localhost/classes/check-folder.php");
            const currentHash = await response.text();

            if (previousHash && currentHash !== previousHash) {
                location.reload(); // Reload the page if the folder has changed
            }
            if (performance.memory) {
                const { usedJSHeapSize, totalJSHeapSize, jsHeapSizeLimit } = performance.memory;

                console.log(`Used JS Heap Size: ${(usedJSHeapSize / 1024 / 1024).toFixed(2)} MB`);
            } else {
                console.log("The performance.memory API is not supported on this browser.");
            }
            previousHash = currentHash; // Update the hash for the next check
        } catch (error) {
            console.error("Error checking folder:", error);
        }
    }, 1000);
</script>
