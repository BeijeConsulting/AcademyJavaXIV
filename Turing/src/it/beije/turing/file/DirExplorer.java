package it.beije.turing.file;

import java.io.File;
import java.util.Arrays;

public class DirExplorer {
	static int tabs = 0;
	
	public static void explore (File f) {
		
		if (f.exists()) {
			if (f.isDirectory()) {
				File[] ls = f.listFiles();
				//System.out.println("Folder "+f.getName()+" contains the following files:");
				for (File i:ls) {
					for (int j=0; j<tabs; j++) {
						System.out.print("\t");
					}
					System.out.println(i.getName());
					if (i.isDirectory()) {
						tabs+=1;
						explore(i);
						tabs-=1;
					} 
				}
				} else if (f.isFile()) {
					return;
			}
				//System.out.println(Arrays.toString(f.list()));
				
//	 else {
//			//System.out.println("Invalid Path");
//	 }
		
	}
	}
	
	public static void main(String[] args) {
		
	//File file = new File("C:/Users/Padawan/Downloads/negozi.csv");
		File file = new File("C:/Users/Padawan/Desktop");
//	System.out.println("file exists? " + file.exists());
//	System.out.println("file is file? " + file.isFile());
//	System.out.println("file is dir? " + file.isDirectory());
//	System.out.println("file is dir? " + Arrays.toString(file.listFiles()));
	
	explore(file);
	}
	
}

