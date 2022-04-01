package it.beije.xiv.esercizi.array;

import java.util.Arrays;


public class StampaZigZag {

    public static void main(String[] args) {

        int[] numeri= new int[10];
        numeri[0] = 1 ;
        numeri[1] = 35 ;
        numeri[2] = 9 ;
        numeri[3] = 2 ;
        numeri[4] = 4 ;
        numeri[5] = 12 ;
        numeri[6] = 100 ;
        numeri[7] = 13 ;
        numeri[8] = 1 ;
        numeri[9] = 12 ;


        System.out.println(Arrays.toString(numeri));
        System.out.println(numeri.length/2);
        System.out.println(numeri.length);

        for (int i=0;i<(numeri.length/2);i++){
            int primo=numeri[i];
            int ultimo=numeri[(numeri.length-1)-i];
            System.out.print(i+"= "+primo);
            System.out.println("_____"+((numeri.length-1)-i)+"= "+ultimo);
        }



    }


}
