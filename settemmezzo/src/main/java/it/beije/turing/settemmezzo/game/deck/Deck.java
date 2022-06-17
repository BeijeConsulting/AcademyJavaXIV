package it.beije.turing.settemmezzo.game.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck
{
	private List<Card> cards;
	
	public Deck()
	{
		cards = generateDeck();
		shuffleDeck();
	}
	
	public List<Card> getCards()
	{
		return cards;
	}
	
	private List<Card> generateDeck()
	{
		List<Card> cards = new ArrayList<>();
		
		for (int i = 1; i < 8; i++)
		{
			Card cardSpade = new Card(i, Seed.SPADE, Figure.NUMBER);
			Card cardCoppe = new Card(i, Seed.COPPE, Figure.NUMBER);
			Card cardDenari = new Card(i, Seed.DENARI, Figure.NUMBER);
			Card cardBastoni = new Card(i, Seed.BASTONI, Figure.NUMBER);
			
			cards.add(cardSpade);
			cards.add(cardCoppe);
			cards.add(cardDenari);
			cards.add(cardBastoni);
		}
		
		Card reSpade = new Card(0.5f, Seed.SPADE, Figure.RE);
		Card reCoppe = new Card(0.5f, Seed.COPPE, Figure.RE);
		Card reDenari = new Card(0.5f, Seed.DENARI, Figure.RE);
		Card reBastoni = new Card(0.5f, Seed.BASTONI, Figure.RE);
		
		cards.add(reSpade);
		cards.add(reCoppe);
		cards.add(reDenari);
		cards.add(reBastoni);

		Card fanteSpade = new Card(0.5f, Seed.SPADE, Figure.FANTE);
		Card fanteCoppe = new Card(0.5f, Seed.COPPE, Figure.FANTE);
		Card fanteDenari = new Card(0.5f, Seed.DENARI, Figure.FANTE);
		Card fanteBastoni = new Card(0.5f, Seed.BASTONI, Figure.FANTE);
		
		cards.add(fanteSpade);
		cards.add(fanteCoppe);
		cards.add(fanteDenari);
		cards.add(fanteBastoni);
		
		Card cavalloSpade = new Card(0.5f, Seed.SPADE, Figure.CAVALLO);
		Card cavalloCoppe = new Card(0.5f, Seed.COPPE, Figure.CAVALLO);
		Card cavalloDenari = new Card(0.5f, Seed.DENARI, Figure.CAVALLO);
		Card cavalloBastoni = new Card(0.5f, Seed.BASTONI, Figure.CAVALLO);
		
		cards.add(cavalloSpade);
		cards.add(cavalloCoppe);
		cards.add(cavalloDenari);
		cards.add(cavalloBastoni);
		
		return cards;
	}
	
	public void shuffleDeck()
	{
		Collections.shuffle(cards);
	}
}
