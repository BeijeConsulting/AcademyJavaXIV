//package it.beije.turing.settemmezzo.websocket.controller;
//
//import it.beije.turing.settemmezzo.game.Game;
//import it.beije.turing.settemmezzo.game.User;
//import it.beije.turing.settemmezzo.game.lobby.Lobby;
//import it.beije.turing.settemmezzo.websocket.service.MatchService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.messaging.handler.annotation.DestinationVariable;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//@CrossOrigin(origins = "http://localhost:3000")
//
//@Slf4j
//@Controller
//@RequiredArgsConstructor
//public class MatchController {
//
//	private final MatchService matchService;
//
//	private final SimpMessagingTemplate simpMessagingTemplate;
//
//	@MessageMapping("/room/{room_id}/check_end_match")
//	public void checkEndMatch(@DestinationVariable("room_id") Integer roomId) {
//		log.debug("checkEndMatch");
//
//		Lobby lobby = Game.getInstance().getLobby(roomId);
//
//		simpMessagingTemplate.convertAndSend("/lobby/" + roomId, matchService.checkEndMatch(lobby));
//	}
//
//	@MessageMapping("/room/{room_id}/quit_match/{user_id}")
//	public void quitMatch(@DestinationVariable("room_id") Integer roomId, @DestinationVariable("user_id") Integer userId) {
//		log.debug("quitMatch");
//
//		Lobby lobby = Game.getInstance().getLobby(roomId);
//		User user = Game.getInstance().getUser(userId);
//
//		simpMessagingTemplate.convertAndSend("/lobby/" + roomId, matchService.quitMatch(lobby, user));
//	}
//}