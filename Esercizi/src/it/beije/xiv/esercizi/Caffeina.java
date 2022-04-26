package it.beije.xiv.esercizi;

public class Caffeina {

    public static void caffeina(int n) {
        if(n % 3 == 0) {
            if(n % 4 == 0) {
                System.out.printf("Coffe");
            } else {
                System.out.printf("Java");
            }

            if(n % 2 == 0) {
                System.out.printf("Script \n");
            } else {
                System.out.printf("\n");
            }
        } else {
            System.out.println("match_missed!");
        }
    }

    public static void main(String[] args) {
        caffeina(0);
        caffeina(3);
        caffeina(12);
        caffeina(30);
        caffeina(16);
    }
}
