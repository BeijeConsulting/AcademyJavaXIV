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

public class GestoreRubricaJPA {

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

    public static void printRubrica(List<Contatto> contatti, Scanner s) {
        //Scanner s = new Scanner(System.in);
        List<Contatto> contatti2 = null;
        int x=0;

        do {
            System.out.print("\nVuoi ordinarli per nome o per cognome? A seconda della decisione digitare: \"no\", \"nome\", \"cognome\") : ");
            String str = s.next();
            switch (str){
                case "no":
                    x++;
                    break;
                case "nome":
                    String[] array = new String[contatti.size()];
                    int i = 0;

                    for(Contatto contatto : contatti) {
                        array[i] = contatto.getNome();
                        i++;
                    }
                    Arrays.sort(array);
                    contatti2 = new ArrayList<Contatto>();
                    for(String nome : array) {
                        for(Contatto contatto : contatti) {
                            if(nome.equals(contatto.getNome())) contatti2.add(contatto);
                        }
                    }
                    contatti = contatti2;
                    x++;
                    System.out.println("Filtro: nome ->");
                    break;
                case "cognome":
                    String[] array1 = new String[contatti.size()];
                    int j = 0;

                    for(Contatto contatto : contatti) {
                        array1[j] = contatto.getCognome();
                        j++;
                    }
                    Arrays.sort(array1);
                    contatti2 = new ArrayList<Contatto>();
                    for(String cognome : array1) {
                        for(Contatto contatto : contatti) {
                            if(cognome.equals(contatto.getCognome())) contatti2.add(contatto);
                        }
                    }
                    contatti = contatti2;
                    System.out.println("Filtro: cognome ->");
                    x++;
                    break;
                default:
                    System.out.println("Inserisci un input valido. ");
                    break;
            }
        } while(x==0);
        for(Contatto c : contatti) {
            System.out.println(c);
        }
    }

