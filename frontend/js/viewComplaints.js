document.addEventListener('DOMContentLoaded', function () {
    fetch('http://localhost:8081/api/complaints')
        .then(response => response.json())
        .then(data => {
            const tableBody = document.getElementById('complaints-table-body');
            tableBody.innerHTML = ''; // Clear existing rows

            data.forEach(complaint => {
                const row = document.createElement('tr');

                row.innerHTML = `
                    <td>${complaint.complaintID || ''}</td>
                    <td>${complaint.subject || ''}</td>
                    <td>${complaint.content || ''}</td>
                    <td>${complaint.status || ''}</td>
                    <td>${complaint.timestamp || ''}</td>
                `;

                tableBody.appendChild(row);
            });
        })
        .catch(error => {
            console.error('Error fetching complaints:', error);
        });
});