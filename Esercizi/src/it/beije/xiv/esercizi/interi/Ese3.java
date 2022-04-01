package it.beije.xiv.esercizi.interi;

public class Ese3 {
    public static void main(String[] args) {
        int numero= Integer.parseInt(args[0]);

        System.out.println("Tabellina del "+ numero);

         for (int i=0;i<=10;i++){
             System.out.println(numero + " x "+ i +" = "+(numero*i));
         }
    }
}
