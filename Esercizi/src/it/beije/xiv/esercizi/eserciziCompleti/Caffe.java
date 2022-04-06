package src.it.beije.xiv.esercizi.eserciziCompleti;

public class Caffe {
public static void main(String...args) {
	int n = 6;
System.out.println(caffeina(n));
}
private static String caffeina(int n) {
	StringBuilder s = new StringBuilder();
	if(n%3==0)
	{
	  if(n%4==0)
	  {
		  s.append("Coffee");
	  }
	  else
	  {
		  s.append("Java");
	  }
	  if(n%2==0)
	  {
		  s.append("Script");
	  }
	}
	else
	{
		s.append("Match missed!");
	}
	return s.toString();
}
}
