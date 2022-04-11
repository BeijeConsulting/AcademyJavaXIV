package it.beije.turing.opendir;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Leggere la cartella
 * salvare il contenuto della cartella
 * ciclare il contenuto della cartella
 * stampare il contenuto
 * se il contenuto é una cartella, stampare il contenuto
 * ricorsivamente.
 */

public class OpenDir {
	
	public static void readDir(String dirPath) {
		int tabs = 0;
		File dir = null;
		dir = new File(dirPath);
		
		if (dir.exists()) openDir(dir, tabs);
		else System.out.println("File non esiste");
	}
	
	public static void openDir(File dir, int tabs) {
		File[] files = dir.listFiles();
		for (File file : files) {
			printChar('\t', tabs);
			System.out.println(file.getName());
			if (file.isDirectory()) {
				openDir(file, ++tabs);
				tabs--;
			}
		}
	}
	
	public static void printChar(char c, int times) {
		for (int i = 0; i < times; i++)
			System.out.print(c);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		readDir("/temp");

	}

}
