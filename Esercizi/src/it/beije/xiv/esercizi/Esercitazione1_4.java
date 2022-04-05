package it.beije.xiv.esercizi;

public class Esercitazione1_4 {

	public static void main(String[] args) {
		/* Stampare a video la seguente figura:
		 
		 ******
		 *****
		 ****
		 ***
		 ** 
		 * 
		 
		 */

		
		for(int i=0; i< 6 ; i++){
			
			for (int j = 6 - i; j > 0; j--) {
				
				System.out.print("*");
				
			}
			
			System.out.print("\n");
		}
	}

}
