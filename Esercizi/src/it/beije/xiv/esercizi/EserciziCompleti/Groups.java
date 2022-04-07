package it.beije.xiv.esercizi.EserciziCompleti;

public class Groups {
	public static void main(String[]args) {
		String s = "{}[][()]";
		System.out.print(groupCheck(s));
	}
	public static boolean groupCheck(String s) {
		StringBuilder s1 = new StringBuilder();
		for(int i=0;i<s.length();i++) {
			
			switch(s.charAt(i)) {
			
			case '(':
				s1.append("(");
				break;
				
			case '[':
				s1.append('[');
				break;
				
			case '{':
				s1.append('{');
				break;
				
			case ')':
				if(s1.toString().endsWith("(")) {
					s1.deleteCharAt(s1.length()-1);
					continue;
				}
				return false;
				
			case ']':
				if(s1.toString().endsWith("[")) {
					s1.deleteCharAt(s1.length()-1);
					continue;
				}
				return false;
				
			case '}':
				if(s1.toString().endsWith("{")) {
					s1.deleteCharAt(s1.length()-1);
					continue;
				}
				return false;
			
			default:
				continue;
			}
				
		}
		if(s1.length() != 0) {
			return false;
		}
		return true;
	}
}
