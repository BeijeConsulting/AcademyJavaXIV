package it.beije.turing.rubrica;

import it.beije.turing.db.JPAcriteria;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RubricaContatti {

    private List<Contatto> listaContatti = new ArrayList<Contatto>();
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
            System.out.print("Nome inesistente \n");
        }
        System.out.println("Inserisci Cognome : ");
        String cognome = in.nextLine();
        if(cognome.equals("")) {
            System.out.print("Cognome inesistente \n");
        }
        System.out.println("Inserisci email : ");
        String email = in.nextLine();
        if(email.equals("")) {
            System.out.print("Email inesistente \n");
        }
        System.out.println("Inserisci telefono : ");
        String telefono = in.nextLine();
        if(telefono.equals("")) {
            System.out.print("Telefono inesistente \n");
        }

        System.out.println("Inserisci note : ");
        String note = in.nextLine();
        if(note.equals("")) {
            System.out.print("Note inesistenti \n");
        }

        contattoNuovo.setNome(nome.trim());
        contattoNuovo.setCognome(cognome.trim());
        contattoNuovo.setEmail(email.trim());
        contattoNuovo.setTelefono(telefono.trim());
        contattoNuovo.setNote(nome.trim());

        jpAcriteria.JPAaggiungiContatto(contattoNuovo);

        }


    public void eliminaContatto() {

        List<Contatto> contattos = jpAcriteria.JPACriteriaLeggiContatti();
        listaContatti = (ArrayList<Contatto>) contattos;
        for (Contatto c: contattos ) {
            System.out.println(c.toString());

        }


        Scanner in = new Scanner(System.in);
        Contatto contatto = new Contatto();

        System.out.println(" Id dell'elemento da eliminare : ");
        String numero = in.nextLine();
        if(numero.equals("")) {
            System.out.print("Nome non valido ");
        }
        int num = Integer.parseInt(numero);

        for (Contatto c: contattos ) {
           if(num == c.getId()){
               jpAcriteria.delete(c);
           }

        }


    }

    public void modificaContatto() {

        List<Contatto> contattos = jpAcriteria.JPACriteriaLeggiContatti();
        listaContatti = (ArrayList<Contatto>) contattos;
        for (Contatto c: contattos ) {
            System.out.println(c.toString());

        }

        Scanner in = new Scanner(System.in);
        Contatto contatto = new Contatto();

        System.out.println(" Id dell'elemento da modificare : ");
        String numero = in.nextLine();
        if(numero.equals("")) {
            System.out.print("Nome non valido ");
        }
        int num = Integer.parseInt(numero);


        for (Contatto c: contattos ) {
            if(num == c.getId()){
                System.out.println("Andiamo a modificare i campi! (premi 'NO' per non modificare)  : ");
                System.out.println("Aggiorna Nome : ");
                String nome = in.nextLine();
                System.out.println("Aggiorna Cognome : ");
                String cognome = in.nextLine();
                System.out.println("Aggiorna Email : ");
                String email = in.nextLine();
                System.out.println("Aggiorna Telefono : ");
                String telefono = in.nextLine();
                System.out.println("Aggiorna Note : ");
                String note = in.nextLine();

                jpAcriteria.modifica(c , nome, cognome, email, telefono, note);


            }

        }
    }


    public void trovaDuplicati() {

        List<Contatto> contattos = jpAcriteria.JPACriteriaLeggiContatti();
        listaContatti = contattos;

        boolean ciSonoDuplicati = false;
        System.out.println(" Ricerca dei duplicati in corso....");


        int i = 0;
        while(i < contattos.size()){
            Contatto c = contattos.get(i);

            int j = i + 1;
            while(j < contattos.size()){
                Contatto c1 = contattos.get(j);
                if(c.getEmail().equalsIgnoreCase(c1.getEmail())  && (c.getId()!=c1.getId()) ){
                    System.out.println("Duplicato trovato in email : ");
                    System.out.println(" Contatto 1 " +c.toString());
                    System.out.println(" Contatto 2 " +c1.toString());
                    ciSonoDuplicati = true;
                }
                j++;
            }

            i++;
        }

        i = 0;
        while(i < contattos.size()){
            Contatto c = contattos.get(i);

            int j = i + 1;
            while(j < contattos.size()){
                Contatto c1 = contattos.get(j);
                if(c.getTelefono().equalsIgnoreCase(c1.getTelefono())  && (c.getId()!=c1.getId()) ){
                    System.out.println("Duplicato trovato in email : ");
                    System.out.println(" Contatto 1 " +c.toString());
                    System.out.println(" Contatto 2 " +c1.toString());
                    ciSonoDuplicati = true;
                }
                j++;
            }

            i++;
        }

//        for(Contatto c : listaContatti){
//
//            for(Contatto c1 : listaContatti){
//
//                if(c.getEmail().equalsIgnoreCase(c1.getEmail())  && (c.getId()!=c1.getId()) ){
//                    System.out.println("Duplicato trovato in email : ");
//                    System.out.println(" Contatto 1 " +c.toString());
//                    System.out.println(" Contatto 2 " +c1.toString());
//                    ciSonoDuplicati = true;
//                }
//            }
//        }
//
//        for(Contatto c : listaContatti){
//
//            for(Contatto c1 : listaContatti){
//
//                if(c.getTelefono().equals(c1.getTelefono()) && (c.getId()!=c1.getId()) ){
//                    System.out.println("Duplicato trovato in Telefono : ");
//                    System.out.println(" Contatto 1 " +c.toString());
//                    System.out.println(" Contatto 2 " +c1.toString());
//                    ciSonoDuplicati = true;
//                }
//
//
//            }
//        }

        if(ciSonoDuplicati==false){
            System.out.println("Non ci sono duplicati");
        }
    }

    public void gestisciDuplicati() {

        List<Contatto> contattos = jpAcriteria.JPACriteriaLeggiContatti();
        listaContatti = contattos;

        boolean ciSonoDuplicati = false;
        System.out.println(" Ricerca dei duplicati in corso....");


        int i = 0;
        while(i < contattos.size()){
            Contatto c = contattos.get(i);

            int j = i + 1;
            while(j < contattos.size()){
                Contatto c1 = contattos.get(j);
                if(c.getEmail().equalsIgnoreCase(c1.getEmail())  && (c.getId()!=c1.getId()) ){
                    System.out.println("Duplicato trovato in email : ");
                    System.out.println(" Contatto 1 " +c.toString());
                    System.out.println(" Contatto 2 " +c1.toString());
                    //jpAcriteria = new JPAcriteria();
                    jpAcriteria.delete(c1);
                }
                j++;
            }

            i++;
        }

        i = 0;
        while(i < contattos.size()){
            Contatto c = contattos.get(i);

            int j = i + 1;
            while(j < contattos.size()){
                Contatto c1 = contattos.get(j);
                if(c.getTelefono().equalsIgnoreCase(c1.getTelefono())  && (c.getId()!=c1.getId()) ){
                    System.out.println("Duplicato trovato in email : ");
                    System.out.println(" Contatto 1 " +c.toString());
                    System.out.println(" Contatto 2 " +c1.toString());
                    //jpAcriteria = new JPAcriteria();
                    jpAcriteria.delete(c1);
                }
                j++;
            }

            i++;
        }

    }


    public void importaEsporta() {
        Scanner in = new Scanner(System.in);
        System.out.println("1.Importa CSV \n2.Importa XML \n3.Esporta CSV \n4.Esporta CSV");

        String scelta = in.next();

        switch(scelta) {

            case "1" :
                System.out.println("	                          			    ");
                System.out.println("			    Importa CSV				    ");


                break;

            case "2":
                System.out.println("	                       		        	");
                System.out.println("	        	Importa XML		        	");


                break;
            case "3" :
                System.out.println("	                          		    	");
                System.out.println("			    Esporta CSV				    ");


                break;

            case "4":
                System.out.println("	                       		        	");
                System.out.println("	        	Esporta XML		        	");


                break;
    }
}


