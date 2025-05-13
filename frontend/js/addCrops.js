document.getElementById("add-product-button").addEventListener("click", async () => {
    const name = document.getElementById("name").value;
    const description = document.getElementById("description").value;
    const quantityAvailable = parseFloat(document.getElementById("quantityAvailable").value);
    const price = parseFloat(document.getElementById("price").value);

    const crop = { name, description, quantityAvailable, price };

    try {
        const response = await fetch("http://localhost:8081/api/inventoryitems", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(crop)
        });

        if (!response.ok) throw new Error("Failed to add crop");

        alert("Crop added successfully!");
        window.location.href = "sellCrops.html"; // Redirect to view table
    } catch (error) {
        console.error("Error adding crop:", error);
        alert("Error occurred while adding crop.");
    }
});