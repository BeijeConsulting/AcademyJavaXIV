package it.beije.turing.settemmezzo.websocket.testcontroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class TestController {

	private final SimpMessagingTemplate simpMessagingTemplate;

	@Autowired
	public TestController(SimpMessagingTemplate simpMessagingTemplate) {
		this.simpMessagingTemplate = simpMessagingTemplate;
	}

	@MessageMapping("/room/{room_id}")
	public void createLobby(@DestinationVariable("room_id") String roomId) {
		simpMessagingTemplate.convertAndSend("/lobby/" + roomId, "Lobby #" + roomId + " creata");
	}
	
}
