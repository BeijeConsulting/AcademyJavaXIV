package main.java.it.beije.turing.JPAContactsManager;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class MainManager {

    public static void mainSwitch(String[] args) {
        boolean endProgram = false;
        Scanner scan = new Scanner(System.in);
        EntityManagerFactorySingleton.createEntityManager();
        while (!endProgram) {
            mainInterface();
            System.out.println("Enter the number of the desired option: ");
            switch (ScannerSwitch.scanner(scan)) {
                case 1:
                    ContactDBManager.ShowContacts();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                default:
                    System.out.println("Program ended. ");
                    endProgram = true;
            }
        }
    }

    public static void mainInterface() {
        System.out.println("Case 1: Show Contacts");
        System.out.println("Case 2: Search Contact/s");
        System.out.println("Case 3: Create new Contact");
        System.out.println("Case 4: Modify a Contact");
        System.out.println("Case 5: Delete a Contact");
        System.out.println("Case 6: Find duplicate Contacts");
        System.out.println("Case 7: Combine duplicate Contacts");
        System.out.println("Press any other number to close the program.");
    }
}