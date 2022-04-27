package it.beije.turing.JDBCContactsManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainManager {

    public static void mainSwitch(String[] args) {
        boolean endProgram = false;
            while (!endProgram) {
                mainInterface();
                System.out.println("Enter the number of the desired option: ");
                switch (ScannerSwitch.scanner(scan)) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

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
        System.out.println("Press any other number to close the program.");
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/turing?serverTimezone=CET", "root", "56Bg-P1ae-9xnM");
    }
}