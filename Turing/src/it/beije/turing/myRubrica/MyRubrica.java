package it.beije.turing.myRubrica;

import it.beije.turing.rubrica.Contatto;

import java.sql.Connection;
import java.util.List;

/**
 * @author Giuseppe Raddato
 * Data: 19 apr 2022
 */
public class MyRubrica {

    public static void main(String[] args) {
        OpRubrica rubrica= new SQLManager();
        List<Contatto> l=rubrica.showContact(Order.NO);
       // print(rubrica.showContact(Order.NO));

        // print(rubrica.search("Ra"));

        /*Contatto contatto= new Contatto();
        contatto.setCognome("Raddato");
        contatto.setNome("Giuseppe");
        contatto.setEmail("mmm@gmail.com");
        contatto.setTelefono("3381234567");
        contatto.setNote("Ciao da me");
        rubrica.insert(contatto);*/

        /*Contatto c= l.get(l.size()-1);
        c.setNome("PIPPO");
        c.setNote("Questa è una nuova nota");
        rubrica.modificaContatto(c);*/



        print(rubrica.showContact(Order.NO));



    }

    private static void print(List<Contatto> listContact) {
        if(!listContact.isEmpty()) {
            System.out.println("====================================================================================================================================================================================");
            System.out.printf("| %10s | %30s | %30s | %35s | %15s | %30s |\n", "ID", "NOME", "COGNOME", "EMAIL", "TELEFONO", "NOTE");
            System.out.println("====================================================================================================================================================================================");
            for (Contatto c : listContact) {
                System.out.printf("| %10s | %30s | %30s | %35s | %15s | %30s |\n", c.getId(), c.getNome(), c.getCognome(), c.getEmail(), c.getTelefono(), c.getNote());
            }
            System.out.println("==========================================================================FINE=====================================================================================================");
        }else {
            System.out.println("Lista Vuota");
        }
    }


}
