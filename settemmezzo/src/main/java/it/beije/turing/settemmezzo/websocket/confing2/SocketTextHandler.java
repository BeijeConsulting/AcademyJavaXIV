package it.beije.turing.settemmezzo.websocket.confing2;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class SocketTextHandler extends TextWebSocketHandler {
	
	List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
	
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message)
            throws InterruptedException, IOException {
    	
    	for(WebSocketSession webSocketSession : sessions) {
    		if (webSocketSession.isOpen() && !session.getId().equals(webSocketSession.getId())) {
    			String payload = message.getPayload();
    	        JSONObject jsonObject = new JSONObject(payload);
                webSocketSession.sendMessage(new TextMessage("Ciao ERCOLANO @idLobby = " + jsonObject.get("room_id")));
            }
    	}
    }
    
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
    }
}
