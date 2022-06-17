<script>
export default {
  data() {
    return {
      showPassword: false,
      password: null,
      flag: false,
      email: null,
      array: null,
      user: null,
      psw:null,
      status:null,
      user: null,
      conferma:null,
      error: false,
      emailRExEx: "[A-z0-9\.\+_-]+@[A-z0-9\._-]+\.[A-z]{2,6}"
    };
  },
  computed: {
    buttonLabel() {
      return (this.showPassword) ? "Hide" : "Show";
    }
  },
  methods: {
    toggleShow() {
      this.showPassword = !this.showPassword;
    },

    accedi(){
      console.log("accedi");
      this.email = document.getElementById("em").value;
      this.psw = document.getElementById("psw").value;
      console.log("email", this.email);
      console.log("psw", this.psw);
      console.log("flag", this.flag);

      var regexp = ^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$;
      var test =regexp.test(this.email);
      console.log("test", test);

      fetch("http://reservation-test.eba-6qvkzxjp.eu-south-1.elasticbeanstalk.com/signin", {
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
          method: "POST",
          body: JSON.stringify(
            {
              email: this.email,
              password: this.password
            }
          )
        })
      .then(response => response.json() )
      .then(data => {
        console.log("data", data)
        if(data.status != 200 ){
            console.log(data.message);
          this.error = !this.error;
        }
        if(data.id != null){
          this.flag = !this.flag;
        }
      })
      .catch(function(res){ console.log( res) })
      console.log("flag dopo",  this.flag);

    },

    registrazione(){
      console.log("registrazione");
      this.email = document.getElementById("em1").value;
      this.psw = document.getElementById("psw").value;
      this.user = document.getElementById("user").value;
      this.conferma = document.getElementById("conf").value;
      console.log("email", this.email);
      console.log("conf ", this.conferma);
      if(this.conferma === this.email){
        fetch("http://reservation-test.eba-6qvkzxjp.eu-south-1.elasticbeanstalk.com/user/registration", {
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
          method: "POST",
          body: JSON.stringify(
            {
              nome: this.user,
              cognome: "",
              email: this.email,
              password: this.password
            }
          )
        })
      .then(response => response.json())
      .then(data => console.log(data), this.flag = !this.flag  )
      .catch(function(res){ console.log(res) })
      console.log("status",  this.flag);
      } else{
        console.log("email diverse"); 
        this.error = !this.error;//todo
      }
      
    },

    modifica(){
      console.log("modifica");

    }

  }
};
</script>


