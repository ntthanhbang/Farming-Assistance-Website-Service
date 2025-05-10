document.addEventListener("DOMContentLoaded", () => {
    fetch("http://localhost:8081/api/inventoryitems") // Adjust the port if needed
        .then(response => response.json())
        .then(data => {
            const tableBody = document.getElementById("crop-table-body");
            tableBody.innerHTML = ""; // Clear existing rows

            data.forEach(item => {
                const row = document.createElement("tr");

                row.innerHTML = `
                    <td>${item.itemID}</td>
                    <td>${item.name}</td>
                    <td>${item.description}</td>
                    <td>${item.quantityAvailable}</td>
                    <td>${item.price}</td>
                `;

                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error("Error fetching inventory:", error));
});