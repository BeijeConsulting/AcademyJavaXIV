package it.beije.turing.db;

import java.io.IOException;
//import java.io.IOException;
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

public class GestRubrica {

    public static void stampaMenu() {
        System.out.print("\n\n<<<Menu Rubrica>>>\n");
        System.out.println("1- Stampa contatti (print)");
        System.out.println("2- Cerca contatto (find)");
        System.out.println("3- Inserisci nuovo contatto (insert)");
        System.out.println("4- Modifica contatto (modify)");
        System.out.println("5- Cancella contatto (delete)");
        System.out.println("6- Trova contatti duplicati (findDup)");
        System.out.println("7- Unisci contatti duplicati (mergeDup)");
        System.out.println("8- Export Database (export)");
        System.out.println("9- Import to Database (import)");
        System.out.println("10- Esci dal gestore della rubrica (exit)");
        System.out.print("Scrivi la parola tra parentesi per la funzione che vuoi avviare sulla rubrica inserita: ");
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

    public static void stampaRubrica(List<Contatto> contatti, Scanner s) {
        //Scanner s = new Scanner(System.in);
        List<Contatto> contattiSupport = null;
        int x = 0;

        do {
            System.out.print("\nVuoi ordinarli per nome o per cognome? (no, nome, cognome) : ");
            String str = s.next();
            if(str.equalsIgnoreCase("no")) {
                x++;
            } else if(str.equalsIgnoreCase("nome")) {
                String[] array = new String[contatti.size()];
                int j = 0;

                for(Contatto contatto : contatti) {
                    array[j] = contatto.getNome();
                    j++;
                }
                Arrays.sort(array);
                contattiSupport = new ArrayList<Contatto>();
                for(String nome : array) {
                    for(Contatto contatto : contatti) {
                        if(nome.equals(contatto.getNome())) contattiSupport.add(contatto);
                    }
                }
                contatti = contattiSupport;
                System.out.println("Rubrica ordinata per nome ->");
                x++;
            } else if(str.equalsIgnoreCase("cognome")) {
                String[] array = new String[contatti.size()];
                int j = 0;

                for(Contatto contatto : contatti) {
                    array[j] = contatto.getCognome();
                    j++;
                }
                Arrays.sort(array);
                contattiSupport = new ArrayList<Contatto>();
                for(String cognome : array) {
                    for(Contatto contatto : contatti) {
                        if(cognome.equals(contatto.getCognome())) contattiSupport.add(contatto);
                    }
                }
                contatti = contattiSupport;
                System.out.println("Rubrica ordinata per cognome ->");
                x++;
            } else {
                System.out.println("Inserisci un input valido. ");
            }
        } while(x == 0);

        for(Contatto c : contatti) {
            System.out.println(c);
        }
    }

    public static void trovaContatto(List<Contatto> contatti, Scanner s) {
        String nome = "";
        String cognome = "";
        List<Contatto> contattiTrovati = new ArrayList<Contatto>();

        System.out.print("\nInserisci nome del contatto che vuoi cercare: ");
        nome = s.next();
        System.out.print("Inserisci cognome del contatto che vuoi cercare: ");
        cognome = s.next();

        for(Contatto contatto : contatti) {
            if(nome.equals(contatto.getNome()) && cognome.equals(contatto.getCognome())) {
                contattiTrovati.add(contatto);
            }
        }

        if(contattiTrovati.size() == 1) {
            System.out.print("Contatto trovato -> ");
            for(Contatto c : contattiTrovati) {
                System.out.print(c);
            }
        } else if(contattiTrovati.size() > 1){
            System.out.print("Contatti trovati -> ");
            for(Contatto c : contattiTrovati) {
                System.out.println(c);
            }
        } else {
            System.out.print("Nessun " + nome +" "+ cognome +" e' stato trovato in rubrica.");
        }
    }

    public static Scanner inserisciContatto(Scanner s) {
        Contatto contatto = new Contatto();
        List<Contatto> contatti = new ArrayList<>();
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

        contatti.add(contatto);

//		if(typeFile.equalsIgnoreCase("csv")) {
//			CSVmanager.writeRubricaCSV(contatti, path, typeFile);
//		} else {
//			XMLmanager.writeRubricaXML(contatti, path);
//		}

        MyHBManager.saveIntoDB(contatti);

        System.out.println("Contatto inserito -> " + contatto);
        return s;
    }

    public static Scanner modificaContatto(List<Contatto> contatti, Scanner s) {
        String str = "";

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

        MyHBManager.updateDB(contatto, contatto.getId());
        return s;
    }

    public static void eliminaContatto(List<Contatto> contatti, Scanner s) {
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
                MyHBManager.deleteDB(contatto.getId());
                x++;
            } else if(confirm.equals("no")) {
                x++;
            }
        } while(x == 0);
    }

    public static boolean areEqual(Contatto c, Contatto c1) {
        return c.getNome().equals(c1.getNome()) && c.getCognome().equals(c1.getCognome()) && c.getTelefono().equals(c1.getTelefono()) && c.getEmail().equals(c1.getEmail()) && c.getNote().equals(c1.getNote());
    }

    public static List<Contatto> trovaContattiDuplicati(List<Contatto> contatti) {

        Contatto contattoDup = null;
        List<Contatto> contattiDup = new ArrayList<Contatto>();

        for(Contatto c : contatti) {
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
            System.out.println("Nessun contatto e' stato duplicato.");
        }

        return contattiDup;
    }

    public static void unisciContattiDuplicati(List<Contatto> contatti, Scanner s) {
        List<Contatto> contattiDup = trovaContattiDuplicati(contatti);

        if(contattiDup.size() > 0) {
            int x = 0;
            do {
                System.out.print("\nVuoi unire i contatti duplicati? (Si/No): ");
                String confirm = s.next().toLowerCase();

                if(confirm.equals("si")) {
                    while(contattiDup.size() > 1) {
                        MyHBManager.deleteDB(contattiDup.get(0).getId());
                        contattiDup.remove(0);
                    }
                    x++;
                } else if(confirm.equals("no")) {
                    x++;
                }
            } while(x == 0);
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
                    MyHBManager.importFromCSV(str, separator, virgolette);
                    j++;
                    System.out.println("<<Import avvenuto con successo>>");
                } catch (IOException ioEx) {
                    System.out.println("Inserisci un path valido.");
                }
            } else if(typeFile.equals("xml")) {
                try {
                    MyHBManager.importFromXML(str);
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

    public static void gestoreRubrica() {
        Scanner s = new Scanner(System.in);
        List<Contatto> contatti = null;

		/*String typeFile = "";
		int x = 0;
		do {
			System.out.print("Vuoi leggere un file csv o un file xml? ");
			typeFile = s.next();

			if(typeFile.equalsIgnoreCase("csv")) {
				x++;
			} else if(typeFile.equalsIgnoreCase("xml")) {
				x++;
			} else {
				System.out.print("Inserisci un tipo di file valido -> ");
			}
		} while(x == 0);

		String path = "";
		String separatore = "";
		boolean virgolette = false;
		int i = 0;
		do {
			System.out.print("Inserisci il path del file che vuoi leggere: ");
			path = s.next();
			if(typeFile.equalsIgnoreCase("csv")) {
				System.out.print("Inserisci il separatore utilizzato: ");
				separatore = s.next();
				System.out.print("Nel file sono state utilizzate le virgolette per scrivere i singoli campi? (input: Si/No) ");
				String v = s.next();
				if(v.equalsIgnoreCase("si")) {
					virgolette = true;
				}
			}

			if(typeFile.equalsIgnoreCase("csv")) {
				try {
					contatti = CSVmanager.loadRubricaFromCSV(path, separatore, virgolette);
					i++;
				} catch(IOException ioEx) {
					System.out.print("Inserisci dati validi -> ");
				}
			} else if(typeFile.equalsIgnoreCase("xml")) {
				try {
					contatti = XMLmanager.loadRubricaFromXML(path);
					i++;
				} catch(Exception Ex) {
					Ex.printStackTrace();
					System.out.print("Inserisci un path valido -> ");
				}
			}
		} while(i == 0);*/

        GestRubrica.stampaMenu();
        //System.out.println(contatti);

        String st = s.next();
        while (!st.equalsIgnoreCase("exit")) {
            st = st.toLowerCase();
            switch(st) {
                case "print":
                    contatti = MyHBManager.getRubrica();
                    stampaRubrica(contatti, s);
                    break;
                case "find":
                    contatti = MyHBManager.getRubrica();
                    trovaContatto(contatti, s);
                    break;
                case "insert":
                    s = inserisciContatto(s);
                    break;
                case "modify":
                    contatti = MyHBManager.getRubrica();
                    modificaContatto(contatti, s);
                    break;
                case "delete":
                    contatti = MyHBManager.getRubrica();
                    eliminaContatto(contatti, s);
                    break;
                case "finddup":
                    contatti = MyHBManager.getRubrica();
                    trovaContattiDuplicati(contatti);
                    break;
                case "mergedup":
                    contatti = MyHBManager.getRubrica();
                    unisciContattiDuplicati(contatti, s);
                    break;
                case "export":
                    contatti = MyHBManager.getRubrica();
                    exportDatabase(contatti, s);
                    break;
                case "import":
                    importDatabase(s);
                    break;
                default:
                    System.out.println("\n<<Scrivi un input valido per il gestore.>>");
            }
            GestRubrica.stampaMenu();
            st = s.next();
            if(st.equalsIgnoreCase("exit")) {
                System.out.println("\n\n<<Gestore rubrica chiuso.>>");
            }
        }
        s.close();
    }

    public static void main(String[] args) {

        gestoreRubrica();

    }

}
