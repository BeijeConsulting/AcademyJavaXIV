package it.beije.xiv.esercizi.completi;

public class Groups {

	public static void main(String[] args) {
		System.out.println(Groups.groupCheck("({})"));
		System.out.println(Groups.groupCheck("[[]()]"));
		System.out.println(Groups.groupCheck("[{()}]"));
		System.out.println(Groups.groupCheck("({d})"));
		System.out.println(Groups.groupCheck("[[s]d()]"));
		System.out.println(Groups.groupCheck("[{(s)}kl]"));
		
		System.out.println(Groups.groupCheck("{(})"));
		System.out.println(Groups.groupCheck("([]"));
		System.out.println(Groups.groupCheck("[])"));

	}
	public static boolean groupCheck(String s) {
		StringBuilder open = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			switch(s.charAt(i)) {
				case '(' :
					open.append("(");
					break;
				case '[':
					open.append("[");
					break;
				case '{':
					open.append("{");
					break;
				case ')':
					if(open.toString().endsWith("(")) {
						open.deleteCharAt(open.length()-1);
						continue;
					}
					return false;
				case ']':
					if(open.toString().endsWith("[")) {
						open.deleteCharAt(open.length()-1);
						continue;
					}
					return false;
				case '}':
					if(open.toString().endsWith("{")) {
						open.deleteCharAt(open.length()-1);
						continue;
					}
					return false;
				default :
					continue;
			}
		}
		if(open.length() != 0) {
			return false;
		}
		return true;
	}

}
