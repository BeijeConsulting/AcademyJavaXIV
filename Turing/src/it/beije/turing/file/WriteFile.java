package it.beije.turing.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import it.beije.turing.rubrica.Contatto;

public class WriteFile {
	
	
	public static void main(String[] args) {
		writeFileContatti();
	}

	private static void createFileWriteExercise() {
		try {
			File file = inputDirectoryPath();
			File[] fileList = file.listFiles();
			File newFile = new File(file.getAbsolutePath() + "/" + file.getName() + ".txt");
			FileWriter fileWriter = new FileWriter(newFile);
			
			writeFileList(0, fileWriter, fileList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static File inputDirectoryPath() {
		Scanner scan = new Scanner(System.in);
		boolean pathInserito = false;
		File file = null;
		
		while(!pathInserito) {
			System.out.println("Inserisci il path della directory:");
			file = new File(scan.nextLine());
			if(file.isDirectory()) {
				scan.close();
				pathInserito = true;
			} else {
				System.out.println("Il path inserito non porta ad una directory.");
			}
			
		}
		
		return file;
	}
	
	public static void writeFileList(int count, FileWriter fileWriter, File[] fileList) {
		
			for(File f : fileList) {
				if(f.isFile() && !f.getName().equalsIgnoreCase(".DS_Store")) {
					writeFileName(fileWriter, f, count);
				} else if(f.isDirectory()) {
					writeDirectory(fileWriter, f, count);
				}
			}
	}
	
	public static void writeFileName(FileWriter fileWriter, File f, int count) {
		
		try {
			for(int i = 0; i < count; i++) {
				fileWriter.write("\t");
			}
			fileWriter.write(f.getName() + "\n");
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int writeDirectory(FileWriter fileWriter, File f, int count) {
		
		try {
			for(int i = 0; i < count; i++) {
				fileWriter.write("\t");
			}
			fileWriter.write(f.getName() + "(dir)" + "\n");
			fileWriter.flush();
			writeFileList(++count, fileWriter, f.listFiles());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public static void writeFileContatti() {
		ArrayList<Contatto> contatti = Contatto.writeContatti();
		
		try {
			File file = new File("/Users/simonepitossi/File/contatti.csv");
			FileWriter fileWriter = new FileWriter(file);
			for(Contatto c: contatti) {
				fileWriter.write(c.toString() + "\n");
			}
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
