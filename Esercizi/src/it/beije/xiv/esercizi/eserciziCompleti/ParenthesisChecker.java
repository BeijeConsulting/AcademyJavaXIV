package src.it.beije.xiv.esercizi.eserciziCompleti;

class CharStack
{
	char c;
	CharStack stack;
	CharStack push(char cha)
	{
		this.c = cha;
		CharStack stack2 = new CharStack();
		stack2.stack=this;
		return stack2;
	}
	CharStack pop()
	{
		return this.stack;
	}
	char getChar()
	{
		return stack.c;
	}
}


public class ParenthesisChecker {
static String s = "({})([])";
public static void main(String...args)
{
	System.out.println(Check(s));
}
 static boolean Check(String s)
 {
	 CharStack stack = new CharStack();
	 stack=stack.push('X');
	for(int i = 0;i<s.length();i++)
	 {
		switch(s.charAt(i))
		{
		case '(':
			stack = stack.push('(');
			break;
		//************
		case ')':
			if(stack.getChar()=='(')
			{
				stack=stack.pop();
				break;
			}
			else
			{
				return false;
			}
		//*************
		case '[':
			stack=stack.push('[');
			break;
		case ']':
			if(stack.getChar()=='[')
			{
				stack=stack.pop();
				break;
			}
			else
			{
				return false;
			}
		case '{':
			stack=stack.push('{');
			break;
		case '}':
			if(stack.getChar()=='{')
			{
				stack=stack.pop();
				break;
			}
			else
			{
				return false;
			}
		}
	 }
	if(stack.getChar()=='X')
	 return true;
	else
	 return false;
 }
}
