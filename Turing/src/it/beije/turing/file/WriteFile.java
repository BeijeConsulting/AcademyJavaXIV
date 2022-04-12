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
			File file = writePath();
			File[] fileList = file.listFiles();
			File newFile = new File(file.getAbsolutePath() + "/" + file.getName() + ".txt");
			FileWriter fileWriter = new FileWriter(newFile);
			
			writeFileList(0, fileWriter, fileList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static File writePath() {
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
					writeFile(fileWriter, f, count);
				} else if(f.isDirectory()) {
					writeDirectory(fileWriter, f, count);
				}
			}
	}
	
	public static void writeFile(FileWriter fileWriter, File f, int count) {
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
	
	public static ArrayList<Contatto> writeContatti() {
		Scanner scan = new Scanner(System.in);
		ArrayList<Contatto> contatti = new ArrayList<Contatto>();
		boolean contattiNonInseriti = true;
		
		System.out.println("Vuoi inserire dei contatti? (Si o no)");
		while(contattiNonInseriti) {
			if(scan.nextLine().equalsIgnoreCase("Si")) {
				contatti.add(Contatto.writeContatti());
				System.out.println("Vuoi inserire altri contatti? (Si o no)");
			} else {
				System.out.println("Inserimento dei contatti terminato.");
				
				contattiNonInseriti = false;
			}
		}
		
		return contatti;
	}
	
	public static void writeFileContatti() {
		ArrayList<Contatto> contatti = writeContatti();
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
