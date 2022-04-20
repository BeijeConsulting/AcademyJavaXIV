package it.beije.turing.file;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import it.beije.turing.rubrica.Contatto;

public class CSVManager {
    public static List<Contatto> loadRubricaFromCSV(String path, String separatore, boolean virgolette) throws IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        List<Contatto> contatti = null;

        try {

            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            contatti = new ArrayList<Contatto>();
            Contatto contatto = null;
            int c = 0;
            int id = -1, nome = -1, cognome = -1, telefono = -1, email = -1, note = -1;

            while (bufferedReader.ready()) {
                String row = bufferedReader.readLine();

                String[] columns = null;
                if(virgolette) {
                    row = row.substring(1, row.length()-1);
                    columns = row.split("\"" +separatore+ "\"");
                } else {
                    columns = row.split(separatore);
                }

                if (c == 0) {
                    int i = 0;
                    for(String s : columns) {
                        switch(s) {
                            case "ID":
                                id = i;
                                break;
                            case "NOME":
                                nome = i;
                                break;
                            case "COGNOME":
                                cognome = i;
                                break;
                            case "TELEFONO":
                                telefono = i;
                                break;
                            case "EMAIL":
                                email = i;
                                break;
                            case "NOTE":
                                note = i;
                                break;
                        }
                    }
                } else {
                    contatto = new Contatto();
                    if(columns.length > 0) {
                        if(nome != -1) {
                            contatto.setId(Integer.parseInt(columns[id]));
                        }
                        if(nome != -1) {
                            contatto.setNome(columns[nome]);
                        }
                        if(cognome != -1) {
                            contatto.setCognome(columns[cognome]);
                        }
                        if(telefono != -1) {
                            contatto.setTelefono(columns[telefono]);
                        }
                        if(email != -1) {
                            contatto.setEmail(columns[email]);
                        }
                        if(note != -1) {
                            contatto.setNote(columns[note]);
                        }
                    }
                    contatti.add(contatto);
                }
                c++;
            }
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
            throw ioEx;
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException fEx) {
                fEx.printStackTrace();
            }
        }
        return contatti;
    }

    public static void writeRubricaCSV(List<Contatto> contatti, String path, String separatore) throws IOException {

        File file = new File(path);

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write("ID" +separatore+ "COGNOME" +separatore+ "NOME" +separatore+ "EMAIL" +separatore+ "TELEFONO" +separatore+ "NOTE\n");
            for (Contatto contatto : contatti) {
                if(Integer.toString(contatto.getId()) != null) {
                    fileWriter.write(contatto.getId());
                }
                fileWriter.write(separatore);
                if(contatto.getCognome() != null) {
                    fileWriter.write(contatto.getCognome());
                }
                fileWriter.write(separatore);
                if(contatto.getNome() != null) {
                    fileWriter.write(contatto.getNome());
                }
                fileWriter.write(separatore);
                if(contatto.getEmail() != null) {
                    fileWriter.write(contatto.getEmail());
                }
                fileWriter.write(separatore);
                if(contatto.getTelefono() != null) {
                    fileWriter.write(contatto.getTelefono());
                }
                fileWriter.write(separatore);
                if(contatto.getNote() != null) {
                    fileWriter.write(contatto.getNote());
                }
                fileWriter.write('\n');
            }
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
            throw ioEx;
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException fEx) {
                fEx.printStackTrace();
            }
        }
    }
}
