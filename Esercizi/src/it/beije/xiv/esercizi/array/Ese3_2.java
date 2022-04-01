package it.beije.xiv.esercizi.array;

public class Ese3_2 {

    public static void main(String[] args) {

        Ese3_2 search=new Ese3_2();

        Object[] num=new Object[10];
        num[0]=new Ese1();
        num[1]=new Ese2();
        num[2]=new Ese3_1();
        num[3]=new Ese3_2();


        Ese1 e=new Ese1();
        System.out.println(search.contains(e,num));

        num[4]=e;
        System.out.println(search.contains(e,num));
    }


    boolean contains(Object e, Object[] array){

        for (Object elem: array) {

            if(elem!=null && elem.equals(e)){
                return true;
            }
        }
        return false;
    }
}
