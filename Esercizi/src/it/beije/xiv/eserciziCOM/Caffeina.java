package it.beije.xiv.eserciziCOM;

public class Caffeina {

	public static void main(String[] args) {
		//Scrivere la funzione caffeina(int n) che prende un numero positivo come argomento e:
		//Se il numero è divisibile per 3, stampa “Java”
		//Se il numero è divisibile per 3 e per 4, stampa “Coffee”
		//Se il numero appartiene ad uno dei due casi precedenti ed è pari, aggiunge “Script” in fondo alla stringa
		//Se non appartiene a nessuno dei casi precedenti stampa “match_missed!”
		caffeina(103);
		
		
	}
		
		public static void caffeina(int n) {
			
			if( (n % 3) == 0) {
				if((n % 4) == 0) {
					System.out.print("Coffee");
					System.out.print(" Script");
				}else {
					if((n % 2) == 0) {
					System.out.print("Java");
					System.out.print(" Script");
					}else {
						System.out.println("Java");
					}
				}
			}else {
				System.out.println("match_missed!");
			}
		}
		
		
}
