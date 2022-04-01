package it.beije.xiv.esercizi.discord1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class CartaForbiceSasso {
    public static void main(String[] args) throws IOException {
       int  choseP1=-1;
       int choseP2=-1;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean inputValid=false;

        do{
            System.out.println("Giocatore 1");
            System.out.println("Inserisci una parola tra Carta Forbice o Sasso: ");
            String s=reader.readLine();
            int result=checkInput(s);

            if(result!=-1){
                choseP1=result;
                inputValid=false;
            }else{
                System.err.println("Input non valido");
                inputValid=true;
            }

        }while (inputValid);


        do{
            System.out.println("Giocatore 2");
            System.out.println("Inserisci una parola tra Carta Forbice o Sasso: ");
            String s = reader.readLine();
            int result=checkInput(s);

            if(result!=-1){
                choseP2=result;
                inputValid=false;
            }else{
                System.err.println("Input non valido");
                inputValid=true;
            }

        }while (inputValid);

       int result=checkResult(choseP1,choseP2);
       if(result==0){
           System.out.println("**************");
           System.out.println("|  Pareggio  |");
           System.out.println("**************");
       }else {
           System.out.println("**************************");
           System.out.println("|  Vince il Giocatore "+result+"  |");
           System.out.println("**************************");
       }
    }


    private static int checkInput(String s) {
        if(s.equalsIgnoreCase("CARTA")){
            return 0;
        }else if(s.equalsIgnoreCase("FORBICE")){
            return 1;
        }else if(s.equalsIgnoreCase("SASSO")){
            return 2;
        }else{
            return -1;
        }
    }


    private static int checkResult(int player1, int player2) {
        if(player1==player2){
            return 0;
        }else{
            return ((player1+1) % 3) == player2 ? 2 : 1;
        }
    }




}
