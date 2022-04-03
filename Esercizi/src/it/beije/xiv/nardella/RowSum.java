package it.beije.xiv.nardella;

public class RowSum {

	public static void main(String[] args) {
		int[][] odd = new int[5][];
		odd[0] = new int[] {1};
		odd[1] = new int[] {3, 5};
		odd[2] = new int[] {7,9,11};
		odd[3] = new int[] {13, 15 ,17,19};
		odd[4] = new int[] {21, 23, 25, 27, 29};
		
		for(int i = 0; i < odd.length; i++){
			System.out.println(rowSumOddNumbers(odd[i], i));
		}
		
		
	}
	public static int rowSumOddNumbers(int[] num, int i) {
		int sum = 0;
		for(int x : num) {
			sum += x;
		}
		return sum;
	}
}
