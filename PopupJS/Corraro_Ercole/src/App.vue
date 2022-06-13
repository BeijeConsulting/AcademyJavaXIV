<script>
export default {
  name: "App",
  data() {
    return {
      name: "",
      surname: "",
      email: "", //string
      emailConfirm: "", //string
      emailCheck: true, //bool
      password: "", //string
      passwordConfirm: "", //string
      passwordCheck: true, //bool
      confirmPasswordCheck: true, //bool
      forgottenPassword: false, //bool
      registrazione: false //bool
    }
  }, methods: {
    sendLogin() {
      if(!this.validazioneEmail() ){
        alert("Formato email errato!");
        return false;
      }
      //fare chiamata a DB con richiesta email
      let result = null;
      const json = JSON.stringify({email: this.email, password: this.password});
      axios.post('https://reservation-api.beije.it/signin', json, {
        headers: {
          'Content-Type': 'application/json'
        }
      }).then((resp) => {
        result = resp.data;
        console.log(result);
      }).catch((resp) => {
        result = resp.data;
        alert("Wrong email/password!");
      })
    }, changePswVisibility() {
      let x = document.getElementById("inputPassword");
      let y = document.getElementById("inputPasswordConfirm");
      if (x != null && x.type == "password") {
        x.type = "text";
      } else if(x != null){
        x.type = "password";
      }
      if (y != null && y.type == "password") {
        y.type = "text";
      } else if(y != null){
        y.type = "password";
      }
    },
    validazioneEmail() {
      // recupero il valore della email indicata nel form
      // se non ho inserito nulla nel campo
      if (this.email == '') { alert("Devi indicare un indirizzo email"); return false; }
      // verifico se è un indirizzo valido
      if ((/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/).test(this.email)) {
        return true;
      }
      else {
        alert("L'indirizzo email che hai inserito non e' valido");
        return false;
      }
      
    },
    validazionePassword() {
      // se non ho inserito nulla nel campo
      if (this.password == '') { return false; }
      // password deve contenere dagli 8 ai 50 caratteri, deve contenere almeno una lettera minuscola, una lettera maiuscola,
      // un numero e un carattere speciale (@$!%*#?&.,:;)
      if ((/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&.,:;])[A-Za-z\d@$!%*#?&.,:;]{8,}$/).test(this.password)) {
        //password inserita ha formato corretto
        this.passwordCheck = true;
        return true;
      }
      else {
        //password inserita NON ha formato corretto
        this.passwordCheck = false;
        return false;
      }
    },
    startRegister() {
      this.registrazione = !this.registrazione;
      this.password = "";
    },
    sendRegistration() {
      //inserire controllo se email già presente nel DB
      
      if (!this.validazioneEmail()) {
        alert("Formato email non valido!");
        return false;
      }
      if(this.email != this.emailConfirm){
        alert("Email diversa da email conferma!");
        return false;
      }
      if (!this.validazionePassword()) {
        alert("Formato password non valido!");
        return false;
      }
      if(this.password != this.passwordConfirm){
        alert("Password diversa da password conferma!");
        return false;
      }
      let result = null;
      const json = JSON.stringify({ name: this.name, surname: this.surname, email: this.email, password: this.password });
        console.log(json);
        axios.post('https://reservation-api.beije.it/user/registration', json, {
            headers: {
                'Content-Type': 'application/json',
            },
        }).then((resp) => {
            result = resp.data;
            console.log(result);
          }).catch((resp) => {
            result = resp.data;
            alert("Registration Error");
            return false;
          });
      alert("Registrazione email inviata");
      return true;
    },
    forgotPassword() {
      this.forgottenPassword = !this.forgottenPassword;
    },
    retrivePassword() {
      if (!this.validazioneEmail()) {
        return;
      }
      alert("Recupera Password da implementare");
    },
    checkEmail() {
      if (this.email == this.emailConfirm) {
        this.emailCheck = true;
        return true;
      }else{
        this.emailCheck = false;
        return false;
      }
    },
    checkPassword(){
      if (this.password == this.passwordConfirm) {
          this.confirmPasswordCheck = true;
          return true;
      }else{
        this.confirmPasswordCheck = false;
        return false;
      }
    }
  },
  watch: {
    password:function(){
      if(this.registrazione){
        this.validazionePassword();
      }
    },
    passwordConfirm:function(){
      this.checkPassword()
    },
    emailConfirm:function(){
      this.checkEmail();
    }
  }
}

</script>

