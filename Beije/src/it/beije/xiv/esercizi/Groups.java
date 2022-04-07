package it.beije.xiv.esercizi;

public class Groups
{
	public static void main(String[] args)
	{
		String s = "{{[a]()(b)}}";
		System.out.println(s + ": Valido -> " + groupCheck(s));
	}

	
	public static boolean groupCheck(String s)				//TODO FIX opening and closing different parethesis --->  {[]} == {(})
	{
		int open = 1;
		
		for(int i = 0; i < s.length(); i++)
		{
			switch(s.charAt(i))
			{
				case '{':
					open += i;
					break;
					
				case '[':
					open += i;
					break;
					
				case '(':
					open += i;
					break;
					
				case ')':
					open -= s.length()-1-i;
					break;
					
				case ']':
					open -= s.length()-1-i;
					break;
					
				case '}':
					open -= s.length()-1-i;
					break;
					
				default:
					continue;
			}
			
			System.out.println("Open: " + open);
		}
		
		return (open == 1) ? true : false;
	}
}
