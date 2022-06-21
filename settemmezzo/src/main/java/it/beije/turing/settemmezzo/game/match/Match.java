package it.beije.turing.settemmezzo.game.match;

import java.util.ArrayList;
import java.util.List;

import it.beije.turing.settemmezzo.game.deck.Card;
import it.beije.turing.settemmezzo.game.deck.Deck;
import it.beije.turing.settemmezzo.game.deck.Hand;

public class Match
{	
	private List<User> users;
	private List<Hand> hands;
	private Deck deck;
	
	public Match(List<User> users)
	{
		this.users = users;
		deck = new Deck();
	}

	public List<Hand> getHands() {
		return hands;
	}

	public boolean start()
	{
		for (User user : users)
		{
			Hand hand = new Hand(user);
			hands.add(hand);
//			user.requestCard();
		}
		
		return true;
	}
	
	
	//TODO TURNI
	//TODO CHECK PER ASSO / RE DI DENARI CHE CAMBIANO VALORE
	
	
	public List<User> end()				//TODO CHIAMARE QUANDO CHECKENDMATCH = TRUE;  AGGIUNGERE PUNTI ALLO SCORE DEI PLAYER
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
		
		return winners;
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
					return true;
				}
				
				return false;
			}
		}
		
		return false;
	}
	
//	public boolean checkEndMatch()			//TODO CALL A FINE DI OGNI TURNO
//	{
//
//	}
}
