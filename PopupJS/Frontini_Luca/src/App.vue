<script>
import LoginPopup from "./components/Pop-Up_Login.vue"
import RegistrationFormVue from "./components/RegistrationForm.vue";
export default{
  name:"App",
  components:{
    LoginPopup,
    RegistrationFormVue,
  },
  data(){
    return{
      LoginPopup,
      RegistrationFormVue,
      login:true,
      register:false,
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
    },
  },
}


</script>

<template>
<main>
  <LoginPopup v-if="login"/>
  <RegistrationFormVue v-if="register"/>
</main>
  
</template>

<style>
body{
min-height: 100vh;
background-color: #1c1e20;
}
</style>
