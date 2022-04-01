package it.beije.xiv.esercizi.array;

public class MediaMultipliDiTre {

    public static void main(String[] args) {
        int[] num={3,4,6,7,2,5,12,18};


        System.out.println("la media dei multipli di 3 è: "+ getAVG_multiple3(num) );

    }

    private static  float getAVG_multiple3(int[] num) {
        int numElem=0;
        float tempSum=0;

        for (int n:num) {
            if(n % 3== 0){
                tempSum+=n;
                numElem++;
            }
        }

        return tempSum/numElem;

    }
}
