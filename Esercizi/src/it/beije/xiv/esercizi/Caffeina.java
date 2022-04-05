package it.beije.xiv.esercizi;
import java.util.Scanner;  // Import the Scanner class


public class Caffeina {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= Integer.parseInt(sc.nextLine());
        caffeina(n);
    }

    private static void caffeina(int n) {
        if (n % 3 == 0 && n % 4 == 0) {
            if (n % 2 == 0) {
                System.out.println("coffeestring");
            } else {
                System.out.println("coffee");
            }
        } else if (n % 3 == 0) {
            if (n % 2 == 0) {
                System.out.println("Javastring");
            } else {
                System.out.println("java");
            }
        } else {
            System.out.println("nomatch");
        }
    }
}
