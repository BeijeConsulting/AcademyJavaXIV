package File;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;



public class EsFileRic {
	public static void open(String[] dir) {
		try {
			int a = dir.length;
			if(dir.length == 0 ) return;
			
			FileReader fr = new FileReader(dir[a]);
			
			
		} catch (FileNotFoundException fnf) {
			// TODO Auto-generated catch block
			fnf.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		File file = new File("/Users/matteoprovezza/Desktop/Beije/AcademyJavaXIV/Turing/src/File/temp");
		
		String[] prova = file.list();
		for (String r : prova) {
			System.out.println(r);
		}
		
		open(prova);
	}

}
