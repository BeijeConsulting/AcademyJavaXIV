package it.beije.turing.file;

public class DirectoryTreeFilePrinter {
public static void main(String...args)
{
	String fileName = "DirTest.txt";
	String tree = DirBroswer.Broswe("src");
	Writer.Write(fileName, tree);
}
}
