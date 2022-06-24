package it.beije.turing.settemmezzo.websocket.controller;

import it.beije.turing.settemmezzo.exception.GameActionException;
import it.beije.turing.settemmezzo.game.User;
import it.beije.turing.settemmezzo.websocket.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserSocketController {



    private final UserService userService;

    private final SimpMessagingTemplate simpMessagingTemplate;

//    @MessageMapping("/room/{room_id}")
//    public void prova(@DestinationVariable("room_id") Integer roomId) {
//        //TODO Aggiungere Auth nel param. per prendere l'utente che richiede l'aizone
//        //utente fittizio
//        User user = createFINTOUser();
//
//        simpMessagingTemplate.convertAndSend("/lobby/" + roomId, true);
//    }

    @MessageMapping("/room/{room_id}/stop_playing")
    public void stopPlaying(@DestinationVariable("room_id") Integer roomId) {
        //TODO Aggiungere Auth nel param. per prendere l'utente che richiede l'aizone
        //utente fittizio
        User user = createFINTOUser();

        simpMessagingTemplate.convertAndSend("/lobby/" + roomId, userService.stopPlaying(user));
    }

    @MessageMapping("/room/{room_id}/resize/{max_players}")
    public void resizeLobby(@DestinationVariable("room_id") Integer roomId, @DestinationVariable("max_players") Integer maxPlayers) {
        //TODO Aggiungere Auth nel param. per prendere l'utente che richiede l'aizone
        //utente fittizio
        User user = createFINTOUser();

        simpMessagingTemplate.convertAndSend("/lobby/" + roomId, userService.resizeLobby(user, maxPlayers));
    }

    @MessageMapping("/room/{room_id}/access/{access_type}")
    public void changeLobbyAccess(@DestinationVariable("room_id") Integer roomId, @DestinationVariable("access_type") Boolean accessType) {
        //TODO Aggiungere Auth nel param. per prendere l'utente che richiede l'aizone
        //utente fittizio
        User user = createFINTOUser();

        simpMessagingTemplate.convertAndSend("/lobby/" + roomId, userService.changeLobbyAccess(user, accessType));
    }

    @MessageMapping("/room/{room_id}/start")
    public void startMatch(@DestinationVariable("room_id") Integer roomId) {
        //TODO Aggiungere Auth nel param. per prendere l'utente che richiede l'aizone
        //utente fittizio
        User user = createFINTOUser();

        simpMessagingTemplate.convertAndSend("/lobby/" + roomId, userService.startMatch(user));
    }

    @MessageMapping("/room/{room_id}/request_card")
    public void requestCard(@DestinationVariable("room_id") Integer roomId) {
        //TODO Aggiungere Auth nel param. per prendere l'utente che richiede l'aizone
        //utente fittizio
        User user = createFINTOUser();

        simpMessagingTemplate.convertAndSend("/lobby/" + roomId, userService.requestCard(user));
    }

    public User createFINTOUser() {
        User user = new User();
        user.setEmail("popo@gmail.com");
        user.setPassword("popo");
        user.setScore(15);
        user.setUsername("popino");
        return user;
    }

}

//UTENTE//////////
// richiesta carta -- socket
// create lobby -- rest
// join lobby -- rest
// quit lobby -- rest
// stop gioco = non voglio piu carte -- socket
// HOST//////////
//resize lobby -- socket
//private lobby -- socket
// start match -- socket
