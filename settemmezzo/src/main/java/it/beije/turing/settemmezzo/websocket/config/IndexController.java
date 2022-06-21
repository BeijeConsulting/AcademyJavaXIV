package it.beije.turing.settemmezzo.websocket.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {
    @GetMapping("/")
    String index(){
        log.info("GET index");
        return "index.html";
    }

}