<template>
  <div class="container d-flex justify-content-center align-items-center flex-column">

    <h2 v-if="!this.forgottenPassword && !this.registrazione" class="p-4">Login</h2>
    <h2 v-if="!this.forgottenPassword && this.registrazione" class="p-4">Registration</h2>
    <h2 v-if="this.forgottenPassword && !this.registrazione" class="p-4">Retrive Password</h2>

    <form class="w-25">

      <div v-if="this.registrazione && !this.forgottenPassword" class="mb-3">
        <label for="inputName" class="form-label">Name</label>
        <input v-model="name" type="text" class="form-control" id="inputName">
      </div>
      <div v-if="this.registrazione && !this.forgottenPassword" class="mb-3">
        <label for="inputSurname" class="form-label">Surname</label>
        <input v-model="surname" type="text" class="form-control" id="inputSurname">
      </div>

      <div class="mb-3">
        <label for="inputEmail" class="form-label">Email address</label>
        <input v-model="email" type="email" class="form-control" id="inputEmail" aria-describedby="emailHelp">
      </div>

      <div v-if="this.registrazione && !this.forgottenPassword" class="mb-3">
        <div v-if="this.emailCheck" class="mb-3">
          <label for="inputConfirmEmail" class="form-label">Confirm Email address</label>
          <input v-model="emailConfirm" type="email" class="form-control" id="inputConfirmEmail"
            aria-describedby="emailHelp">
        </div>
        <div v-if="!this.emailCheck" class="mb-3">
          <label for="inputConfirmEmail" class="form-label">Confirm Email address</label>
          <input v-model="emailConfirm" type="email" class="form-control is-invalid" id="inputConfirmEmail"
            aria-describedby="emailHelp">
        </div>
      </div>

      <div v-if="!this.forgottenPassword && !this.registrazione" class="mb-3">
        <div class="mb-3">
          <label for="inputPassword" class="form-label">Password</label>
          <input v-model="password" type="password" class="form-control" id="inputPassword">
        </div>
      </div>
      <div v-if="!this.forgottenPassword && this.registrazione" class="mb-3">
        <div v-if="this.passwordCheck" class="mb-3">
          <label for="inputPassword" class="form-label">Password</label>
          <input v-model="password" type="password" class="form-control" id="inputPassword">
        </div>
        <div v-if="!this.passwordCheck" class="mb-3">
          <label for="inputPassword" class="form-label">Password</label>
          <input v-model="password" type="password" class="form-control is-invalid" id="inputPassword">
        </div>
      </div>

      <div v-if="this.registrazione && !this.forgottenPassword" class="mb-3">
        <div v-if="this.confirmPasswordCheck" class="mb-3">
          <label for="inputPasswordConfirm" class="form-label">Confirm Password</label>
          <input v-model="passwordConfirm" type="password" class="form-control" id="inputPasswordConfirm" 
          aria-describedby="emailHelp">
        </div>
        <div v-if="!this.confirmPasswordCheck" class="mb-3">
          <label for="inputPasswordConfirm" class="form-label">Confirm Password</label>
          <input v-model="passwordConfirm" type="password" class="form-control is-invalid" id="inputPasswordConfirm" 
          aria-describedby="emailHelp">
        </div>
      </div>

      <div v-if="!this.registrazione && !this.forgottenPassword" class="mb-3 form-check">
        <input type="checkbox" class="form-check-input" id="checkBox" @click="changePswVisibility()">
        <label class="form-check-label" for="checkBox">Show Password</label>
      </div>

      <div v-if="this.registrazione && !this.passwordCheck">
        <h6 class="p-2">Formato password non corretta! </h6>
        <h6>Deve contenere almeno 8 caratteri <br /> Deve contenere almeno una lettera minuscola <br /> Deve contenere
          almeno una lettera maiuscola <br />
          Deve contenere almeno un numero <br /> Deve contenere almeno un carattere speciale (@$!%*#?&.,:;) <br />
        </h6>
      </div>

      <div>
        
        <button v-if="!this.registrazione && !this.forgottenPassword" type="submit" class="btn btn-primary w-100"
          @click.prevent="sendLogin()">Login</button>

        <button v-if="this.registrazione && !this.forgottenPassword" type="submit" class="btn btn-primary w-100"
          @click.prevent="sendRegistration()">Register</button>
        <a v-if="this.registrazione && !this.forgottenPassword" type="clickable" class="d-flex justify-content-center"
          @click.prevent="startRegister()">Back to Login</a>

        <button v-if="!this.registrazione && this.forgottenPassword" type="submit" class="btn btn-primary w-100"
          @click.prevent="retrivePassword()">Retrive Password</button>
        <a v-if="!this.registrazione && this.forgottenPassword" type="clickable" class="d-flex justify-content-center"
          @click.prevent="forgotPassword()">Back to Login</a>
      </div>
      <div>
        <a v-if="!this.registrazione && !this.forgottenPassword" title="Go to Registration" type="clickable" class="d-flex justify-content-center"
          @click.prevent="startRegister()">Register</a>
        <a v-if="!this.registrazione && !this.forgottenPassword" title="Go to Retrive Password" type="clickable" class="d-flex justify-content-center"
          @click.prevent="forgotPassword()">Forgot Password</a>
      </div>

    </form>
  </div>
</template>

<style>
.container {
  min-height: 100vh;
}

form {
  -webkit-box-shadow: 0px 0px 25px 1px rgba(0, 0, 0, 0.54);
  box-shadow: 0px 0px 25px 1px rgba(0, 0, 0, 0.54);
  border-radius: 10px;
  padding: 30px 15px;
}
a{
  cursor: pointer;
}
</style>
