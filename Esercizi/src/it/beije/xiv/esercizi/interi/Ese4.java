package it.beije.xiv.esercizi.interi;

public class Ese4 {
    public static void main(String[] args) {

        StringBuilder s=new StringBuilder("*****");
        for (int i=s.length()-1;i>=0;i--){
            System.out.println(s);
            s.deleteCharAt(i);
        }
    }
}
