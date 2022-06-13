let title = document.getElementById('title');
let errorMessage = document.getElementById('errorMessage');

let divName = document.getElementById('divName');
let divSurame = document.getElementById("divSurame");
let divEmail = document.getElementById('divEmail');
let divConfirmEmail = document.getElementById('divConfirmEmail');
let divPassword = document.getElementById('divPassword');

let name = document.getElementById('name');
let surname = document.getElementById('surname');
let email = document.getElementById('email');
let confirmEmail = document.getElementById('confirmEmail');
let password = document.getElementById('password');

let viewReg = document.getElementById('viewReg');
let viewLog = document.getElementById('viewLog');
let viewRegBtn = document.getElementById('viewRegBtn');
let viewLogBtn = document.getElementById('viewLogBtn');
let viewForBtn = document.getElementById('viewForBtn');
let viewPswInfo = document.getElementById('viewPswInfo');

function checkEmail(checkEmail) {
    if(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(checkEmail)) {
        return true;
    } else {
        return false;
    }
}

function checkPassword() {
    if(viewLogBtn.classList.contains('d-none')) {
        console.log('view log btn');
        if(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/.test(password.value)) {
            return true;
        } else if (password.value == ''){
            if(password.classList.contains('is-invalid')) {
                password.classList.remove('is-invalid');
            }
        } else {
            password.classList.add('is-invalid');
            return false;
        }
    }
}

function checkError() {
    if(!errorMessage.classList.contains('d-none')) {
        errorMessage.classList.add('d-none');
        errorMessage.innerHTML = "";
    }
}

function clearValue() {
    name.value = "";
    email.value = "";
    confirmEmail.value = "";
    password.value = "";
    name.classList.remove('is-invalid');
    password.classList.remove('is-invalid');
    email.classList.remove('is-invalid');
    confirmEmail.classList.remove('is-invalid');
    errorMessage.classList.add('d-none');
}

function viewPassword() {
    let viewPsw = document.getElementById('viewPsw');
    let hidePsw = document.getElementById('hidePsw');

    if(viewPsw.classList.contains('d-none')) {
        password.setAttribute('type', 'password');
        viewPsw.classList.remove('d-none');
        viewPsw.classList.add('d-block');
        hidePsw.classList.remove('d-block');
        hidePsw.classList.add('d-none');
    } else {
        password.setAttribute('type', 'text');
        viewPsw.classList.remove('d-block');
        viewPsw.classList.add('d-none');
        hidePsw.classList.remove('d-none');
        hidePsw.classList.add('d-block');
    }
}

function viewRegister() {
    title.innerHTML = 'Register';
    clearValue();
    if(divPassword.classList.contains('d-none')) {
        divPassword.classList.remove('d-none');
    }
    if(!viewForBtn.classList.contains('d-none')) {
        viewForBtn.classList.add('d-none');
    }
    divName.classList.remove('d-none');
    divSurname.classList.remove("d-none");
    divConfirmEmail.classList.remove('d-none');
    viewLog.classList.remove('d-none');
    viewReg.classList.add('d-none');
    viewLogBtn.classList.add('d-none');
    viewRegBtn.classList.remove('d-none');
    viewRegBtn.classList.add('d-flex');
    viewPswInfo.classList.remove('d-none');
}

function viewLogin() {
    title.innerHTML = 'Login';
    clearValue();
    if(divPassword.classList.contains('d-none')) {
        divPassword.classList.remove('d-none');
    }
    if(!viewForBtn.classList.contains('d-none')) {
        viewForBtn.classList.add('d-none');
    }
    divName.classList.add('d-none');
    divSurname.classList.add("d-none");
    divConfirmEmail.classList.add('d-none');
    viewReg.classList.remove('d-none');
    viewLog.classList.add('d-none');
    viewLogBtn.classList.remove('d-none');
    viewLogBtn.classList.add('d-flex');
    viewRegBtn.classList.add('d-none');
    viewPswInfo.classList.add('d-none');
}

function viewForgotPsw() {
    title.innerHTML = 'Forgot password';
    clearValue();
    if(!viewPswInfo.classList.contains('d-none')) {
        viewPswInfo.classList.add('d-none');
    }
    divName.classList.add('d-none');
    divSurname.classList.add("d-none");
    divConfirmEmail.classList.add('d-none');
    divPassword.classList.add('d-none');
    viewRegBtn.classList.add('d-none');
    viewLogBtn.classList.add('d-none');
    viewForBtn.classList.remove('d-none');
    viewForBtn.classList.add('d-flex');
}

function login() {
    let emailTmp = checkEmail(email.value);
    if(emailTmp) {
        let result;
        const json = JSON.stringify({ email: email.value, password: password.value });
        axios.post("https://reservation-api.beije.it/signin", json, {
            headers: {
                "Content-Type": "application/json",
            },
        })
        .then((resp) => {
            alert("<-- Login succesfull! -->");
            clearValue();
        })
        .catch((resp) => {
            console.clear();
            errorMessage.classList.remove("d-none");
            errorMessage.innerHTML = resp.response.data.message;
        });
    } else {
        errorMessage.classList.remove('d-none');
        if(!emailTmp) {
            email.classList.add('is-invalid');
            errorMessage.innerHTML = " - Email invalid";
        }
    }
}

function register() {
    let nameTmp = name.value.length >= 3; 
    let surnameTmp = surname.value.length >= 3;
    let emailTmp = checkEmail(email.value);
    let pswTmp = checkPassword();
    let confirmEmailTmp = (email.value === confirmEmail.value);
    if(emailTmp && pswTmp && confirmEmailTmp && nameTmp && surnameTmp) {
        const json = JSON.stringify({
            name: name.value,
            surname: surname.value,
            email: email.value,
            password: password.value,
        });
        console.log(json);
        axios.post("https://reservation-api.beije.it/user/registration", json, {
            headers: {
                "Content-Type": "application/json",
            },
        })
        .then((resp) => {
            alert("<-- Registration succesfull! -->");
            clearValue();
        })
        .catch((resp) => {
            console.clear();
            errorMessage.classList.remove("d-none");
            errorMessage.innerHTML = resp.response.data.message;
        });
    } else {
        errorMessage.classList.remove('d-none');
        if (!surnameTmp) {
            surname.classList.add("is-invalid");
            errorMessage.innerHTML = " - Surname invalid";
        }
        if(!nameTmp) {
            name.classList.add('is-invalid');
            errorMessage.innerHTML += " - Name invalid";
        }
        if(!emailTmp) {
            email.classList.add('is-invalid');
            errorMessage.innerHTML += " - Email invalid";
        }
        if(!emailTmp || !confirmEmailTmp) {
            confirmEmail.classList.add('is-invalid');
            errorMessage.innerHTML += " - Confirm email invalid";
        }
        if(!pswTmp) {
            errorMessage.innerHTML += " - Password invalid";
            password.classList.add('is-invalid');
        }
    }
}

function forgotPassword() {
    let emailTmp = checkEmail(email.value);

    if(emailTmp) {

    } else {
        errorMessage.classList.remove('d-none');
        errorMessage.innerHTML = "- Email invalid";
        email.classList.add('is-invalid');
    }
}