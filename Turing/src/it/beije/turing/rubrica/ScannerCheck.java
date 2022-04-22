package it.beije.turing.rubrica;

import java.util.Scanner;

public class ScannerCheck {

    static Scanner scanner=null;
    static int first;
    static int last;
    static boolean again = false;

    public ScannerCheck(Scanner scanner, int first, int last) {
        this.scanner = scanner;
        this.first = first;
        this.last = last;
    }

    public static String check() {
        String choose = null;

        do {
            if (scanner.hasNext()) choose = scanner.next();
            repeatChose(choose);
        } while (again);

        return choose;
    }

    private static void repeatChose(String choose){
        try {
            while ( (Integer.parseInt(choose) < first || Integer.parseInt(choose) > last)) {
                System.out.println("Scelta effettuata: " + "non corrisponde al range: ("+ first + "-"+ last +")");
                choose = scanner.next();
            }
            again = false;
        } catch (IllegalArgumentException nfEx) {
            System.out.println("Si prega di inserire un numero");
            again = true;

        }

    }
}
