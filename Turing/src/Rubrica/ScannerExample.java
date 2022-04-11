package Rubrica;

import java.util.Scanner;


public class ScannerExample {
	
	public static void main(String[] args) {
		System.out.println("avvio scanner...");
		
		Scanner s = new Scanner(System.in);
		String st = s.next();
		while (!st.equalsIgnoreCase("exit")) {
			System.out.println(st);
			st = s.next();
			
			//...
		}
		
		System.out.println("BYE!!");
		s.close();

	}

}