package it.beije.xiv.esercizi;

public class ConvertString {
	public static void main(String[] args) {
		ConvertString c = new ConvertString();
		String s = "recede";
		String n = c.convert(s);
		System.out.print(n);
	}
	String convert(String s) {
		String c = new String();
		for(int i=0;i<s.length();i++) {
			char a = s.charAt(i);
			int count = 0;
			for(int j=0;j<s.length();j++) {
				if(a == s.charAt(j)) {
					count++;
				}
			}
			if(count>1) {
				c+=')';
			}
			else {
				c+='(';
			}
		}
		
		return c;
	}
}
