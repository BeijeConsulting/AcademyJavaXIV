package it.beije.turing.settemmezzo.config;

import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompBrokerRelayMessageHandler;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

public class RegistryContainer {

	private StompEndpointRegistry reg;
	private static RegistryContainer cont;
	
 private RegistryContainer() {}
 
 public static RegistryContainer getInstance() {
	 if(cont==null)
	 {
		 cont=new RegistryContainer();
	 }
	 return cont;
 }

public StompEndpointRegistry getReg() {
	return reg;
}

public void setReg(StompEndpointRegistry reg) {
	this.reg = reg;
}


 
 
}
