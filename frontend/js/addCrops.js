document.getElementById('add-product-button').addEventListener('click', async () => {
    const name = document.getElementById('name').value.trim();
    const category = document.getElementById('category').value.trim();
    const price = parseFloat(document.getElementById('price').value.trim());

    if (!name || !category || isNaN(price)) {
        alert("Please fill in all fields correctly.");
        return;
    }

    const item = {
        name: name,
        category: category,
        price: price
    };

    try {
        const response = await fetch('http://localhost:8081/api/inventoryitems', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item)
        });

        if (response.ok) {
            alert("Crop added successfully!");
            // Optionally redirect or clear fields
            document.getElementById('name').value = '';
            document.getElementById('category').value = '';
            document.getElementById('price').value = '';
        } else {
            alert("Failed to add crop.");
        }
    } catch (error) {
        console.error("Error adding crop:", error);
        alert("Error occurred while adding crop.");
    }
});