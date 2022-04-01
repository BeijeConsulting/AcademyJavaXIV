package it.beije.xiv.esercizi.programmazionecompleti;

import java.util.ArrayList;

/**
 * @author Giuseppe Raddato
 * Data: 01 apr 2022
 */
public class TriangleSum {

    //Dato il seguente triangolo di numeri dispari:
    //  1
    //  3       5
    //  7        9        11
    //  13     15       17       19
    //  21     23     25       27     29
    //  ….
    //  si scriva la funzione rowSumOddNumbers(int n) che calcola la somma dei numeri nella riga n-esima. Per esempio:
    //  rowSumOddNumbers(1) = 1
    //  rowSumOddNumbers(3) = 7 + 9 + 11 = 27

    public static void main(String[] args) {
       // System.out.println("N=1 "+rowSumOddNumbers(1));
        System.out.println("N=2 "+rowSumOddNumbers(9));
    }


    public static int rowSumOddNumbers(int numRow){
        int totalSum=0;
        int lastElem=1;
        int i=1;
        while (i<=numRow){
            int j=0;
            while (j++<i){
                if(i==numRow){
                    totalSum+=lastElem;
                }
                System.out.print(lastElem+" ");
                lastElem+=2;
            }
            i++;
            System.out.println();
        }

        return totalSum;
    }


}
