package it.beije.turing.settemmezzo.websocket.confing2;

import it.beije.turing.settemmezzo.exception.GameActionException;
import it.beije.turing.settemmezzo.game.Game;
import it.beije.turing.settemmezzo.game.User;
import it.beije.turing.settemmezzo.game.lobby.Lobby;
import it.beije.turing.settemmezzo.websocket.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
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
        JSONObject jsonObject = new JSONObject(payload);

        User user = null;
        try {
            Integer userId = (Integer) jsonObject.get("user_id");
            Game game = Game.getInstance();

            user = game.getUser(userId);
            log.debug("USER : " + user);

            if (user.getSessionId() == null) user.setSessionId(session.getId());

        } catch (JSONException ex) {
            ex.printStackTrace();
            throw new GameActionException("user_id fail reading");
        }
        Lobby lobby = user.getLobby();

        JSONObject response = new JSONObject();
        response.put("idLobby", lobby.getIdLobby());
        response.put("accessType", lobby.isAccessType());
        response.put("userMax", lobby.getUserMax());
        response.put("match", lobby.getMatch());
//
        JSONArray jsonArray = new JSONArray();

        log.debug("users" + jsonArray);

        for (User u : lobby.getUsers()) {
            JSONObject jsonObjectTemp = new JSONObject();
            jsonObjectTemp.put("id", u.getId());
            jsonObjectTemp.put("username", u.getUsername());
            jsonObjectTemp.put("score", u.getScore());

            jsonArray.put(jsonObjectTemp);
        }

        response.put("users", jsonArray);

    	for(WebSocketSession webSocketSession : sessions) {
            log.debug("sessione : " + webSocketSession);
    		if (webSocketSession.isOpen()) {

                for (User u : lobby.getUsers()) {
                    log.debug("user sessionid : " + u.getSessionId());
                    log.debug("sessionid : " + webSocketSession.getId());
                    if (u.getSessionId().equals(webSocketSession.getId())) {
                        webSocketSession.sendMessage(new TextMessage(response.toString()));
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
