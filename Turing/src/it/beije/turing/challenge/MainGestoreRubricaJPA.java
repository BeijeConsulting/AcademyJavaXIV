package it.beije.turing.challenge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import it.beije.turing.file.CSVManager;
import it.beije.turing.file.XMLManager;
import it.beije.turing.rubrica.Contatto;

public class MainGestoreRubricaJPA {

    public static void main(String[] args) {
        gestioneRubrica();

    }

    public static void printMenu() {
        System.out.println("Per stampare tutti i contatti digitare: \"stampa\"");
        System.out.println("Per cercare uno specifico contatto digitare: \"cerca\"");
        System.out.println("Per inserire un nuovo contatto digitare: \"inserisci\" ");
        System.out.println("Per modificare un contatto già esistente digitare: \"modifica\"");
        System.out.println("Per cancellare un contatto già esistente digitare: \"elimina\"");
        System.out.println("Per verificare se ci sono contatti duplicati in rubrica digitare: \"duplicati\"");
        System.out.println("Per unire i contatti duplicati digitare: \"unisci\"");
        System.out.println("Per esportare un database digitare: \"esporta\"");
        System.out.println("Per importare un database digitare: \"importa\"");
        System.out.println("Per uscire dal gestore di rubrica digitare: \"esci\"");
    }

    public static void printRubrica(List<Contatto> contatti) {
        for(Contatto c : contatti) {
            System.out.println(c);
        }
    }

    public static void findContatto(List<Contatto> contatti, Scanner s) {
        List<Contatto> contattiMatch = new ArrayList<>();
        System.out.print("\nInserisci il nome del contatto desiderato: ");
        String nome = s.next();
        System.out.print("\nInserisci il cognome del contatto desiderato: ");
        String cognome = s.next();

        for(Contatto contatto : contatti) {
            if(nome.equals(contatto.getNome()) && cognome.equals(contatto.getCognome())) {
                contattiMatch.add(contatto);
            }
        }
        if(contattiMatch.size() >= 1){
            for(Contatto c : contattiMatch) {
                System.out.println(c);
            }
        } else {
            System.out.print(nome +" "+ cognome +" non esiste in rubrica.");
        }
    }

    public static void insertContatto(Scanner s) {
        Contatto contatto = new Contatto();
        List<Contatto> contatti = new ArrayList<>();
        s = new Scanner(System.in);

        System.out.print("\nInserisci il nome del nuovo contatto: ");
        contatto.setNome(s.nextLine());
        System.out.print("Inserisci il cognome del nuovo contatto: ");
        contatto.setCognome(s.nextLine());
        System.out.print("Inserisci il numero di telefono del nuovo contatto: ");
        contatto.setTelefono(s.nextLine());
        System.out.print("Inserisci l' email del nuovo contatto: ");
        contatto.setEmail(s.nextLine());
        System.out.print("Inserisci eventuali note del nuovo contatto: ");
        contatto.setNote(s.nextLine());
        contatti.add(contatto);

        for (Contatto c: contatti) {
            JPACriteriaManager.insertContatto(c);
        }
    }

    public static void updateContatto(List<Contatto> contatti, Scanner s) {
        String str = "";
        //Per mostrare i contatti così da scegliere successivamente quale modificare
        for(Contatto c : contatti) {
            System.out.println(c);
        }

        System.out.println("Inserisci l'id del contatto che vuoi modificare: ");
        str = s.next();
        Contatto contatto = null;
        for(Contatto c : contatti) {
            if(c.getId() == Integer.parseInt(str)) {
                contatto = c;
            }
        }
        s = new Scanner(System.in);
        System.out.print("\nInserisci il nome : ");
        contatto.setNome(s.nextLine());
        System.out.print("Inserisci il cognome : ");
        contatto.setCognome(s.nextLine());
        System.out.print("Inserisci il numero di telefono : ");
        contatto.setTelefono(s.nextLine());
        System.out.print("Inserisci l' email : ");
        contatto.setEmail(s.nextLine());
        System.out.print("Inserisci il note : ");
        contatto.setNote(s.nextLine());

        JPACriteriaManager.updateDB(contatto, contatto.getId());
    }

