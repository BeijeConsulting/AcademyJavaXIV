package it.beije.turing.rubrica;

import it.beije.turing.db.JPAcriteria;

import java.util.Scanner;

public class Applicazione {
    public static void main(String[] args){

        RubricaContatti rubrica = new RubricaContatti();
        Scanner in = new Scanner(System.in);
        String scelta;
        boolean esci = false;

        System.out.println("Ciao sono la tua rubrica");
        System.out.println("Cosa Vuoi Fare?");

        do {
            System.out.println("					");
            System.out.println("1. Vedi lista contatti ");
            System.out.println("2. Aggiungi Contatto");
            System.out.println("3. Cerca Contatto");
            System.out.println("4. Elimina Contatto");
            System.out.println("5. Cancella Contatto");
            System.out.println("6. Modifica contatto ");
            System.out.println("7. Trova Contatti Duplicati");
            System.out.println("8. Unisci Contatti Duplicati");
            System.out.println("9. Esci dal programma");
            System.out.print("Scopri l'arcano : ");

            // C:/Users/luigi/Downloads/rubrica.csv
            // C:/Users/luigi/Downloads/rubrica_-_email.csv
            // C:/Users/luigi/Downloads/rubrica_-_cognome.csv

            scelta = in.next();

            switch(scelta) {

                case "1" :
                    System.out.println("	                     			");
                    System.out.println("			CONTATTI PRESENTI				");


                    rubrica.leggiContatti();

                    esci = false;
                    break;

                case "2":
                    System.out.println("	                     			");
                    System.out.println("		AGGIUNGI CONTATTO 			");

                    rubrica.aggiungiContatto();
                    System.out.println("		CONTATTO AGGIUNTO 			");
                    esci = false;

                    break;

                case "3":
                    System.out.println("	                     			");
                    System.out.println("		CERCA CONTATTO				");

                    rubrica.cercaContatto();
                    esci = false;
                    break;

                case "4":
                    System.out.println("Elimina Contatto");
                    esci = false;
                    break;

                case "5":
                    System.out.println("Cancella Contatto");
                    esci = false;
                    break;

                case "6":
                    System.out.println("Modifica contatto");
                    esci = false;
                    break;

                case "7":
                    System.out.println("Trova duplicati");
                    esci = false;
                    break;

                case "8":
                    System.out.println("Unisci duplicati");
                    esci = false;
                    break;

                case "9":
                    System.out.println("		Arrivederci				");
                    esci = true;
                    System.exit(0);

                    break;

                default :
                    esci = false;
                    System.out.println("Scelta sbagliata : ");

            }
        } while (!esci);


    }




}

