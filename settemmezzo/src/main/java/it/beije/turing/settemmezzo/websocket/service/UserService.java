package it.beije.turing.settemmezzo.websocket.service;

import it.beije.turing.settemmezzo.game.Game;
import it.beije.turing.settemmezzo.game.User;
import it.beije.turing.settemmezzo.game.lobby.Lobby;
import it.beije.turing.settemmezzo.http.repository.UserAuthorityRepository;
import it.beije.turing.settemmezzo.http.repository.UserRepository;
import it.beije.turing.settemmezzo.login.UserAuthority;
import it.beije.turing.settemmezzo.login.UserDto;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService{

    private final UserRepository userRepository;

    private final UserAuthorityRepository userAuthorityRepository;

    private static final Integer DEFAULT_AUTHORITY = 1;

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
                throw new RuntimeException("Email giá presente nel database");
            }
        } else {
            throw new RuntimeException("Nome, Cognome, Password o Email = null, o stringa vuota");
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
            throw new RuntimeException("No users found.");// TODONoContentException();
        }
        return list;
    }

    public User addUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("User already exists");
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
            throw new RuntimeException("No user found with given id");
        }
        userRepository.deleteById(user.getId());
        return true;
    }

    public User updateUser(User user, UserDto newUser) {

        if (newUser.getEmail() != null && newUser.getEmail() != "") {
            user.setEmail(newUser.getEmail());
        }
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
            throw new RuntimeException("email = null");
        }
//        catch (Exception e) {
//            throw e;
//        }
    }

    public Lobby createLobby(User user) {
        if (user.getLobby() != null) throw new RuntimeException("Already in a Lobby");

        Lobby lobby = user.getGame().createLobby(user);
        user.setLobby(lobby);

		if (user.getLobby() != null) return lobby;

        throw new RuntimeException("Error creating the Lobby");
    }

    public Lobby joinLobby(User user) {
        if (user.getLobby() != null) throw new RuntimeException("Already in a Lobby");

		if (user.getLobby().getIdLobby() <= -1) user.setLobby(user.getGame().joinPublicLobby(user));
		else user.setLobby(user.getGame().joinPrivateLobby(user, user.getLobby().getIdLobby()));

        if (user.getLobby() != null) return user.getLobby();

        throw new RuntimeException("Error joining the Lobby");
    }

    public Boolean quitLobby(User user) {
		if (user.getLobby() == null) throw new RuntimeException("Not in a Lobby");

		if (user.getLobby().quitLobby(user))
		{
			user.setLobby(null);
			return true;
		}

		return false;
    }
}
