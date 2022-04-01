package it.beije.xiv.esercizi.interi;


public class Ese7 {

    public static void main(String[] args) {

        int elem = 100;
        int first = 1;
        int secondo = 1;


        for (int i = 1; i <= elem; i++) {
            System.out.print(first+" ");
            int sum = first + secondo;
            first = secondo;
            secondo = sum;

        }
    }
}
