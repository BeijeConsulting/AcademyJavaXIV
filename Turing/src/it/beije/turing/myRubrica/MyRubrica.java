package it.beije.turing.myRubrica;

import it.beije.turing.rubrica.Contatto;

import java.util.List;

/**
 * @author Giuseppe Raddato
 * Data: 19 apr 2022
 */
public class MyRubrica {

    public static void main(String[] args) {
        OpRubrica rubrica= new SQLManager();
        print(rubrica.showContact(Order.NO)) ;



    }

    private static void print(List<Contatto> listContact) {
        System.out.println("====================================================================================================================================================================================");
        System.out.printf("| %10s | %30s | %30s | %35s | %15s | %30s |\n","ID","NOME","COGNOME","EMAIL","TELEFONO","NOTE");
        System.out.println("====================================================================================================================================================================================");
        for (Contatto c:listContact) {
        System.out.printf("| %10s | %30s | %30s | %35s | %15s | %30s |\n",c.getId(),c.getNome(),c.getCognome(),c.getEmail(),c.getTelefono(),c.getNote());
        }
        System.out.println("==========================================================================FINE=====================================================================================================");

    }


}
