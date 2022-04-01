package it.beije.xiv.esercizi.programmazionecompleti;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author Giuseppe Raddato
 * Data: 01 apr 2022
 */
public class CalculateGas {


    public static void main(String[] args) {
        int res=getExpirationDate(100, 4,100);
        if(res!=-1){
            System.out.println("Dal "+res+" la bibita non sarà più vendibile");
        }else{
            System.err.println("Parametri non corretti");
        }
    }


    public static int getExpirationDate(int content,int evapPerDay, int threshold){
        if( 0< evapPerDay && evapPerDay<=100 && 0< threshold && threshold<=100 && content > 0) {
            int perEva24h = (content * evapPerDay) / 100;
            int numDay = threshold / perEva24h;

            LocalDate dateEstimate = LocalDate.now();
            Period p = Period.ofDays(numDay);
            dateEstimate = dateEstimate.plus(p);

            return dateEstimate.getDayOfMonth();
        } else{
            return -1;

        }

    }
}
