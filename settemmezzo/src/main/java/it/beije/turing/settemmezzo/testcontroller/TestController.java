package it.beije.turing.settemmezzo.testcontroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import it.beije.turing.settemmezzo.config.RegistryContainer;

@Slf4j
@Controller
public class TestController {

	private final SimpMessagingTemplate simpMessagingTemplate;

	@Autowired
	public TestController(SimpMessagingTemplate simpMessagingTemplate) {
		this.simpMessagingTemplate = simpMessagingTemplate;
	}

	@MessageMapping("/sock")
	public void creaSocket() {
		log.error("creaSocket: " + RegistryContainer.getInstance().getReg());
		System.err.println("###############");
		RegistryContainer.getInstance().getReg().addEndpoint("/lol").withSockJS();

	}
	
	@MessageMapping("/room/{room_id}")
	public void Greeting(@DestinationVariable("room_id") String roomId, String name ) {
		simpMessagingTemplate.convertAndSend("/lobby/" + roomId, "Ciao, " + name);
	}
	
}
