package it.beije.xiv.esercizi;

import java.util.ArrayList;

public class Persistence {

    public static void persistenza(int num) {
        int count=0;
        int sum=1;
        boolean finish=true;
        String numString=Integer.toString(num);
        ArrayList<Integer> sumList = new ArrayList<Integer>();
        for (int i=0; i<numString.length(); i++){
            sumList.add((int)(numString.charAt(i)-48));
    }
        while(finish){
            for (int el: sumList) {
                System.out.println("el: " + el);
                System.out.println("sum: " + sum);
                sum=sum*el;
            }
                if (Integer.toString(sum).length()==1){
                    finish=false;
                }
                else{
                    sumList.clear();
                    System.out.println(sumList.size());
                    String n=Integer.toString(sum);
                    for (int i=0; i<n.length(); i++){
                        sumList.add((int)(numString.charAt(i)-48));
                    }
                    System.out.println("size "+sumList.size());

                    count+=1;
                }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        int num=323;
        persistenza(num);
    }


}