    public static void deleteContatto(List<Contatto> contatti, Scanner s) {
        System.out.println();

        for(Contatto c : contatti) {
            System.out.println(c);
        }

        System.out.print("\nInserisci l'id del contatto che vuoi eliminare: ");
        String str = s.next();

        Contatto contatto = null;
        for(Contatto c : contatti) {
            if(c.getId() == Integer.parseInt(str)) {
                contatto = c;
            }
        }

        while(true){
            System.out.print("\nSei sicuro di voler eliminare il contatto? (Si/No): ");
            String confirm = s.next();

            if(confirm.equalsIgnoreCase("si")) {
                JPACriteriaManager.deleteDB(contatto.getId());
                break;
            } else if(confirm.equalsIgnoreCase("no")) {
                break;
            }
        }
    }

    public static boolean areEqual(Contatto cont1, Contatto cont2) {
        boolean res = cont1.getNome().equals(cont2.getNome()) && cont1.getCognome().equals(cont2.getCognome()) &&
                      cont1.getTelefono().equals(cont2.getTelefono()) && cont1.getEmail().equals(cont2.getEmail()) &&
                      cont1.getNote().equals(cont2.getNote());
        return res;
    }

    public static List<Contatto> findDuplicati(List<Contatto> contatti) {

        Contatto contattoDup = null;
        List<Contatto> contattiDup = new ArrayList<>();

        for(Contatto c : contatti){
            for(Contatto c1 : contatti) {
                if(c.getId() != c1.getId()) {
                    if(areEqual(c, c1)) {
                        contattoDup = c1;
                        if(contattiDup.size() == 0) {
                            contattiDup.add(contattoDup);
                        } else if(areEqual(contattoDup, contattiDup.get(0))) {
                            contattiDup.add(contattoDup);
                        }
                    }
                }
            }
        }

        if(contattiDup.size() > 0) {
            System.out.println("Contatti duplicati: ");
            for(Contatto c : contattiDup) {
                System.out.println(c);
            }
        } else {
            System.out.println("Non sono presenti contatti duplicati.");
        }
        return contattiDup;
    }

    public static void mergeDuplicati(List<Contatto> contatti, Scanner s) {
        List<Contatto> contattiDup = findDuplicati(contatti);

        if(contattiDup.size() > 0) {
            while(true) {
                System.out.print("\nVuoi unire i contatti duplicati? Digitare \"si\" o \"no\": ");
                String confirm = s.next();

                if(confirm.equalsIgnoreCase("si")) {
                    while(contattiDup.size() > 1) {
                        JPACriteriaManager.deleteDB(contattiDup.get(0).getId());
                        contattiDup.remove(0);
                    }
                    break;
                } else if(confirm.equalsIgnoreCase("no")) {
                    System.out.println("\nContatti duplicati non uniti");
                    break;
                }
            }
        }
    }

    public static void exportDB(List<Contatto> contatti, Scanner s) {
        String extension = extensionFile(s);
        while(true){
            System.out.print("\nInserisci il path del file dove vuoi esportare il database: ");
            String str = s.next();
            if(extension.equals("csv")) {
                String separator = null;
                System.out.print("\nInserisci il separatore: ");
                separator = s.next();
                try {
                    CSVManager.writeRubricaCSV(contatti, str, separator);
                    System.out.println("Operazione conclusa");
                    break;
                } catch (IOException ioEx) {
                    System.out.println("Inserisci un path valido.");
                }
            } else if(extension.equals("xml")) {
                try {
                    XMLManager.writeRubricaXML(contatti, str);
                    System.out.println("Operazione conclusa");
                    break;
                } catch(TransformerConfigurationException tcEx) {
                    System.out.println("Inserisci un path valido.");
                } catch(ParserConfigurationException pcEx) {
                    System.out.println("Inserisci un path valido.");
                } catch(TransformerException tEx) {
                    System.out.println("Inserisci un path valido.");
                }
            }
        }

    }

