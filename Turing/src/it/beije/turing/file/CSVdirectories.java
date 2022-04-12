package it.beije.turing.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CSVdirectories {
	public int countTab = 0;
	public List<String> list = new ArrayList<String>();
	
	public void takeForPrint(String pathDirectory) {
		
		File file = new File(pathDirectory);
		String[] listFile = file.list();
		
		if (listFile != null) {
			for(String s : listFile) {
				File fileFromList = new File(pathDirectory + "/" + s);
				StringBuilder str = new StringBuilder();
				if(fileFromList.isDirectory()) {
					for(int i = 0; i < this.countTab; i++) {
						str.append("\t");
					}
					str.append(s + "\n");
					this.countTab++;
					this.takeForPrint(pathDirectory + "/" + s);
				} else {
					for(int i = 0; i < this.countTab; i++) {
						str.append("\t");
					}
					str.append(s + "\n");
				}
				this.list.add(str.toString());
			}
			this.countTab--;
		} else {
			this.list.add("La directory non contiene nessun file");
		}
	
	}
	
	public void printDirectories(String pathNewFile) {
		
		File newFile = new File(pathNewFile);
		
		FileWriter fileWriter = null;
		
		try {
			fileWriter = new FileWriter(newFile);
			
			for(String s : this.list) {
				fileWriter.write(s);
			}
			
		} catch(IOException ioExc) {
			ioExc.printStackTrace();
		} finally {
			try {				
				fileWriter.flush();
				fileWriter.close();
			} catch(IOException ioExc) {
				ioExc.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		
		CSVdirectories csvC = new CSVdirectories();
		
		//csvC.printDirectories("/Users/lorenzoorru0/Desktop/CSVjava/corso_java", null);
		csvC.takeForPrint("/Users/lorenzoorru0/Desktop/CSVjava/corso_java");
		csvC.printDirectories("/Users/lorenzoorru0/Desktop/CSVjava/CSVprintDirectories.txt");
	}
}
