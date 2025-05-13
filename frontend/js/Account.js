async function fetchAccounts(endpoint, tableId) {
      try {
        const res = await fetch(`http://localhost:8081/api/${endpoint}`);
        const data = await res.json();

        const tbody = document.getElementById(tableId).querySelector("tbody");
        tbody.innerHTML = "";

        data.forEach(account => {
  const row = document.createElement("tr");
  row.innerHTML = `
    <td>${account.farmerID || account.supplierID || "N/A"}</td>
    <td>${account.fullName || account.name || account.username || "N/A"}</td>
    <td>${account.address || "N/A"}</td>
    <td>${account.phone || account.phoneNumber || "N/A"}</td>
    <td>${account.email || "N/A"}</td>
  `;
  tbody.appendChild(row);
});

      } catch (error) {
        console.error(`Failed to load ${endpoint}:`, error);
      }
    }

    fetchAccounts("suppliers", "suppliersTable");
    fetchAccounts("farmers", "farmersTable");