//package it.beije.turing.settemmezzo.websocket.controller;
//
//import it.beije.turing.settemmezzo.game.Game;
//import it.beije.turing.settemmezzo.game.User;
//import it.beije.turing.settemmezzo.websocket.service.UserService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.messaging.handler.annotation.DestinationVariable;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//@Slf4j
//@CrossOrigin(origins = "http://localhost:3000")
//@Controller
//@RequiredArgsConstructor
//public class UserSocketController {
//
//
//
//    private final UserService userService;
//
//    private final SimpMessagingTemplate simpMessagingTemplate;
//
//    @MessageMapping("/room/{room_id}/{user_id}")
//    public void connectLobby(@DestinationVariable("room_id") Integer roomId, @DestinationVariable("user_id") Integer userId, String message) {
//        log.debug("connectLobby");
//        log.debug("message: " + message);
//
//        User user = Game.getInstance().getUser(userId);
//
//        simpMessagingTemplate.convertAndSend("/lobby/" + roomId, user.getLobby());
//    }
//
//    @MessageMapping("/room/{room_id}/quit")
//    public void quitLobby(@DestinationVariable("room_id") Integer roomId) {
//        log.debug("quitLobby");
//
//        simpMessagingTemplate.convertAndSend("/lobby/" + roomId, Game.getInstance().getLobby(roomId));
//    }
//
//    @MessageMapping("/room/{room_id}/stop_playing/{user_id}")
//    public void stopPlaying(@DestinationVariable("room_id") Integer roomId, @DestinationVariable("user_id") Integer userId) {
//        //utente fittizio
//        User user = Game.getInstance().getUser(userId);
//
//        simpMessagingTemplate.convertAndSend("/lobby/" + roomId, userService.stopPlaying(user));
//    }
//
//    @MessageMapping("/room/{room_id}/resize/{max_players}/{user_id}")
//    public void resizeLobby(@DestinationVariable("room_id") Integer roomId, @DestinationVariable("max_players") Integer maxPlayers, @DestinationVariable("user_id") Integer userId) {
//        log.debug("resizeLobby");
//        User user = Game.getInstance().getUser(userId);
//
//        simpMessagingTemplate.convertAndSend("/lobby/" + roomId, userService.resizeLobby(user, maxPlayers));
//    }
//
//    @MessageMapping("/room/{room_id}/access/{access_type}/{user_id}")
//    public void changeLobbyAccess(@DestinationVariable("room_id") Integer roomId, @DestinationVariable("access_type") Boolean accessType, @DestinationVariable("user_id") Integer userId) {
//        log.debug("changeLobbyAccess");
//        User user = Game.getInstance().getUser(userId);
//
//        simpMessagingTemplate.convertAndSend("/lobby/" + roomId, userService.changeLobbyAccess(user, accessType));
//    }
//
//    @MessageMapping("/room/{room_id}/start/{user_id}")
//    public void startMatch(@DestinationVariable("room_id") Integer roomId, @DestinationVariable("user_id") Integer userId) {
//        log.debug("startMatch");
//        User user = Game.getInstance().getUser(userId);
//
//        simpMessagingTemplate.convertAndSend("/lobby/" + roomId, userService.startMatch(user));
//    }
//
//    @MessageMapping("/room/{room_id}/request_card/{user_id}")
//    public void requestCard(@DestinationVariable("room_id") Integer roomId, @DestinationVariable("user_id") Integer userId) {
//        log.debug("requestCard");
//        User user = Game.getInstance().getUser(userId);
//
//        simpMessagingTemplate.convertAndSend("/lobby/" + roomId, userService.requestCard(user));
//    }
//}