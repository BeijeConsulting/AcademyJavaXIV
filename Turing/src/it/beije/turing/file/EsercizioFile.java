package it.beije.turing.file;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EsercizioFile {
	public static StringBuilder directories = new StringBuilder();
	public static StringBuilder name = new StringBuilder();

	public static String takeUserInput() {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		scanner.close();
		return s;
	}

	public static File openFile() {
		File file = null;
		String s;
		do {
			System.out.println("Inserire percorso file: ");
			s = takeUserInput();
			file = new File(s);
			System.out.println("\n");
		} while (!file.exists());
		name.append(s);
		return file;
	}

	public static File[] findDirectories(File file) {
		return file.listFiles();
	}

	public static void addTabs(int i) {
		for (int x = 0; x < i; x++)
			directories.append("\t");
	}

	public static void openDirectories(File[] files, int tabs) {
		for (File f : files) {
			addTabs(tabs);
			if (f.isDirectory()) {
				directories.append("Dir:" + f.getAbsolutePath() + "\n");
				// System.out.println("DIR: " + f.getAbsolutePath());
				openDirectories(findDirectories(f), tabs + 1);
			} else {
				directories.append(f.getAbsolutePath() + "\n");
			}
				
		}
	}

	public static void main(String[] args) {
		File fr = openFile();

		if (!fr.isDirectory()) {
			directories.append(fr.getAbsolutePath() + "\n");
			// System.out.println(fr.getAbsolutePath());
		} else {
			// System.out.println("DIR: " + fr.getAbsolutePath());
			directories.append("Dir:" + fr.getAbsolutePath() + "\n");
			openDirectories(findDirectories(fr), 0);
		}
		writeOnFile();
	}

	public static void writeOnFile() {
		File file = new File(name.toString() + ".txt");
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
			fileWriter.write(directories.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
