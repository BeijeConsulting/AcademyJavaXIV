package it.beije.xiv.esercizi;

public class Esercitazione3_5 {
	public static void main(String[] args) {
		//Scrivere il metodo: “public int mostRecurrent(int [] array)” ,
		//che trova l’elemento più ricorrente in un array. 
		//Il metodo restituisce l’elemento trovato.
		
		
		int[] array = {4, 1, 55, 47, 3, 55, 7 , 4, 1, 3, 6, 4}; 
		
		int val = mostRecurrent(array);
		
		System.out.println("Il valore ripetuto più volte è "+ val);
		
	}

	public static int mostRecurrent(int [] array) {
		
		int valore = 0; 
		int ricorrenza = 0; 
		
		for(int i = 0; i < array.length ; i++) {
			
			if(contaOcc(array[i], array) > ricorrenza ) {
				valore = array[i];
				ricorrenza = contaOcc(array[i], array);
			}
			if(contaOcc(array[i], array) > ricorrenza ) {
				valore = array[i];
				ricorrenza = contaOcc(array[i], array);
			}
		}
		return valore;	
		}
	
	
	public static int contaOcc(int numero, int[] array) {
		
		int occorrenza = 0; 
		
		for(int i = 0; i < array.length ; i++) {
			if(array[i] == numero ) {
				occorrenza++; 
			}
		}
		return occorrenza; 
		}	
}