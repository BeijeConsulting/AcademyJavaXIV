package it.beije.turing.myRubrica;

import it.beije.turing.myRubrica.db.HibernateManager;
import it.beije.turing.myRubrica.db.JPAManager;
import it.beije.turing.myRubrica.db.SQLManager;
import it.beije.turing.myRubrica.interfaces.OpRubrica;
import it.beije.turing.myRubrica.interfaces.Order;
import it.beije.turing.rubrica.Contatto;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
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

        Scanner scanner=new Scanner(System.in);
        boolean repeat=true;
        do{
            System.out.print ("GESTIONE RUBRICA");
            System.out.println(" (-h per la lista delle operazioni)");
            System.out.print("Inserisci OP: ");

            String chose= scanner.nextLine();
            if(chose.equalsIgnoreCase("-h") || chose.equalsIgnoreCase("-help")){
                System.out.println("\tshow <params> = [(Opzionale) -N= ordinati per nome -S= ordinati per cognome] per visualizzare tutti i contatti ");
                System.out.println("\tsearch <parola> = [parola = parola da cercare] cerca la parola all' interno di tutti i campi nel DB");
                System.out.println("\tdelete <ID> = [ID = id del contatto] id del contatto da cancellare");
                System.out.println("\tinsert = comando per inserire il contatto da cancellare");
                System.out.println("\tmod <ID> = [ID = id del contatto] id del contatto da modificare");
                System.out.println("\tduplicate <PARAMS>= [(Opzionale) PARAMS= -U per unirli -UA per unirli automaticamente] id del contatto da modificare");
                System.out.println("\timport <TYPEFILE> <PATH> =  [TYPEFILE = CSV per il formato .csv XML per il  formato .xml] formato file da importare " +
                        "\n\t\t\t\t\t\t\t\t[PATH=indirizzo del file da importare] ");
                System.out.println("\texport <TYPEFILE> <PATH> =  [TYPEFILE = CSV per il formato .csv XML per il  formato .xml] formato file da salvare " +
                        "\n\t\t\t\t\t\t\t\t[PATH=indirizzo del file da salvare] ");
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
            ///Users/giusepperaddato/Codici/Java/SpringExample/Getting Started Guides/AcademyJavaXIV/Turing/src/main/resources/file/xml/test_parser1.xml
            ///Users/giusepperaddato/Codici/Java/SpringExample/Getting Started Guides/AcademyJavaXIV/Turing/src/main/resources/file/csv/rubrica.csv

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
