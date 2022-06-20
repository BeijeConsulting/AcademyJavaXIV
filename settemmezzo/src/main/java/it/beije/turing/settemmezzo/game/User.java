package it.beije.turing.settemmezzo.game;

import it.beije.turing.settemmezzo.game.deck.Card;
import it.beije.turing.settemmezzo.game.lobby.Lobby;

public class User
{
	private String username;
	
	private String email;
	private String password;
	
	private int score = 0;				//---^ DB SINCRO
	
	private boolean online = false;		//NON A DB SOLO IN LOCALE
	
	private Game game = Game.getInstance();		//NON A DB SOLO IN LOCALE
	private Lobby lobby = null;		//NON A DB SOLO IN LOCALE

	
	
	public Lobby getLobby() {
		return lobby;
	}

	public void setLobby(Lobby lobby) {
		this.lobby = lobby;
	}

	public boolean getOnline()
	{
		return online;
	}
	
	public void setOnline(boolean online)
	{
		this.online = online;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public boolean createLobby()
	{
		if (lobby != null) return false;
		
		game.createLobby(this);
		
		if (lobby != null) return true;
		
		return false;
	}
	
	public boolean joinLobby(int idLobby)
	{
		if (lobby != null) return false;
		
		if (idLobby <= -1) lobby = game.joinPublicLobby(this);
		else lobby = game.joinPrivateLobby(this, idLobby);
		
		if (lobby != null) return true;
		
		return false;
	}
	
	public boolean quitLobby()
	{
		if (lobby == null) return false;
		
		if (lobby.quitLobby(this))
		{
			lobby = null;
			return true;
		}
		
		return false;
	}
	
//	public boolean resizeLobby(int userMax)
//	{
//
//	}
	
//	public boolean privateLobby(boolean privateSession)
//	{
//
//	}
	
//	public boolean startMatch()
//	{
//
//	}
	
	public Leaderboard getLeaderboard()
	{
		return game.getLeaderboard();
	}

//	public boolean requestCard()
//	{
//
//	}

//	public boolean stopPlaying()
//	{
//
//	}
}