package it.beije.xiv.esercizi.discord1;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class DataInput {

    //Realizzare un programma che, ricevuta in input una data in formato 13/09/2021 stampi le seguenti informazioni:
    //Lunedì 13 Settembre, giorno 256 dell'anno 2021, settimana numero 37
    //in italiano od inglese, va bene comunque
    public static void main(String[] args) {

        String dataInput="13/09/2021";

        LocalDate date= LocalDate.parse(dataInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int weekOfYear = date.get(WeekFields.of(Locale.getDefault()).weekOfYear());

        //Monday 13 September , day 256 of the year 2021, week number 37


        System.out.println(date.getDayOfWeek() +" "+ date.getDayOfMonth() +" "+date.getMonth()+", DAY "+date.getDayOfYear()
                +" OF THE YEAR "+ date.getYear()+", WEEK NUMBER "+weekOfYear+" ");

    }


}
