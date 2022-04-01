package it.beije.xiv.esercizi.stringhe;

public class Contrario {
    public static void main(String[] args) {
        //versione 1
        StringBuilder s= new StringBuilder("Viva Java!");
        System.out.println(s.reverse());

        //versione 2
        String s2="Viva Java!";
        StringBuilder result=new StringBuilder(s2.length());
        for (int i=s2.length()-1;i>=0;i--){
            result.append(s2.charAt(i));
        }
        System.out.println(result);


    }
}
