package it.beije.turing.settemmezzo.websocket.service;

import it.beije.turing.settemmezzo.exception.AlreadyExistException;
import it.beije.turing.settemmezzo.exception.GameActionException;
import it.beije.turing.settemmezzo.exception.InvalidArgumentException;
import it.beije.turing.settemmezzo.exception.NoContentException;
import it.beije.turing.settemmezzo.exception.SettemmezzoException;
import it.beije.turing.settemmezzo.game.Game;
import it.beije.turing.settemmezzo.game.Leaderboard;
import it.beije.turing.settemmezzo.game.User;
import it.beije.turing.settemmezzo.game.deck.Card;
import it.beije.turing.settemmezzo.game.deck.Hand;
import it.beije.turing.settemmezzo.game.lobby.Lobby;
import it.beije.turing.settemmezzo.game.match.Match;
import it.beije.turing.settemmezzo.http.repository.UserAuthorityRepository;
import it.beije.turing.settemmezzo.http.repository.UserRepository;
import it.beije.turing.settemmezzo.login.UserAuthority;
import it.beije.turing.settemmezzo.login.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class UserService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAuthorityRepository userAuthorityRepository;

    private static final Integer DEFAULT_AUTHORITY = 1;

    public Match requestCard(User user) {
        if (user.getLobby() == null) return null;
        else if (user.getLobby().getMatch() == null) return null;

        if (user.getLobby().getMatch().isEnded() || (user.getLobby().getMatch().getPlayerHand(user.getId()).getCards().size() > 0 && !user.getLobby().getMatch().getPlayerHand(user.getId()).isTurn())) return user.getLobby().getMatch();

        user.getLobby().getMatch().requestCard(user);
        return user.getLobby().getMatch();
    }

    public Match stopPlaying(User user) {
        if (user.getLobby() == null) return null;
        else if (user.getLobby().getMatch() == null) return null;

        if (user.getLobby().getMatch().isEnded() || !user.getLobby().getMatch().getPlayerHand(user.getId()).isTurn()) return user.getLobby().getMatch();
        
        log.debug("ENTRO STOP PLAYING");
        user.getLobby().getMatch().stopPlaying(user);
        return user.getLobby().getMatch();
    }

    public Lobby resizeLobby(User user, Integer maxPlayers) {
        if (user.getLobby() == null) return null;

        user.getLobby().setUserMax(user, maxPlayers);
        return user.getLobby();
    }

    public Lobby changeLobbyAccess(User user, Boolean accessType) {
        if (user.getLobby() == null) return null;

        user.getLobby().changeLobbyAccess(user, accessType);
        return user.getLobby();
    }

    public Match startMatch(User user) {
        //TODO COUNT DOWN / STOP COUNT DOWN
        if (user.getLobby() == null) return null;

        //SET MATCH UTENTE?

        return user.getLobby().startMatch(user);
    }

    private void setDefaultAuthority(User newUser) {

        UserAuthority userAuthority = new UserAuthority();
        userAuthority.setUserId(newUser.getId());
        userAuthority.setAuthorityId(DEFAULT_AUTHORITY);
        userAuthorityRepository.saveAndFlush(userAuthority);

    }

    public void saveRegisteredUser(User user) {
        userRepository.save(user);
    }

    public User createUser(User user) {

        if ((user.getUsername() != null && !user.getUsername().isEmpty()
                && user.getPassword() != null && !user.getPassword().isEmpty())
                && (user.getEmail() != null && !user.getEmail().isEmpty())) {

            if (userRepository.findByEmail(user.getEmail()) == null) {

                User newUser = userRepository.save(user);
                setDefaultAuthority(newUser);

                userRepository.flush();

                return user;
            } else {
                throw new AlreadyExistException("Email giá presente nel database");
            }
        } else {
            throw new InvalidArgumentException("Nome, Cognome, Password o Email = null, o stringa vuota");
        }
    }

    public JSONObject getLobby(User user) {
        return buildJSONLobby(user.getLobby());
    }



//    private JSONObject buildJSONMatch() {
//
//    }

