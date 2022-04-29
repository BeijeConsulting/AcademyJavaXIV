package it.beije.turing.myRubrica;

import it.beije.turing.myRubrica.db.HibernateManager;
import it.beije.turing.myRubrica.db.JPAManager;
import it.beije.turing.myRubrica.db.SQLManager;
import it.beije.turing.myRubrica.interfaces.OpRubrica;
import it.beije.turing.myRubrica.interfaces.Order;
import it.beije.turing.rubrica.Contatto;


import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Scanner;

/**
 * @author Giuseppe Raddato
 * Data: 19 apr 2022
 */
public class MyRubrica {

    public static void main(String[] args) {
        OpRubrica rubrica= new JPAManager();
        List<Contatto> l = null;

// /Users/giusepperaddato/Codici/Java/SpringExample/Getting Started Guides/AcademyJavaXIV/Turing/src/main/resources/file/csv/rubrica.csv

        Scanner scanner=new Scanner(System.in);
        boolean repeat=true;
        do{
            System.out.print ("\n\nGESTIONE RUBRICA");
            System.out.println(" (-h per la lista delle operazioni)");
            System.out.print("Inserisci OP: ");

            String chose= scanner.nextLine();
            if(chose.equalsIgnoreCase("-h") || chose.equalsIgnoreCase("-help")){
                System.out.println("\tshow <params> = [(Opzionale) -N= ordinati per nome -S= ordinati per cognome] per visualizzare tutti i contatti ");
                System.out.println("\tdelete <ID> = [ID = id del contatto] id del contatto da cancellare");
                System.out.println("\tinsert = comando per inserire il contatto da cancellare");
                System.out.println("\tmod <ID> = [ID = id del contatto] id del contatto da modificare");
                System.out.println("\tsearch <parola> = [parola = parola da cercare] cerca la parola all' interno di tutti i campi nel DB");
                System.out.println("\tduplicate = mostra duplicati");
                System.out.println("\tduplicate <PARAMS>= [(Opzionale) -UA per unirli automaticamente] unisci contatti duplicati");
                System.out.println("\timport <TYPEFILE> =  [TYPEFILE = CSV per il formato .csv XML per il  formato .xml] formato file da importare");
                System.out.println("\texport <TYPEFILE> =  [TYPEFILE = CSV per il formato .csv XML per il  formato .xml] formato file da salvare ");

                System.out.println("\texit =Esci");
            }
            if(chose.startsWith("exit")){
                repeat=false;
            }
            if(chose.startsWith("show")){
                String[] io=chose.split(" ");
                if(io.length>2){
                    System.out.println("Parametri non validi");
                }else if(io.length==1){
                    System.out.println("NON ORDINATI ");
                    l=rubrica.showContact(Order.NO);
                    print(l);
                }else if(io.length==2){
                    if(io[1].equalsIgnoreCase("-N")){
                        System.out.println("ORDINATI PER NOME");
                        l=rubrica.showContact(Order.NOME);
                        print(l);
                    }
                    if(io[1].equalsIgnoreCase("-S")){
                        System.out.println("ORDINATI PER COGNOME");
                        l=rubrica.showContact(Order.COGNOME);
                        print(l);
                    }
                }
            }
            if(chose.startsWith("search")){
                String[] io=chose.split(" ");
                if(io.length>=2){
                    StringBuilder stringBuilder= new StringBuilder(chose.substring(chose.indexOf("search")+"search".length(),chose.length()).trim());

                    print(rubrica.search(stringBuilder.toString()));
                }else{
                    errore();
                }
            }
            if(chose.startsWith("delete")){
                String[] io=chose.split(" ");
                if(io.length>=2){
                   try{
                      int id=Integer.parseInt(io[1]);
                      if(l==null){
                          l=rubrica.showContact(Order.NO);
                      }
                      boolean f=false;
                       for (Contatto temp:l) {
                           if(temp.getId()==id){
                               f=true;
                               System.out.println("Stai cancellando il contatto");
                               System.out.println(temp);
                               System.out.println("Sei sicuro di volerlo cancellare? (Y or N)");
                               String c =scanner.next();
                               if(c.equalsIgnoreCase("Y")){
                                   boolean d=rubrica.deleteContatto(temp);
                                       System.out.println("\n\nContatto Cancellato\n\n");

                               }else if(c.equalsIgnoreCase("N")){
                                   System.out.println("Operazioen Annulata");

                               }else {
                                   errore();
                               }
                               break;
                           }
                       }
                       if(!f){
                           System.err.println("ID non Trovato");
                       }

                   } catch (NumberFormatException e){
                       errore();
                   }
                }else{
                    errore();
                }
            }
            if(chose.startsWith("insert")){
                String[] io=chose.split(" ");
                if(io.length ==1){
                    Contatto c= insertContact(scanner);

                    rubrica.insert(c);
                    System.out.println("\nContatto aggiunto\n");

                }
            }
            if(chose.startsWith("mod")){


                String[] io=chose.split(" ");
                if(io.length>=2){
                    try{
                        int id=Integer.parseInt(io[1]);
                        if(l==null){
                            l=rubrica.showContact(Order.NO);
                        }
                        boolean f=false;
                        System.out.println("Premi invio se non vuoi modificare un parametro");
                        for (Contatto temp:l) {
                            if(temp.getId()==id){
                                f=true;
                                Contatto c= insertContact(scanner,temp);

                                rubrica.modificaContatto(c);
                                break;
                            }
                        }
                        if(!f){
                            System.err.println("ID non Trovato");
                        }

                    } catch (NumberFormatException e){
                        errore();
                    }
                }else{
                    errore();
                }


            }

            //test_/Users/giusepperaddato/Codici/Java/SpringExample/Getting Started Guides/AcademyJavaXIV/Turing/src/main/resources/file/xml/parser1.xml
            ///Users/giusepperaddato/Codici/Java/SpringExample/Getting Started Guides/AcademyJavaXIV/Turing/src/main/resources/file/csv/rubrica.csv
            if(chose.startsWith("export")){
                String[] io=chose.split(" ");
                if(io.length==2){
                    if((!io[1].equalsIgnoreCase("xml")) && (!io[1].equalsIgnoreCase("csv"))){
                        System.err.println("Estesione non supportata");
                    }else{
                        System.out.print("Inserisci path dove vuoi salvare il file: ");
                        String path=scanner.nextLine();
                        File f=new File(path);

                        if(!f.isDirectory()){
                           System.err.println("Hai inserito il path di un file");
                        }else {
                            System.out.print("Inserisci nome del file: ");
                            String nome=scanner.nextLine();
                            String pathTemp=path+"/"+nome+"."+io[1].toLowerCase();
                            f=new File(pathTemp);
                            if( f.exists()){
                                System.out.println("\nEsiste un file con il nome: "+nome+"."+io[1].toLowerCase()+" in questa catella ");
                                System.out.print("Vuoi sovrascrivere il file? (Y/N): ");
                                String c=scanner.nextLine();
                                if(c.equalsIgnoreCase("N")){
                                    pathTemp=path+"/"+nome+"(copia)."+io[1].toLowerCase();
                                }
                            }
                            if(io[1].equalsIgnoreCase("xml")){
                                OpRubrica.exportFileXML(pathTemp,rubrica.showContact(Order.NO));
                                if(new File(pathTemp).exists()){
                                    System.out.println("\nFile Creato\n");
                                }else{
                                    System.err.println("\nQualcosa è andato storto riporva\n");
                                }
                            }  else if(io[1].equalsIgnoreCase("csv")){
                                System.out.print("Quale separatore vuoi utilizzare: ");
                                String s;
                                do{
                                    s=scanner.nextLine();
                                    if(s.length()!=1){
                                        System.out.println("Il separatore può essere solo un carattere di lunghezza massima di 1");
                                    }
                                }while (s.length()!=1);
                                OpRubrica.exportFileCVS(pathTemp,rubrica.showContact(Order.NO),s);

                                if(new File(pathTemp).exists()){
                                    System.out.println("\nFile Creato\n");
                                }else{
                                    System.err.println("\nQualcosa è andato storto riporva\n");
                                }
                            }else {
                                System.err.println("Errore");
                            }
                        }

                    }
                }
            }
            if(chose.startsWith("import")){
                String[] io=chose.split(" ");
                    if(io.length==2){
                        if((!io[1].equalsIgnoreCase("xml")) && (!io[1].equalsIgnoreCase("csv"))){
                            System.err.println("Estesione non supportata");
                        }else{
                            System.out.print("Inserisci path: ");
                            String path=scanner.nextLine();
                            File f=new File(path);
                            if(f.isFile() && f.exists()){
                                if(io[1].equalsIgnoreCase("xml")){
                                    List<Contatto> p = rubrica.importFromXML(path);
                                    System.out.println("\nSono stati aggiunti: "+p.size()+" contatti\n");
                                }else if(io[1].equalsIgnoreCase("csv")){
                                    System.out.print("Inserisci il carattere di  separazione :");
                                    String separator=scanner.next();
                                    List<Contatto> p = rubrica.importFromCVS(path, separator);
                                    System.out.println("\nSono stati aggiunti: "+p.size()+" contatti\n");
                                }
                            }else {
                                System.err.println("File non trovato");
                            }
                        }

                    }else {
                        System.err.println("Comando non vavlido");
                    }
            }
            if(chose.startsWith("duplicate")){
                String[] io=chose.split(" ");
                if(io.length>=2){
                    System.out.println(io[1]);
                    if(io[1].equalsIgnoreCase("-UA")){
                       rubrica.unisciContatti(rubrica.contattiDuplicati());
                       System.out.println("Contatti uniti");
                    }

                } else if(io.length==1){
                    List<List <Contatto>> de= rubrica.contattiDuplicati();
                    for (int i = 0; i < de.size(); i++) {
                        print(de.get(i));
                    }
                    System.out.println(de.size());
                }
            }


        }while (repeat);

        scanner.close();
        System.out.println("A presto!!!");

    }
    private static Contatto insertContact(Scanner scanner) {
        Contatto c = new Contatto();
        return insertContact(scanner,c);
    }


