package it.beije.turing.settemmezzo.websocket.service;

import it.beije.turing.settemmezzo.game.User;
import it.beije.turing.settemmezzo.game.deck.Hand;
import it.beije.turing.settemmezzo.game.lobby.Lobby;
import it.beije.turing.settemmezzo.game.match.Match;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MatchService {

    public Match checkEndMatch(Lobby lobby) {

        if (!lobby.getMatch().isEnded()) return lobby.getMatch();

        
        log.debug("MATCH FINITO");
        return lobby.getMatch().end();
    }

    public Match quitMatch(Lobby lobby, User user) {

        Match match = lobby.getMatch().quitMatch(user);
        lobby.quitLobby(user);
        user.setLobby(null);
        return match;
    }
}
