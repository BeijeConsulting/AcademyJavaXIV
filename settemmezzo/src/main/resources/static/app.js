var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect(param) {
   var socket = new SockJS(param);
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/greetings', function (greeting) {
            console.log(greeting);
            showGreeting(JSON.parse(greeting.body));
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/sock", {}, JSON.stringify({'name': $("#name").val(),
    'body': "ciao"}));
}

function showGreeting(message) {
    console.log(message)
    $("#greetings").append("<tr><td>" + message.body + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect("/ws"); });
    $( "#disconnect" ).click(function() { connect("/lol"); });
    $( "#send" ).click(function() { sendName(); });
});