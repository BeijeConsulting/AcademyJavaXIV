let loginTitle = null;
let registerTitle = null;
let forgotTitle = null;

let fieldPasswordEye = null;
let confirmPasswordEye = null;

let showFieldPassword = null;
let hideFieldPassword = null;

let loginButton = null;
let registerButton = null;
let forgotButton = null;
let openLoginButton = null;
let openRegisterButton = null;
let openForgotButton = null;

let nome = null;

let confirmPassword = null;
let confirmEmail = null;

let passwordMatching = null;
let minCharacters = null;
let minNumbers = null;
let minUppercase = null;
let minSpecial = null;


document.addEventListener('DOMContentLoaded', function() {
    console.log("START");
    initialize();
}, false);

function initialize () {
    this.loginTitle = document.getElementById("loginTitle");
    this.registerTitle = document.getElementById("registerTitle");
    this.forgotTitle = document.getElementById("forgotTitle");
    this.loginButton = document.getElementById("loginButton");
    this.registerButton = document.getElementById("registerButton");
    this.forgotButton = document.getElementById("forgotButton");
    this.openLoginButton = document.getElementById("openLoginButton");
    this.openRegisterButton = document.getElementById("openRegisterButton");
    this.openForgotButton = document.getElementById("openForgotButton");
    this.fieldPassword = document.getElementById("fieldPassword");
    this.confirmPassword = document.getElementById("confirmPassword");
    this.confirmEmail = document.getElementById("confirmEmail");
    
    this.nome = document.getElementById("nome");

    this.fieldPasswordEye = document.getElementById("fieldPasswordEye");
    this.confirmPasswordEye = document.getElementById("confirmPasswordEye");

    this.showFieldPassword = document.getElementById("showFieldPassword");
    this.hideFieldPassword = document.getElementById("hideFieldPassword");

    this.showPasswordId = document.getElementById("showPassword");
    this.hidePasswordId = document.getElementById("hidePassword");

    this.passwordMatching = document.getElementById("passwordMatching");
    this.minCharacters = document.getElementById("minCharacters");
    this.minNumbers = document.getElementById("minNumbers");
    this.minUppercase = document.getElementById("minUppercase");
    this.minSpecial = document.getElementById("minSpecial");

    //TITLE
    this.loginTitle.style.display = "flex";
    this.registerTitle.style.display = "none";
    this.forgotTitle.style.display = "none";

    //BUTTONS
    this.loginButton.style.display = "flex";
    this.registerButton.style.display = "none";
    this.forgotButton.style.display = "none";
    this.openLoginButton.style.display = "none";
    this.openRegisterButton.style.display = "flex";
    this.openForgotButton.style.display = "flex";

    //FIELDS
    //password
    this.fieldPassword.style.display = "flex";
    this.confirmPassword.style.display = "none";

    this.showFieldPassword.style.display = "flex";
    this.hideFieldPassword.style.display = "none";

    this.passwordMatching.style.display = "none";
    this.minCharacters.style.display = "none";
    this.minUppercase.style.display = "none";
    this.minSpecial.style.display = "none";

    //email
    this.confirmEmail.style.display = "none";

    //nome
    this.nome.style.display = "none";
}

function login() {
    let email = document.getElementById("inputFieldEmail").value;
    let password = document.getElementById("fieldPasswordEye").value;

    if (email == "")
    {
        alert("Email can't be blank.");
        return;
    }

    if (password == "")
    {
        alert("Password can't be blank.");
        return;
    }

    if (!checkEmail(email))
    {
        alert("Email not valid");
        return;
    }

    console.log(email);
    console.log(password);

    //CHIAMATA API
    const json = JSON.stringify({ email: email, password: password });
    console.log(json);
    axios.post('https://reservation-api.beije.it/signin', json, {
        headers: {
            'Content-Type': 'application/json',
        },
    })
    .then((resp) => {
        console.log(resp);
        alert("SUCCESS LOGIN");
    })
    .catch((resp) => {
        console.log(resp);
        alert("FAILED LOGIN");
    });
}

function register() {
    let email = document.getElementById("inputFieldEmail").value;
    let emailConfirm = document.getElementById("inputConfirmEmail").value;
    let password = document.getElementById("fieldPasswordEye").value;
    let passwordConfirm = document.getElementById("confirmPasswordEye").value;
    let name = document.getElementById("inputNome").value;
    let surname = "test";

    if (email == "" || emailConfirm == "")
    {
        alert("Email can't be blank.");
        return;
    }

    if (email != emailConfirm)
    {
        alert("Email can't be different.");
        return;
    }

    if (!checkEmail(email))
    {
        alert("Email not valid");
        return;
    }

    if (name == "")
    {
        alert("Name can't be blank.");
        return;
    }

    if (password == "" || passwordConfirm == "")
    {
        alert("Password can't be blank.");
        return;
    }

    if (password != passwordConfirm || !checkLength(password) || !checkNumber(password) || !checkUppercase(password) || !checkSpecial(password))
    {
        alert("Password doesn't respect the criteria");
        return;
    }

    console.log(email);
    console.log(emailConfirm);
    console.log(password);    
    console.log(passwordConfirm);

    //CHIAMATA API
    const json = JSON.stringify({ name: name, surname: surname, email: email, password: password });
    console.log(json);
    axios.post('https://reservation-api.beije.it/user/registration', json, {
        headers: {
            'Content-Type': 'application/json',
        },
    })
    .then((resp) => {
        console.log(resp);
        alert("SUCCESS REGISTRATION");
    })
    .catch((resp) => {
        console.log(resp);
        alert("FAILED REGISTRATION");
    });
}

