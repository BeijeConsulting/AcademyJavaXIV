package it.beije.xiv.esercizi;

public class RowSumOddNumbers {
	public static void main(String...args) {
		RowSumOddNumbers r = new RowSumOddNumbers();
		int n = 5;
		String res = r.rowSumOddNumbers(n);
		System.out.print(res);
	}
	String rowSumOddNumbers(int n) {
		StringBuilder s = new StringBuilder();
		int somma = 0;
		for(int i=0,count = n+(n-1)*(n-1);i<n;i++,count+=2) {
			somma+= count;
			if(i==(n-1)) {
				s.append(count+" = "+somma);
			}
			else s.append(count+" + ");
		}
		
		return s.toString();
	}
}
