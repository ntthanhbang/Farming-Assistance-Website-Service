document.getElementById('submit-complaint').addEventListener('click', function () {
    const complaintID = document.getElementById('complaint-id').value;
    const subject = document.getElementById('complaint-subject').value;
    const content = document.getElementById('complaint-content').value;
    const farmer = document.getElementById('complaint-farmerID').value;
    // const timestamp = document.getElementById('complaint-timestamp').value;

    if (!complaintID || !subject || !content || !farmer) {
        alert('Please fill in all fields');
        return;
    }

    const complaint = {
        // complaintID: complaintID,
        // subject: subject,
        // content: content,
        // timestamp: timestamp,
        // status: 'Unreviewed' // Force status to Unreviewed

        subject: subject,
        content: content,
        farmer: { farmerID: farmer }, // Assuming a nested structure with FarmerID
        status: 'unreviewed' // Backend will handle setting this
        // timestamp: new Date().toISOString() // You can omit this if backend handles it
    };

    
console.log('Complaint Data:', complaint);
console.log('Sending Complaint:', JSON.stringify(complaint));


    fetch('http://localhost:8081/api/complaints', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(complaint)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to submit complaint');
        }
        return response.json();
    })
    .then(() => {
        alert('Complaint submitted successfully');
        location.reload(); // Reload to update the unreviewed table
    })
    .catch(error => {
        console.error('Error submitting complaint:', error);
        alert('Error submitting complaint');
    });
});
