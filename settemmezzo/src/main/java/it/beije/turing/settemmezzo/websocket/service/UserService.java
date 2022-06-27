package it.beije.turing.settemmezzo.websocket.service;

import it.beije.turing.settemmezzo.exception.AlreadyExistException;
import it.beije.turing.settemmezzo.exception.GameActionException;
import it.beije.turing.settemmezzo.exception.InvalidArgumentException;
import it.beije.turing.settemmezzo.exception.NoContentException;
import it.beije.turing.settemmezzo.exception.SettemmezzoException;
import it.beije.turing.settemmezzo.game.User;
import it.beije.turing.settemmezzo.game.lobby.Lobby;
import it.beije.turing.settemmezzo.game.match.Match;
import it.beije.turing.settemmezzo.http.repository.UserAuthorityRepository;
import it.beije.turing.settemmezzo.http.repository.UserRepository;
import it.beije.turing.settemmezzo.login.UserAuthority;
import it.beije.turing.settemmezzo.login.UserDto;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {


    private final UserRepository userRepository;

    private final UserAuthorityRepository userAuthorityRepository;

    private static final Integer DEFAULT_AUTHORITY = 1;

    public Match requestCard(User user) {
        if (user.getLobby() == null) return null;
        else if (user.getLobby().getMatch() == null) return null;

        if (user.getLobby().getMatch().isEnded() || !user.getLobby().getMatch().getPlayerHand(user.getId()).isTurn()) return user.getLobby().getMatch();

        user.getLobby().getMatch().requestCard(user);
        return user.getLobby().getMatch();
    }

    public Match stopPlaying(User user) {
        if (user.getLobby() == null) return null;
        else if (user.getLobby().getMatch() == null) return null;

        if (user.getLobby().getMatch().isEnded() || !user.getLobby().getMatch().getPlayerHand(user.getId()).isTurn()) return user.getLobby().getMatch();

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
}
