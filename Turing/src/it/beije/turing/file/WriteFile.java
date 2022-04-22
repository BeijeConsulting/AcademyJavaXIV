package it.beije.turing.file;

import it.beije.turing.rubrica.Contatto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriteFile {


    public static void main(String[] args) {
        List<Contatto> contatti = new ArrayList<>();
        //writeRubricaCSV(contatti, "/Users/simonepitossi/File/newContatti.csv", ";");
        writeRubricaXML(contatti, "/Users/simonepitossi/File/newXML.xml", true);
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

        while (!pathInserito) {
            System.out.println("Inserisci il path della directory:");
            file = new File(scan.nextLine());
            if (file.isDirectory()) {
                scan.close();
                pathInserito = true;
            } else {
                System.out.println("Il path inserito non porta ad una directory.");
            }

        }

        return file;
    }

    public static void writeFileList(int count, FileWriter fileWriter, File[] fileList) {

        for (File f : fileList) {
            if (f.isFile() && !f.getName().equalsIgnoreCase(".DS_Store")) {
                writeFileName(fileWriter, f, count);
            } else if (f.isDirectory()) {
                writeDirectory(fileWriter, f, count);
            }
        }
    }

    public static void writeFileName(FileWriter fileWriter, File f, int count) {

        try {
            for (int i = 0; i < count; i++) {
                fileWriter.write(" ");
            }
            fileWriter.write(f.getName() + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int writeDirectory(FileWriter fileWriter, File f, int count) {

        try {
            for (int i = 0; i < count; i++) {
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

    public static void writeRubricaCSV(List<Contatto> contatti, String pathFile, String separator, boolean writeNewContacts) {
        final File file = new File(pathFile);
        FileWriter fileWriter = null;


        try {
            if (!file.exists()) {
                fileWriter = new FileWriter(file);
            } else {
                fileWriter = new FileWriter(file, true);
                System.out.println("Il file esiste già, ogni contatto verrà aggiunto. ");
            }

            if (writeNewContacts) {
                contatti = Contatto.writeContatti();
            }

            for (Contatto c : contatti) {
                fileWriter.write(c.getNome() + separator);
                fileWriter.write(c.getCognome() + separator);
                fileWriter.write(c.getTelefono() + separator);
                fileWriter.write(c.getEmail() + separator);
                fileWriter.write(c.getNote() + "\n");
            }

            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeRubricaXML(List<Contatto> contatti, String pathFile, boolean writeNewContacts) {
        File file = new File(pathFile);

        if (!file.exists()) {
            writeNewXML(file, contatti, writeNewContacts);
        } else {
            System.out.println("Il file esiste già, ogni contatto verrà aggiunto. ");
            addNewContactsXML(file, contatti, writeNewContacts);
        }
    }

    public static void writeNewXML(File file, List<Contatto> contatti, boolean writeNewContacts) {
        FileWriter fileWriter;

        try {
            fileWriter = new FileWriter(file);

            if (writeNewContacts) {
                contatti = Contatto.writeContatti();
            }

            fileWriter.write("<Contatti>" + "\n");
            for (Contatto c : contatti) {
                fileWriter.write("\t" + "<Contatto>" + "\n");
                fileWriter.write("\t\t" + "<nome>" + c.getNome() + "</nome>" + "\n");
                fileWriter.write("\t\t" + "<cognome>" + c.getCognome() + "</cognome>" + "\n");
                fileWriter.write("\t\t" + "<email>" + c.getEmail() + "</email>" + "\n");
                fileWriter.write("\t\t" + "<telefono>" + c.getTelefono() + "</telefono>" + "\n");
                fileWriter.write("\t\t" + "<note>" + c.getNote() + "</note>" + "\n");
                fileWriter.write("\t" + "</Contatto>" + "\n");
            }
            fileWriter.write("</Contatti>" + "\n");

            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addNewContactsXML(File file, List<Contatto> contatti, boolean writeNewContacts) {
        FileWriter fileWriter;
        FileReader fileReader;
        BufferedReader bufferedReader;
        boolean trovatoFineRoot = false;
        List<String> oldFile = new ArrayList<>();

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            while (bufferedReader.ready()) {
                String s = bufferedReader.readLine();

                if (s.equalsIgnoreCase("</Contatti>")) {
                    trovatoFineRoot = true;
                } else if (!trovatoFineRoot) {
                    oldFile.add(s + "\n");
                }
            }

            fileWriter = new FileWriter(file);

            if (writeNewContacts) {
                contatti = Contatto.writeContatti();
            }

            for (String s : oldFile) {
                fileWriter.write(s);
            }

            for (Contatto c : contatti) {
                fileWriter.write("\t" + "<Contatto>" + "\n");
                fileWriter.write("\t\t" + "<nome>" + c.getNome() + "</nome>" + "\n");
                fileWriter.write("\t\t" + "<cognome>" + c.getCognome() + "</cognome>" + "\n");
                fileWriter.write("\t\t" + "<email>" + c.getEmail() + "</email>" + "\n");
                fileWriter.write("\t\t" + "<telefono>" + c.getTelefono() + "</telefono>" + "\n");
                fileWriter.write("\t\t" + "<note>" + c.getNote() + "</note>" + "\n");
                fileWriter.write("\t" + "</Contatto>" + "\n");
            }
            fileWriter.write("</Contatti>" + "\n");

            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


