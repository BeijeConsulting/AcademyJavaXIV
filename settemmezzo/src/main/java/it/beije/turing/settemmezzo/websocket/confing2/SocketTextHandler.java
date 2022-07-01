package it.beije.turing.settemmezzo.websocket.confing2;

import it.beije.turing.settemmezzo.exception.GameActionException;
import it.beije.turing.settemmezzo.game.Game;
import it.beije.turing.settemmezzo.game.User;
import it.beije.turing.settemmezzo.game.lobby.Lobby;
import it.beije.turing.settemmezzo.game.match.Match;
import it.beije.turing.settemmezzo.websocket.service.MatchService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@Slf4j
public class SocketTextHandler extends TextWebSocketHandler {

    private  UserService userService = new UserService();

    private MatchService matchService = new MatchService();
	List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message)
            throws InterruptedException, IOException {
        log.debug("handleTextMessage");

        String payload = message.getPayload();
        JSONObject jsonPayload = new JSONObject(payload);

        JSONObject response = null;
        List<User> users = null;

        log.debug("quit lobby fuori" + jsonPayload);

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
                if (lobby != null) {
                    users = lobby.getUsers();
                    response = userService.buildJSONLobby(lobby);
                }

                break;
            }
            case "resizeLobby": {

                User user = setSenderUser(session, jsonPayload);
                Integer userMax = (Integer) jsonPayload.get("userMax");
                Lobby lobby = userService.resizeLobby(user, userMax);

                response = userService.buildJSONLobby(lobby);
                users = lobby.getUsers();

                break;
            }
            case "changeLobbyAccess": {

                User user = setSenderUser(session, jsonPayload);
                Boolean accessType = (Boolean) jsonPayload.get("accessType");
                Lobby lobby = userService.changeLobbyAccess(user, accessType);

                response = userService.buildJSONLobby(lobby);
                users = lobby.getUsers();

                break;
            }
            case "startMatch": {

                User user = setSenderUser(session, jsonPayload);
                Match match = userService.startMatch(user);

                response = userService.buildJSONMatch(match);
                users = match.getUsers();

                break;
            }
            case "requestCard": {

                User user = setSenderUser(session, jsonPayload);
                Match match = userService.requestCard(user);

                response = userService.buildJSONMatch(match);
                users = match.getUsers();

                break;
            }
            case "stopPlaying": {

                User user = setSenderUser(session, jsonPayload);
                Match match = userService.stopPlaying(user);

                response = userService.buildJSONMatch(match);
                users = match.getUsers();

                break;
            }
            case "quitMatch": {

                User user = setSenderUser(session, jsonPayload);
                Lobby lobby = user.getLobby();
                users = new ArrayList<>(lobby.getMatch().getUsers());
                Match match = matchService.quitMatch(lobby, user);

                response = userService.buildJSONMatch(match);

                break;
            }
            case "checkEndMatch": {

                User user = setSenderUser(session, jsonPayload);
                Lobby lobby = Game.getInstance().getLobby(user.getLobby().getIdLobby());
                Match match = matchService.checkEndMatch(lobby);

                response = userService.buildJSONMatch(match);
                users = match.getUsers();

                break;
            }
            default: {
                throw new GameActionException("Bad request sent to websocket");
            }
        }

        if (users != null && users.size() > 0) {
            sendResponse(response, users);
        }

    }

    private void sendResponse(JSONObject response, List<User> users)
            throws InterruptedException, IOException {

        log.debug("sendResponse");
        log.debug("users : " + users);
        log.debug("response : " + response);
        log.debug("sessions : " + sessions);

        for(WebSocketSession webSocketSession : sessions) {

            log.debug("webSocketSession = " + webSocketSession);
            log.debug("webSocketSession.isOpen() = " + webSocketSession.isOpen());

            if (webSocketSession.isOpen()) {
                for (User u : users) {
                    log.debug("user in users = " + u);
                    log.debug("id websocket in users = " + webSocketSession.getId());
                    log.debug("user id session = " + u.getSessionId());
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

            user.setSessionId(session.getId());

        } catch (JSONException ex) {
            ex.printStackTrace();
            throw new GameActionException("user_id fail reading");
        }
        return user;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        session.close();
        sessions.remove(session);
    }
}
