document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("login-form");

    form.addEventListener("submit", async function (e) {
        e.preventDefault(); // stop form from redirecting

        const email = document.getElementById("email").value;
        const password = document.getElementById("password").value;

        try {
            const response = await fetch("http://localhost:8081/api/farmers/login", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ email, password })
            });

            if (response.ok) {
                const data = await response.json();
                alert("Login successful!");
                // Redirect to farmer homepage
                window.location.href = "homePageFarmer.html";
            } else {
                alert("Invalid credentials. Try again.");
            }
        } catch (err) {
            alert("Error connecting to server.");
            console.error(err);
        }
    });
});
