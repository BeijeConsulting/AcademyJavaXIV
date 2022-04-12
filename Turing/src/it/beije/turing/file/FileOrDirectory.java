package it.beije.turing.file;

import java.io.File;
import java.io.IOException;

public class FileOrDirectory {
    String path;
    public FileOrDirectory(String path) {
        this.path=path;
    }

    public void verifyFile(){
        File file= null;
        try {
            file = new File(this.path);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("file is file? " + file.getAbsolutePath());
        System.out.println("file is dir? " + file.isDirectory());
    }

    public static void main(String[] args) {
    FileOrDirectory f= new FileOrDirectory("ciao.txt");
    f.verifyFile();
    }

}
