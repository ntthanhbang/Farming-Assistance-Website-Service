function searchTable() {
    const input = document.getElementById("searchInput").value.toLowerCase();
    const rows = document.querySelectorAll("#transactionTable tbody tr");
  
    rows.forEach(row => {
      const cells = row.getElementsByTagName("td");
      let match = false;
      for (let cell of cells) {
        if (cell.textContent.toLowerCase().includes(input)) {
          match = true;
          break;
        }
      }
      row.style.display = match ? "" : "none";
    });
  }
  
  function addTransaction() {
    const transactionId = document.getElementById("transactionId").value;
  const transItemId = document.getElementById("transItemId").value; // NEW
  const itemId = document.getElementById("itemId").value;
  const quantity = document.getElementById("quantity").value;
  const farmerId = document.getElementById("farmerId").value;
  const supplierId = document.getElementById("supplierId").value;
  const paymentStatus = document.getElementById("paymentStatus").value;
  const timestamp = document.getElementById("timestamp").value;
  const paymentMethod = document.getElementById("paymentMethod").value;

  if (!transactionId || !transItemId || !itemId || !quantity || !farmerId || !supplierId || !paymentStatus || !timestamp || !paymentMethod) {
    alert("Please fill out all fields.");
    return;
  }

  const table = document.getElementById("transactionTable").getElementsByTagName("tbody")[0];
  const newRow = table.insertRow();

  [transactionId, transItemId, itemId, quantity, farmerId, supplierId, paymentStatus, timestamp, paymentMethod].forEach(text => {
    const cell = newRow.insertCell();
    cell.textContent = text;
  });

  // Clear form
  document.getElementById("transactionId").value = '';
  document.getElementById("transItemId").value = ''; // Clear transItemID
  document.getElementById("itemId").value = '';
  document.getElementById("quantity").value = '';
  document.getElementById("farmerId").value = '';
  document.getElementById("supplierId").value = '';
  document.getElementById("paymentStatus").value = '';
  document.getElementById("timestamp").value = '';
  document.getElementById("paymentMethod").value = '';
  }

  