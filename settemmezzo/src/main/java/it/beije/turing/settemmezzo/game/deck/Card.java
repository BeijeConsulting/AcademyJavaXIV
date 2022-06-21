package it.beije.turing.settemmezzo.game.deck;

public class Card
{
	private float value;
	private Seed seed;
	private Figure figure;
	
	public Card(float value, Seed seed, Figure figure)
	{
		this.value = value;
		this.seed = seed;
		this.figure = figure;
	}
	
	public float getValue() {
		return value;
	}
	
	public void setValue(float value)
	{	
		if (value < 0.5f) value = 0.5f;
		else if (value > 7) value = 7;
		
		this.value = value;
	}
	
	public Seed getSeed() {
		return seed;
	}
	
	public void setSeed(Seed seed) {
		this.seed = seed;
	}

	public Figure getFigure() {
		return figure;
	}

	public void setFigure(Figure figure) {
		this.figure = figure;
	}
}

enum Seed
{
	SPADE,
	COPPE,
	DENARI,
	BASTONI
}

enum Figure
{
	RE,
	FANTE,
	CAVALLO,
	NUMBER
}