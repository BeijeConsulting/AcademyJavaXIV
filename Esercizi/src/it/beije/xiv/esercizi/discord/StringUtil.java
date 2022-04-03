package it.beije.xiv.esercizi.discord;

public class StringUtil {

	
	public String substring(String s, int beginIndex) {
		
		if (beginIndex>=s.length()) {
			s.charAt(beginIndex);		//StringIndexOutOfBoundsException
		}
		String result = new String();
		for (int i=beginIndex; i<s.length(); i++) {
			result += s.charAt(i);		//add each char until end of string
		}
		return result;
	}
	
	public String substring(String s, int beginIndex, int endIndex) {
		
		if (beginIndex>=s.length()|endIndex>s.length()) {
			s.charAt(beginIndex);	
			s.charAt(endIndex);					//StringIndexOutOfBoundsException
		} else if (beginIndex > endIndex) {
			s.charAt(endIndex-beginIndex);		//StringIndexOutOfBoundsException
		}
		String result = new String();
		for (int i=beginIndex; i<endIndex; i++) {
			result += s.charAt(i);				//add each char until endIndex
		}
		return result;
		
		
	}
	
	public String toLowerCase(String s){
		
		String result = new String();
		for (int i=0; i<s.length(); i++) {								//for each character:
			if ((int)s.charAt(i)<=90 & (int)s.charAt(i)>=65) {			//if uppercase
				char newch = (char)((int)s.charAt(i)+32);				//shift char to corresponding lowercase unicode
				result += newch;										//assign to working String
			} else if ((int)s.charAt(i)<=122 & (int)s.charAt(i)>=97){	//if lowercase
				result += s.charAt(i);									//assign as-is to working String
			} else {													//if not alphabetic
				result += s.charAt(i);									//assign as-is to working String
			}
		}
		return result;
	}
	
	public String toUpperCase(String s){
	
	String result = new String();
	for (int i=0; i<s.length(); i++) {									//for each character:
		if ((int)s.charAt(i)<=90 & (int)s.charAt(i)>=65) {				//if uppercase
			result += s.charAt(i);										//assign as-is to working String
		} else if ((int)s.charAt(i)<=122 & (int)s.charAt(i)>=97){		//if lowercase
			char newch = (char)((int)s.charAt(i)-32);					//shift char to corresponding UPPERCASE unicode
			result += newch;											//assign to working String
		} else {														//if not alphabetic
			result += s.charAt(i);										//assign as-is to working String
		}
	}
	return result;
	}
	
	public boolean equals(String s1, String s2) {
		
		if (s1.length()!=s2.length()) {									//return false if they are of different length
			return false;
		} 
		for (int i=0; i<s1.length();i++) {								//for each char
			if (s1.charAt(i)!=s2.charAt(i)) {							//return false if any is different
				return false;
			}
		}
		return true;
	}
	
	public boolean equalsIgnoreCase(String s1, String s2){
		
		if (s1.length()!=s2.length()) {									//return false if they are of different length
			return false;
		} 
		StringUtil su = new StringUtil();
		s1 = su.toLowerCase(s1);
		s2 = su.toLowerCase(s2);										//make both strings lowercase
		for (int i=0; i<s1.length();i++) {								//for each char
			if (s1.charAt(i)!=s2.charAt(i)) {							//return false if any is different
				return false;
			}
		}
		return true;
	}
	
	public boolean contains(String s, String str){
		
		for (int i = 0; i<=s.length()-str.length(); i++) {			//check each char of main String
			if (s.charAt(i)==str.charAt(0)) {						//if one matches beginning of searched String, enter loop
				for (int j = 1; j<str.length(); j++) {				//
					if (s.charAt(i+j)==str.charAt(j)) {				//check each char of the searched String
						if (j==str.length()-1) {					//if the last one matches
							return true;							//return true
						}
						continue;
					}
				}
			} else {continue;										//keep searching
			}
		} return false;
	}
	
	public boolean startsWith(String s, String prefix){
		
		StringUtil su = new StringUtil();
		if (su.substring(s, 0, prefix.length()).equals(prefix)) {		//check substring at beginning against prefix
			return true;
		}
		return false;
	}
	
	public boolean endsWith(String s, String suffix){
		
		StringUtil su = new StringUtil();
		if (su.substring(s, (s.length()-suffix.length())).equals(suffix)) {		//check substring at beginning against prefix
			return true;
		}
		return false;
	}
	
	public String replace(String s, char oldChar, char newChar){
		
		String result = new String();
		for (int i = 0; i<s.length(); i++) {								//for each char
			if (s.charAt(i)==oldChar) {										//if oldChar is at that index
				result+=newChar;											//add newChar to working String instead
			} else {
				result+=s.charAt(i);										//else, copy char as-is
			}
		}
		return result;
	}
	
	public String replace(String s, String oldChar, String newChar){

		StringUtil su = new StringUtil();
		String result = new String();
		for (int i = 0; i<s.length(); i++) {									//for each char
			if((i+oldChar.length())>s.length()) {								//Defense: if oldChar can't fit, don't check if it's there
				result+=s.charAt(i);											//copy remaining string as-is
				continue;														//skip next code, it will crash
			}
			else if (su.substring(s, i, i+oldChar.length()).equals(oldChar)) {	//if there is oldChar at this index
				result+=newChar;												//add newChar to working string
				i+=oldChar.length()-1;											//skip to the end of oldChar in the main string
			} else {															//if there is no oldChar
				result+=s.charAt(i);											//copy current char as-is
			}
		}
		return result;
	}
	
	public String trim(String s){
		
		StringUtil su = new StringUtil();
		String result = new String(s);
		while (true) {										//remove whitespace at beggining
			if (result.charAt(0)==' ') {					//if whitespace
				result = su.substring(result, 1);			//remove first character
			} else { break;									//if no whitespace at beginning, exit loop
				}
		}
		while (true) {													//remove whitespace at end
			if (result.charAt(result.length()-1)==' ') {				//if whitespace
				result = su.substring(result, 0, result.length()-1);	//remove last character
			} else { break;												//if no whitespace at end, exit loop
				}
		}
		return result;
	}
	
	public static void main(String[] args) {



	}

}
