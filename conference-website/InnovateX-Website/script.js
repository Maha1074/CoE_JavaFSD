document.getElementById("registrationForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent form from submitting normally

    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phone").value;
    let eventDay = document.getElementById("event").value;

    if (name && email && phone && eventDay) {
        alert("Registration successful!\n\nName: " + name + "\nEmail: " + email + "\nPhone: " + phone + "\nEvent Day: " + eventDay);
        document.getElementById("registrationForm").reset();
    } else {
        alert("Please fill in all the required fields.");
    }
});
