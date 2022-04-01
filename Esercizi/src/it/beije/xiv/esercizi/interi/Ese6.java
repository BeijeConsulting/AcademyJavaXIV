package it.beije.xiv.esercizi.interi;

public class Ese6 {
    public static void main(String[] args) {
        StringBuilder f1 = new StringBuilder();

        for (int i =1;i<=6; i++){
            f1.append(i);
            StringBuilder f2 = new StringBuilder();

            for (int j =7-i; j>=1; j--){
                f2.append(j);
            }

            System.out.printf("%s %s\n",f1 ,f2);
        }
    }
}
