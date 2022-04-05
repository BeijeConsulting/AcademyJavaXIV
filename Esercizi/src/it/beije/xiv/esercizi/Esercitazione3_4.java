package it.beije.xiv.esercizi;

public class Esercitazione3_4 {

	public static void main(String[] args) {
		/*
		Verificare la sequenza crescente di un array. 
		Il metodo “boolean isCrescente(int [] array)” restituisce 
		true se tutti gli elementi dell’array passato sono in ordine crescente,
		false altrimenti. 
		*/
		int[] array1 =  {20,19,18,7};
		
		boolean ciao = isDecrescente(array1);
		if (ciao == true) {
			System.out.println("L'arrey è decrescente"); 
			}else{
			System.out.println("L'arrey non è decrescente");
			}

		
		int[] array2 =  {1,2,6,7,8,9,10};
		
		boolean ciao2 = isCrescente(array2);
		if (ciao2 == true) {
		System.out.println("L'arrey è crescente"); 
		}else
		System.out.println("L'arrey non è crescente");
		
	}
	

	
	
	public static boolean isCrescente(int [] array) {
	 
	 boolean verifica = true; 
		for(int i = 1; i < array.length ; i++) {
			
			if(!(array[i] > array[(i-1)])) {
				verifica = false;
				break; 
			}
		}
		 return verifica; 
		}
	
	public static boolean isDecrescente(int [] array) {
		
		 boolean verifica = true; 
			for(int i = 1; i < array.length ; i++) {
				
				if(!(array[i] < array[(i-1)])) {
					verifica = false;
					break; 
				}
			}
			 return verifica; 
			}
	}

