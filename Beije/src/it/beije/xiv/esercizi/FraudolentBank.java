package it.beije.xiv.esercizi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FraudolentBank
{	
	/*	OPERAZIONE esempio "ABC 50.0 210 B"
	 *	ABC = nome azione acquistata/venduta
	 * 	50.0 = importo singola azione
	 * 	210 quantità
	 * 	'B' è l'operazione, Buy o Sell ('B' o 'S')
	 * 
	 * 	Read file -> to array (or list) of String
	 * 	for every line calculate op
	 * 
	 * 	at end produce line: "Op: (nn) Buy: (bb) Sell: (ss)"
	 * 	nn -> n° of operations read
	 * 	bb -> total value of op buy
	 * 	ss -> total value of op sell
	 * 
	 * 	EXTRA: parse input, wrong inputs are ignored and put at end of output
	 * 	
	 */
	
	public static void main(String[] args)
	{
		FraudolentBank fb = new FraudolentBank();
		List<String> file = null;
		
		try
		{
			file = fb.readFile("C:\\Users\\Mattia\\git\\AcademyJavaXIV\\Beije\\src\\it\\beije\\xiv\\esercizi\\Operations.txt");   //TODO fix
			
			for(String s : fb.processOperation(file))
			{
				System.out.println(s);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}		
	}
	
	private List<String> readFile(String path) throws IOException
	{
		return Files.readAllLines(Paths.get(path));
	}
	
	private List<String> processOperation(List<String> operation)
	{
		List<String> lista = new ArrayList<>(); //el[0] calcolo, el[1] errate
		String errate = "";
		lista.add(0, errate);
		lista.add(1, errate);
		int nn = 0;
		int mm = 0;
		double bb = 0;
		double ss = 0;
		
		for(String s : operation)
		{
			if(!s.matches("[A-z]+\\s[0-9]+(\\.[0-9]+)?\\s[0-9]+\\s[SB]"))
			{
				lista.set(1, errate += "\n" + s);
				mm++;
			}
			else
			{
				String[] l = s.split(" ", 4);
				
				float importoAzione = Float.parseFloat(l[1]);
				int quantitaAzioni = Integer.parseInt(l[2]);
				if (s.charAt(s.length()-1) == 'B')
				{
					bb += importoAzione * quantitaAzioni;
					nn++;
				}
				else
				{
					ss += importoAzione * quantitaAzioni;
					nn++;
				}
			}
		}
		
		String processed = "Op: " + nn + " Buy: " + bb + " Sell: " + ss;
		errate = "Err: " + mm + errate;
		
		lista.set(0, processed);
		lista.set(1, errate);
		
		return lista;
	}
}
