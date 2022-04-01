package it.beije.xiv.esercizi.stringhe;

public class StampaMaiuscole {
    public static void main(String[] args) {
        String[] arrayString={"Hello", "ciao", "Ola","salut"};

        for (int index=0; index<arrayString.length;index++) {

            char first=arrayString[index].charAt(0);

            if ('A' <= first & first  <= 'Z') {
                System.out.println(arrayString[index]);
            }

        }
    }
}
