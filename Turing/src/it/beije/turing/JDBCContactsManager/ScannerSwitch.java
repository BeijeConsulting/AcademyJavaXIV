package it.beije.turing.JDBCContactsManager;

import java.util.Scanner;

public class ScannerSwitch {

    public static int scanner(Scanner scan) {
        boolean validInt = false;
        int choice = 0;

        do {
            if(scan.hasNextInt()) {
                choice = scan.nextInt();
                validInt = true;
            } else {
                scan.next();
                System.out.println("Invalid input. ");
            }
        } while(!validInt);

        return choice;
    }
}
