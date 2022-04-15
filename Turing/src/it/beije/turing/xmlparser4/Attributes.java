package it.beije.turing.xmlparser4;


public class Attributes
{
	private String name;
	
	private String content;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	public Attributes(String name,String content)
	{
		this.name=name;
		this.content=content;
	}
}