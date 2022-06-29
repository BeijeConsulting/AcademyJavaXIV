package it.beije.turing.settemmezzo.game.match;

import java.util.ArrayList;
import java.util.List;

import it.beije.turing.settemmezzo.game.User;
import it.beije.turing.settemmezzo.game.deck.Card;
import it.beije.turing.settemmezzo.game.deck.Deck;
import it.beije.turing.settemmezzo.game.deck.Hand;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Match
{	
	private List<User> users;
	private List<Hand> hands = new ArrayList<>();
	private List<User> winners;
	private Deck deck;
	private boolean ended = false;

	
	public Match(List<User> users)
	{
		this.users = users;
		deck = new Deck();
	}

	public List<Hand> getHands() {
		return hands;
	}

	public Match start()
	{
		for (User user : users)
		{
			Hand hand = new Hand(user);
			if (users.get(0).equals(user)) {
				hand.setTurn(true);
				log.debug("user turn true : " + users.get(0));
			}
			hands.add(hand);
//			user.requestCard();
		}
		
		return this;
	}

	public List<User> getWinners() {
		return winners;
	}

	public void setWinners(List<User> winners) {
		this.winners = winners;
	}

	public Hand getPlayerHand(Integer playerId)
	{
		for (Hand hand : hands)
		{
			if (hand.getUser().getId() == playerId) return hand;
		}

		return null;
	}
	
	//TODO TURNI
	//TODO CHECK PER ASSO / RE DI DENARI CHE CAMBIANO VALORE
	
	
	public Match end()				//TODO CHIAMARE QUANDO CHECKENDMATCH = TRUE;  AGGIUNGERE PUNTI ALLO SCORE DEI PLAYER
	{
		List<User> winners = new ArrayList<>();
		
		float win = 0;
		
		for (Hand hand : hands)
		{
			if (hand.getCardValue() >= win && hand.getCardValue() <= 7.5f)
			{
				win = hand.getCardValue();
			}
		}
		
		for (Hand hand : hands)
		{
			if (hand.getCardValue() == win)
			{
				winners.add(hand.getUser());
			}
		}

		this.winners = winners;
		
		return this;
	}

	public boolean isEnded() {
		return ended;
	}

	public List<User> getUsers() {
		return users;
	}

	public Card giveCard()
	{
		return deck.getCards().remove(0);
	}

	public boolean requestCard(User user)
	{
		//TODO IF MIO TURNO?
		
		if (deck.getCards().size() > 0)
		{
			for (Hand hand : hands)
			{
				if (hand.getUser() == user)
				{
					if (hand.getContinuePlaying() && hand.isUnderSettemmezzo())
					{
						hand.addCard(giveCard());
						hand.isUnderSettemmezzo();
						return true;
					}
					
					return false;
				}
			}
		}
		return false;
	}

	public boolean stopPlaying(User user)
	{
		//TODO IF TURNO DI USER
		
		for (Hand hand : hands)
		{
			if (hand.getUser() == user)
			{
				if (hand.isUnderSettemmezzo() && hand.getContinuePlaying())
				{
					hand.setContinuePlaying(false);
					hand.isUnderSettemmezzo();
					return true;
				}
				
				return false;
			}
		}
		
		return false;
	}

	public Match quitMatch(User user) {

		Hand handToRemove = null;

		for (Hand hand : hands) {
			if (hand.getUser().getId() == user.getId()) {
				handToRemove = hand;
				if (handToRemove.isTurn()) nextTurn(user.getId());
				break;
			}
		}

		if (handToRemove != null) hands.remove(handToRemove);

		users.remove(user);
		return this;
	}


	public void nextTurn(Integer playerId)
	{
		int j = 0;
		for (int i = 0; i < hands.size(); i++)
		{
			if (hands.get(i).getUser().getId() == playerId)
			{
				j = i+1;
				hands.get(i).setTurn(false);
				break;
			}
		}

		if (j >= hands.size())
		{
			ended = true;
			return;
		}
		if (hands.get(j).getContinuePlaying()) hands.get(j).setTurn(true);
		else nextTurn(hands.get(j).getUser().getId());
	}

//	public boolean checkEndMatch()			//TODO CALL A FINE DI OGNI TURNO
//	{
//
//	}
}
