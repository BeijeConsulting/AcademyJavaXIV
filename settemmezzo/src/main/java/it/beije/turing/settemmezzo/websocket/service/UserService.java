package it.beije.turing.settemmezzo.websocket.service;

import it.beije.turing.settemmezzo.game.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public Boolean requestCard(User user) {
        if (user.getLobby() == null) return false;
        else if (user.getLobby().getMatch() == null) return false;

        return user.getLobby().getMatch().requestCard(user);
    }

    public Boolean stopPlaying(User user) {
        if (user.getLobby() == null) return false;
        else if (user.getLobby().getMatch() == null) return false;

        return user.getLobby().getMatch().stopPlaying(user);
    }

    public Boolean resizeLobby(User user, Integer maxPlayers) {
        if (user.getLobby() == null) return false;

        return user.getLobby().setUserMax(user, maxPlayers);
    }

    public Boolean changeLobbyAccess(User user, Boolean accessType) {
        if (user.getLobby() == null) return false;

        return user.getLobby().changeLobbyAccess(user, accessType);
    }

    public Boolean startMatch(User user) {
        //TODO COUNT DOWN / STOP COUNT DOWN
        if (user.getLobby() == null) return false;

        //SET MATCH UTENTE?

        return user.getLobby().startMatch(user);
    }
}
