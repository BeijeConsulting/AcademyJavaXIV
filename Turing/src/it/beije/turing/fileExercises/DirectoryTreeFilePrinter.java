package it.beije.turing.fileExercises;

import it.beije.turing.file.Writer;

public class DirectoryTreeFilePrinter {
public static void main(String...args)
{
	String fileName = "DirTest.txt";
	String tree = DirBroswer.Broswe("src");
	Writer.Write(fileName, tree);
}
}
