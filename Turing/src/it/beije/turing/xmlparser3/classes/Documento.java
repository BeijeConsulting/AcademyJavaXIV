package it.beije.turing.xmlparser3.classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.beije.turing.xmlparser3.Exception.TagNotOpenException;
import it.beije.turing.xmlparser3.interfaces.Elemento;
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
       /* StringBuilder s = new StringBuilder();


        LinkedList<Elemento> lkde= new LinkedList<>();

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
                *//*
                if(!r.isEmpty()){
                    System.out.println((i++)+":"+matcher.group());
                }
                *//*

                System.out.println(r);
                Elemento elemento = new ConcreteElement();

                if(r.indexOf('<') == 0 && r.indexOf('>')==r.length()-1){
                    if(r.contains("/")){
                        //check stack
                        String e = listElement.get(listElement.size()-1);
                        String a = e.substring(0,1).replace("<","</")+e.substring(1,e.length());

                        if(r.equals(a)){
                            listElement.remove(listElement.size()-1);
                        }else{
                            throw new TagNotOpenException();
                        }
                    }else{

                        listElement.add(r);
                        if(r.contains(" ")){
                            elemento.setTagName(r.substring(1,r.indexOf(" ")));
                        }else{
                            elemento.setTagName(r.substring(1,r.indexOf(">")));
                        }

                        if(!listElement.get(listElement.size()-1).contains("/")&& !listElement.isEmpty()) {
                           // Elemento figlio = new Elemento();

                        }
                        //System.out.println(elemento.getTagName());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        return null;
    }

    public Elemento getRootElement() {
        return null;
    }


}