    public static void importDB(Scanner s) {
        String typeFile = extensionFile(s);
        while(true){
            System.out.print("\nInserisci il path del file da dove vuoi importare i dati per il database: ");
            String str = s.next();
            if(typeFile.equals("csv")) {
                System.out.print("\nInserisci il separatore: ");
                String separator = s.next();
                boolean virgolette = false;
                while(true){
                    System.out.print("\nIl file usa le virgolette? (Si/No) ");
                    String r = s.next();
                    if(r.equalsIgnoreCase("si")) {
                        virgolette = true;
                        break;
                    } else if(r.equalsIgnoreCase("no")) {
                        break;
                    } else {
                        System.out.print("Inserisci un input valido.");
                    }
                }
                try {
                    JPACriteriaManager.importFromCSV(str, separator, virgolette);
                    System.out.println("Operazione conclusa");
                    break;
                } catch (IOException ioEx) {
                    System.out.println("Inserisci un path valido.");
                }
            } else if(typeFile.equals("xml")) {
                try {
                    JPACriteriaManager.importFromXML(str);
                    System.out.println("Operazione conclusa");
                    break;
                } catch(IOException ioEx) {
                    System.out.println("Inserisci un path valido.");
                } catch(ParserConfigurationException pcEx) {
                    System.out.println("Inserisci un path valido.");
                } catch(SAXException saxEx) {
                    System.out.println("Inserisci un path valido.");
                }
            }
        }
    }

    public static String extensionFile(Scanner s) {
        String str = null;

        while(true){
            System.out.print("\nImport/export su file csv o xml? Digitare \"csv\" o \"xml\" a seconda della scelta ");
            str = s.next();
            if(str.equalsIgnoreCase("csv")) {
                str = "csv";
                break;
            } else if(str.equalsIgnoreCase("xml")) {
                str = "xml";
                break;
            } else {
                System.out.print("Inserisci un tipo di file corretto.");
            }
        }
        return str;
    }

    public static void gestioneRubrica() {
        Scanner s = new Scanner(System.in);
        List<Contatto> contatti = null;
        printMenu();
        String st = s.next();
        while (!st.equalsIgnoreCase("esci")) {
            st = st.toLowerCase();
            switch(st) {
                case "stampa":
                    System.out.print("\nVuoi ordinarli per nome o per cognome? A seconda della decisione digitare: \"no\", \"nome\", \"cognome\" : ");
                    String str = s.next();
                    switch (str){
                        case "no":
                            contatti = JPACriteriaManager.getRubrica();
                            printRubrica(contatti);
                            break;
                        case "nome":
                            contatti = JPACriteriaManager.getOrderedRubrica("nome");
                            printRubrica(contatti);
                            break;
                        case "cognome":
                            contatti = JPACriteriaManager.getOrderedRubrica("cognome");
                            printRubrica(contatti);
                            break;
                        default:
                            System.out.println("Inserisci un input valido. ");
                            break;
                    }
                    break;
                case "cerca":
                    contatti = JPACriteriaManager.getRubrica();
                    findContatto(contatti, s);
                    break;
                case "inserisci":
                    insertContatto(s);
                    break;
                case "modifica":
                    contatti = JPACriteriaManager.getRubrica();
                    updateContatto(contatti, s);
                    break;
                case "elimina":
                    contatti = JPACriteriaManager.getRubrica();
                    deleteContatto(contatti, s);
                    break;
                case "duplicati":
                    contatti = JPACriteriaManager.getRubrica();
                    findDuplicati(contatti);
                    break;
                case "unisci":
                    contatti = JPACriteriaManager.getRubrica();
                    mergeDuplicati(contatti, s);
                    break;
                case "esporta":
                    contatti = JPACriteriaManager.getRubrica();
                    exportDB(contatti, s);
                    break;
                case "importa":
                    importDB(s);
                    break;
                default:
                    System.out.println("\n Scrivi un input valido.");
            }
            System.out.println("\n");
            printMenu();
            st = s.next();
        }
        s.close();
    }


}
