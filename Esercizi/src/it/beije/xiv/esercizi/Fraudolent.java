package it.beije.xiv.esercizi;

import java.io.*;

public class Fraudolent {


    public static void readFile(String path) {
        double buy = 0;
        double sell = 0;
        int op = 0;
        File file = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            file = new File(path);
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            while(bufferedReader.ready()) {
                String[] split = bufferedReader.readLine().split(" ");
                op++;
                double importo = Double.parseDouble(split[1]);
                int quantita = Integer.parseInt(split[2]);
                if(split[3].equalsIgnoreCase("B\"")) {
                    buy += quantita*importo;
                } else {
                    sell = quantita*importo;
                }
            }

            System.out.println("Op: " + op + " Buy: " + buy + " Sell: " + sell);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readFile("/Users/simonepitossi/File/fraudolent.txt");
    }
}
