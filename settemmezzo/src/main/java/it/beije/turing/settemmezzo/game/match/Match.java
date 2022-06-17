package it.beije.turing.settemmezzo.game.match;

import java.util.List;

import it.beije.turing.settemmezzo.game.User;

public class Match
{	
	private List<User> users;
	
	public Match(List<User> users)
	{
		this.users = users;
	}

	public boolean  start()
	{
		return true;
	}
}
