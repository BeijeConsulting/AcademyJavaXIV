package esercizi;

public class equalsUtil {
	
	
	//String replace(String s, String oldChar, String newChar)
	
	
	public static String toLowerCaseUtil(String s) {
		String str ="";
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(0) >= 'A' && s.charAt(i) <= 'Z') {
				str += (char) (s.charAt(i) + 'a' - 'A');
			}
			else {
				str += s.charAt(i);
			}
			
		}
		return str.toString();
		
	}
	
	public static String toUpperCaseUtil(String s) {
		String str ="";
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(0) >= 'a' && s.charAt(i) <= 'z') {
				str += (char) (s.charAt(i) + 'A' - 'a');
			}
			else {
				str += s.charAt(i);
			}
			
		}
		return str.toString();
	}
	
	public static boolean  equalsUtil(String s1, String s2) {
		
		if(s1.length() != s2.length()) {
			return false;
		}
		
		for (int i = 0; i < s1.length() ; i++) {
			
			if(s1.charAt(i) != s2.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean  equalsIgnoreUtil(String s1, String s2) {
		String s3 = toUpperCaseUtil(s1);
		String s4 = toUpperCaseUtil(s2);
		return equalsUtil(s3, s4);
		
	}

	public static boolean startsWithUtil(String s, String prefix) {
		int lenPrefix = prefix.length();
		int lenS = s.length();
		
		if(lenPrefix > lenS) return false;
		
		if(lenPrefix <= lenS) {
			for (int i = 0; i < lenPrefix; i++) {
				if(s.charAt(i) != prefix.charAt(i) ) {
					return false;
				}
			}
		}
		return true;
		}
	
	public static boolean endsWithUtil(String s, String suffix) {
		String newS="";
		for (int i = s.length() - 1 ; i >= 0; i--) {
			newS += s.charAt(i);
		}
		
		String newSuffix="";
		for (int i = suffix.length() - 1 ; i >= 0; i--) {
			newSuffix += suffix.charAt(i);
		}
		
		return startsWithUtil(newS, newSuffix);
		
		}
		

	/*public static boolean contains(String s, String str) {
		
	}*/
	
	public static String substringUtil(String s, int beginIndex) {
		String newS = "";
		for (int i = beginIndex ; i < s.length(); i++) {
			newS += s.charAt(i);
		}
		return newS;
	}
	
	public static String substringUtil(String s, int beginIndex, int endIndex) {
		String newS = "";
		if(endIndex <= s.length() - 1 && beginIndex <= endIndex) {
		for (int i = beginIndex; i < endIndex; i++) {
			newS += s.charAt(i);
		}
		}
		return newS;
	}
	
	
	public static String replaceUtil(String s, char oldChar, char newChar) {
		String newS="";
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == oldChar) {
				newS += newChar;
			} else {
			newS += s.charAt(i);
			}
			
		}
		return newS;
	}
	
	public static String trimUtil(String s) {
		int i = 0;
		
		while((boolean) (s.charAt(i) == ' ' )){ //|| s.charAt(i) == ' \t ' || s.charAt(i) == ' \r 
			System.out.println("todo");
			i++;
		}
		return"";
	}
	
	public static void main(String[] args) {
		
		String test = "test";
		String t1 = "TEST";
		String t2 ="pippo";
		String t3 = "abcdefghijk";
		
		
		System.out.println("upper case -> " + toUpperCaseUtil(test));
		
		System.out.println("lower case -> " + toLowerCaseUtil(t1));
	
		System.out.println("equals false -> "  + equalsUtil(test, t2));
		
		System.out.println("equals true -> " + equalsUtil(test, "test"));
		
		System.out.println("equals ignore case -> " + equalsIgnoreUtil(test, t1));
		
		System.out.println("starts whith true-> " + startsWithUtil(test, "tes"));
		
		System.out.println("starts whith false-> " + startsWithUtil(test, "Se"));
		
		System.out.println("ends whith true-> " + endsWithUtil(test, "st"));
		
		System.out.println("ends whith false-> " + endsWithUtil(test, "Ab"));
		
		System.out.println("starts whith false-> " + startsWithUtil(test, "Se"));
		
		System.out.println("substring 1-> " + substringUtil(t1, 2));
		
		System.out.println("substring 2-> " + substringUtil(t3, 2, 6));
		
		System.out.println("substring 2-> " + replaceUtil(t2, 'p', 'P'));
		
		System.out.println("trim -> " + trimUtil("   ciao"));
		
		
		
		
	}

}
