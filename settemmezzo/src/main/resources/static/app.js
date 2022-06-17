var stompClientWs = null;
var stompClientLol = null;

let roomIdLol = 100
let roomIdWs = 200

function setConnectedWs(connected) {
    
    const connectWs = document.getElementById("connect-ws");
    const disconnectWs = document.getElementById("disconnect-ws");

    if (connected) {
        connectWs.setAttribute("disabled", connected);
        disconnectWs.removeAttribute("disabled")
        $("#conversation").show();
    }
    else {
        connectWs.removeAttribute("disabled");
        disconnectWs.setAttribute("disabled", !connected);
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connectWs() {
   var socket = new SockJS('/ws');
    stompClientWs = Stomp.over(socket);
    stompClientWs.connect({}, function (frame) {
        setConnectedWs(true);
        console.log('Connected: ' + frame);
        stompClientWs.subscribe('/lobby/' + roomIdWs, function (greeting) {
            console.log(greeting);
            showGreetingWs(greeting);
        });
    });
}

function disconnectWs() {
    if (stompClientWs !== null) {
        stompClientWs.disconnect();
    }
    setConnectedWs(false);
    console.log("Disconnected");
}

function setConnectedLol(connected) {
    
    const connectLol = document.getElementById("connect-lol");
    const disconnectLol = document.getElementById("disconnect-lol");

    if (connected) {
        connectLol.setAttribute("disabled", connected);
        disconnectLol.removeAttribute("disabled");
        $("#conversation").show();
    }
    else {
        connectLol.removeAttribute("disabled");
        disconnectLol.setAttribute("disabled", connected);
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connectLol() {
   var socket = new SockJS('/lol');
    stompClientLol = Stomp.over(socket);
    stompClientLol.connect({}, function (frame) {
        setConnectedLol(true);
        console.log('Connected: ' + frame);
        stompClientLol.subscribe('/lobby/' + roomIdLol, function (greeting) {
            console.log(greeting); 
            showGreetingLol(greeting);
        });
    });
}

function disconnectLol() {
    if (stompClientLol !== null) {
        stompClientLol.disconnect();
    }
    setConnectedLol(false);
    console.log("Disconnected");
}

function sendNameWs() {
    stompClientWs.send("/app/sock");
}
function sendNameLol() {
    stompClientLol.send("/app/room/" + roomIdLol, {}, document.getElementById("name-lol").value);
}

function showGreetingWs(message) {
    console.log(message)
    $("#ws-lobby").append("<tr><td>" + message.body + "</td></tr>");
}
function showGreetingLol(message) {
    console.log(message)
    $("#lol-lobby").append("<tr><td>" + message.body + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect-ws" ).click(function() { connectWs(); });
    $( "#disconnect-ws" ).click(function() { disconnectWs(); });
    $( "#send-ws" ).click(function() { sendNameWs(); });
    $( "#connect-lol" ).click(function() { connectLol(); });
    $( "#disconnect-lol" ).click(function() { disconnectLol(); });
    $( "#send-lol" ).click(function() { sendNameLol(); });
});