//	public UserDto login(String email, String password) {
//		System.out.print("Password inserita: " + passwordEncoder.encode(password));
//		System.out.print("Password inserita: " + passwordEncoder.encode(password));
//		// TODO buon lunedì owo
//
//		User user = userRepository.findByEmail(email);
//		if (user == null) {
//			throw new RuntimeException("No user found.");// TODONoContentException();
//		}
//		if (passwordEncoder.matches(password, user.getPassword())) {
//			System.out.println("Password corretta");
//		}
//
//		return new UserDto(user);
//	}

    public List<User> getAllUser() {
        List<User> list = userRepository.findAll();

        if (list.isEmpty()) {
            throw new NoContentException("No users found.");// TODONoContentException();
        }
        return list;
    }

    public User getUserInGame(Integer userId) {
        User user = Game.getInstance().getUser(userId);
        if (user != null) return user;
        throw new GameActionException("No user found in game");
    }

    public User getUser(Integer id) {
    	
    	User user = userRepository.findById(id).get();
    	
    	if(user == null) {
    		throw new NoContentException();
    	}
    	return user;
    	
    }

    public User addUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new AlreadyExistException("User already exists");
        }
        try {
            userRepository.save(user);
        } catch (IllegalArgumentException e) {
            throw e;
        }

        return user;

    }

    public boolean removeUser(User user) {

        if (user == null) {
            throw new NoContentException("No user found with given id");
        }
        userRepository.deleteById(user.getId());
        return true;
    }

    public User updateUser(User user, UserDto newUser) {
        if (newUser.getPassword() != null && newUser.getPassword() != "") {
            user.setPassword(newUser.getPassword());
        }
        if (newUser.getUsername() != null && newUser.getEmail() != "") {
            user.setUsername(newUser.getUsername());
        }

        userRepository.save(user);

        return user;
    }
    
    public User loadUserByUsername(String email) throws UsernameNotFoundException {

        try {
            User utente = userRepository.findByEmail(email);
            if (utente == null) {

                throw new UsernameNotFoundException("email: " + email + " not found");
            }

            return utente;
        } catch (IllegalArgumentException iaEx) {
            throw new InvalidArgumentException("email = null");
        }
//        catch (Exception e) {
//            throw e;
//        }
    }

    public Lobby createLobby(User user) {
        if (user.getLobby() != null) throw new GameActionException("Already in a Lobby");

        Lobby lobby = user.getGame().createLobby(user);
        user.setLobby(lobby);

		if (user.getLobby() != null) return lobby;

        throw new GameActionException("Error creating the Lobby");
    }

    public Lobby joinLobby(User user, Integer roomId) {
        if (user.getLobby() != null) throw new GameActionException("Already in a Lobby");

		if (roomId <= -1) user.setLobby(user.getGame().joinPublicLobby(user));
		else user.setLobby(user.getGame().joinPrivateLobby(user, roomId));
		
        user.setOnline(true);

        if (user.getLobby() != null) return user.getLobby();

        throw new GameActionException("Error joining the Lobby");
    }

    public Map<String, Boolean> quitLobby(User user) {
		if (user.getLobby() == null) throw new GameActionException("Not in a Lobby");

        Map<String, Boolean> esito = new HashMap<String, Boolean>();

		if (user.getLobby().quitLobby(user))
		{
			user.setLobby(null);
            esito.put("esito", Boolean.TRUE);
			return esito;
		}

        esito.put("esito", Boolean.FALSE);
        return esito;
    }

	public Leaderboard getLeaderboard()
	{
		Leaderboard leaderboard = new Leaderboard(userRepository.getLeaderboard());
		return leaderboard;
	}

    public JSONObject buildJSONLobby(Lobby lobby) {

        JSONObject response = new JSONObject();

        response.put("idLobby", lobby.getIdLobby());
        response.put("accessType", lobby.isAccessType());
        response.put("userMax", lobby.getUserMax());
        response.put("match", lobby.getMatch());

        JSONArray jsonArray = new JSONArray();

        for (User u : lobby.getUsers()) {
            JSONObject jsonObjectTemp = new JSONObject();
            jsonObjectTemp.put("id", u.getId());
            jsonObjectTemp.put("username", u.getUsername());
            jsonObjectTemp.put("score", u.getScore());

            jsonArray.put(jsonObjectTemp);
        }

        response.put("users", jsonArray);

        return response;
    }

    public JSONObject buildJSONMatch(Match match) {

        JSONObject response = new JSONObject();


        if (match.getHands() != null && match.getHands().size() > 0) {

            JSONArray hands = new JSONArray();

            for (Hand hand : match.getHands()) {
                JSONObject handTemp = new JSONObject();
                JSONObject userTemp = new JSONObject();
                userTemp.put("id", hand.getUser().getId());
                userTemp.put("username", hand.getUser().getUsername());
                userTemp.put("score", hand.getUser().getScore());

                handTemp.put("user", userTemp);

                JSONArray cards = new JSONArray();

                for (Card card : hand.getCards()) {
                    JSONObject cardTemp = new JSONObject();
                    cardTemp.put("value", card.getValue());
                    cardTemp.put("seed", card.getSeed());
                    cardTemp.put("figure", card.getFigure());

                    cards.put(cardTemp);
                }

                handTemp.put("cards", cards);
                handTemp.put("cardValue", hand.getCardValue());
                handTemp.put("continuePlaying", hand.getContinuePlaying());
                handTemp.put("turn", hand.isTurn());

                hands.put(handTemp);
            }

            response.put("hands", hands);
        } else {
            response.put("hands", new ArrayList<>());
        }

        if (match.getUsers() != null && match.getUsers().size() > 0) {

            JSONArray users = new JSONArray();

            for (User u : match.getUsers()) {
                JSONObject userTemp = new JSONObject();
                userTemp.put("id", u.getId());
                userTemp.put("username", u.getUsername());
                userTemp.put("score", u.getScore());

                users.put(userTemp);
            }

            response.put("users", users);
        } else {
            response.put("users", new ArrayList<>());
        }

        if (match.getWinners() != null && match.getWinners().size() > 0) {

            JSONArray winners = new JSONArray();

            for (User u : match.getWinners()) {
                JSONObject winnerTemp = new JSONObject();
                winnerTemp.put("id", u.getId());
                winnerTemp.put("username", u.getUsername());
                winnerTemp.put("score", u.getScore());

                winners.put(winnerTemp);
            }

            response.put("winners", winners);
        } else {
            response.put("winners", new ArrayList<>());
        }

        response.put("ended", match.isEnded());



        return response;
    }
}
