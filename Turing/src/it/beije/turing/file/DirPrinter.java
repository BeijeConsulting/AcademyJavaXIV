package it.beije.turing.file;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DirPrinter {
	
	public static int tabs = 0;

	public static File scanPath() {
		System.out.println("Enter directory path");
		Scanner s = new Scanner(System.in);
		String st = s.next();
		s.close();
		return new File(st);
	}
	
	public static void explore (File f, FileWriter fw) throws IOException{
		
		if (f.exists()) {
			if (f.isDirectory()) {
				File[] ls = f.listFiles();
				for (File i:ls) {
					for (int j=0; j<tabs; j++) {
						fw.write('\t');
					}
					fw.write(i.getName());
					fw.write('\n');
					if (i.isDirectory()) {
						tabs+=1;
						explore(i,fw);
						tabs-=1;
					} 
				}
			} else if (f.isFile()) {
				return;
			}
		}
	}
	
	
	public static void main(String[] args) {

		File file = scanPath();
		File text = new File("C:/Users/Padawan/Desktop/prova.txt");
		
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(text);
			explore(file, fw);
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		} finally {
			try {
				fw.flush();
				fw.close();
			} catch (IOException fEx) {
				fEx.printStackTrace();
			}
			
			System.out.println("done");
		}
		
	}

	}


	
