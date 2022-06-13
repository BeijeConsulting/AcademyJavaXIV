
const app = document.getElementById("app");
// app.style.display = "none";

//LOGIN VARS
let emailLoginInput;
let passwordLoginInput;
let submitLogin;
let jsonLogin;

let emailLogin;
let passwordLogin;


//REGISTRATION VARS
let nameRegisterInput
let emailConfirmRegisterInput
let emailRegisterInput;
let passwordRegisterInput;
let submitRegister;
let jsonRegister

let nameRegister;
let emailRegister;
let passwordRegister;

let changeForm;

// FLOW
showLoginModal();




///////////FUNCTIONS///////////////

async function showLoginResult() {
   jsonLogin = await signin();
   console.log(jsonLogin);
   if (!jsonLogin.hasOwnProperty("message")) {
      const name = jsonLogin.email.substring(0, jsonLogin.email.indexOf("@"));
      app.innerHTML = "";
      app.innerHTML = `<div class="container d-flex justify-content-center align-items-center flex-column">
                        <h1>Bentornato ${name}</h1>
                        <h2>Che la pace sia con te</h2>
                     </div>`
   } else {
      const errorMessage = document.getElementById("submit_error");
      errorMessage.textContent = jsonLogin.message;
      errorMessage.classList.remove("d-none");
      setTimeout(() => {
         errorMessage.classList.add("d-none");
      }, 3000);
   }
}

async function showRegisterResult() {
   jsonRegister = await register();
   console.log(jsonRegister);
   if (!jsonRegister.hasOwnProperty("message")) {
      app.innerHTML = "";
      app.innerHTML = `<div class="container d-flex justify-content-center align-items-center flex-column">
                        <h1>Controlla la mail di conferma</h1>
                        <h2>Che la pace sia con te</h2>
                     </div>`
   } else {
      const errorMessage = document.getElementById("submit_error");
      errorMessage.textContent = jsonLogin.message;
      errorMessage.classList.remove("d-none");
      setTimeout(() => {
         errorMessage.classList.add("d-none");
      }, 3000);
   }
}

async function signin() {
   const response = await fetch('https://reservation-api.beije.it/signin', {
      method: 'POST',
      body: JSON.stringify({
         email: emailLogin,
         password: passwordLogin
      }),
      headers: {
         'Content-type': 'application/json; charset=UTF-8',
      },
   });

   return await response.json();
}

async function register() {
   const fullName = splitFullName();
   const response = await fetch('https://reservation-api.beije.it/user/registration', {
      method: 'POST',
      body: JSON.stringify({
         name: fullName[0],
         surname: fullName[1],
         email: emailRegister,
         password: passwordRegister
      }),
      headers: {
         'Content-type': 'application/json; charset=UTF-8',
      },
   });

   return await response.json();
}

function showLoginModal() {

   app.innerHTML = "";

   app.innerHTML = `<div class="container d-flex justify-content-center align-items-center flex-column">
                     <h1 class="py-3">Accedi</h1>
                     <div id="submit_error" class="d-none alert alert-danger" role="alert"></div>
                     <form id="login" class="w-25">
                        <div class="mb-3">
                           <label for="email" class="form-label">Email address</label>
                           <input type="email" class="form-control" id="email" name="email">
                        </div>
                        <div class="mb-3">
                           <label for="password" class="form-label">Password</label>
                           <input type="password" class="form-control" id="password" name="password">
                        </div>
                        <div class="text-center">
                           <button id="submit_login" type="submit" class="btn btn-light">Accedi</button>
                        </div>
                        <div class="text-center">
                           <span>- oppure -</span>
                           <h5 id="change_form">Registrati</h5>
                        </div>
                     </form>
                  </div>`;

   emailLoginInput = document.getElementById("email");
   passwordLoginInput = document.getElementById("password");
   submitLogin = document.getElementById("submit_login");
   changeForm = document.getElementById("change_form");

   addListenerLogin();
}

function showRegisterModal() {

   app.innerHTML = "";

   app.innerHTML = `<div class="container d-flex justify-content-center align-items-center flex-column">
                     <h1 class="py-3">Registrati</h1>
                     <form id="register" class="w-25">				
                        <div class="mb-3">
                           <label for="name" class="form-label">Nome</label>
                           <input type="name" class="form-control" id="name" name="name">
                        </div>
                        <div class="mb-3">
                           <label for="email" class="form-label">Email address</label>
                           <input type="email" class="form-control" id="email" name="email">
                        </div>
                        <div class="mb-3">
                           <label for="email_confirm" class="form-label">Confirm Email address</label>
                           <input type="email" class="form-control" id="email_confirm" name="email_confirm">
                        </div>
                        <div class="mb-3">
                           <label for="password" class="form-label">Password</label>
                           <input type="password" class="form-control" id="password" name="password">
                        </div>
                        <div class="text-center">
                           <button id="submit_register" type="submit" class="btn btn-light">Registrati</button>
                        </div>
                        <div class="text-center">
                           <span>- oppure -</span>
                           <h5 id="change_form">Accedi</h5>
                        </div>
                     </form>
                  </div>`;

   nameRegisterInput = document.getElementById("name");
   emailRegisterInput = document.getElementById("email")
   emailConfirmRegisterInput = document.getElementById("email_confirm");
   passwordRegisterInput = document.getElementById("password");
   submitRegister = document.getElementById("submit_register");
   changeForm = document.getElementById("change_form")

   addListenerRegister();
}

function addListenerLogin() {
   emailLoginInput.addEventListener("input", (event) => {
      emailLogin = event.target.value;
   })
   
   passwordLoginInput.addEventListener("input", (event) => {
      passwordLogin = event.target.value;
   })

   changeForm.addEventListener("click", (event) => {
      event.preventDefault();
      showRegisterModal();
   })

   submitLogin.addEventListener("click", (event) => {
      event.preventDefault();
      showLoginResult();
   })
}

function addListenerRegister() {
   nameRegisterInput.addEventListener("input", (event) => {
      nameRegister = event.target.value;
   })
   
   emailRegisterInput.addEventListener("input", (event) => {
      emailRegister = event.target.value;
   })

   emailConfirmRegisterInput.addEventListener("input", (event) => {
      if(event.target.value != emailRegister) {
         console.log("email differnti, controlla meglio");
      }
   })

   passwordRegisterInput.addEventListener("input", (event) => {
      passwordRegister = event.target.value;
   })

   changeForm.addEventListener("click", (event) => {
      event.preventDefault();
      showLoginModal();
   })

   submitRegister.addEventListener("click", (event) => {
      event.preventDefault();
      showRegisterResult();
   })
}

function splitFullName() {
   console.log(nameRegister.split(" "));
   return nameRegister.split(" ");
}