<template>
   <div class="container h-100 d-flex flex-column align-items-center">
      <button @click="sendTest" class="btn btn-success">TEST SEND</button>
      <div v-if="lobby == null && leaderboard == null" class="home">
         <h1 v-if="user == null && register == false">Login</h1>
         <h1 v-else-if="register == true">Registration</h1>
         <form v-if="user == null && register == false" @submit.prevent="login" class="login">
            <div class="mb-3">
               <label for="email" class="form-label">Email address</label>
               <input type="text" class="form-control" id="email" name="email" v-model="email">
            </div>
            <div class="mb-3">
               <label for="password" class="form-label">Password</label>
               <input type="text" class="form-control" id="password" name="password" v-model="password">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
             <button v-if="register == false" class="btn btn-secondary" style="margin-left: 5px" @click="register = !register">Register</button>
         </form>

          <form v-else-if="user == null && register == true" @submit.prevent="postRegistration" class="login">
            <div class="mb-3">
               <label for="email" class="form-label">Email address</label>
               <input type="text" class="form-control" id="email" name="email" v-model="registration.email">
            </div>
            <div class="mb-3">
               <label for="username" class="form-label">Username</label>
               <input type="text" class="form-control" id="username" name="username" v-model="registration.username">
            </div>
            <div class="mb-3">
               <label for="password" class="form-label">Password</label>
               <input type="text" class="form-control" id="password" name="password" v-model="registration.password">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
           
         <button v-if="register == true" class="btn btn-secondary" style="margin-top: 5px" @click="register = !register">Back to login</button>
         </form>

         <div v-else>
            <h1 class="my-5 text-center">HOME</h1>
            <input for="" min="-1" v-model="lobbyNumber" @change="changeJoin(lobbyNumber)"/>
            <nav class="d-flex flex-column align-items-center">
               <a class="nav_item" @click="playFast" href="#">GIOCA VELOCE</a>
               <a class="nav_item" @click="createLobby" href="#">CREA LOBBY</a>
               <a class="nav_item" @click="getLeaderboard" href="#">CLASSIFICA</a>
            </nav>
         </div>
         
      </div>

      <div v-else-if="leaderboard != null" class="d-flex flex-column">
         <h1>LEADERBOARD</h1>
         <table class="table text-white">
            <thead>
               <tr>
                  <th scope="col">#</th>
                  <th scope="col">Username</th>
                  <th scope="col">Score</th>
               </tr>
            </thead>
            <tbody>
               <tr v-for="(user, index) in leaderboard.users" :key="user.id">
                  <th scope="row">{{index + 1}}</th>
                  <td>{{user.username}}</td>
                  <td>{{user.score}}</td>
               </tr>
            </tbody>
            </table>
         <button class="btn btn-success" @click="leaderboard = null">HOME</button>
      </div>

      <div v-else-if="match == null" class="lobby mt-5">

         <h1 class="text-center">Lobby</h1>

         <div class="lobby_container">
            <div class="players">
               <ul>
                  <li class="user" v-for="user in getUsersInLobby"
                     :key="user.id"
                  >
                     <img src="@/assets/img/logo_short_red.svg" alt="logo beije.it">
                     <span class="username">
                        {{user.username}}
                     </span>
                     <span class="position">
                        #1
                     </span>
                     <span class="total_score">
                        {{user.score}}
                     </span>
                  </li>
               </ul>
            </div>
            <div v-if="user.id == lobby.users[0].id" class="options">
               <label class="switch">
                  <input :checked="!lobby.accessType" type="checkbox">
                  <span @click="changeLobbyAccess" class="slider"></span>
               </label>

               <div class="max_players">
                  <span @click="changeMaxPlayer(+1)" class="next"></span>
                  <span @click="changeMaxPlayer(-1)" class="prev"></span>
                  <div id="box">
                     <span>{{lobby.userMax}}</span>
                  </div>
               </div>
               <!-- <div class="max_players d-flex align-items-center">
                  <input type="number" class="form-control" min="2" max="7" v-model="lobby.userMax" @change="changeMaxPlayer">
                  <p class="m-0">Player massimi</p>
               </div> -->
            </div>
            <div class="start text-center">
               <div class="start_container">
                  <div @click="quitLobby" class="quit">
                     <span>&times;</span>
                  </div>
                  <label for="">{{lobby.idLobby}}</label>
                  <button v-if="user.id == lobby.users[0].id" @click="startMatch" class="my_btn">START</button>
                  <div v-else class="countdown text-center">
                     <p class="my_btn m-0">10</p>
                  </div>
               </div>
            </div>
         </div>
         
      </div>
      
      <div v-else-if="!match.ended" class="match">
         <h1>MATCH</h1>
         <div class="match_container">
            <div class="match_table">

               <div id="master">
                  <img src="@/assets/img/logo_official_white.svg" alt="logo beije.it">
                  <h1>MASTER</h1>
               </div>

               <div v-for="(player, index) in getMatchUsers"
                  :key="player.id"
                  :id="'player_' + (index + 1)" 
                  class="player"
               >
                  <p class="player_name">{{player.username}}</p>
                  <div v-for="(card, index) in getMatchHand(player.id).cards"
                     :key="player.id + 'card' + index"
                     class="match_card"
                  >
                     <div v-if="user.id == player.id" class="front">
                        <p class="card_value">{{card.value}}</p>
                     </div>
                     <div v-else class="back">
                        <img src="@/assets/img/logo_short_red.svg" alt="logo beije.it">
                     </div>
                  </div>
               </div>

            </div>

         </div>
         <div class="options">
            <div v-if="getMatchHand(user.id).continuePlaying && getMatchHand(user.id).turn" @click="requestCard" class="option request_card">
               <span>CHIEDI CARTA</span>
            </div>
            <div v-if="getMatchHand(user.id).continuePlaying && getMatchHand(user.id).turn" @click="stopPlaying" class="option stop_playing">
               <span>STO BENE</span>
            </div>
            <div @click="quitMatch" class="option quit_game">
               <span>ESCI</span>
            </div>
         </div>
      </div>

      <div class="winners" v-else-if="match.ended">
         <h1>Vincitori</h1>
         <div v-if="match.winners.length == 0">
            <h3 class="text-center">NESSUNO</h3>
            <img src="@/assets/img/gif_sad.gif" alt="">
         </div>
         <ul v-else>
            <li class="winner" v-for="winner in this.match.winners" :key="winner.id">
               <p class="player_name m-0">
                  {{winner.username}}
               </p>
               <span>score</span>
            </li>
         </ul>
         <div class="options">
            <div @click="quitGame" class="option exit_game">
               <span>ESCI</span>
            </div>
         </div>
      </div>

      

   </div>
