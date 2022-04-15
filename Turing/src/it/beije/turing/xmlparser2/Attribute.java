package it.beije.turing.xmlparser2;

public class Attribute {
	private String name;
	private String value;
	
	public Attribute() {}
	
	public Attribute(String name, String value) {
		this.name = name;
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
