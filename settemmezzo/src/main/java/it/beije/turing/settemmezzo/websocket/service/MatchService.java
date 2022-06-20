package it.beije.turing.settemmezzo.websocket.service;

import it.beije.turing.settemmezzo.game.deck.Hand;
import it.beije.turing.settemmezzo.game.lobby.Lobby;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    public Boolean checkEndMatch(Lobby lobby) {

        for (Hand hand : lobby.getMatch().getHands())
        {
            if (hand.getContinuePlaying())
            {
                return false;
            }
        }

        lobby.getMatch().end();

        return true;
    }

}
