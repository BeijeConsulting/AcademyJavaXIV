package it.beije.turing.settemmezzo.game;

import java.util.ArrayList;
import java.util.List;

public class Leaderboard
{
	private List<User> users;

	public Leaderboard(List<User> users)
	{
		this.users = users;
	}
	
	public List<User> getUsers() {
		return users;
	}
}