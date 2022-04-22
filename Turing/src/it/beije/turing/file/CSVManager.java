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
            int a = 0;
            int id = -1, nome = -1, cognome = -1, telefono = -1, email = -1, note = -1;

            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();

                String[] colonne = null;
                if(virgolette) {
                    line = line.substring(1, line.length()-1);
                    colonne = line.split("\"" +separatore+ "\"");
                } else {
                    colonne = line.split(separatore);
                }

                if (a == 0) {
                    int i = 0;
                    for(String s : colonne) {
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
                    if(colonne.length > 0) {
                        if(nome != -1) {
                            contatto.setId(Integer.parseInt(colonne[id]));
                        }
                        if(nome != -1) {
                            contatto.setNome(colonne[nome]);
                        }
                        if(cognome != -1) {
                            contatto.setCognome(colonne[cognome]);
                        }
                        if(telefono != -1) {
                            contatto.setTelefono(colonne[telefono]);
                        }
                        if(email != -1) {
                            contatto.setEmail(colonne[email]);
                        }
                        if(note != -1) {
                            contatto.setNote(colonne[note]);
                        }
                    }
                    contatti.add(contatto);
                }
                a++;
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
