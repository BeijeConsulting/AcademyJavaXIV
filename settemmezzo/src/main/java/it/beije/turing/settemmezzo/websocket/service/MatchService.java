package it.beije.turing.settemmezzo.websocket.service;

import it.beije.turing.settemmezzo.exception.GameActionException;
import it.beije.turing.settemmezzo.game.User;
import it.beije.turing.settemmezzo.game.lobby.Lobby;
import it.beije.turing.settemmezzo.game.match.Match;
import it.beije.turing.settemmezzo.http.repository.UserAuthorityRepository;
import it.beije.turing.settemmezzo.http.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MatchService {

    @Autowired
	private UserRepository userRepository;
	
    public Match checkEndMatch(Lobby lobby) {
    	
    	if (lobby.getMatch() == null) return null;
    	
        if (!lobby.getMatch().isEnded()) return lobby.getMatch();

        
        log.debug("MATCH FINITO");
        Match m = lobby.getMatch().end();
        
        int winnerSize = m.getWinners().size() == 0 ? 1 : m.getWinners().size();
        
        int points = (50 * (m.getUsers().size()-1)) / winnerSize;
        
//        for (User user : m.getWinners())
//        {
//			User u = userRepository.findById(user.getId()).orElseThrow(() -> new GameActionException("IHIH"));
//			u.addScore(points);
//			userRepository.save(u);
//		}
        
        return m;
    }

    public Match quitMatch(Lobby lobby, User user) {

        Match match = lobby.getMatch().quitMatch(user);
        user.setLobby(null);
        
        lobby.quitLobby(user);
        return match;
    }
}
