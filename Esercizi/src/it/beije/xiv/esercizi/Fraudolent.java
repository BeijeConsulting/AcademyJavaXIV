package it.beije.xiv.esercizi;
import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Fraudolent {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\39346\\IdeaProjects\\AcademyJavaXIV\\Esercizi\\src\\it\\beije\\xiv\\esercizi\\azioni"));
        ArrayList<Integer> sumListS = new ArrayList<Integer>();
        ArrayList<Integer> sumListB = new ArrayList<Integer>();
        String s="";
        while(s!=null) {
            s = (String)(reader.readLine());
            System.out.println(s);
            String[] splitStr = s.split("\\s+");
            if (splitStr[3].toLowerCase().equals("s")){
            int molt= Integer.parseInt(splitStr[1])*Integer.parseInt(splitStr[2]);
            sumListS.add(molt);
                }
            else if (splitStr[3].toLowerCase().equals("b")){
                int molt= Integer.parseInt(splitStr[1])*Integer.parseInt(splitStr[2]);
                sumListB.add(molt);
            }
        }
        int sumB=0;
        int sumS=0;
        for (int el: sumListS){
            sumS+=el;
        }
        for (int el: sumListB){
            sumB+=el;
    }
        System.out.println("somma sell:" + sumS);
        System.out.println("somma buy:" + sumB);
    }}
