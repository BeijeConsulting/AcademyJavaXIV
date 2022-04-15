package it.beije.turing.xmlparser2;

import java.util.ArrayList;

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
	
	public static ArrayList<Attribute> buildAttributes(String[] attributes) {
		
		ArrayList<Attribute> attributesList = new ArrayList<Attribute>();
		
		for(String s : attributes) {
			Attribute attribute = new Attribute();
			String str = "";
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '=') {
					attribute.setName(str);
					str = "";
				}
				
				str += s.charAt(i);
			}
			str = str.substring(2,str.length());
			str = str.substring(0, str.length() - 1);
			attribute.setValue(str);
			attributesList.add(attribute);
		}
		
		return attributesList;
	}
}
