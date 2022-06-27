package it.beije.turing.settemmezzo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@ComponentScan("it.beije.turing")
public class SettemmezzoApplication {
	//API location: http://localhost:8080/swagger-ui/index.html
	public static void main(String[] args) {
		log.info("SERVER_PORT : " + System.getenv("SERVER_PORT"));
		SpringApplication.run(SettemmezzoApplication.class, args);
	}

}
