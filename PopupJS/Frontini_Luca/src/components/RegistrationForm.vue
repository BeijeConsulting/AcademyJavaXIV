<template>
    <div class="LoginPopUp">
        <div class="inner">
            <input class="field" v-model="Name" placeholder="Name" />
            <input class="field" v-model="Email" placeholder="Email" />
            <input class="field" v-model="EmailCheck" placeholder="Email Verification" />
            <p class="error" v-if="mailErrorMessage">{{ mailErrorMessage }}</p>
            <input class="field" v-model="Password" placeholder="Password" />
            <input class="field" v-model="PasswordCheck" placeholder="Password Verification" />
            <p class="error" v-if="pwErrorMessage">{{ pwErrorMessage }}</p>
            <button class="btn" @click="Register()">Register</button>
            <p class="error" v-if="registrationErrorMessage">{{ registrationErrorMessage }}</p>
            <button class="btn" @click="Cancel()">Cancel</button>
        </div>
    </div>

</template>

<script>
import axios from "axios";

export default {
    name: "RegistrationFormVue",
    data() {
        return {
            Email: '',
            Password: '',
            EmailCheck: '',
            PasswordCheck: '',
            Name: '',
            pwErrorMessage: null,
            mailErrorMessage: null,
            registrationErrorMessage: null,
            form: {
                name: null,
                surname: "x",
                email: null,
                password: null

            }
        }


    },
    methods: {
        Cancel() {
            this.$parent.reset();
        },
        Register() {
            if (this.Email && this.Password && this.Name) {
                this.form.name = this.Name;
                if (this.Email == this.EmailCheck) {
                    const mailCheck = /.+@.+\..+/
                    if (mailCheck.test(this.Email)) {
                        this.form.email = this.Email
                    }
                    else {
                        this.mailErrorMessage = "please insert a valid e-mail :)"
                    }
                }
                else {
                    this.mailErrorMessage = "Emails do not match"
                }
                if (this.Password == this.PasswordCheck) {
                    const pwUpCase = /.*[A-Z].*/ //at least one upercase
                    const pwLowCase = /.*[a-z].*/ //at least one lowercase
                    const pwNumber = /.*\d.*/ //at least one number
                    const pwSymbol = /.*[-_*@!$&].*/ //at least one upercase//at least one upercase
                    if (this.Password.length < 8) {
                        this.pwErrorMessage = "Password must be at least 8 characters long"
                    }
                    else if (pwUpCase.test(this.Password) && pwLowCase.test(this.Password) && pwNumber.test(this.Password)//&&pwSymbol.test(this.Password)
                    ) {
                        this.form.password = this.Password;
                    }
                    else {
                        this.pwErrorMessage = "pw not valid it must have at least one uppecase,onelowercase,one number and one symbol( _ - * @ ! $ &)"
                    }
                }
                else {
                    this.pwErrorMessage = "passwords do not match"
                }
                console.log(this.form)
                if (this.form.name && this.form.password && this.form.email) {
                    let self = this;
                    axios.post(this.$parent.url + "user/registration", this.form)
                        .then(function (response) {
                            console.log(response)
                            if (response.status == 200) {
                            self.$emit("regSuccFlip");
                            self.$parent.reset();
                            }
                        })
                        .catch(function (error) {

                            console.log(error);
                            self.registrationErrorMessage = error.response.data.message;

                        });
                    
                }
            }

            else {
                this.registrationErrorMessage = "not all fields are complete"

            }
        }

    },

}
</script>

<style>
.LoginPopUp {
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    display: flex;
    align-items: center;
    border: 4px solid greenyellow;
    justify-content: center;
}

.error {
    color: red;
    border: 2px solid red;
    margin: 4px
}

.inner {
    align-items: center;
    margin: 4px;
    flex-direction: column;
    display: flex;


}

.field {
    border: 2px solid greenyellow;

    width: 87%;
}

.btn {
    background-color: lightgray;
    width: 100%;
    padding: 4px;
    margin: 4px;
    border: 2px solid white;
}
</style>