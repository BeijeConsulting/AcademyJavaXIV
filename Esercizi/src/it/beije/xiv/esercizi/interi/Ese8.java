package it.beije.xiv.esercizi.interi;

public class Ese8 {
    public static void main(String[] args) {
        int n = 10;
        int first = 1;
        int secondo = 1;

        StringBuilder s= new StringBuilder();
        s.append(first);
        System.out.println(s+" ");

        for (int i = 2; i <= n; i++) {
            s.append(","+secondo);
            System.out.println(s+" ");
            int sum = first + secondo;
            first = secondo;
            secondo = sum;


        }
    }
}
