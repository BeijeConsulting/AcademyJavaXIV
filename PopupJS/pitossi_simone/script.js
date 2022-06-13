console.log("collegato");


const app = document.getElementById("app")
let count = 0;


//LOGIN VARS
let emailLoginInput;
let passwordLoginInput;
let submitLogin;
let jsonLogin;

let emailLogin;
let passwordLogin;

//REGISTRATION VARS
let nameRegisterInput;
let surnameRegisterInput;
let emailConfirmRegisterInput;
let emailRegisterInput;
let passwordRegisterInput;
let submitRegister;
let jsonRegister;

let nameRegister;
let surnameRegister;
let emailRegister;
let emailConfirmRegister;
let passwordRegister;


showLoginModal();


async function showLoginResult() {
    jsonLogin = await signIn();
    console.log(jsonLogin);
    if (!jsonLogin.hasOwnProperty("message")) {
        const name = jsonLogin.email.substring(0, jsonLogin.email.indexOf("@"));
        app.innerHTML = "";
        app.innerHTML = `<div class="container d-flex justify-content-center align-items-center flex-column"> <h1> Bentornato ${name} </h1> <h2>Che la pace sia con te</h2></div>`;
    } else {
        const errorMessage = document.getElementById("submit_error");
        errorMessage.textContent = jsonLogin.message;
        errorMessage.classList.remove("d-none");
        setTimeout(() => {
            errorMessage.classList.add("d-none");
        }, 3000);
    }
}

async function signIn() {
    const response = await fetch('https://reservation-api.beije.it/signin', {
        method: 'POST',
        body: JSON.stringify({
            email: emailLogin,
            password: passwordLogin,
            userId: 1,
        }),
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
        },
    })

    return await response.json();
}

function showLoginModal() {
    app.innerHTML = "";

    app.innerHTML = `<div class="container d-flex justify-content-center align-items-center flex-column">
        <h1 class="py-3">LA NEWSLETTER SENZA NEWS</h1>
        <div id="submit_error" class="d-none alert alert-danger" role="alert"></div>
        <form id="login" class="w-25">
        <div class="text-center">
            <button class="btn m-3 btn-primary text-white" style="color: blue">Login</button>
            <button id="registration_login" type="submit" class="btn m-3 btn-light">Registrati</button>
        </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email address</label>
                <input type="email" class="form-control" id="email" name="email">
                <p class="invalid-feedback">Email non valida</p>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password">
            </div>
            <div class="text-center">
                <button id="submit_login" type="submit" class="btn btn-light">Accedi</button>
            </div>
        </form>
    </div>`;

    emailLoginInput = document.getElementById("email");
    passwordLoginInput = document.getElementById("password");
    submitLogin = document.getElementById("submit_login");
    submitRegister = document.getElementById("registration_login");

    addListenerLogin();
}

function addListenerLogin() {
    emailLoginInput.addEventListener("input", (event) => {
        emailLogin = event.target.value;
        if (!isValidEmail(emailLogin)) {
            emailLoginInput.classList.add("is-invalid");
        } else {
            emailLoginInput.classList.remove("is-invalid");
            emailLoginInput.classList.add("is-valid");
        }
    })

    passwordLoginInput.addEventListener("input", (event) => {
        passwordLogin = event.target.value;
    })

    submitLogin.addEventListener("click", (event) => {
        event.preventDefault();
        showLoginResult();
    })

    submitRegister.addEventListener("click", (event) => {
        event.preventDefault();
        showRegistrationModal();
    })
}

function showRegistrationModal() {
    app.innerHTML = "";

    app.innerHTML = `<div class="container d-flex justify-content-center align-items-center flex-column">
    <h1 class="py-3">REGISTRATI</h1>
    <div id="submit_error" class="d-none alert alert-danger" role="alert"></div>
    <form id="register" class="w-25">
    <div class="text-center">
    <button id="submit_login" type="submit" class="btn m-3 btn-light">Login</button>
            <button class="btn m-3 btn-primary text-white">Registrati</button>
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">Nome</label>
            <input type="name" class="form-control" id="name" name="name">
            <p class="invalid-feedback">Inserire almeno due caratteri</p>
        </div>
        <div class="mb-3">
            <label for="surname" class="form-label">Cognome</label>
            <input type="name" class="form-control" id="surname" name="surname">
            <p class="invalid-feedback">Inserire almeno due caratteri</p>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email address</label>
            <input type="email" class="form-control" id="email" name="email">
            <p class="invalid-feedback">Email non valida</p>
        </div>
        <div class="mb-3">
            <label for="email_confirm" class="form-label">Confirm Email address</label>
            <input type="email" class="form-control" id="email_confirm" name="email_confirm">
            <p class="invalid-feedback">Email differente e/o non valida</p>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" name="password">
            <p class="invalid-feedback">Password non valida, deve contenere MIN 8 caratteri con ALMENO 1 minuscola, 1 maiuscola, 1 numero ed un simbolo speciale</p>
        </div>
        <div class="text-center">
            
            <button id="registration_login" type="submit" class="btn btn-light">Registrati</button>
            <p class="invalid-feedback">Per registarti serve che tutti i campi sono validi</p>
        </div>
    </form>
</div>`;

    nameRegisterInput = document.getElementById("name");
    surnameRegisterInput = document.getElementById("surname");
    emailConfirmRegisterInput = document.getElementById("email_confirm");
    emailRegisterInput = document.getElementById("email");
    passwordRegisterInput = document.getElementById("password");
    submitLogin = document.getElementById("submit_login");
    submitRegister = document.getElementById("registration_login");

    addListenerRegister();
}

