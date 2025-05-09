document.addEventListener('DOMContentLoaded', () => {
    const chatBox = document.getElementById('chat-box');
    const chatInput = document.getElementById('chat-input');
    const sendButton = document.getElementById('send-button');
  
    // Function to append message to chat box
    function appendMessage(message, sender) {
      const messageElement = document.createElement('div');
      messageElement.classList.add('chat-message');
      messageElement.textContent = `${sender}: ${message}`;
      chatBox.appendChild(messageElement);
      chatBox.scrollTop = chatBox.scrollHeight;
    }
  
    // Send message
    function sendMessage() {
      const message = chatInput.value.trim();
      if (message !== '') {
        const sender = window.location.pathname.includes('FarmerChat.html') ? 'Farmer' : 'Supplier';
        appendMessage(message, sender);
        // Store message in localStorage to simulate sending to other chat box
        localStorage.setItem('chat-message', JSON.stringify({ message, sender }));
        chatInput.value = '';
      }
    }
  
    sendButton.addEventListener('click', sendMessage);
  
    chatInput.addEventListener('keypress', (e) => {
      if (e.key === 'Enter') {
        sendMessage();
      }
    });
  
    // Listen for messages from other chat box
    window.addEventListener('storage', (e) => {
      if (e.key === 'chat-message') {
        const { message, sender } = JSON.parse(e.newValue);
        // Prevent echoing the message in the same chat box
        const currentSender = window.location.pathname.includes('FarmerChat.html') ? 'Farmer' : 'Supplier';
        if (sender !== currentSender) {
          appendMessage(message, sender);
        }
      }
    });
  });