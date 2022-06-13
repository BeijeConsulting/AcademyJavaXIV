document.querySelector("#login").addEventListener("click", function(){
    document.querySelector(".popup").classList.add("active");
});

document.querySelector(".popup .close-log").addEventListener("click",function(){
    document.querySelector(".popup").classList.remove("active");
});

document.querySelector("#registrati").addEventListener("click", function(){
    document.querySelector(".popup-reg").classList.add("active");
});

document.querySelector(".popup-reg .close-log-reg").addEventListener("click",function(){
    document.querySelector(".popup-reg").classList.remove("active");
});


function checkAllRight(){
    var pswRegex = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,16}$/;
    var emailRegex = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    const email = $('#email-reg').val();
    const psw = $('#password-reg').val();
    const psw2 = $('#confirm_password').val();
    let name = $('#nome').val().length;
    let surname = $('#cognome').val().length;
    if(name>3){
        $('#nome').css('color', 'green');
    }
    else{
        $('#nome').css('color', 'red');
    }
    if(surname>3){
        $('#cognome').css('color', 'green');
    }
    else{
        $('#cognome').css('color', 'red');
    }
    if(validateEmailPsw(email, emailRegex)){
        $('#email-reg').css('color', 'green');
    }
    else{
        $('#email-reg').css('color', 'red');
    }
    if(validateEmailPsw(psw, pswRegex)){
        $('#password-reg').css('color', 'green');
        alert("corretta");
    }
    else{
        $('#password-reg').css('color', 'red');
        alert("sbagliata");
    }
    console.log(psw);
    console.log(psw2);
    if(psw===psw2){
        $('#confirm_password').css('color', 'green');
    }
    else{
        $('#confirm_password').css('color', 'red');
    }
}

const validateEmailPsw = (email, exToEvaluete) => {
    return String(email)
        .toLowerCase()
        .match(
            exToEvaluete      );
};