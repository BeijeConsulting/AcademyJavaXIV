package it.beije.turing.settemmezzo.game.deck;

import java.util.ArrayList;
import java.util.List;

import it.beije.turing.settemmezzo.game.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hand
{
	private User user;
	private List<Card> cards = new ArrayList<>();
	private float cardValue = 0;
	private boolean continuePlaying = true;

	private boolean turn = false;

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

	public boolean isTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	public List<Card> getCards() {
		return cards;
	}
	
	public void addCard(Card card)
	{
		cards.add(card);
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
		
 		for (Card card : cards)
		{
			c += card.getValue();
		}
		log.debug("count card value : " + c);
		cardValue = c;
		
		boolean under = c <= 7.5f ? true : false;
		
		if (c >= 7.5f) setContinuePlaying(false);
		//else setContinuePlaying(under);

		if (turn && !continuePlaying) user.getLobby().getMatch().nextTurn(user.getId());

		return under;
	}
}
