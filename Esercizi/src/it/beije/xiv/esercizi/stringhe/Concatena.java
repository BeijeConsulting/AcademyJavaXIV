package it.beije.xiv.esercizi.stringhe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Concatena {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder parole= new StringBuilder();

        System.out.println("Inserisci 3 parole");

        for (int i =1;i<=3;i++){
            System.out.println("Parola "+i+" :");
            parole.append(reader.readLine());
            if(i!=3){
                parole.append("*");
            }
        }

        System.out.println("Output:" +parole);
    }
}
