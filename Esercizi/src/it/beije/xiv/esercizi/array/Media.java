package it.beije.xiv.esercizi.array;

public class Media {

    public static void main(String[] args) {
        int[] array= {1,2,3,4,5,6,7,8,11};

        System.out.println("La media è "+getAVG(array));

    }
    public static float getAVG(int[] array){
        float sum=0;
        for(int a: array){
            sum+=a;
        }
        return  sum/array.length;

    }

}



