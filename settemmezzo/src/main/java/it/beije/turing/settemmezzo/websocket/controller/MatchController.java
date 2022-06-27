package it.beije.turing.settemmezzo.websocket.controller;

import it.beije.turing.settemmezzo.game.User;
import it.beije.turing.settemmezzo.game.lobby.Lobby;
import it.beije.turing.settemmezzo.websocket.service.MatchService;
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
public class MatchController {

	private final MatchService matchService;

	private final SimpMessagingTemplate simpMessagingTemplate;

	@MessageMapping("/room/{room_id}/check_end_match")
	public void checkEndMatch(@DestinationVariable("room_id") Integer roomId) {

		//TODO ricavare lobby
		Lobby lobby = createFakeLobby(roomId);

		simpMessagingTemplate.convertAndSend("/lobby/" + roomId, matchService.checkEndMatch(lobby));
	}

	public Lobby createFakeLobby(Integer roomId) {
		User user = new User();
		user.setEmail("popo@gmail.com");
		user.setPassword("popo");
		user.setScore(15);
		user.setUsername("popino");
		return new Lobby(user, roomId);
	}
	
}

//MATCH//////////////
//checkEndMatch