    public static void findContatto(List<Contatto> contatti, Scanner s) {
        String nome = "";
        String cognome = "";
        List<Contatto> contattiMatch = new ArrayList<Contatto>();

        System.out.print("\nInserisci il nome del contatto desiderato: ");
        nome = s.next();
        System.out.print("\nInserisci il cognome del contatto desiderato: ");
        cognome = s.next();

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
            System.out.print(nome +" "+ cognome +" non è presente in rubrica.");
        }
    }

    public static Scanner insertContatto(Scanner s) {
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

        JPACriteriaManager.insertContatto(contatti);
        return s;
    }

    public static Scanner updateContatto(List<Contatto> contatti, Scanner s) {
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
        return s;
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

        int x = 0;
        do {
            System.out.print("\nSei sicuro di voler eliminare il contatto? (Si/No): ");
            String confirm = s.next().toLowerCase();

            if(confirm.equals("si")) {
                JPACriteriaManager.deleteDB(contatto.getId());
                x++;
            } else if(confirm.equals("no")) {
                x++;
            }
        } while(x == 0);
    }

    public static boolean areEqual(Contatto c, Contatto c1) {
        return c.getNome().equals(c1.getNome()) && c.getCognome().equals(c1.getCognome()) && c.getTelefono().equals(c1.getTelefono()) && c.getEmail().equals(c1.getEmail()) && c.getNote().equals(c1.getNote());
    }

    public static List<Contatto> findDuplicati(List<Contatto> contatti) {

        Contatto contattoDup = null;
        List<Contatto> contattiDup = new ArrayList<Contatto>();

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
            do {
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
            } while(true);
        }
    }

    public static void exportDatabase(List<Contatto> contatti, Scanner s) {
        String str = null;
        String typeFile = sceltaFile(s);

        int j = 0;
        do {
            System.out.print("\nInserisci il path del file dove vuoi esportare il database: ");
            str = s.next();
            if(typeFile.equals("csv")) {
                String separator = null;
                System.out.print("\nInserisci il separatore: ");
                separator = s.next();
                try {
                    CSVManager.writeRubricaCSV(contatti, str, separator);
                    j++;
                    System.out.println("<<Export avvenuto con successo>>");
                } catch (IOException ioEx) {
                    System.out.println("Inserisci un path valido.");
                }
            } else if(typeFile.equals("xml")) {
                try {
                    XMLManager.writeRubricaXML(contatti, str);
                    j++;
                    System.out.println("<<Export avvenuto con successo>>");
                } catch(TransformerConfigurationException tcEx) {
                    System.out.println("Inserisci un path valido.");
                } catch(ParserConfigurationException pcEx) {
                    System.out.println("Inserisci un path valido.");
                } catch(TransformerException tEx) {
                    System.out.println("Inserisci un path valido.");
                }
            }
        } while(j == 0);

    }

    public static String sceltaFile(Scanner s) {
        String str = null;

        int x = 0;
        do {
            System.out.print("\nVuoi effettuare l'export su un file csv o xml? ");
            str = s.next();

            if(str.equalsIgnoreCase("csv")) {
                str = "csv";
                x++;
            } else if(str.equalsIgnoreCase("xml")) {
                str = "xml";
                x++;
            } else {
                System.out.print("Inserisci un tipo di file corretto.");
            }
        } while(x == 0);

        return str;
    }

    public static void importDatabase(Scanner s) {
        String typeFile = sceltaFile(s);
        String str = null;

        int j = 0;
        do {
            System.out.print("\nInserisci il path del file da dove vuoi importare i dati per il database: ");
            str = s.next();
            if(typeFile.equals("csv")) {
                System.out.print("\nInserisci il separatore: ");
                String separator = s.next();
                int y = 0;
                boolean virgolette = false;
                do {
                    System.out.print("\nIl file usa le virgolette? (Si/No) ");
                    String r = s.next();
                    if(r.equalsIgnoreCase("si")) {
                        virgolette = true;
                        y++;
                    } else if(r.equalsIgnoreCase("no")) {
                        y++;
                    } else {
                        System.out.print("Inserisci un input valido.");
                    }
                } while(y == 0);
                try {
                    JPACriteriaManager.importFromCSV(str, separator, virgolette);
                    j++;
                    System.out.println("<<Import avvenuto con successo>>");
                } catch (IOException ioEx) {
                    System.out.println("Inserisci un path valido.");
                }
            } else if(typeFile.equals("xml")) {
                try {
                    JPACriteriaManager.importFromXML(str);
                    j++;
                    System.out.println("<<Import avvenuto con successo>>");
                } catch(IOException ioEx) {
                    System.out.println("Inserisci un path valido.");
                } catch(ParserConfigurationException pcEx) {
                    System.out.println("Inserisci un path valido.");
                } catch(SAXException saxEx) {
                    System.out.println("Inserisci un path valido.");
                }
            }
        } while(j == 0);
    }

    public static void gestioneRubrica() {
        Scanner s = new Scanner(System.in);
        List<Contatto> contatti = null;

        GestoreRubricaJPA.printMenu();

        String st = s.next();
        while (!st.equalsIgnoreCase("esci")) {
            st = st.toLowerCase();
            switch(st) {
                case "stampa":
                    contatti = JPACriteriaManager.getRubrica();
                    printRubrica(contatti, s);
                    break;
                case "cerca":
                    contatti = JPACriteriaManager.getRubrica();
                    findContatto(contatti, s);
                    break;
                case "inserisci":
                    s = insertContatto(s);
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
                    exportDatabase(contatti, s);
                    break;
                case "importa":
                    importDatabase(s);
                    break;
                default:
                    System.out.println("\n<<Scrivi un input valido.>>");
            }
            System.out.println("\n");
            GestoreRubricaJPA.printMenu();
            st = s.next();
        }
        s.close();
    }

    public static void main(String[] args) {
        gestioneRubrica();

    }
}
