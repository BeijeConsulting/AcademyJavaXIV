package it.beije.turing.xmlparser3.classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.beije.turing.xmlparser3.interfaces.LoadFile;

/**
 * @author Giuseppe Raddato
 * Data: 14 apr 2022
 */
public class Documento implements LoadFile {
    private static Documento d=null;

    public static Documento getIstance(){
        if(d==null){
            d=new Documento();
        }
        return d;
    }

    private Documento(){}

    @Override
    public Documento parse(String path) {
        StringBuilder s = new StringBuilder();
        List<StringBuilder> listElement = new ArrayList<>();

        try {
            File f = new File(path);
            FileReader fileReader = new FileReader(f);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while(bufferedReader.ready()) {
                char row = (char) bufferedReader.read();
                s.append(row);

            }
            Pattern pattern = Pattern.compile("(<.*?>)|(.+?(?=<|$))");
            //Pattern pattern = Pattern.compile("/(<.[^(><.)]+>)/g");
            Matcher matcher = pattern.matcher(s.toString());
            int i=0;
            while (matcher.find()) {
                String r=matcher.group().trim();
                if(!r.isEmpty()){
                    System.out.println((i++)+":"+matcher.group());
                }

            }




        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public Elemento getRootElement() {
        return null;
    }
}
