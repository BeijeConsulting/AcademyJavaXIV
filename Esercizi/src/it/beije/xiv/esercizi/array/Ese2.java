package it.beije.xiv.esercizi.array;

public class Ese2 {
    public static void main(String[] args) {
        int[] num={2,4,1,6,9,5,2,5,1,3,5};

        int maxIndex=getMax(num);
        System.out.println("Il numero massimo è: "+ num[maxIndex] +" in posizione i="+maxIndex);
        int minIndex=getMin(num);
        System.out.println("Il numero minimo è: "+ num[minIndex]+" in posizione i="+minIndex);
    }

    public static int getMax(int[] array){
        return searchMaxMin(array, true);
    }

    public static int getMin(int[] array){
        return searchMaxMin(array, false);
    }

    public static int searchMaxMin(int[] array, boolean type)
    {
        int index=0;
        for (int i=1; i<array.length; i++){
            if(type){
                if (array[index] < array[i]) {
                    index=i;
                }

            }else{
                if (array[index] > array[i]) {
                    index=i;
                }
            }

        }
        return index;
    }
}
