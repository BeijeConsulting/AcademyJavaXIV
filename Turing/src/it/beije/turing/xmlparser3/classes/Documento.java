package it.beije.turing.xmlparser3.classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    	System.out.println("ciao");
    	try {
    		File f = new File(path);
    		System.out.println(f.exists());
			FileReader fileReader = new FileReader(f);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while(bufferedReader.ready()) {
				char row = (char) bufferedReader.read();
				if(row!='\n'|| row!='\t') {
					s.append(row);
					System.out.print("ciao");
				}
			}
			
			String[] result = s.toString().split("><");
			System.out.println(Arrays.toString(result));
			
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
