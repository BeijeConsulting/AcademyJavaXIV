package it.beije.xiv.esercizi;

public class Esercitazione1_7 {

	public static void main(String[] args) {
		/*
		 * Scrivere un programma che stampi i primi 
		 * 100 elementi della successione di Fibonacci.
		 * Scrivere un programma che stampi le n righe 
		 * della successione di Fibonacci in questo modo:
		 * 
				1
				1, 1
				1, 1, 2
				1, 1, 2, 3
				1, 1, 2, 3, 5
				1, 1, 2, 3, 5, 8
				1, 1, 2, 3, 5, 8, 13
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		for (int i = 0; i < 100; i++)
        {
            long f = 0, s = 1;
                    
            for (int j = 0; j <= i; j++)
            {
                System.out.print(s);
                if (j < i) System.out.print(", ");
                long temp = s;
                s += f;
                f = temp;
            }
            
            f = s = 1;
            
            System.out.println();
        }
	}

}
