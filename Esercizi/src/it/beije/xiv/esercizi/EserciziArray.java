package it.beije.xiv.esercizi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class EserciziArray {

	public static void main(String[] args) {
		EserciziArray tmp = new EserciziArray();
		
		EserciziArray.esercizio1(new int[] {9,15,2,6});
		System.out.println();
		
		EserciziArray.esercizio2(new int[] {9,15,2,6});
		System.out.println();
		
		System.out.println(tmp.contains(2, new int[] {9,15,2,6,2,9,3,2,15,2,9,2}));
		System.out.println();
		
		System.out.println(tmp.contains("Cavallo", new String[] {"SEI","UN","CAVALLO"}));
		System.out.println(tmp.contains(new String("Cavallo"), new String[] {"SEI","UN","Cavallo"}));
		System.out.println(tmp.contains("Cavallo", new String[] {"SEI","UN","Cavallo"}));
		System.out.println();
		
		System.out.println(tmp.isCrescente(new int[] {0,1,2,3,4,5}));
		System.out.println(tmp.isCrescente(new int[] {0,1,2,4,3,5}));
		System.out.println();
		
		tmp.mostRecurrent(new int[] {9,15,2,6,2,9,3,2,15,2,9,2});
		System.out.println();
		
		tmp.mediaMultipliDiTre(new int[] {1,2,3,4,5,6,7,8,9});
		System.out.println();
		
		tmp.stampaZigZag(new int[] {0,1,2,3,4,5,6,7,8,9});
		System.out.println();
		
		tmp.media(new int[] {1,2,3,4,5,6,7,8,9});
		System.out.println();
		
		String[] test = tmp.addString("Ercole", new String[] {"Ciao", "15945", "questo"});
		for(String s : test) {
			System.out.println(s);
		}
		System.out.println();
		
		System.out.println("Esercizio 10");
		try (Scanner s = new Scanner(System.in)) {
			System.out.print("Morra Cinese\nPlayer1 Inserisca una mossa(Carta,Forbice,Sasso): ");
			String player1 = s.nextLine();
			System.out.print("Player2 Inserisca una mossa(Carta,Forbice,Sasso): ");
			String player2 = s.nextLine();
			tmp.morraCinese(player1, player2);
		}
		System.out.println();
		
		
		tmp.stampaData("13/09/2021");
	}
	
	public static void esercizio1(int[] src) {
		System.out.println("Esercizio 1");
		Arrays.sort(src);
		System.out.println("Max: " + src[src.length-1]);
		System.out.println("Min: " + src[0]);
	}
	
	public static void esercizio2(int[] src) {
		System.out.println("Esercizio 2");
		int ris = -1, max = 0;
		for(int i = 0; i < src.length; i++) {
			if(max < src[i]) {
				ris = i;
				max = src[i];
			}
		}
		System.out.println("Max position: " + ris + "\nMax = " + src[ris]);
	}
	
	/*
	 * La differenza sta nel fatto che nell'object il metodo equals potrebbe essere sovrascritto e quindi
	 * potrebbe non fare il controllo sulle istanze dell'oggetto bensì sul loro contenuto 
	 */
	public boolean contains(int e, int[] array) {
		System.out.println("Esercizio 3.1");
		for(int i : array) {
			if(i == e) return true;
		}
		return false;
	}
	public boolean contains(Object e, Object[] array) {
		System.out.println("Esercizio 3.2");
		for(Object i : array) {
			if(i.equals(e)) return true;
		}
		return false;
	}
	
	public boolean isCrescente(int [] array) {
		System.out.println("Esercizio 4");
		for(int i = 0; i < array.length; i++) {
			if(i+1 == array.length) break;
			if(array[i] < array[i+1]) continue;
			return false;
		}
		return true;
	}
	
	public int mostRecurrent(int [] array) {
		System.out.println("Esercizio 5");
		Arrays.sort(array);
		int ris = -1, count = 0, currentRis = 0, currentCount = 0;
		for(int i = 0; i < array.length; i++) {
			currentRis = array[i];
			currentCount = 0;
			for(int j = i+1; j < array.length; j++) {
				if(array[i] == array[j]) {
					currentCount++;
				}
			}
			if(count < currentCount) {
				count = currentCount;
				ris = currentRis;
			}
		}
		count += 1;
		System.out.println("Most recurrent: " + ris + " appared "+count+" times");
		return ris;
	}
	
	public double mediaMultipliDiTre(int[] src) {
		System.out.println("Esercizio 6");
		double tmp = 0, count = 0;
		for(int i : src) {
			if(i%3 == 0) {
				tmp += i;
				count++;
			}
		}
		System.out.println("Media matematica multipli di 3: "+ (tmp/count));
		return tmp/count;
	}
	
	public void stampaZigZag(int[] src) {
		System.out.println("Esercizio 7");
		for(int i = 0, j = src.length-1; ; i++, j--) {
			if(i == j) {
				System.out.print(src[i] + "\n");
				break;
			} else if(j == i+1) {
				System.out.print(src[i] + "  " + src[j] + "\n");
				break;
			}
			System.out.print(src[i] + "  " + src[j] + "  ");
		}
	}
	
	public void media(int[] src) {
		System.out.println("Esercizio 8");
		int ris = 0;
		for(int i : src) {
			ris += i;
		}
		System.out.println("Media: " + (ris/src.length));
	}
	
	public String [] addString(String s, String[] a) {
		System.out.println("Esercizio 9");
		String[] ris = new String[a.length+1];
		for(int i = 0; i < a.length; i++) {
			ris[i] = a[i];
		}
		ris[a.length] = s;
		return ris;
	}
	
	public void morraCinese(String s1, String s2) {
		if(s1 != null && s2 != null) {
				
				int p1 = 0, p2 = 0;
				switch(s1.toLowerCase()) {
					case "carta":
						p1 = -1;
						break;
					case "forbici":
						p1 = 0;
						break;
					case "sasso":
						p1 = 1;
						break;
					default:
						System.out.println("Player1 Inserire la mossa corretta (Carta, Forbice, Sasso).");
				}
				switch(s2.toLowerCase()) {
				case "carta":
					p2 = -1;
					break;
				case "forbici":
					p2 = 0;
					break;
				case "sasso":
					p2 = 1;
					break;
				default:
					System.out.println("Player2 Inserire la mossa corretta (Carta, Forbice, Sasso).");
					return;
				}
				System.out.println("Player1 = "+s1+" VS Player2 = "+s2);
				if(p1 == p2) {
					System.out.println("Pareggio");
					return;
				}
				if((p1 == -1 && p2 == 0) || (p1 == 0 && p2 == 1) || (p1 == 1 && p2 == -1)) {
					System.out.println("Player2 Vince");
				}else {
					System.out.println("Player1 Vince");
				}
		}else{
			System.out.println("Inserire valori per Player1 e Player2");
		}
	}
	
	public void stampaData(String date) {
		System.out.println("Esercizio 11");
		DateTimeFormatter f2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(date,f2);
		System.out.println(localDate.getDayOfWeek() + " " + localDate.getDayOfMonth() + 
				" " + localDate.getMonth() + ", giorno "+ localDate.getDayOfYear() + " dell'anno " + 
				localDate.getYear() + ", settimana numero " + (localDate.getDayOfYear()/7+1));
		
	}
}
