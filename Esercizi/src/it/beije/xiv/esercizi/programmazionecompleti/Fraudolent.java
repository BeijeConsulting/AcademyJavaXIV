package it.beije.xiv.esercizi.programmazionecompleti;

import java.io.*;


import java.nio.charset.StandardCharsets;
import java.util.*;


/**
 * @author Giuseppe Raddato
 * Data: 01 apr 2022
 */
public class Fraudolent {

//“ABC 50.0 210 B”
//“ABC” è il nome dell’azione acquistata/venduta
//50.0 è l’importo della singola azione
//210 è la quantità
//‘B’ è l’operazione, che può valere ‘B’ (Buy) o ‘S’ (Sell)

    public static void main(String[] args) throws IOException {

        Fraudolent f= new Fraudolent("fraudolent.txt");

        for ( String r:f.getResult()) {
            System.out.println(r);
        }

    }

    private ArrayList<String> getResult() {
        int numErr=lineResult.size();
        lineResult.add(0,"Op:"+totalOp+" Buy: "+totalBuy+" Sell: "+totalSell);
        lineResult.add(1,"Err: "+numErr);
        return lineResult;
    }


    private ArrayList<String> lineResult=new ArrayList<>();
    Float totalBuy=new Float(0.0);
    Float totalSell=new Float(0.0);
    int totalOp=0;

    public Fraudolent(String filepath) throws IOException {

         printInputStream(filepath);
    }


    private  void printInputStream(String filepath) {
        InputStream is = Fraudolent.class.getClassLoader().getResourceAsStream(filepath);


        try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if(line.isEmpty()) {continue;}
                List<String> lineSep=Arrays.asList(line.split(" "));

                if(lineSep.size() != 4){
                    this.lineResult.add(line);
                }else{
                    try{
                        String name=lineSep.get(0);
                        Float importaAction=Float.parseFloat(lineSep.get(1));
                        Integer quant=Integer.parseInt(lineSep.get(2));
                        if(lineSep.get(3).length()==1){
                            switch (lineSep.get(3).charAt(0)){
                                case 'B':{
                                    totalBuy +=importaAction*quant;
                                    totalOp++;
                                    break;}
                                case 'S':{
                                    totalSell +=importaAction*quant;
                                    totalOp++;
                                    break;}
                                default:{
                                    throw new RuntimeException();
                                }
                            }
                        }else{
                            throw new RuntimeException();
                        }

                    } catch (Exception e){
                        this.lineResult.add(line);
                    }
                }

        }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}