    private static Contatto insertContact(Scanner scanner, Contatto c) {
        for (Method me:c.getClass().getDeclaredMethods()) {
            if(me.getName().startsWith("set")&& !me.getName().equalsIgnoreCase("setid")){
                System.out.print("Inserisci "+me.getName().substring(3,me.getName().length())+"= ");
                String t=scanner.nextLine();
                if(!t.isEmpty()){
                    try {
                        me.invoke(c,t) ;
                    } catch (IllegalAccessException e) {
                        errore();
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        errore();
                        e.printStackTrace();
                    }
                }
            }
        }
        return c;
    }

    private static void errore() {
        System.err.println("Errore ripeti");
    }

    public static void print(List<Contatto> listContact) {
        if(!listContact.isEmpty()) {
            System.out.println("=============================================================================================================================================================================");
            System.out.printf("| %10s | %30s | %30s | %35s | %15s | %30s |\n", "ID", "NOME", "COGNOME", "EMAIL", "TELEFONO", "NOTE");
            System.out.println("=============================================================================================================================================================================");
            for (Contatto c : listContact) {
                System.out.printf("| %10s | %30s | %30s | %35s | %15s | %30s |\n", c.getId(), c.getNome(), c.getCognome(), c.getEmail(), c.getTelefono(), c.getNote());
            }
            System.out.println("=============================================================================================================================================================================");
        }else {
            System.out.println("Lista Vuota");
        }
    }
}