package it.beije.xiv.nardella;

import java.util.ArrayList;

public class Groups {
	static final char OPEN_ROUND = '(';
	static final char OPEN_SQUARE = '[';
	static final char OPEN_CURLY = '{';
	static final char CLOSED_ROUND = ')';
	static final char CLOSED_SQUARE = ']';
	static final char CLOSED_CURLY = '}';
	
	public static void main(String[] args) {
		System.out.println(groupCheck("[[]()]"));
		System.out.println(groupCheck("[{()}]"));
		System.out.println(groupCheck("({d})"));
		System.out.println(groupCheck("[[s]d()]"));
		System.out.println(groupCheck("[{(s)}kl]"));
		
		System.out.println(groupCheck("{(})"));
		System.out.println(groupCheck("([]"));
		System.out.println(groupCheck("([]"));
	}

	public static boolean groupCheck(String s) {
		ArrayList<Character> brackets = new ArrayList<>();
		char c;
		
		for(int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if(c == ')' || c == ']' || c == '}' ) {
				if(brackets.isEmpty())
					return false;
				else {
					if(brackets.get(brackets.size() - 1).equals(c)) {
						brackets.remove(brackets.size() - 1 );
					}
					else {
						return false;
					}
				}
			}
			
			//Adding to the arraylist the matching type of bracket I need to close the last bracket
			if(c == OPEN_ROUND)
				brackets.add(CLOSED_ROUND);
			else if(c == OPEN_SQUARE)
				brackets.add(CLOSED_SQUARE);
			else if(c == OPEN_CURLY)
				brackets.add(CLOSED_CURLY);
			}
		
		if(brackets.isEmpty()) {return true;}
		else {return false;}
		
	}
}
