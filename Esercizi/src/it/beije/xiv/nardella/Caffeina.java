package it.beije.xiv.nardella;

import java.util.*;

public class Caffeina {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input = -1;

		do {
			input = Integer.parseInt(scanner.nextLine());
		} while (input <= 0);

		caffeine(input);

	}

	public static void caffeine(int n) {
		StringBuilder s = new StringBuilder("");

		if (n % 3 == 0) {
			if (n % 4 == 0) {s.append("Coffee");} 
			else {s.append("Java");}
			
			if (n % 2 == 0) {s.append("Script");}
			
		} else {
			s.append("No match!");
		}
		System.out.println(s.toString());
	}

}
