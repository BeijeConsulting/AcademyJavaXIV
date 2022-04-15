package it.beije.turing.xmlparser6;

public class Testo extends Nodo
{
	private String testo;

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	@Override
	public String getTagName()
	{
		return null;
	}

	@Override
	public void setTagName(String tagName) {}
}