function forgotPassword() {
    let email = document.getElementById("inputFieldEmail").value;

    if (email == "")
    {
        alert("Email can't be blank.");
        return;
    }

    if (!checkEmail(email))
    {
        alert("Email not valid");
        return;
    }
    
    alert("GOOD");

    console.log(email);

    //CHIAMATA API
}


//FORMS

function openLogin() {
    //TITLE
    this.loginTitle.style.display = "flex";
    this.registerTitle.style.display = "none";
    this.forgotTitle.style.display = "none";

    //BUTTONS
    this.loginButton.style.display = "flex";
    this.registerButton.style.display = "none";
    this.forgotButton.style.display = "none";
    this.openLoginButton.style.display = "none";
    this.openRegisterButton.style.display = "flex";
    this.openForgotButton.style.display = "flex";

    //FIELDS
    //password
    this.fieldPassword.style.display = "flex";
    this.confirmPassword.style.display = "none";
    this.fieldPasswordEye.value = "";
    this.confirmPasswordEye.value = "";
    this.hidePassword();
    this.checkPassword();

    this.passwordMatching.style.display = "none";
    this.minCharacters.style.display = "none";
    this.minNumbers.style.display = "none";
    this.minUppercase.style.display = "none";
    this.minSpecial.style.display = "none";

    //email
    this.confirmEmail.style.display = "none";
    document.getElementById("inputConfirmEmail").value = "";

    //nome
    this.nome.style.display = "none";
    document.getElementById("inputNome").value = "";
}

function openRegister() {
    //TITLE
    this.loginTitle.style.display = "none";
    this.registerTitle.style.display = "flex";
    this.forgotTitle.style.display = "none";

    //BUTTONS
    this.loginButton.style.display = "none";
    this.registerButton.style.display = "flex";
    this.forgotButton.style.display = "none";
    this.openLoginButton.style.display = "flex";
    this.openRegisterButton.style.display = "none";
    this.openForgotButton.style.display = "flex";

    //FIELDS
    //password
    this.fieldPassword.style.display = "flex";
    this.confirmPassword.style.display = "flex";
    this.fieldPasswordEye.value = "";
    this.confirmPasswordEye.value = "";
    this.hidePassword();
    this.checkPassword();

    this.passwordMatching.style.display = "list-item";
    this.minCharacters.style.display = "list-item";
    this.minNumbers.style.display = "list-item";
    this.minUppercase.style.display = "list-item";
    this.minSpecial.style.display = "list-item";

    //email
    this.confirmEmail.style.display = "flex";
    document.getElementById("inputConfirmEmail").value = "";    

    //nome
    this.nome.style.display = "flex";
    document.getElementById("inputNome").value = "";
}

function openForgotPassword() {
    //TITLE
    this.loginTitle.style.display = "none";
    this.registerTitle.style.display = "none";
    this.forgotTitle.style.display = "flex";

    //BUTTONS
    this.loginButton.style.display = "none";
    this.registerButton.style.display = "none";
    this.forgotButton.style.display = "flex";
    this.openLoginButton.style.display = "flex";
    this.openRegisterButton.style.display = "flex";
    this.openForgotButton.style.display = "none";

    //FIELDS
    //password
    this.fieldPassword.style.display = "none";
    this.confirmPassword.style.display = "none";
    this.fieldPasswordEye.value = "";
    this.confirmPasswordEye.value = "";
    this.hidePassword();
    this.checkPassword();

    this.passwordMatching.style.display = "none";
    this.minCharacters.style.display = "none";
    this.minNumbers.style.display = "none";
    this.minUppercase.style.display = "none";
    this.minSpecial.style.display = "none";

    //email
    this.confirmEmail.style.display = "none";
    document.getElementById("inputConfirmEmail").value = "";    

    //nome
    this.nome.style.display = "none";
    document.getElementById("inputNome").value = "";
}

//PASSWORD

function showPassword() {
    this.fieldPasswordEye.type = "text";
    this.confirmPasswordEye.type = "text";

    this.showFieldPassword.style.display = "none";
    this.hideFieldPassword.style.display = "flex";
}

function hidePassword() {
    this.fieldPasswordEye.type = "password";
    this.confirmPasswordEye.type = "password";

    this.showFieldPassword.style.display = "flex";
    this.hideFieldPassword.style.display = "none";
}

function checkPassword() {
    let password = document.getElementById("fieldPasswordEye").value;
    let passwordConfirm = document.getElementById("confirmPasswordEye").value;

    if (password === passwordConfirm && password != "") this.passwordMatching.style.color = "green";      //MATCHING
    else this.passwordMatching.style.color = "black";

    if (checkLength(password)) this.minCharacters.style.color = "green";      //MIN CHAR
    else this.minCharacters.style.color = "black";

    if (checkNumber(password)) this.minNumbers.style.color = "green";      //MIN CHAR
    else this.minNumbers.style.color = "black";

    if (checkUppercase(password)) this.minUppercase.style.color = "green";      //MIN UPPERCASE
    else this.minUppercase.style.color = "black";

    if (checkSpecial(password)) this.minSpecial.style.color = "green";      //MIN SPECIAL
    else this.minSpecial.style.color = "black";
}

function checkLength(password) {
    if (password.length >= 8) return true;

    return false;
}

function checkNumber(password) {
    let numberCaseRegex = new RegExp("[\\d]+");

    if (numberCaseRegex.test(password)) return true;

    return false;
}

function checkUppercase(password) {
    let upperCaseRegex = new RegExp("[A-Z]+");

    if (upperCaseRegex.test(password)) return true;

    return false;
}

function checkSpecial(password) {
    let specialCaseRegex = new RegExp("[_\\-*@!$&]+");

    if (specialCaseRegex.test(password)) return true;

    return false;
}

function checkEmail(email) {
    let emailRegex = new RegExp("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$");

    if (emailRegex.test(email)) return true;

    return false;
}