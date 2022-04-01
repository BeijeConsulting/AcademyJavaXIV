package it.beije.xiv.esercizi.array;

import java.util.Arrays;

public class Ese9 {
    public static void main(String[] args) {
        String[] oldArray=new String[5];
            oldArray[0]= "Uno";
            oldArray[1]= "due";
            oldArray[2]= "cia";
            oldArray[3]= "cavolo";

        Ese9 ese= new Ese9();



        String[] newArray=ese.addString("ULTIMO",oldArray);
        System.out.println(Arrays.toString(newArray));
        System.out.println(newArray.length);
    }

    public String[] addString(String s, String[] a){


        String[] newArray=new String[a.length+1];

        for (int i=0; i<a.length; i++){
            newArray[i] = a[i];
        }

        newArray[(a.length)] = s;
        return newArray;
    }
}
