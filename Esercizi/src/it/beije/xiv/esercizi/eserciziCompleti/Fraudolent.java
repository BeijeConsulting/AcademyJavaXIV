package src.it.beije.xiv.esercizi.eserciziCompleti;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Fraudolent {

public static void main(String...args)
{
	String filename = "Fraudolent.txt";
	ArrayList<String> list=readFile(filename);
	System.out.println(list);
	System.out.println(readOperations(list));
}

private static ArrayList<String> readFile(String nomeFile)
{
	ArrayList<String> list=new ArrayList<>();
	File file = new File(nomeFile);
	try 
	{
		Scanner scanner = new Scanner(file);
		while(scanner.hasNextLine())
		{
			list.add(scanner.nextLine());
		}
		scanner.close();
	}
	catch(Exception e)
	{
		list.add("ERROR!");
		return list;
	}
	return list;
}
private static String readOperations(ArrayList<String> list)
{
	int count=0;
	double bb =0.0;
	double ss = 0.0;
	for(String s: list)
	{
		count++;
		String[] stringaDivisa=s.split(" ");
		if(stringaDivisa[3].equals("B"))
		{
			double price=Double.parseDouble(stringaDivisa[1]);
			int quantity = Integer.parseInt(stringaDivisa[2]);
			bb+=quantity*price;
		}
		else if(stringaDivisa[3].equals("S"))
		{
			double price=Double.parseDouble(stringaDivisa[1]);
			int quantity = Integer.parseInt(stringaDivisa[2]);
			ss+=quantity*price;
		}
	}
	return ("OPn: "+count+" BB: "+bb+" SS: "+ss);
}
}