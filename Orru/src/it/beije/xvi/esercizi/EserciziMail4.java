package it.beije.xvi.esercizi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormatSymbols.*;

public class EserciziMail4 {
	/*Gli agenti di borsa della banca Fraudolent compiono operazioni finanziare quotidianamente ed annotano le operazioni su un file, nel seguente formato: “ABC 50.0 210 B”, dove
	“ABC” è il nome dell’azione acquistata/venduta
	50.0 è l’importo della singola azione
	210 è la quantità
	‘B’ è l’operazione, che può valere ‘B’ (Buy) o ‘S’ (Sell)
	Si vuole quindi un programma che:

	legga il file inviato dagli agenti e lo restituisca come array (o List) di stringhe
	per ogni riga calcoli l’importo dell’operazione ed alla fine produca una semplice riga:
	“Op: (nn) Buy: (bb) Sell: (ss)”
	dove al posto di (nn) ho ul numero di operazioni lette, al posto di (bb) l’importo totale delle operazioni di acquisto ed in (ss) l’importo totale delle operazioni di vendita.

	Complicazione (opzionale):

	alcuni agenti commettono errori nello scrivere il file, pertanto alcune righe potranno non rispondere allo standard (che è molto rigido!). Le righe “sbagliate” non vanno considerate, ma vanno elencate alla fine del processo, dopo la riga di output del programma, in questo modo:
	Op: (nn) Buy: (bb) Sell: (ss)
	Err: (ee)
	(riga sbagliata 1)
	(riga sbagliata 2)
	(riga sbagliata 3)*/
	
