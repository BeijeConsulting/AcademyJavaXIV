package it.beije.turing.ContactsManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainManager {

    public static void mainSwitch(String[] args) {
        boolean endProgram = false;
        Scanner scan = new Scanner(System.in);
        Connection connection = null;
        Statement statement = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();

            while (!endProgram) {
                mainInterface();
                System.out.println("Enter the number of the desired option: ");
                switch (ScannerSwitch.scanner(scan)) {
                    case 1:
                        ContactDBManager.showContactList(statement, scan);
                        break;
                    case 2:
                        ContactDBManager.searchContact(statement, scan);
                        break;
                    case 3:
                        ContactDBManager.addNewContact(connection, scan);
                        break;
                    case 4:
                        ContactDBManager.editContacts(statement, scan);
                        break;
                    default:
                        System.out.println("Program ended. ");
                        endProgram = true;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
                connection.close();
                scan.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void mainInterface() {
        System.out.println("Case 1: Show Contacts");
        System.out.println("Case 2: Search Contact/s");
        System.out.println("Case 3: Create new Contact");
        System.out.println("Case 4: Modify a Contact");
        System.out.println("Press any other number to close the program.");
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/turing?serverTimezone=CET", "root", "56Bg-P1ae-9xnM");
    }
}
