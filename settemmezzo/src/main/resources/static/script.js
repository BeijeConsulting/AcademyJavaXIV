let stompClient = null;

console.log(SockJS);

const lobbyId = 0;


const buttonConnect = document.getElementById("connect");
const buttonSend = document.getElementById("send");
const name = document.getElementById("name");

buttonConnect.addEventListener("click", (event) => {
   event.preventDefault();
   connect();
})

buttonSend.addEventListener("click", (event) => {
   event.preventDefault();
   sendMessage();
})


function connect() {
   console.log("connessione in corso a /ws");
   let socket = new SockJS("/ws");
   stompClient = Stomp.over(socket);
   stompClient.connect({}, function name(frame) {
      stompClient.subscribe("/lobby/" + lobbyId, function name(obj) {
         console.log(obj);
      })
   })
}

function sendMessage() {
   console.log("sending message");
   stompClient.send("/app/room/" + lobbyId, {}, "CIAO");
}


function disconnect() {
   if (stompClient !== null) {
      stompClient.disconnect();
   }
   console.log("Disconnected");
}