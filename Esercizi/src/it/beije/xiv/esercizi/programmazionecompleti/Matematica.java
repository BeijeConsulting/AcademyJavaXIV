package it.beije.xiv.esercizi.programmazionecompleti;

/**
 * @author Giuseppe Raddato
 * Data: 02 apr 2022
 */
public class Matematica {

    public static void main(String[] args) {
        System.out.println(persistenza(999));
    }
    public static int persistenza(int val){

        String s=String.valueOf(val);
        int nvolte=0;
        int valtemp;

            do{
                nvolte++;
                valtemp=1;
                for (int i = 0; i < s.length(); i++) {
                    valtemp *=Integer.parseInt(String.valueOf(s.charAt(i)));
                }
                s=String.valueOf(valtemp);

            }while ( valtemp>9);

        return nvolte;

    }
}
