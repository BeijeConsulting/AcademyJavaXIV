package it.beije.turing.settemmezzo.game.lobby;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import it.beije.turing.settemmezzo.game.Game;
import it.beije.turing.settemmezzo.game.User;
import it.beije.turing.settemmezzo.game.match.Match;

public class Lobby
{
	private List<User> users = null;
	private int idLobby;
	private boolean privateSession = true;
	private int userMax = 7;
	private Match match;			//GET/SET IMPLEMENTAZIONE
	
	public Lobby(User host, int idLobby)
	{
		this.idLobby = idLobby;
		users = new ArrayList<>();
		users.add(host);
	}

	
	public int getUsersSize()
	{
		return users.size();
	}
	
	public int getIdLobby() {
		return idLobby;
	}
	
	public Match getMatch() {
		return match;
	}

	public boolean isPrivateSession() {
		return privateSession;
	}

	public boolean setPrivateSession(User user, boolean privateSession)		//SOLO HOST
	{				
		if (user != users.get(0)) return false;
		
		this.privateSession = privateSession;
		
		return true;
	}

	public int getUserMax() {
		return userMax;
	}

	public boolean setUserMax(User user, int userMax)				//SOLO HOST
	{
		if (user != users.get(0)) return false;
		
		if (userMax < 2) userMax = 2;
		else if (userMax > 7) userMax = 7;
		else if (users.size() >= userMax) userMax = users.size();
		
		this.userMax = userMax;
		
		return true;
	}
	
	public boolean joinLobby(User user)
	{
		if (users.size() >= userMax) return false;
		
		users.add(user);
		
		return true;
	}
	
	public boolean startMatch(User user)		//COUNTDOWN --> INIZIO PARTITA			//SOLO HOST
	{
		if (user != users.get(0)) return false;
		
		match = new Match(users);
		
		return match.start();
	}
	
	public boolean quitLobby(User user)			//TUTTI
	{
		boolean success = users.remove(user);
		
		if (users.size() == 0) Game.getInstance().destroyLobby(this);
		
		return success;
	}
}