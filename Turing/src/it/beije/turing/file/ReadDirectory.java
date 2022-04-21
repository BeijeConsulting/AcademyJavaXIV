package it.beije.turing.file;

import java.io.*;
import java.util.Scanner;

public class ReadDirectory {
	private static StringBuilder result= new StringBuilder();
   
    public static void main(String[] args) throws IOException {

        System.out.println("Insert path");
        Scanner s = new Scanner(System.in);
        String path =null;
        File file=null;
        boolean repeat=true;
        do {
            path = s.next();
            file= new File(path);
            if(!file.exists()){
                repeat=true;
                System.err.println("Repeat");
                System.out.println("Insert path");
            }else {
                repeat=false;
            }
        }while (repeat);

        s.close();

        StringBuilder resultFinal = showDirectoryTree(0, file);
        writeOnFile(resultFinal, path ,"resultTree");

    }

   

    static StringBuilder showDirectoryTree(int lvl, File file) throws IOException {
            File[] files = file.listFiles();
            if(files!=null){
                for (int i = 0; i < files.length; i++){
                    if(files[i].isDirectory()){
                        for (int j = 0; j <lvl; j++) {
                            System.out.print('\t');
                            result.append('\t');
                        }

                        System.out.println(files[i].getName()+"(dir) PATH:"+ file.getAbsolutePath());
                        result.append(files[i].getName()+"(dir) PATH:"+ file.getAbsolutePath()+"\n");

                       showDirectoryTree(++lvl,files[i]);
                    }else {
                        for (int j = 0; j < lvl; j++) {
                            System.out.print('\t');
                            result.append("\t");
                        }
                        System.out.println(files[i].getName());
                        result.append(files[i].getName()+"\n");
                    }
                }
            }
            return result;
    }
    private static void writeOnFile(StringBuilder resultFinal, String path,String nomeFile) {
        File file = new File(path+"/"+nomeFile+".txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(resultFinal.toString());
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException fEx) {
                fEx.printStackTrace();
            }
            System.out.println("Written");
        }
    }
}