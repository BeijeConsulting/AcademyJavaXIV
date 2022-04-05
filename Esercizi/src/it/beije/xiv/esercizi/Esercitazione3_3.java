package it.beije.xiv.esercizi;

public class Esercitazione3_3 {

	public static void main(String[] args) {
		// scrivere un metodo “boolean contains(int e, int[] array)” che restituisca 
		//true se l’elemento e è presente nell’array, false altrimenti.
		//Ripetere l’esercizio con “boolean contains(Object e, Object[] array)”, quali differenze ci sono?
		
		int[] array =  {2,3,5,7,1,34,6,8};
		int e = 30; 
		
		boolean ciao = contains(e, array);
		
		System.out.println(ciao);  
		
	}
	
	public static boolean contains(int e, int[] array) {
		boolean verifica = false; 
		for(int i = 0; i < array.length ; i++) {
			if(array[i] == e) {
				verifica = true; 
			}
		}
		return verifica; 
	}
	
	public static boolean contains(Object e, Object[] array) {
		boolean verifica = false; 
		for(int i = 0; i < array.length ; i++) {
			if(array[i] == e) {
				verifica = true; 
			}
		}
		return verifica; 
	}
}
