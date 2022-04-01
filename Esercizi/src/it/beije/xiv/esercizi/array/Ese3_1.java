package it.beije.xiv.esercizi.array;

public class Ese3_1 {


    public static void main(String[] args) {
        int[] num={3,4,6,7,2,5};
        int e=3;
        Ese3_1 ese3=new Ese3_1();


        System.out.println(ese3.contains(e,num));

    }


    boolean contains(int e, int[] array){
        for (int elem: array) {
            if(elem==e){
                return true;
            }
        }
        return false;
    }
}
