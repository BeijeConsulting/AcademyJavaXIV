package it.beije.xiv.esercizi.completi;

public class TriangoloDispari {

	public static void main(String[] args) {
		System.out.println(TriangoloDispari.rowSumOddNumbers(2));
	}
	public static int rowSumOddNumbers(int n) {
		int firstRowNumber = 1;
		int ris = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i; j++) {
				firstRowNumber += 2;
			}
		}
		for(int i = 0; i < n; i++) {
			ris += firstRowNumber;
			firstRowNumber += 2;
		}
		return ris;
	}
}
