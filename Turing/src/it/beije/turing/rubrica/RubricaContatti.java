package it.beije.turing.rubrica;

import it.beije.turing.db.JPAcriteria;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RubricaContatti {

    private ArrayList<Contatto> listaContatti = new ArrayList<Contatto>();
    private JPAcriteria jpAcriteria;

    public RubricaContatti(){
        jpAcriteria = new JPAcriteria();
    }

    public void leggiContatti(){

        List<Contatto> contattos = jpAcriteria.JPACriteriaLeggiContatti();
        listaContatti = (ArrayList<Contatto>) contattos;
        for (Contatto c: contattos ) {
            System.out.println(c.toString());
        }
    }

    public void cercaContatto() {


            Scanner in = new Scanner(System.in);
            ArrayList<Contatto> contattiTrovati = new ArrayList<Contatto>();

            System.out.println("Inserisci elemento da cercare: ");
            String elemento = in.nextLine();


            System.out.println("Inserisci tipo di elemento da cercare: ");
            System.out.println("1. Nome ");
            System.out.println("2. Cognome ");
            System.out.println("3. Numero ");
            System.out.println("4. Email  ");

            String scelta = in.nextLine();
            if(scelta.equals("")) {
                System.out.print("Scelta non valida");
            }

            System.out.println("Bene");

            switch(scelta) {

                case "1" :
                    System.out.println(" I Risutati sono: ");
                    contattiTrovati = filtraPerNome(elemento);
                    stampa(contattiTrovati);
                    break;

                case "2" :

                    System.out.println(" I Risutati sono: ");
                    contattiTrovati = filtraPerCognome(elemento);
                    stampa(contattiTrovati);
                    break;

                case "3" :
                    System.out.println(" I Risutati sono: ");
                    contattiTrovati = filtraPerTelefono(elemento);
                    stampa(contattiTrovati);
                    break;

                case "4" :

                    System.out.println(" I Risutati sono: ");
                    contattiTrovati = filtraPerEmail(elemento);
                    stampa(contattiTrovati);
                    break;
                default :

                    System.out.println("Indice sbagliato");

            }







        }

    private void stampa(ArrayList<Contatto> contattiTrovati) {

        for (Contatto c: contattiTrovati ) {
            System.out.println(c.toString());
        }
    }

/////////////////////////////////////////		FILTRA PER  EMAIL

        private ArrayList<Contatto> filtraPerEmail(String elemento) {

            ArrayList<Contatto> contattiTrovati = new ArrayList<Contatto>();

            for( Contatto c : listaContatti) {

                if(c.getEmail().equalsIgnoreCase(elemento)) {
                    contattiTrovati.add(c);
                }
            }

            return contattiTrovati;
        }


//////////////////////////////////////		FILTRA PER TELEFONO

        private ArrayList<Contatto> filtraPerTelefono(String elemento) {

            ArrayList<Contatto> contattiTrovati = new ArrayList<Contatto>();

            for( Contatto c : listaContatti) {

                if(c.getTelefono().equalsIgnoreCase(elemento)) {
                    contattiTrovati.add(c);
                }
            }

            return contattiTrovati;
        }


//////////////////////////////////////     FILTRA PER NOME
        private ArrayList<Contatto> filtraPerNome(String elemento) {

            ArrayList<Contatto> contattiTrovati = new ArrayList<Contatto>();

            for( Contatto c : listaContatti) {

                if(c.getNome().equalsIgnoreCase(elemento)) {
                    contattiTrovati.add(c);
                }
            }

            return contattiTrovati;
        }

////////////////////////////////////////	 FILTRA PER COGNOME			 ////////////////////////////////////////////////////////////////////////////////

        private ArrayList<Contatto> filtraPerCognome(String elemento) {

            ArrayList<Contatto> contattiTrovati = new ArrayList<Contatto>();

            for( Contatto c : listaContatti) {

                if(c.getCognome().equalsIgnoreCase(elemento)) {
                    contattiTrovati.add(c);
                }
            }

            return contattiTrovati;
        }

    public void aggiungiContatto() {



        Scanner in = new Scanner(System.in);
        Contatto contattoNuovo = new Contatto();

        System.out.println("Inserisci Nome : ");
        String nome = in.nextLine();
        if(nome.equals("")) {
            System.out.print("Nome non valido ");
        }
        System.out.println("Inserisci Cognome : ");
        String cognome = in.nextLine();
        if(cognome.equals("")) {
            System.out.print("Cognome non valido ");
        }
        System.out.println("Inserisci email : ");
        String email = in.nextLine();
        if(email.equals("")) {
            System.out.print("Email non valida");
        }
        System.out.println("Inserisci telefono : ");
        String telefono = in.nextLine();
        if(telefono.equals("")) {
            System.out.print("Telefono non valido");
        }

        System.out.println("Inserisci note : ");
        String note = in.nextLine();
        if(note.equals("")) {
            System.out.print("Note non valide");
        }

        contattoNuovo.setNome(nome);
        contattoNuovo.setCognome(cognome);
        contattoNuovo.setEmail(email);
        contattoNuovo.setTelefono(telefono);
        contattoNuovo.setNote(nome);

        jpAcriteria.JPAaggiungiContatto(contattoNuovo);

        }


    }

