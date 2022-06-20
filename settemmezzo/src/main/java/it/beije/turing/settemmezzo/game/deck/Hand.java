package it.beije.turing.settemmezzo.game.deck;

import java.util.List;

import it.beije.turing.settemmezzo.game.User;

public class Hand
{
	private User user;
	private List<Card> hand;
	private float cardValue = 0;
	private boolean continuePlaying = true;
	
	public Hand(User user)
	{
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Card> getHand() {
		return hand;
	}
	
	public void addCard(Card card)
	{
		hand.add(card);
	}

	public float getCardValue() {
		return cardValue;
	}
	
	public boolean getContinuePlaying() {
		return continuePlaying;
	}
	
	public void setContinuePlaying(boolean continuePlaying) {
		this.continuePlaying = continuePlaying;
	}
	
	public boolean isUnderSettemmezzo()
	{
		float c = 0f;
		
		for (Card card : hand)
		{
			c += card.getValue();
		}
		
		cardValue = c;
		
		boolean under = c <= 7.5f ? true : false;
		
		setContinuePlaying(under);
		
		return under;
	}
}
