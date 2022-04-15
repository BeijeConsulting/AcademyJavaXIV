package it.beije.turing.xmlparser4;


public class Attributes
{
	private String name;
	
	private String value;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getValue() {
		return value;
	}
	public void setValue(String content) {
		this.value = content;
	}
	
	
	
	public Attributes(String name,String content)
	{
		this.name=name;
		this.value=content;
	}
	public String toString()
	{
		return(name+"=\""+value+"\"");
	}
}