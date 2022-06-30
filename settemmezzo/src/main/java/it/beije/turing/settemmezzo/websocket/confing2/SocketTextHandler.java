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
import org.springframework.web.socket.CloseStatus;
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

    private  UserService userService = new UserService();
	List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message)
            throws InterruptedException, IOException {
        log.debug("handleTextMessage");

        String payload = message.getPayload();
        JSONObject jsonPayload = new JSONObject(payload);

        JSONObject response = null;
        List<User> users = null;

        switch ((String) jsonPayload.get("method")) {
            case "connectLobby": {

                User user = setSenderUser(session, jsonPayload);

                response = userService.getLobby(user);
                users = user.getLobby().getUsers();
                break;
            }
            case "quitLobby": {

                Integer idLobby = (Integer) jsonPayload.get("idLobby");
                Lobby lobby = Game.getInstance().getLobby(idLobby);
                users = lobby.getUsers();
                response = userService.buildJSONLobby(lobby);

                break;
            }
            case "requestCard": {

                break;
            }
            case "stopPlaying": {
                break;
            }
            case "resizeLobby": {
                break;
            }
            case "changeLobbyAccess": {
                break;
            }
            case "startMatch": {
                break;
            }
            default: {
                throw new GameActionException("Bad request sent to websocket");
            }
        }

        sendResponse(response, users);

    }

    private void sendResponse(JSONObject response, List<User> users)
            throws InterruptedException, IOException {

        for(WebSocketSession webSocketSession : sessions) {

            if (webSocketSession.isOpen()) {
                for (User u : users) {
                    if (u.getSessionId().equals(webSocketSession.getId())) {
                        webSocketSession.sendMessage(new TextMessage(response.toString()));
                    }
                }
            }
        }
    }

    public User setSenderUser(WebSocketSession session, JSONObject jsonPayload) {
        User user = null;
        try {
            Integer userId = (Integer) jsonPayload.get("user_id");
            Game game = Game.getInstance();

            user = userService.getUserInGame(userId);
            log.debug("USER : " + user);

            if (user.getSessionId() == null) user.setSessionId(session.getId());

        } catch (JSONException ex) {
            ex.printStackTrace();
            throw new GameActionException("user_id fail reading");
        }
        return user;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.debug("session : " + session);
        sessions.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        session.close();
        sessions.remove(session);
    }
}
