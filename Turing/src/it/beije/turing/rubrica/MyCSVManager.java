package it.beije.turing.rubrica;

import it.beije.turing.file.CSVutil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyCSVManager {

    public List<Contatto> loadRubricaFromCSV(String pathFile, String separator) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        List<Contatto> contacts = null;
        int NOME = -1;
        int COGNOME = -1;
        int TELEFONO = -1;
        int EMAIL = -1;
        int NOTE = -1;
        boolean firstLoop = true;

        try {
            fileReader = new FileReader(pathFile);
            bufferedReader = new BufferedReader(fileReader);
            contacts = new ArrayList<>();
            Contatto contact = null;
            while (bufferedReader.ready()) {
                String row = bufferedReader.readLine();
                if (firstLoop) {
                    String[] fields = CSVutil.cleanRow(row, separator);
                    for (int i = 0; i < fields.length; i++) {
                        switch (fields[i].toUpperCase()) {
                            case "NOME": {
                                NOME = i;
                                break;
                            }
                            case "COGNOME": {
                                COGNOME = i;
                                break;
                            }
                            case "TELEFONO": {
                                TELEFONO = i;
                                break;
                            }
                            case "EMAIL": {
                                EMAIL = i;
                                break;
                            }
                            case "NOTE": {
                                NOTE = i;
                                break;
                            }
                            default:
                                throw new IllegalArgumentException(
                                        "Unexpected value: " + fields[i].toUpperCase());
                        }
                    }
                    firstLoop = false;
                } else {
//					System.out.println(row);
                    String[] fields = CSVutil.cleanRow(row, separator);

                    contact = new Contatto();
                    if (NOME != -1) {
                        contact.setNome(fields[NOME]);
                    }
                    if (COGNOME != -1) {
                        contact.setCognome(fields[COGNOME]);
                    }
                    if (TELEFONO != -1) {
                        contact.setTelefono(fields[TELEFONO]);
                    }
                    if (EMAIL != -1) {
                        contact.setEmail(fields[EMAIL]);
                    }
                    if (NOTE != -1) {
                        contact.setNote(fields[NOTE]);
                    }
//					System.out.println(contact);
                    contacts.add(contact);
                }

            }
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException fEx) {
                fEx.printStackTrace();
            }
        }

        return contacts;

    }

    public void writeRubricaCSV(List<Contatto> contacts, String pathFile, String separator) {
        File file = new File(pathFile);
        FileWriter fileWriter = null;

        try {
            if (file.exists()) {
                System.out.println("FILE GIÁ ESISTENTE!!!");
                fileWriter = new FileWriter(file, true);
            } else fileWriter = new FileWriter(file, false);

            for (Contatto contact : contacts) {
                if (contact.getCognome() != null) {
                    fileWriter.write(contact.getCognome());
                }
                fileWriter.write('\t');
                if (contact.getNome() != null) {
                    fileWriter.write(contact.getNome());
                }
                fileWriter.write('\t');
                if (contact.getEmail() != null) {
                    fileWriter.write(contact.getEmail());
                }
                fileWriter.write('\t');
                if (contact.getTelefono() != null) {
                    fileWriter.write(contact.getTelefono());
                }
                fileWriter.write('\n');
            }
        } catch (IOException ioE) {
            ioE.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException fEx) {
                fEx.printStackTrace();
            }

            System.out.println("Done");
        }
    }


}
