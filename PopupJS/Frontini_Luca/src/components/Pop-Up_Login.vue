<template>
  <div class="LoginPopUp">
    <div class="inner">
        <p class="regmex" v-if="regSucc" >REGISTRATION SUCCESSFULL <br> YOU MAY NOW LOGIN</p>
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
import axios from "axios";

export default {
    name: "LoginPopup",
    prop:["regSucc"],
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
         else{
            let self=this;
            if(this.loginErrorMessage)
            {
                this.loginErrorMessage=null;
            }
            let data = {
                email: this.Email,
                password: this.Password,
            };
            let headers={
                'Content-Type': 'JSON'

            }
            axios.post(this.$parent.url+"signin",data,headers)
            .then(function (response){
                console.log(response)
                self.$parent.logOn({
                    name:response.data.email,
                    auth:response.data.permission,
                    token:response.data.token
                });
            })
            .catch(function(error)
            {
                 self.setErrorMessage('Wrong Credentials',self);
                console.log(error);
               
            });
         }
        },
        Register(){
        this.$parent.registration()

        },
        setErrorMessage(message,self)
        {
            self.loginErrorMessage=message;
        }
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
/* border:2px solid  greenyellow; */
justify-content: center;
}

.inner{
    align-items: center;
    
    flex-direction: column;
    display: flex;
    
    
}  
.field{
    /* border: 2px solid greenyellow; */
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
.regmex{
    color:yellowgreen;
    border: 2px solid yellowgreen;
    margin: 4px
}
.error{
    color: red;
    border: 2px solid red;
    margin: 4px
}

</style>