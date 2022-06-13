<template>
  <div class="LoginPopUp">
    <div class="inner">
     <input class="field" v-model="Name" placeholder="Name"/>
      <input class="field" v-model="Email" placeholder="Email"/>
      <input class="field" v-model="EmailCheck" placeholder="Email Verification"/>
      <p class="error" v-if="mailErrorMessage">{{mailErrorMessage}}</p>
      <input class="field" v-model="Password" placeholder="Password"/>
      <input class="field" v-model="PasswordCheck" placeholder="Password Verification"/> 
      <p class="error" v-if="pwErrorMessage">{{pwErrorMessage}}</p>
        <button class="btn" @click="Register()">Register</button>
        <button class="btn" @click="Cancel()">Cancel</button>
    </div>
  </div>
 
</template>

<script>

export default {
    name: "RegistrationFormVue",
    data(){
        return{
        Email:'' ,
        Password:'' ,
        EmailCheck:'' ,
        PasswordCheck:'' ,
        Name:'',
        pwErrorMessage:null,
        mailErrorMessage:null,
        }

    },
    methods:{
        Cancel(){
         this.$parent.reset();
        },
        Register(){
        if(this.Email==this.EmailCheck){
            const mailCheck = /.+@.+\..+/
            if(mailCheck.test(this.Email))
            {
                console.log("ok")
            }
            else{
                this.mailErrorMessage="please insert a valid e-mail :)"
            }
        }
        else{
            this.mailErrorMessage="Emails do not match"
        }
        if(this.Password==this.PasswordCheck){
            const pwUpCase =/.*[A-Z].*/ //at least one upercase
            const pwLowCase =/.*[a-z].*/ //at least one lowercase
            const pwNumber =/.*\d.*/ //at least one number
            const pwSymbol =/.*[-_*@!$&].*/ //at least one upercase//at least one upercase
            if(this.Password.length<8)
            {
                this.pwErrorMessage="Password must be at least 8 characters long"
            }
            else if(pwUpCase.test(this.Password)&&pwLowCase.test(this.Password)&&pwNumber.test(this.Password)//&&pwSymbol.test(this.Password)
            )
            {
                console.log("ok")
            }
            else{
                this.pwErrorMessage="pw not valid it must have at least one uppecase,onelowercase,one number and one symbol( _ - * @ ! $ &)"
            }
        }
        else{
            this.pwErrorMessage="passwords do not match"
        }
        

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

.error{
    color: red;
    border: 2px solid red;
    margin: 4px
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

</style>