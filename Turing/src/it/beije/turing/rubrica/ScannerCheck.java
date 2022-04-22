package it.beije.turing.rubrica;

import java.util.Scanner;

public class ScannerCheck {

    Scanner scanner = null;
    int first;
    int last;
    boolean again = false;

    public ScannerCheck(Scanner scanner, int first, int last) {
        this.scanner = scanner;
        this.first = first;
        this.last = last;
    }


    public String check() {
        String choose = null;

        do {
            if (scanner.hasNext()) choose = scanner.next();

            repeatChose(choose);
        } while (again);

        return choose;
    }

    private void repeatChose(String choose) {
        try {
            Integer.parseInt(choose);
            while ((Integer.parseInt(choose) < first || Integer.parseInt(choose) > last)) {
                System.out.println("Scelta effettuata: " + "non corrisponde al range: " + first + " " + last);
                choose = scanner.next();
                again = false;
            }

        } catch (IllegalArgumentException nfEx) {
            System.out.println("Si prega di inserire un numero");
            again = true;

        }

    }

    public static int checkNumber(String choose) {
        try {
            int numb = Integer.parseInt(choose);
            return numb;

        } catch (IllegalArgumentException nfEx) {
            System.out.println("Si prega di inserire un numero");
            return -1;
        }
    }
}