</template>

<script>
import axios from "axios";
export default {
   name: "HomeView",
   data() {
      return {
         ws: null,
         lobbyNumber: -1,
         configuration: null,
         peerConnection: null,
         dataChannel: null,
         stompClient: null,
         register: false,
         registration: {
            username: null,
            email: null,
            password: null,
         },
         email: "potato",
         password: "potato",
         leaderboard: null,
         user: null,
         lobby: null,
         match: null,
         connectionEstablished: false,
         URL: "://7emezzo-dev.eba-uwfpyt28.eu-south-1.elasticbeanstalk.com/"
         //URL: "://localhost:8080/"
      }
   },

   mounted() {
      // this.connect();
   },

   methods: {
      changeJoin(value) {
         if (value >= 0)this.lobbyNumber = value;
         else this.lobbyNumber = -1;
      },
      login() {
         axios.post("http" + this.URL + "signin", {
            email: this.email,
            password: this.password
         }).then(response => {
            this.user = response.data;
            console.log(this.user);
         })
      },
      postRegistration(){
         axios.post("http" + this.URL + "registration", this.registration)
            .then(response => {
               this.user = response.data;
               console.log(this.user);
               this.register = false;
            })
      },

      getLeaderboard() {
         axios.get("http" + this.URL + "leaderboard", {
            headers: {
                  Authorization: "Bearer " + this.user.token //the token is a variable which holds the token
               }
         }).then(response => {
            this.leaderboard = response.data;
            console.log(this.leaderboard);
         })
      },

      playFast() {
         axios.put("http" + this.URL + "lobby/" + this.lobbyNumber, {}, {
               headers: {
                  Authorization: "Bearer " + this.user.token //the token is a variable which holds the token
               }
            }).then(response => {
               this.lobby = response.data;
               this.connect();
               this.connectionEstablished = false;
               setTimeout(() => {
                  if (this.lobby != null && this.ws != null) {
                     const message = {
                        user_id: this.user.id,
                        method: "connectLobby"
                     }
                     this.sendMessage(message);
                     this.connectionEstablished = true;
                  }
               }, 1000);
            })
      },

      createLobby() {
         axios.post("http" + this.URL + "lobby", {}, {
               headers: {
                  Authorization: "Bearer " + this.user.token //the token is a variable which holds the token
               }
            }).then(response => {
               this.lobby = response.data;
               this.connect();
               this.connectionEstablished = false;
               setTimeout(() => {
                  if (this.lobby != null && this.ws != null) {
                     const message = {
                        user_id: this.user.id,
                        method: "connectLobby"
                     }
                     this.sendMessage(message);
                     this.connectionEstablished = true;
                  }
               }, 1000);
            })
      },

      // connect() {
      //    if (this.lobby == null) return;
         
      //    const socket = new SockJS("http://localhost:8080/ws");
      //    this.stompClient = Stomp.over(socket);
      //    console.log("stomp settato", this.stompClient);
      //    this.stompClient.connect({}, (frame) => {
      //       console.log("Connected: " + frame);
      //       this.stompClient.subscribe("/lobby/" + this.lobby.idLobby, (response) => {
      //          const obj = JSON.parse(response.body);
      //          if (obj.hasOwnProperty("idLobby")) {
      //             this.lobby = obj;
      //          } else {
      //             if (this.match == null) {
      //                this.match = obj;
      //                this.requestCard();
      //             } else {
      //                this.match = obj;
      //             }
      //          }
      //       });
      //    })
      // },

      connect() {
         this.ws = new WebSocket("ws" + this.URL + "ws");
         
         this.ws.onopen = () => {
            console.log("CONNECTED");
         }
         this.ws.onmessage = (event) => {
            console.log(JSON.parse(event.data));
            const obj = JSON.parse(event.data);
            if (obj.hasOwnProperty("idLobby")) {
               this.lobby = obj;
            } else {
               if (this.match == null) {
                  this.match = obj;
                  setTimeout(() => {
                     this.requestCard();
                  }, 1000);
               } else {
                  this.match = obj;
               }
            }
         }

      },

      disconnect() {
         if (this.ws !== null) {
            this.ws.close();
            this.lobby = null;
            this.match = null;
            this.connectionEstablished = false;
         }
      },

      sendMessage(message) {
         setTimeout(() => {
            this.ws.send(JSON.stringify(message));
         }, 200);
      },

      // disconnect() {
      //    if (this.stompClient !== null) {
      //       this.stompClient.disconnect();
      //       this.lobby = null;
      //       this.match = null;
      //       this.connectionEstablished = false;
      //       //TODO DELETE INSTANCE LOBBY - MATCH => JAVA
      //    }
      // },

      requestCard() {
         // this.sendMessage("/app/room/" + this.lobby.idLobby + "/request_card/" + this.user.id);
         const message = {
            user_id: this.user.id,
            method: "requestCard"
         }
         this.sendMessage(message);
          setTimeout(() => {
            this.endMatch();
         }, 100);
      },

      stopPlaying() {
         const message = {
            user_id: this.user.id,
            method: "stopPlaying"
         }
         this.sendMessage(message);
         setTimeout(() => {
            this.endMatch();
         }, 100);
      },

      changeMaxPlayer(value) {
         if ((this.lobby.userMax + value) >= 2 && (this.lobby.userMax + value) <= 7) {
            const message = {
               user_id: this.user.id,
               method: "resizeLobby",
               userMax: this.lobby.userMax + value
            }
            this.sendMessage(message);
         }
      },

      changeLobbyAccess() {
         console.log("changing access");
         const message = {
               user_id: this.user.id,
               method: "changeLobbyAccess",
               accessType: !this.lobby.accessType
            }
         this.sendMessage(message);
      },

      startMatch() {
         const message = {
            user_id: this.user.id,
            method: "startMatch"
         }
         this.sendMessage(message);
      },

      endMatch() {
         console.log("check end match...");
         const message = {
            user_id: this.user.id,
            method: "checkEndMatch",
         }
         this.sendMessage(message);
      },

      quitLobby() {
         axios.delete("http" + this.URL + "lobby",  {
               headers: {
                  Authorization: "Bearer " + this.user.token //the token is a variable which holds the token
               }
            }).then(response => {
               if (response.data.esito) {
                  if (this.lobby != null && this.ws != null) {
                     console.log("QUITTO");
                     const message = {
                        method: "quitLobby",
                        idLobby: this.lobby.idLobby
                     }
                     console.log("MESSAGE", message);
                     this.sendMessage(message);
                  }
                  this.lobby = null;
                  setTimeout(() => {
                     this.disconnect();
                  }, 1000);
                  
               } else {
                  console.log("Cannot disconnect");
               }
            })
      },

      quitGame() {
         const message = {
            user_id: this.user.id,
            method: "quitMatch"
         }
         this.sendMessage(message);
         this.disconnect();
      },

      quitMatch() {
         const message = {
            user_id: this.user.id,
            method: "quitMatch"
         }
         this.sendMessage(message);
         setTimeout(() => {
            this.endMatch();
            this.disconnect();
         }, 100);
      },

      getMatchHand(playerId) {
            
         for (const hand of this.match.hands) {
            
            if (hand.user.id == playerId) {
               return hand;
            }
         }
      },
   },

   computed: {
      getUsersInLobby() {
         return this.lobby.users;
      },


      getMatchUsers() {
         return this.match.users;
      }
      
   }
}
</script>