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

document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("login-form-admin");

    form.addEventListener("submit", async function (e) {
        e.preventDefault(); // prevent default form action

        const email = document.getElementById("admin-email").value;
        const password = document.getElementById("admin-password").value;

        try {
            const response = await fetch("http://localhost:8081/api/administrators/login", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({
                    email: email,
                    password: password
                })
            });

            if (response.ok) {
                const data = await response.json();
                alert("Admin login successful!");
                window.location.href = "homePageAdmin.html";
            } else {
                alert("Invalid admin credentials. Try again.");
            }
        } catch (err) {
            alert("Error connecting to server.");
            console.error(err);
        }
    });
});

document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("login-form-supplier");

    form.addEventListener("submit", async function (e) {
        e.preventDefault(); // prevent default form action

        const email = document.getElementById("supplier-email").value;
        const password = document.getElementById("supplier-password").value;

        try {
            const response = await fetch("http://localhost:8081/api/suppliers/login", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ email, password })
            });

            if (response.ok) {
                const data = await response.json();
                alert("Supplier login successful!");
                window.location.href = "homePageSuppilerAfterLogin.html"; // change if needed
            } else {
                alert("Invalid supplier credentials. Try again.");
            }
        } catch (err) {
            alert("Error connecting to server.");
            console.error(err);
        }
    });
});