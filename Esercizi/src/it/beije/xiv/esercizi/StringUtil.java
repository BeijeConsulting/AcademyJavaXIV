package it.beije.xiv.esercizi;

public class StringUtil {
	public static void main(String[]args) {
		StringUtil s = new StringUtil();
		
		System.out.println(s.substring("Alessio", 4));
		System.out.println("  ");
		System.out.println(s.substring("Alessio", 4,6));
		System.out.println("  ");
		System.out.println(s.toLowerCase("CiaoDDD"));
		System.out.println("  ");
		System.out.println(s.toUpperCase("CiaoDDD"));
		System.out.println("  ");
		System.out.println(s.equals("FranciA","Francia"));
		System.out.println("  ");
		System.out.println(s.equalsIgnoreCase("FRAnciA","Francia"));
		System.out.println("  ");
		System.out.println(s.contains("Francia","cia"));
		System.out.println("  ");
		System.out.println(s.startsWith("rancia","ra"));
		System.out.println("  ");
		System.out.println(s.endsWith("rancia","ancia"));
		System.out.println("  ");
		System.out.println(s.replace("rancia",'a','z'));
		System.out.println("  ");
		System.out.println(s.replace("rancia","ran","m"));
		System.out.println("  ");
		System.out.println(s.trim("  raia c"));
		System.out.println("  ");
		
	}
	
	String substring(String s, int beginIndex) {
		String s1 = new String();
		for(int i=beginIndex;i<s.length();i++) {
			s1+=s.charAt(i);
		}
		return s1;
	}
	
	String substring(String s, int beginIndex, int endIndex) {
		String s1 = new String();
		for(int i=beginIndex;i<endIndex;i++) {
			s1+=s.charAt(i);
		}
		return s1;
	}
	
	String toLowerCase(String s) {
		String s1 = new String();
		for(int i=0;i<s.length();i++) {
			if((s.charAt(i)>='A')&&(s.charAt(i)<='Z')) {
				s1+= (char)(s.charAt(i)+ ('a'-'A'));
			}
			else s1+=s.charAt(i);
		}
		return s1;
	}
	
	String toUpperCase(String s) {
		String s1 = new String();
		for(int i=0;i<s.length();i++) {
			if((s.charAt(i)>='a')&&(s.charAt(i)<='z')) {
				s1+= (char)(s.charAt(i)- ('a'-'A'));
			}
			else s1+=s.charAt(i);
		}
		return s1;
	}
	
	boolean equals(String s1, String s2) {
		if(s1.length()!= s2.length()) return false;
		for(int i = 0; i<s1.length();i++) {
			if(s1.charAt(i)!= s2.charAt(i))
				return false;
		}
		return true;
	}
	
	boolean equalsIgnoreCase(String s1, String s2) {
		if(s1.length()!= s2.length()) return false;
		for(int i = 0; i<s1.length();i++) {
			if(s1.toLowerCase().charAt(i) != s2.toLowerCase().charAt(i))
				return false;
		}
		return true;
	}
	
	boolean contains(String str, String s) {
		int j=0;
		for(int i = 0;i<str.length();i++) {
			if(str.charAt(i)== s.charAt(0)) {
				for(j=0;j<s.length();j++) {
					if(s.charAt(j)==str.charAt(i)) {
						i++;
						continue;						
					}
					break;
				}
			}
		}
		if(j==s.length()) { 
			return true;
		}
		return false;
	}
	
	boolean startsWith(String s, String prefix) {
		if(s.charAt(0)== prefix.charAt(0)) {
			for(int i=0;i<prefix.length();i++) {
				if(s.charAt(i)==prefix.charAt(i)) {
					continue;
				}
				else return false;
			}
			return true;
		}
		else return false;
	}
	
	boolean endsWith(String s, String suffix) {
		if(s.charAt(s.length()-1)== suffix.charAt(suffix.length()-1)) {
			for(int i=s.length()-1, j = suffix.length()-1;j>=0;i--,j--) {
				if(s.charAt(i)== suffix.charAt(j)) {
					continue;
				}
				else return false;
			}
			return true;
		}
		else return false;
	}
	
	String replace(String s, char oldChar, char newChar) {
		String s1 = new String();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)== oldChar) s1+=newChar;
			else s1+= s.charAt(i);
		}
		return s1;
	}
	
	String replace(String s, String oldChar, String newChar) {
		String s1 = new String();
		int count=0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == oldChar.charAt(0)) {
				for(int j=0;j<s.length()-oldChar.length();j++) {
					if(oldChar.charAt(j)== s.charAt(i+j)) {
						count++;	
					}
				}
				if(count==oldChar.length()) {
					for(int j=0;j<newChar.length();j++) {
						s1+=newChar.charAt(j);
					}
					i= i+count-1;
				}
				else break;
			}
			else {
				s1+= s.charAt(i);
			}
		}
		return s1;
	}
	
	String trim(String s){
        int indexLast = s.length();
        int indexFirst = 0;
        char[] arraystring = s.toCharArray();

        while ((indexFirst < indexLast) && (arraystring[indexFirst] <= ' ')) {
            indexFirst++;}
        while ((indexFirst < indexLast) && (arraystring[indexLast - 1] <= ' ')) {
            indexLast--;}

        return ((indexLast < s.length()||(indexFirst > 0))) ? substring(s,indexFirst, indexLast):s;
    }
}
