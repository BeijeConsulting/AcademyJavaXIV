package it.beije.xiv.esercizi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EserciziStringhe {

	public static void main(String[] n) {

		Scanner scan = new Scanner(System.in);
		ArrayList<Long> array = new ArrayList<>();
		EserciziStringhe ex = new EserciziStringhe();
		
		ex.straniNumeri();
		ex.primi100ElementiFibonacci(0L, 1L, 0, array);
		ex.stampaPrimi10NumeriInteri();
		ex.stampaPrimo20NumeriOrdineDescendente();
		ex.tabellina(scan);
		ex.stampaCarattereSpecialeASC();
		ex.stampaCarattereSpecialeDESC();
		ex.soloVocali("Frase di prova per verificare se il metodo funziona.");
		ArrayList<String> list = new ArrayList<String>();
		list.add("Da stampare");
		list.add("non stampare");
		list.add("Probabilmente da stampare");
		ex.stampaMaiuscole(list);
		System.out.println(ex.contaLettere('a' , "Frase di prova per verificare se il metodo funziona."));
		ex.stampaAlContratio("Frase di prova per verificare se il metodo funziona.");
		ex.concatena();
		ex.stampaGetter();
		ex.stampaSetter();
	}
	
	private void stampaSetter() {
		String str = "";
		str = verificaStringaSenzaSpazi(str);
		System.out.println("public void set" + Character.toString(str.charAt(0)).toUpperCase() + str.substring(1) + "(int " + str + ") {\n\tthis." + str + " = "+ str + ";\n}");
	}
	
	private void stampaGetter() {
		String str = "";
		str = verificaStringaSenzaSpazi(str);
		System.out.println("public int get" + Character.toString(str.charAt(0)).toUpperCase() + str.substring(1) + "() {\n\treturn " + str +";\n}");
	}
 	
	private void concatena() {
		String primaParola = " Prima Parola";
		String secondaParola = " ";
		String terzaParola = " ";
		
		primaParola = verificaStringaSenzaSpazi(primaParola);
		secondaParola = verificaStringaSenzaSpazi(secondaParola);
		terzaParola = verificaStringaSenzaSpazi(terzaParola);
		
		System.out.println(primaParola + "*" + secondaParola + "*" + terzaParola);

	}
			
	private String verificaStringaSenzaSpazi(String parola) {
		Scanner scan3 = new Scanner(System.in);
		boolean spaziPresenti = true;
		
		do {
			if(spaziPresenti) {
				System.out.println("Inserisci una parola senza spazi: ");
				parola = scan3.nextLine();
				if(parola.contains(" ")) {
					System.out.println("Puoi inserire solo una parola senza spazi. ");
				} else {
					spaziPresenti = false;
				}
			}
		} while(spaziPresenti);
		return parola;
	}
	
	private void stampaAlContratio(String str) {
		StringBuilder sB = new StringBuilder(str);
		System.out.println(sB.reverse());
	}
	
	private void soloVocali(String str) {
		ArrayList<Integer> arrayVocali = new ArrayList<Integer>();
		arrayVocali = inserisciCharFromStringToArray("a", str, arrayVocali);
		arrayVocali = inserisciCharFromStringToArray("e", str, arrayVocali);
		arrayVocali = inserisciCharFromStringToArray("i", str, arrayVocali);
		arrayVocali = inserisciCharFromStringToArray("o", str, arrayVocali);
		arrayVocali = inserisciCharFromStringToArray("u", str, arrayVocali);
		Collections.sort(arrayVocali);
		System.out.println(str);
		for(int i : arrayVocali) {
			System.out.print(str.charAt(i));
		}
		System.out.println();
	}
	
	private void stampaMaiuscole(ArrayList<String> arrayStr) {
		for(String str : arrayStr) {
			String str2 = Character.toString(str.charAt(0)).toUpperCase();
			if(str.startsWith(str2)) {
				System.out.println(str);
			}
		}
	}
	
	private int contaLettere(char c, String str) {
		ArrayList<Integer> arrayChar = new ArrayList<Integer>();
		arrayChar = inserisciCharFromStringToArray(Character.toString(c), str, arrayChar);
		return arrayChar.size();
	}

	private ArrayList<Integer> inserisciCharFromStringToArray(String ch, String str, ArrayList<Integer> arrayVocali) {
		boolean cicloA = true;
		int i = 0;
		int x = 0;
		
		do {
			i = str.indexOf(ch.charAt(0), x);
			if(i != -1) {
				arrayVocali.add(i);
				x = i + 1;
			} else {
				cicloA = false;
			}
		} while (cicloA);
		
		return arrayVocali;
	}

	private void stampaCarattereSpecialeDESC() {
		StringBuilder str1 = new StringBuilder("#");
		System.out.println(str1);
		
		for(int i = 0; i < 5; i++) {
			str1.append("#");
			System.out.println(str1);
		}
	}

	private void stampaCarattereSpecialeASC() {
		StringBuilder str = new StringBuilder("******");
		System.out.println(str);
		
		for(int i = str.length() - 1; i > 0; i--) {
			str.deleteCharAt(i);
			System.out.println(str);
		}
	}

	private void tabellina(Scanner scan) {
		int inputNumero;
		
		do {
			System.out.println("Inserisci il numero intero per stampare la tabellina (Non maggiore di 100): ");
			inputNumero = scan.nextInt();
			} while (inputNumero > 100);
		
		int inputNumeroTabellina;
		
		do {
		System.out.println("Inserisci fino a che numero vuoi la tabellina (Non maggiore di 100): ");
		inputNumeroTabellina = scan.nextInt();
		} while (inputNumeroTabellina > 100);
		
		for(int i = 0; i <= inputNumeroTabellina; i++) {
			System.out.println(inputNumero * i);
		}
	}

	private void stampaPrimo20NumeriOrdineDescendente() {
		for(int i = 20; i >= 0; i--) {
			System.out.println(i + " ");
		}
	}

	private void stampaPrimi10NumeriInteri() {
		for(int i = 0; i <= 10; i++) {
			System.out.println(i + " ");
		}
	}
	
	private void straniNumeri() {
		StringBuilder str = new StringBuilder("1   654321");
		System.out.println(str);
		for(Integer i = 2, x = 4, y = 1; i <=6; i++, x++, y++) {
			str.insert(str.indexOf(y.toString()) + 1, i.toString());
			str.replace(x, x + 2, " ");
			System.out.println(str);
		}
		
	}
	
	private void primi100ElementiFibonacci(long primo, long secondo, int count, ArrayList<Long> fibonacciDaStampare) {
		long terzo = primo + secondo;
		count++;
		if(primo == 0 && primo == 1 && secondo != 2) {
			fibonacciDaStampare.add(primo);
			System.out.print(secondo);
			primi100ElementiFibonacci(secondo, terzo, count, fibonacciDaStampare);
		} else if(count == 15){
			for(Long numeroFibonacci : fibonacciDaStampare) {
				System.out.print(numeroFibonacci + ", ");
			}
			System.out.print(terzo + ", ");
			System.out.println();
		} else {
			fibonacciDaStampare.add(terzo);
			for(Long numeroFibonacci : fibonacciDaStampare) {
				System.out.print(numeroFibonacci + ", ");
			}
			System.out.println();
			primi100ElementiFibonacci(secondo, terzo, count, fibonacciDaStampare);
		}
	}

}
