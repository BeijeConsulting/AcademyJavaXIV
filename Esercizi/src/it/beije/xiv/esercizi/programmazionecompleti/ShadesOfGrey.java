package it.beije.xiv.esercizi.programmazionecompleti;

import java.util.ArrayList;

/**
 * @author Giuseppe Raddato
 * Data: 01 apr 2022
 */
public class ShadesOfGrey {
    public static void main(String[] args) {

        String[] s = getShades(256);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }


    }
    //Scrivere una funzione che prende un numero intero n come parametro e ritorna un array di sfumature di grigio in codice esadecimale (#aaaaaa, per esempio).
    // L’array dovrebbe essere ordinato in senso ascendente (#010101, #020202, ecc), usando le lettere minuscole.public class ShadesOfGrey {
    //static String[] shadesOfGrey(int num) {
    //// returns n shades of grey in an array
    //}
    //}Ricorda che: il grigio è un colore composto dalla stessa quantità di rosso, verde e blu: #010101, #aeaeae, #555555. Inoltre: #000000 e #FFFFFF
    // non sono valori accettati.Se n è negativo ritornare un array vuoto, se n è maggiore di 254, ritornare un array di 254 elementi.
   public static String[] getShades(int num){
        String[] list=new String[ num >= 254 ? 254 : num];

       for (int i = 0; i <list.length; i++) {
           String s=Integer.toHexString(0x01+i);
           s=(s.length()==1)? "0"+s : s;
           list[i] = ("#"+s+s+s);
       }
       return list;
   }
}
