// Get the modal
var modal = document.getElementById("myModal");

//Get the subscribe modal
var subModal = document.getElementById("subModal");

//Get the forgot psw modal
var forgotModal = document.getElementById("forgotPsw");

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the button that opens the modal
var subBtn = document.getElementById("subBtn");

// Get the button for the login
var logBtn = document.getElementById("logBtn");

// Get the button for psw forgot
var forgotBtn = document.getElementById("forgotBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];



//Implementing regex
const re = /^(?:\d{3}|\(\d{3}\))([-\/\.])\d{3}\1\d{4}$/;

logBtn.onclick = function () {
    var email = document.getElementById("email");
    var psw = document.getElementById("password");
    if (checkMail(email.value)) {
        let result = null;
        const json = JSON.stringify({ email: email.value, password: psw.value });
        axios.post('https://reservation-api.beije.it/signin', json, {
            headers: {
                'Content-Type': 'application/json',
            },
        })
            .then((resp) => {
                console.log(resp);
            })
            .catch((resp) => {
                alert(resp);
                console.log("Response: " + resp.response.data.message);
                this.result = resp.response.data.message;
            })
    }
    else {
        alert("Email sbagliata");
    }
}

// When the user clicks the button, open the modal 
btn.onclick = function () {
    modal.style.display = "flex";
}

//Open subscribe pop up
subBtn.onclick = function () {
    subModal.style.display = "flex";
    modal.style.display = "none";
}

// When the user clicks the button, open the modal 
forgotBtn.onclick = function () {
    forgotModal.style.display = "flex";
}


// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

function logIn(email, password) {

}

function checkMail(mail) {
    if ((/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/).test(mail)) {
        return true;
    }
    else {
        return false;
    }
}

function checkPassword(password) {
    if ((/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/).test(password)) {
        return true;
    }
    else {
        return false;
    }
}

function showPsw() {
    var oldPsw = document.getElementById("oldPsw");
    var newPsw = document.getElementById("newPsw");
    var psw = document.getElementById("password");
    var subPassword = document.getElementById("subPassword");
    var checkBox = document.getElementById("showPsw-1");
    var checkBoxPsw = document.getElementById("showPsw-2");
    var checkBoxSignUp = document.getElementById("showPsw-3");

    if (checkBoxSignUp.checked) {
        subPassword.type = "text";
    }
    else {
        subPassword.type = "password";
    }

    if (checkBoxPsw.checked) {
        oldPsw.type = "text";
        newPsw.type = "text";

    }
    else {
        oldPsw.type = "password";
        newPsw.type = "password";
    }
    if (checkBox.checked) {
        psw.type = "text";
    }
    else {
        psw.type = "password";
    }
}

function returnToLogin() {
    modal.style.display = "flex";
    subModal.style.display = "none";
    forgotModal.style.display = "none";
}

function subscribe() {
    var name = document.getElementById("name").value;
    var surname = document.getElementById("surname").value;
    var email = document.getElementById("subMail").value;
    var password = document.getElementById("subPassword").value;
    var correct = true;

    if (!checkMail(email)) {
        alert("Email inserita non valida.");
        correct = false;
    }
    if (!checkPassword(password)) {
        correct = false;
        alert("Password inserita non valida. Una password deve contenere almeno 8 caratteri tra cui 1 carattere speciale, 1 lettera maiuscola e 1 numero");
    }
    if (correct) {
        const json = JSON.stringify({ name: name, surname: surname, email: email, password: password });
        console.log(json);
        axios.post('https://reservation-api.beije.it/user/registration', json, {
            headers: {
                'Content-Type': 'application/json',
            },
        })
            .then((resp) => {
                console.log(resp);
            })
            .catch((resp) => {
                console.log(resp);
            });
    }


}