function addListenerRegister() {
    nameRegisterInput.addEventListener("input", (event) => {
        nameRegister = event.target.value;

        if ((nameRegister.length < 2)) {
            if (count = 5) {
                count -= 1;
            }
            nameRegisterInput.classList.add("is-invalid");
        } else {
            if (count < 5) {
                count += 1;
            }
            nameRegisterInput.classList.remove("is-invalid");
            nameRegisterInput.classList.add("is-valid");
        }
        console.log(nameRegister);
    })

    emailRegisterInput.addEventListener("input", (event) => {
        emailRegister = event.target.value;

        if (!isValidEmail(emailRegister)) {
            if (count = 5) {
                count -= 1;
            }
            emailRegisterInput.classList.add("is-invalid");
        } else {
            if (count < 5) {
                count += 1;
            }
            if (isValidConfirmedEmail(emailConfirmRegister)) {
                emailConfirmRegisterInput.classList.remove("is-invalid");
                emailConfirmRegisterInput.classList.add("is-valid");
            }
            emailRegisterInput.classList.remove("is-invalid");
            emailRegisterInput.classList.add("is-valid");
        }

        console.log(emailRegister);
    })

    emailConfirmRegisterInput.addEventListener("input", (event) => {
        emailConfirmRegister = event.target.value;

        if (!isValidConfirmedEmail(emailConfirmRegister)) {
            if (count = 5) {
                count -= 1;
            }
            emailConfirmRegisterInput.classList.add("is-invalid");
        } else {
            if (count < 5) {
                count += 1;
            }
            emailConfirmRegisterInput.classList.remove("is-invalid");
            emailConfirmRegisterInput.classList.add("is-valid");
        }

        console.log(emailConfirmRegister);
    })

    passwordRegisterInput.addEventListener("input", (event) => {
        passwordRegister = event.target.value;

        if (!isValidPassword(passwordRegister)) {
            if (count = 5) {
                count -= 1;
            }
            passwordRegisterInput.classList.add("is-invalid");
        } else {
            if (count < 5) {
                count += 1;
            }
            passwordRegisterInput.classList.remove("is-invalid");
            passwordRegisterInput.classList.add("is-valid");
        }

        console.log(passwordRegister);
    })

    surnameRegisterInput.addEventListener("input", (event) => {
        surnameRegister = event.target.value;

        if (surnameRegister.length < 2) {
            if (count = 5) {
                count -= 1;
            }
            surnameRegisterInput.classList.add("is-invalid");
        } else {
            if (count < 5) {
                count += 1;
            }
            surnameRegisterInput.classList.remove("is-invalid");
            surnameRegisterInput.classList.add("is-valid");
        }
        console.log(surnameRegister);
    })

    submitLogin.addEventListener("click", (event) => {
        event.preventDefault();
        showLoginModal();
    })

    submitRegister.addEventListener("click", (event) => {
        event.preventDefault();
        console.log(count);
        if (count == 5) {
            count == 0;
            submitRegister.classList.remove("is-invalid");
            submitRegister.classList.add("is-valid");
            showRegisterResult();
        } else {
            submitRegister.classList.add("is-invalid");
        }
    })
}


async function showRegisterResult() {
    jsonLogin = await register();
    console.log(jsonLogin);
    if (!jsonLogin.hasOwnProperty("message")) {
        const name = jsonLogin.email.substring(0, jsonLogin.email.indexOf("@"));
        app.innerHTML = "";
        app.innerHTML = `<div class="container d-flex justify-content-center align-items-center flex-column"> 
        <h1> Benvenuto ${name} </h1> 
        <h2>Che la pace sia con te</h2>
        <button id="submit_login" type="submit" class="btn m-3 btn-light">Login</button></div>
    `;
        submitLogin = document.getElementById("submit_login");

        addListenerResult()
    } else {
        const errorMessage = document.getElementById("submit_error");
        errorMessage.textContent = jsonLogin.message;
        errorMessage.classList.remove("d-none");
        setTimeout(() => {
            errorMessage.classList.add("d-none");
        }, 3000);
    }
}

function addListenerResult() {
    submitLogin.addEventListener("click", (event) => {
        event.preventDefault();
        showLoginModal();
    })
}

async function register() {
    const response = await fetch('https://reservation-api.beije.it/user/registration', {
        method: 'POST',
        body: JSON.stringify({
            name: nameRegister,
            surname: surnameRegister,
            email: emailRegister,
            password: passwordRegister,
            userId: 1,
        }),
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
        },
    })

    return await response.json();
}

function isValidEmail(email) {
    return /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email);
}

function isValidConfirmedEmail(email) {
    if ((email == emailRegister) && isValidEmail(email)) {
        return true;
    } else {
        return false;
    }
}

function isValidPassword(password) {
    return /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,16}$/.test(password);
}