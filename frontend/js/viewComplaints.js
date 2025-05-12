document.addEventListener('DOMContentLoaded', function () {
    fetch('http://localhost:8081/api/complaints')
        .then(response => response.json())
        .then(data => {
            const reviewedBody = document.getElementById('reviewed-complaints-body');
            const unreviewedBody = document.getElementById('unreviewed-complaints-body');

            reviewedBody.innerHTML = '';
            unreviewedBody.innerHTML = '';

            data.forEach(complaint => {
                const row = document.createElement('tr');

                row.innerHTML = `
                    <td>${complaint.complaintID || ''}</td>
                    <td>${complaint.subject || ''}</td>
                    <td>${complaint.content || ''}</td>
                    <td>${complaint.status || ''}</td>
                    <td>${complaint.timestamp || ''}</td>
                `;

                if (complaint.status && complaint.status.toUpperCase() === 'REVIEWED') {
                    reviewedBody.appendChild(row);
                } else {
                    unreviewedBody.appendChild(row);
                }
            });
        })
        .catch(error => {
            console.error('Error fetching complaints:', error);
        });
});