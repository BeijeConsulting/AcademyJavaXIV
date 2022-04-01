package it.beije.xiv.esercizi.array;

public class Ese5 {
    public static void main(String[] args) {

        int[] array={1,2,3,4,5,6,1,2,3,1,2};
        System.out.println(new Ese5().mostRecurrent(array));

    }

    public int mostRecurrent(int [] array){
        int count = 1;
        int tempCount;
        int valueTemp = 0;

        int recurrent = 0;

        for (int i = 0; i < (array.length-1) ; i++) {
            valueTemp = array[i];
            tempCount = 0;

            for (int j = 1; j < array.length; j++) {
                if (valueTemp == array[j]){
                    tempCount++;
                }
            }
            if (tempCount > count) {
                count = tempCount;
                recurrent = valueTemp;

            }
        }
        return recurrent;
    }
}