<template>
  <div>
    <div v-if="flag" class="log"> <h1> SEI LOGGATO </h1></div>
    <div v-else>
      <!-- home -->
      <div id="index" class="buttonLogin"> 
        <button type="button" class="btn btn-primary" onclick="document.getElementById('id01').style.display='block'">Accedi</button>
        <button type="button" class="btn btn-secondary" onclick="document.getElementById('id02').style.display='block'">Registrati</button>
      </div>

      <!-- accedi -->
      <div id="id01" class="modal">

        <form class="modal-content animate">
            <div class="text">LogIn</div>
          <div class="container">
            <!-- <label for="email"><b>Email</b></label>
            <input id="em" type="email" placeholder="Email" name="email" required> -->

            <label for="email" class="form-label"> <b>Email</b></label>
        <input type="email" class="form-control"  placeholder="Email" id="em" name="email" required/>
        
            
            <label for="uname"><b>Password</b></label>
            <div class="field has-addons">
                <div class="control is-expanded">
                  <input id = "psw" v-if="showPassword" type="text"  placeholder="Password" class="input" v-model="password" />
                  <input  id = "psw" v-else type="password" placeholder="Password" class="input" v-model="password">
                </div>
              <div class="control">
                  <button class="btn btn-secondary showpsw" @click="toggleShow"> 
                    <span class="icon is-small is-right">
                      <i class="fas" :class="{ 'fa-eye-slash': showPassword, 'fa-eye': !showPassword }"></i>
                    </span> 
                    mostra password
                  </button>
              </div>
            </div>  <br>
              <div class="error" v-if="error"> email e/o  password non corrette</div>
            <button type="button" class="btn btn-primary" @click="accedi">Accedi</button>
            oppure <a onclick="document.getElementById('id02').style.display='block', document.getElementById('id01').style.display='none'"> <u>registrati</u></a> 
          </div>

          <div class="container" style="background-color:#f1f1f1">
            <button type="button" class="btn btn-danger cancelbtn"  onclick="document.getElementById('id01').style.display='none'">Cancel</button>
            <button type="button" class="btn btn-secondary newpsw"  onclick="document.getElementById('id03').style.display='block', document.getElementById('id01').style.display='none'">Password dimenticata?</button>

          </div>
        </form>
      </div>

      <!-- registrati -->
      <div id="id02" class="modal">
        
        <form class="modal-content animate">
          <div class="text">Registrati</div>
          <div class="container">
            <label for="uname"><b>Nome</b></label>
            <input id="user" type="text" placeholder="Username" name="uname" required>

            <label for="uname"><b>Email</b></label>
            <input id="em1" type="text" placeholder="Email" name="Enail" required>

            <label for="uname"><b>Conferma Email</b></label>
            <input id ="conf" type="text" placeholder="Conferma Email" name="conferma" required>
            <div class="error" v-if="error"> email non corrisponde</div>

            <label for="uname"><b>Password</b></label>
            <div class="field has-addons">
                <div class="control is-expanded">
                  <input id = "psw" v-if="showPassword" type="text"  placeholder="Password" class="input" v-model="password" />
                  <input  id = "psw" v-else type="password" placeholder="Password" class="input" v-model="password">
                </div>
              <div class="control">
                  <button class="btn btn-secondary showpsw" @click="toggleShow"> 
                    <span class="icon is-small is-right">
                      <i class="fas" :class="{ 'fa-eye-slash': showPassword, 'fa-eye': !showPassword }"></i>
                    </span> 
                    mostra password
                  </button>
              </div>
            </div>     
          </div>

          <div class="container" style="background-color:#f1f1f1">
            <button type="button" class="btn btn-danger cancelbtn" onclick="document.getElementById('id02').style.display='none'">Cancel</button>
            <button type="button" class="btn btn-primary newpsw" @click="registrazione">Registrati</button>
          </div>
        </form>
      </div>

      <!-- password dimenticata -->
      <div id="id03" class="modal">
        
        <form class="modal-content animate">
          <div class="text">Nuova Password</div>
          <div class="container">
            <label for="uname"><b>Email</b></label>
            <input type="text" placeholder="Username" name="uname" required>
            <label for="uname"><b>Password</b></label>
            <div class="field has-addons">
                <div class="control is-expanded">
                  <input v-if="showPassword" type="text"  placeholder="Password" class="input" v-model="password" />
                  <input v-else type="password" placeholder="Password" class="input" v-model="password">
                </div>
              <div class="control">
                  <button class="btn btn-secondary showpsw" @click="toggleShow"> 
                    <span class="icon is-small is-right">
                      <i class="fas" :class="{ 'fa-eye-slash': showPassword, 'fa-eye': !showPassword }"></i>
                    </span> 
                    mostra password
                  </button>
              </div>
            </div> 
              
            <button type="button" class="btn btn-primary" @click="modifica">invia</button>
          </div>

          <div class="container" style="background-color:#f1f1f1">
            <button type="button" class="btn btn-danger cancelbtn" onclick="document.getElementById('id03').style.display='none'">Cancel</button>
          </div>
        </form>
      </div>
    </div>

    
  </div>
</template>

<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  }

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

/* Set a style for all buttons */
button {
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}
.log{

  position: absolute;
  width: auto;
  margin-left: 40%;
  margin-top: 25%;
}

.text{
  margin: auto;
  width: auto;
  font-weight: bold;
  padding: 10px;
}
.error{
  color: rgb(249, 65, 65);
}
.text2{
  margin: auto;
  width: auto;
  font-weight: bold;
  padding: 10px;
}

.buttonLogin{
  margin: 0;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width:40%;
}

button:hover {
  opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
  width: auto;
  padding: 10px 18px;
}

.showpsw {
  width: auto;
  padding: 10px 18px;
  right: 16px;
}
.newpsw {
  width: auto;
  padding: 10px 18px;
  position:absolute;
  right: 16px;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
  padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
  border: 1px solid #888;
  width:40%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
  position: absolute;
  right: 25px;
  top: 0;
  color: #000;
  font-size: 35px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: red;
  cursor: pointer;
}

/* Add Zoom Animation */
.animate {
  -webkit-animation: animatezoom 0.6s;
  animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
  from {-webkit-transform: scale(0)} 
  to {-webkit-transform: scale(1)}
}
  
@keyframes animatezoom {
  from {transform: scale(0)} 
  to {transform: scale(1)}
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
    display: block;
    float: none;
  }
  .cancelbtn {
    width: 100%;
  }
}
</style>