	public ArrayList<String> fraudolentFunction() {
		File file = new File("/Users/lorenzoorru0/Desktop/test.txt");
		ArrayList<String> array = new ArrayList<>();
		ArrayList<String> arrayErr = new ArrayList<>();
		
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				array.add(sc.nextLine().trim());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int op = 0;
		double bb = 0;
		double ss = 0;
		
		String[] arraySupport = array.toArray(new String[0]);
		
		for(int i = 0; i < arraySupport.length; i++) {
			if(arraySupport[i].charAt(arraySupport[i].length() - 1) != 'B' && arraySupport[i].charAt(arraySupport[i].length() - 1) != 'S') {
				array.remove(arraySupport[i]);
	        	arrayErr.add(arraySupport[i]);
			}
		}
		
		arraySupport = array.toArray(new String[0]);
		
		for(String s : arraySupport) {
			int x = 0;
			int sI = 0;
			int fI = 0;
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) <= 32 && x == 0) {
					sI = i + 1;
					x++;
				} else if(s.charAt(i) <= 32 && x == 1) {
					fI = i;
					x++;
				}
			}
			
			try {
				Double.parseDouble(s.substring(sI, fI));
				Double.parseDouble(s.substring(fI + 1, s.length()-2));
				double imp = Double.parseDouble(s.substring(sI, fI));
				double qty = Double.parseDouble(s.substring(fI + 1, s.length()-2));
				if(s.charAt(s.length() - 1) == 'B') {
					op++;
					bb += imp * qty;
				} else if(s.charAt(s.length() - 1) == 'S') {
					op++;
					ss += imp * qty;
				}
	        } catch (NumberFormatException e) {
	        	array.remove(s);
	        	arrayErr.add(s);
	        }
			
		}
		
		array.add("Op: " +op+ " Buy: " +bb+ " Sell: " +ss);
		
		System.out.println("Op: " +op+ " Buy: " +bb+ " Sell: " +ss);
	    System.out.println("Err: " + arrayErr.size());
	    for(String s : arrayErr) {
	    	System.out.println(s);
	    }
	    return array;
	}
	
	/*###################################################################

	Una fabbrica alimentare produce una bibita gassata molto apprezzata. Sfortunatamente, il gas utilizzato per fare le caratteristiche bollicine è molto volatile ed ogni giorno ne evapora un po’.
	Si vuole un programma che calcoli il numero di giorni utile per l’imbottigliamento della bibita stessa, conoscendo:
	La quantità di bibita pronta nella cisterna (‘content‘, espresso in ml)
	la percentuale di gas che evapora in 24 ore (‘evapPerDay‘)
	la soglia percentuale oltre la quale la bibita non è più apprezzabile (‘threshold‘) più
	Tutti i numeri sono interi positivi. Il programma restituirà il numero del giorno oltre il quale la bibita non sarà più vendibile (non più sufficientemente gasata)*/

	/*###################################################################

	Dato il seguente triangolo di numeri dispari:   
	1               
	3       5
	7        9        11
	13     15       17       19
	21     23     25       27     29
	….
	si scriva la funzione rowSumOddNumbers(int n) che calcola la somma dei numeri nella riga n-esima. Per esempio:
	rowSumOddNumbers(1) = 1
	rowSumOddNumbers(3) = 7 + 9 + 11 = 27
	ecc.*/
	public int rowSumOddNumbers(int n) {
		int sum = 0; 
		
		for(int i = n * 2 + 1, j = 0; j < n; i += 2, j++) {
			sum += i;
		}
		
		return sum;
	}
	

	/*###################################################################

	Scrivere la funzione caffeina(int n) che prende un numero positivo come argomento e:
	Se il numero è divisibile per 3, stampa “Java”
	Se il numero è divisibile per 3 e per 4, stampa “Coffee”
	Se il numero appartiene ad uno dei due casi precedenti ed è pari, aggiunge “Script” in fondo alla stringa
	Se non appartiene a nessuno dei casi precedenti stampa “match_missed!”
	###################################################################

	Scrivere una funzione che prende un numero intero n come parametro e ritorna un array di sfumature di grigio in codice esadecimale (#aaaaaa, per esempio). L’array dovrebbe essere ordinato in senso ascendente (#010101, #020202, ecc), usando le lettere minuscole.public class ShadesOfGrey {
	static String[] shadesOfGrey(int num) {
	// returns n shades of grey in an array
	}
	}Ricorda che: il grigio è un colore composto dalla stessa quantità di rosso, verde e blu: #010101, #aeaeae, #555555. Inoltre: #000000 e #FFFFFF non sono valori accettati.Se n è negativo ritornare un array vuoto, se n è maggiore di 254, ritornare un array di 254 elementi.
	###################################################################

	Scrivere una funzione che verifichi la correttezza di una stringa in cui sono inserite delle parentesi. In programmazione, ma anche nel linguaggio naturale, le istruzioni o le frasi possono essere inserite in gruppi di parentesi: (), [] o {}. All’apertura di una parentesi ci si aspetta una chiusura coerente, tipo: [], ([]), {[]({})}. I gruppi che non vengono chiusi o non vengono chiusi in ordine corretto vengono considerati sbagliati. Per esempio: [{], ([)], [(.
	La funzione che si chiede è:

	1
	2
	3
	4
	5
	public class Groups {
	public static boolean groupCheck(String s) {
	//....
	}
	}
	tale funzione dovrebbe restituire true per i seguenti valori:
	({})
	[[]()]
	[{()}]
	({d})
	[[s]d()]
	[{(s)}kl]
	e false per questi altri:

	{(})
	([]
	[])
	###################################################################

	Lo scopo di questo esercizio è convertire una stringa in una nuova stringa, dove ogni carattere della nuova stringa è ‘(‘ se il carattere corrispondente nella stringa originale è unico, altrimenti vale ‘)’. Ignorare le maiuscole/minuscole per decidere se un carattere è duplicato o meno.Per esempio:”din” => “(((“”recede” => “()()()”
	“Success” => “)())())”

	“(( @” => “))((“

	###################################################################

	Scrivere la funzione “persistenza”, che prende un parametro intero positivo e ritorna la sua “persistenza moltiplicativa”, che è il numero di volte per cui bisogna moltiplicare le cifre fra loro fino ad avere un unico carattere.Per esempio:persistence(39) == 3 // perché 3*9 = 27, 2*7 = 14, 1*4=4
	// e 4 è diuna cifra solapersistence(999) == 4 // perché 9*9*9 = 729, 7*2*9 = 126,
	// 1*2*6 = 12, e 1*2 = 2
	persistence(4) == 0 // perché 4 è già una cifra singola*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EserciziMail4 s = new EserciziMail4();
		
		//Call fraudolentFunction
		s.fraudolentFunction();
		
		//

		System.out.println("Row sum odd numbers: " + s.rowSumOddNumbers(4));
	}

}
