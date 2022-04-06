package src.it.beije.xiv.esercizi.eserciziCompleti;
import java.util.ArrayList;
public class StringReplacer {
public static void main(String...args)
{
	String s = "abjjdjefejo";
	System.out.println(replace(s));
}
static String replace(String s) {
	StringBuilder builder = new StringBuilder();
	ArrayList<String> memory = new ArrayList<>();
	for(int i=0;i<s.length();i++)
	{
		char c = s.charAt(i);
		if(memory.contains(c+"U"))
		{
			memory.set(memory.indexOf(c+"U"), c+"D");
		}
		else if(memory.contains(c+"D"))
		{
			continue;
		}
		else
		{
			memory.add(c+"U");
		}
	}
	for (String ch : memory)
	{
		if(ch.substring(1).equals("D"))
		{
			builder.append(")");
		}
		else
			builder.append("(");
	}
	return builder.toString();
	
}
}
