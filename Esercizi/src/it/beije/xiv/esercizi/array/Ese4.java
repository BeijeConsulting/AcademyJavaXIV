package it.beije.xiv.esercizi.array;

public class Ese4 {
    public static void main(String[] args) {
        Ese4 ese4= new Ese4();
        int[] elemOrderChar={'a','b','c','d'};

        System.out.println("Caratteri oridnati: "+ese4.isCrescente(elemOrderChar));

        int[] elemNonOrderChar={'a','b','c','a'};
        System.out.println("Caratteri Non Oridnati: "+ese4.isCrescente(elemNonOrderChar));


        int[] elemOrderInt={1,2,3,4,5,6,7,8};
        System.out.println("Numeri Oridnati: "+ese4.isCrescente(elemOrderInt));

        int[] elemNonOrderInt={1,2,3,4,5,6,7,8,0};
        System.out.println("Numeri Non Oridnati: "+ese4.isCrescente(elemNonOrderInt));
    }

    boolean isCrescente(int [] array){
        for (int i=1;i<array.length;i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }
}
