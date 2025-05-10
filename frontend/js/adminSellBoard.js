document.addEventListener("DOMContentLoaded", function () {
    fetch("http://localhost:8081/api/advertisements")
        .then(response => {
            if (!response.ok) {
                throw new Error("Network response was not ok");
            }
            return response.json();
        })
        .then(data => {
            const tableBody = document.getElementById("advertisement-table-body");
            tableBody.innerHTML = ""; // Clear existing rows

            data.forEach(ad => {
                const row = document.createElement("tr");

                row.innerHTML = `
                    <td>${ad.advertisementId?.transactionId ?? ''}</td>
                    <td>${ad.advertisementId?.transactionItemId ?? ''}</td>
                    <td>${ad.itemId}</td>
                    <td>${ad.quantity}</td>
                    <td>${ad.farmerId}</td>
                    <td>${ad.supplierId}</td>
                    <td>${ad.paymentStatus}</td>
                    <td>${new Date(ad.timestamp).toLocaleString()}</td>
                    <td>${ad.paymentMethod}</td>
                `;

                tableBody.appendChild(row);
            });
        })
        .catch(error => {
            console.error("Error fetching advertisements:", error);
            alert("Failed to load advertisements.");
        });
});