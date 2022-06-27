<template>
   <div class="container h-100 d-flex flex-column align-items-center">
      <div v-if="lobby == null" class="home">
         <h1 v-if="user == null">Login</h1>
         <form v-if="user == null" @submit.prevent="login" class="login">
            <div class="mb-3">
               <label for="email" class="form-label">Email address</label>
               <input type="text" class="form-control" id="email" name="email" v-model="email">
            </div>
            <div class="mb-3">
               <label for="password" class="form-label">Password</label>
               <input type="text" class="form-control" id="password" name="password" v-model="password">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
         </form>

         <div v-else>
            <h1 class="my-5 text-center">HOME</h1>
            <nav class="d-flex flex-column align-items-center">
               <a class="nav_item" @click="playFast" href="#">GIOCA VELOCE</a>
               <a class="nav_item" @click="createLobby" href="#">CREA LOBBY</a>
               <a class="nav_item" href="#">CLASSIFICA</a>
            </nav>
         </div>
      </div>

      <div v-else-if="match == null" class="lobby mt-5">

         <h1 class="text-center">Lobby</h1>

         <div class="lobby_container">
            <div @click="quitLobby" class="quit">&times;</div>
            <div class="players">
               <ul>
                  <li class="user" v-for="user in getUsersInLobby"
                     :key="user.id"
                  >
                     {{user.username}}
                  </li>
               </ul>
            </div>
            <div v-if="user.id == lobby.users[0].id" class="options">
               <div class="access_type">
                  <div @click="changeLobbyAccess" class="slider" :class="!lobby.accessType ? 'private' : ''"></div>
                  <p v-if="lobby.accessType">lobby pubblica</p>
                  <p v-else>lobby privata</p>
               </div>
               <div class="max_players d-flex align-items-center">
                  <input type="number" class="form-control" min="2" max="7" v-model="lobby.userMax" @change="changeMaxPlayer">
                  <p class="m-0">Player massimi</p>
               </div>
            </div>
            <div v-if="user.id == lobby.users[0].id" class="start text-center">
               <button @click="startMatch" class="my_btn">START</button>
            </div>
            <div v-else class="countdown text-center">
               <p class="my_btn mt-4">10</p>
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

      <div v-else>
         <ul>
            <li v-for="winner in this.match.winners" :key="winner.id">
               {{winner.username}}
            </li>
         </ul>
      </div>

   </div>
</template>

<script>
import axios from "axios";
export default {
   name: "HomeView",
   data() {
      return {
         stompClient: null,
         email: "potato",
         password: "potato",
         user: null,
         lobby: null,
         match: null,
         connectionEstablished: false
      }
   },

   mounted() {
      // this.connect();
   },

   methods: {
      login() {
         axios.post("http://localhost:8080/signin", {
            email: this.email,
            password: this.password
         }).then(response => {
            this.user = response.data;
            console.log(this.user);
         })
      },

      playFast() {
         axios.put("http://localhost:8080/lobby/-1", {}, {
               headers: {
                  Authorization: "Bearer " + this.user.token //the token is a variable which holds the token
               }
            }).then(response => {
               this.lobby = response.data;
               this.connect();
               this.connectionEstablished = false;
               setTimeout(() => {
                  if (this.lobby != null && this.stompClient != null) {
                     this.stompClient.send("/app/room/" + this.lobby.idLobby + "/" + this.user.id);
                     this.connectionEstablished = true;
                  }
               }, 1000);
            })
      },

      createLobby() {
         axios.post("http://localhost:8080/lobby", {}, {
               headers: {
                  Authorization: "Bearer " + this.user.token //the token is a variable which holds the token
               }
            }).then(response => {
               this.lobby = response.data;
               this.connect();
               this.connectionEstablished = false;
               setTimeout(() => {
                  if (this.lobby != null && this.stompClient != null) {
                     console.log("sended");
                     this.stompClient.send("/app/room/" + this.lobby.idLobby + "/" + this.user.id);
                     this.connectionEstablished = true;
                  }
               }, 1000);
            })
      },

      connect() {
         if (this.lobby == null) return;
         
         const socket = new SockJS("http://localhost:8080/ws");
         this.stompClient = Stomp.over(socket);
         console.log("stomp settato", this.stompClient);
         this.stompClient.connect({}, (frame) => {
            console.log("Connected: " + frame);
            this.stompClient.subscribe("/lobby/" + this.lobby.idLobby, (response) => {
               const obj = JSON.parse(response.body);
               if (obj.hasOwnProperty("idLobby")) {
                  this.lobby = obj;
               } else {
                  if (this.match == null) {
                     this.match = obj;
                     this.requestCard();
                  } else {
                     this.match = obj;
                  }
               }
            });
         })
      },

      disconnect() {
         if (this.stompClient !== null) {
            this.stompClient.disconnect();
            this.lobby = null;
            this.match = null;
            this.player = null;
            //TODO DELETE INSTANCE LOBBY - MATCH => JAVA
         }
      },

      requestCard() {
         this.stompClient.send("/app/room/" + this.lobby.idLobby + "/request_card/" + this.user.id);
          setTimeout(() => {
                  this.endMatch();
               }, 1000);
      },

      stopPlaying() {
         this.stompClient.send("/app/room/" + this.lobby.idLobby + "/stop_playing/" + this.user.id);
         setTimeout(() => {
                  this.endMatch();
               }, 1000);
      },

      changeMaxPlayer() {
         this.stompClient.send("/app/room/" + this.lobby.idLobby + "/resize/" + this.lobby.userMax + "/" + this.user.id);
      },

      changeLobbyAccess() {
         console.log("changing access");
         this.stompClient.send("/app/room/" + this.lobby.idLobby + "/access/" + !this.lobby.accessType + "/" + this.user.id);
      },

      startMatch() {
         this.stompClient.send("/app/room/" + this.lobby.idLobby + "/start/" + this.user.id);
         this.turn = this.user;
      },

      endMatch() {
         this.stompClient.send("/app/room/" + this.lobby.idLobby + "/check_end_match");
      },

      quitLobby() {
         axios.delete("http://localhost:8080/lobby",  {
               headers: {
                  Authorization: "Bearer " + this.user.token //the token is a variable which holds the token
               }
            }).then(response => {
               if (response.data.esito) {
                  if (this.lobby != null && this.stompClient != null) {
                     this.stompClient.send("/app/room/" + this.lobby.idLobby + "/quit");
                  }
                  this.lobby = null;
                  this.disconnect();
               } else {
                  console.log("Cannot disconnect");
               }
            })
      },

      quitMatch() {
         this.stompClient.send("/app/room/" + this.lobby.idLobby + "/quit_match/" + this.user.id);
         this.disconnect();
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