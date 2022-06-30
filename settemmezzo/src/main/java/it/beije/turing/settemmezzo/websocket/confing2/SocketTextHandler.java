package it.beije.turing.settemmezzo.websocket.confing2;

import it.beije.turing.settemmezzo.exception.GameActionException;
import it.beije.turing.settemmezzo.game.Game;
import it.beije.turing.settemmezzo.game.User;
import it.beije.turing.settemmezzo.game.lobby.Lobby;
import it.beije.turing.settemmezzo.websocket.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@Slf4j
public class SocketTextHandler extends TextWebSocketHandler {

    @Autowired
    private UserService userService;
	List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message)
            throws InterruptedException, IOException {
        log.debug("handleTextMessage");

        String payload = message.getPayload();
        log.debug(payload);
        JSONObject jsonObject = new JSONObject(payload);
        log.debug("json" + jsonObject);
        log.debug("QUESTA E LA CLASSe");

        User user = null;
        try {
            Integer userId = (Integer) jsonObject.get("user_id");
            log.debug("userId " + userId);

            Game game = Game.getInstance();
            log.debug("Game " + game);

            Lobby lobby = Game.getInstance().getLobby(0);
            log.debug("lobby : " + lobby);

            user = game.getUser(userId);
            log.debug("USER : " + user);

            if (user.getSessionId() != null) user.setSessionId(session.getId());

        } catch (JSONException ex) {
            ex.printStackTrace();
            throw new GameActionException("user_id fail reading");
        }

        Lobby lobby = user.getLobby();
        log.debug("lobby + " + lobby);

    	for(WebSocketSession webSocketSession : sessions) {
            log.debug("sessione : " + webSocketSession);
    		if (webSocketSession.isOpen()) {

                for (User u : lobby.getUsers()) {
                    if (webSocketSession.getId().compareTo(u.getSessionId()) == 0) {
                        webSocketSession.sendMessage(new TextMessage(lobby.toString()));
                    }
                }
            }
    	}
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.debug("session : " + session);
        sessions.add(session);
    }
}
