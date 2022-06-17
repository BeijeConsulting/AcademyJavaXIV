package it.beije.turing.settemmezzo.testcontroller;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import it.beije.turing.settemmezzo.config.RegistryContainer;

@Controller
public class TestController {

	
	@MessageMapping("/sock")
	public void creaSocket() {
		 RegistryContainer.getInstance().getReg().addEndpoint("/lol").withSockJS();
	}
	
	@MessageMapping("/hello")
	@SendTo("/greetings")
	public String Greeting(String a ) {
		return("qualcosa"+a);
	}
	
}
