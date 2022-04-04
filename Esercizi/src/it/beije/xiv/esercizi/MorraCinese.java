package it.beije.xiv.esercizi;

import java.util.Scanner;  // Import the Scanner class

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 39346
 */



public class MorraCinese {

    public static void choose(){
        Scanner first = new Scanner(System.in);  // Create a Scanner object
        Scanner second = new Scanner(System.in);  // Create a Scanner object
        String one;
        String two;
        do{
            System.out.println("scelta primo giocatore (sasso-carta-forbice)");
            one=first.nextLine().toLowerCase();  // Read user input
        } while (!one.equals("sasso") && !one.equals("carta") && !one.equals("forbice"));
        do{
            System.out.println("scelta secondo giocatore (sasso-carta-forbice)");
            two=second.nextLine().toLowerCase();  // Read user input
        } while (!two.equals("sasso") && !two.equals("carta") && !two.equals("forbice"));
        winner(one, two);
    }

    public static void winner(String one, String two){
        if (one.equals("sasso") && two.equals("sasso") || one.equals("forbice") && two.equals("forbice") ||one.equals("carta") && two.equals("carta")){
            System.out.println("Pareggio");
        }
        else if ((one.equals("carta") && two.equals("sasso")) || (one.equals("forbice") && two.equals("carta"))){
            System.out.println("vince giocatore 1");
        }
        else{
            System.out.println("vince giocatore 2");

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        choose();
    }

}
