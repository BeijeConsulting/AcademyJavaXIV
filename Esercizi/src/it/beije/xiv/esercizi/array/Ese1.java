package it.beije.xiv.esercizi.array;

public class Ese1 {

    public static void main(String[] args) {
        int[] num={3,4,6,7,2,5};


        System.out.println("Il numero massimo è: "+ getMax(num) );

        System.out.println("Il numero minimo è: "+ getMin(num) );
    }

    public static int getMax(int[] array){
        return searchMaxMin(array, true);
    }

    public static int getMin(int[] array){
        return searchMaxMin(array, false);
    }

    public static int searchMaxMin(int[] array, boolean type)
    {
        int num=array[0];
        for (int i=1; i<array.length; i++){
            if(type){
                if (num < array[i]) {
                    num=array[i];
                }

            }else{
                if (num > array[i]) {
                    num=array[i];
                }
            }

        }
        return num;
    }



}
