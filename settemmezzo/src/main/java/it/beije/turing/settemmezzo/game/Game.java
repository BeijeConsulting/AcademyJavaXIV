package it.beije.turing.settemmezzo.game;

import java.util.ArrayList;
import java.util.List;

import it.beije.turing.settemmezzo.game.lobby.Lobby;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game
{	
	private static Game single_instance = null;
	
	private List<Lobby> lobbies = new ArrayList<>();
	private List<User> users = new ArrayList<>();
//	private Leaderboard leaderboard = new Leaderboard();
	private int idCount = 0;
	
	
	private Game() {}
    
    public static Game getInstance()
    {

        if (single_instance == null) {
            single_instance = new Game();
		}

        return single_instance;
    }

	public List<User> getUsers() {
		return users;
	}

	//REST
	public Lobby createLobby(User user)
	{
		Lobby lobby = new Lobby(user, idCount++);
		lobbies.add(lobby);
		
		return lobby;
	}

	//REST
//	public Leaderboard getLeaderboard()
//	{
//		updateLeaderboard();
//
//		return leaderboard;
//	}


//	private void updateLeaderboard()
//	{
//		leaderboard.update();
//	}

	public Lobby joinPrivateLobby(User user, int idLobby)
	{
		for (Lobby lobby : lobbies)
		{
			if (lobby.getIdLobby() == idLobby && lobby.getMatch() == null)
			{
				lobby.joinLobby(user);
				return lobby;
			}
		}
		
		return null;
	}
	
	public Lobby joinPublicLobby(User user)
	{
		for (Lobby lobby : lobbies)
		{
			if (lobby.getUsersSize() < lobby.getUserMax() && lobby.isAccessType() && lobby.getMatch() == null)
			{
				lobby.joinLobby(user);
				return lobby;
			}
		}
		
		Lobby lobby = createLobby(user);
		lobby.changeLobbyAccess(user, true);

		return lobby;

	}

	public void destroyLobby(Lobby lobby)
	{
		lobbies.remove(lobby);
	}
	
	public void addUser(User user)
	{
//		if (getUser(user.getId()) == null) users.add(user);
		users.add(user);
	}
	
	public void removeUser(User user)
	{
		users.remove(user);
	}

	public User getUser(Integer userId)
	{
		for (User user : users)
		{
			if (user.getId().compareTo(userId) == 0) {

				return user;
			}
		}
		
		return null;
	}

	public Lobby getLobby(Integer lobbyId)
	{
		for (Lobby lobby : lobbies)
		{
			if (lobby.getIdLobby() == lobbyId) return lobby;
		}

		return null;
	}
//
	@Override
	public String toString() {
		return "Game{" +
				"lobbies=" + lobbies +
				", users=" + users +
				", idCount=" + idCount +
				'}';
	}
}