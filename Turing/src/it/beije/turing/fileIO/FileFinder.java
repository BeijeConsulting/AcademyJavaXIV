package it.beije.turing.fileIO;

import java.io.File;

public class FileFinder {
	
	private File[] children;
	
	public FileFinder(File root) {
		children = root.listFiles();
	}
	
	public void find(String extension) {
		for (File child : children) {
			String fileName = child.toString();
			if (child.isDirectory()) {
				FileFinder finder = new FileFinder(child);
				finder.find(extension);
			}
			else if(fileName.endsWith(extension)) {
				System.out.print(fileName);
			}
		}
	}
}
