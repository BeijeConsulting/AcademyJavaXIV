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

       print(rubrica.showContact(Order.NOME)) ;



    }

    private static void print(List<Contatto> showContact) {

    }


}
