document.addEventListener('DOMContentLoaded', function () {
    fetch('http://localhost:8081/api/notifications')
        .then(response => response.json())
        .then(data => {
            const tbody = document.getElementById('notification-tbody');
            tbody.innerHTML = ''; // Clear previous data

            data.forEach(notif => {
                const row = document.createElement('tr');

                row.innerHTML = `
                    <td>${notif.notificationID}</td>
                    <td>${notif.content}</td>
                    <td>${notif.status}</td>
                    <td>${new Date(notif.timeStamp).toLocaleString()}</td>
                `;

                tbody.appendChild(row);
            });
        })
        .catch(error => {
            console.error('Failed to load notifications:', error);
        });
});