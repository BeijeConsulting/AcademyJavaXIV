<script>
import LoginPopup from "./components/Pop-Up_Login.vue"
import RegistrationFormVue from "./components/RegistrationForm.vue";
import Welcome from "./components/Welcome.vue";
export default{
  name:"App",
  components:{
    LoginPopup,
    RegistrationFormVue,
    Welcome
},
  data(){
    return{
      LoginPopup,
      RegistrationFormVue,
      login:true,
      register:false,
      url:"http://reservation-test.eba-6qvkzxjp.eu-south-1.elasticbeanstalk.com/",
      fields:null,
      logged:false,
      regSucc:false,
    }
  },
  methods:{
    registration()
    {
      this.login=false;
      this.register=true;
    },
    reset()
    {
      this.login=true;
      this.register=false;
      this.logged=false;
    },
  logOn(dto)
    {
      this.login=false;
      this.logged=true;
      this.fields={
       name:dto.name,
       auth: dto.auth,
       token: dto.token,
      };
    },
    regFlip()
    {
      console.log("bug")
      this.regSucc=true;
    }
  },
}


</script>

<template>
<main>
  <LoginPopup v-if="login" :regSucc = "regSucc" />
  <RegistrationFormVue v-if="register" @regSuccFlip="regFlip()"/>
   <Welcome v-if="logged" :fields="fields" />
</main>
  
</template>

<style>
body{
min-height: 100vh;
background-color: #1c1e20;
}
</style>
