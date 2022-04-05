package it.beije.xiv.esercizi;

public class Esercitazione1_6 {
	public static void main(String[] args) {
	
	/*  1      654321
		12      54321
		123      4321
		1234      321
		12345      21
		123456      1
	*/
		
		for (int i = 0; i < 6; i++)
        {
            for (int j = 1 + i; j > 0; j--)
            {
                System.out.print(j);
            }
            
            System.out.print("    ");
            
            for (int j = 6 - i; j > 0; j--)
            {
                System.out.print(j);
            }
            
            if (i < 6) System.out.println();
        }
	}
}
