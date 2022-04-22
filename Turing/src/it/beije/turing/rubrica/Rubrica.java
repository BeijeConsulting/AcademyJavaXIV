package it.beije.turing.rubrica;
import it.beije.turing.db.JPACriteria;

import java.util.*;

public class Rubrica {

    List<Contatto> contacts = new ArrayList<>();

    public Rubrica() {
        Start();
    }

    private void Start () {
        Scanner sc= new Scanner(System.in);

        String choose;

        boolean again = true;


        System.out.println("Avvio Rubrica, si prega di inserire operazione da effettuare: ");
        JPACriteria.openSession();

        do {
            System.out.println("1 - Tutti i contatti");
            System.out.println("2 - Ordina per nome o cognome");
            System.out.println("3 - Ricerca contatto");
            System.out.println("4 - Aggiungi contatto");
            System.out.println("5 - Elimina contatto");
            System.out.println("6 - Modifica contatto");
            System.out.println("7 - Gestisci duplicati");
            System.out.println("8 - Importa");
            System.out.println("9 - Esporta");
            System.out.println("0 - Chiudi programma");

            ScannerCheck mySc=new ScannerCheck(sc, 0,8);
            ScannerCheck orderChoose2 = new ScannerCheck(sc, 1,2);
            ScannerCheck orderChoose3 = new ScannerCheck(sc, 1,3);

            choose = mySc.check();


            switch (Integer.parseInt(choose)) {
                case 0: {
                    System.out.println("Chiudi programma");
                    again = false;
                    JPACriteria.closeSession();
                    break;
                }
                case 1: {
                    JPACriteria.loadRubica();
                    break;
                }
                case 2: {
                    System.out.println("Inserire 1 per ordinare per nome, 2 per cognome: ");
                    int sort= Integer.parseInt(orderChoose2.check());
                    JPACriteria.sortRubrica(sort);
                    break;
                }
                case 3: {
                    System.out.println("Inserire 1 per ricercare per id, 2 per nome, 3 per cognome: ");
                    int case3_choose= Integer.parseInt(orderChoose3.check());

                    JPACriteria.searchRubrica(case3_choose);
                    break;
                }
                case 4: {
                    JPACriteria.insertRubrica();
                    break;
                }
                case 5: {
                    JPACriteria.delateRubrica();
                    break;
                }
                case 6: {
                    JPACriteria.modifyRubrica();
                    break;
                }
                case 7: {
                    System.out.println("Inserire 1 per trovare duplicati, 2 per eliminarli ");
                    int case7_choose= Integer.parseInt(orderChoose2.check());
                    JPACriteria.manageDuplicate(case7_choose);
                    break;
                }
                case 8: {
                    break;
                }
                case 9: {
                    break;
                }
            }
        } while (again);

    }
}
