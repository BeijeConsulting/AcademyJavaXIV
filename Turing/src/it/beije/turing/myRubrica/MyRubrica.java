package it.beije.turing.myRubrica;

import it.beije.turing.myRubrica.db.SQLManager;
import it.beije.turing.myRubrica.interfaces.OpRubrica;
import it.beije.turing.myRubrica.interfaces.Order;
import it.beije.turing.rubrica.Contatto;

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
        OpRubrica rubrica= new SQLManager();
        List<Contatto> l = null;

        Scanner scanner=new Scanner(System.in);
        boolean repeat=true;
        do{
            System.out.print ("GESTIONE RUBRICA");

            System.out.println(" (-h per la lista delle operazioni)");
            System.out.print("Inserisci OP: ");

            String chose= scanner.nextLine();
            if(chose.equalsIgnoreCase("-h") || chose.equalsIgnoreCase("-help")){
                System.out.println("\tshow <params> = [-N= ordinati per nome -S= ordinati per cognome] per visualizzare tutti i contatti ");
                System.out.println("\tsearch <parola> = [parola = parola da cercare] cerca la parola all' interno di tutti i campi nel DB");
                System.out.println("\tdelete <ID> = [ID = id del contatto] id del contatto da cancellare");
                System.out.println("\tinsert = comando per inserire il contatto da cancellare");
                System.out.println("\tmod <ID> = [ID = id del contatto] id del contatto da modificare");
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
                    System.out.println(stringBuilder);
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

    private static void print(List<Contatto> listContact) {
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
