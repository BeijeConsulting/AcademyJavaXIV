<template>
  <div class="LoginPopUp">
    <div class="inner">
     <input class="field" v-model="Email" placeholder="Email"/>
      <input class="field" v-model="Password" placeholder="Password"/>
      <p class="error" v-if="loginErrorMessage">{{loginErrorMessage}}</p>
     <button class="btn" @click="Login()">Login</button>
        <button class="btn" @click="Register()">Register</button>
    </div>
  </div>
 
</template>

<script>
import { isFunction } from '@vue/shared'

export default {
    name: "LoginPopup",
    data(){
        return{
        Email:'' ,
        Password:'' , 
        loginErrorMessage:null,
        }

    },
    methods:{
        Login(){
         if(!this.Password||!this.Email)
         {
            this.loginErrorMessage='email or password not provided'
         }
        },
        Register(){
        this.$parent.registration()

        },
    },

}
</script>

<style>
.LoginPopUp{
position:absolute;
left:50%;
top:50%;
transform: translate(-50%,-50%);
display: flex;
align-items: center;

justify-content: center;
}

.inner{
    align-items: center;
    
    flex-direction: column;
    display: flex;
    
    border:4px solid  greenyellow;
}  
.field{
    border: 2px solid greenyellow;
    padding:10px;
    margin:4px;
}

.btn{
    background-color: lightgray;
    width: calc(100% - 8px);
    padding:4px;
    margin:4px;
    border: 2px solid white;
}

.error{
    color: red;
    border: 2px solid red;
    margin: 4px
}

</style>