package it.beije.turing.JDBCContactsManager;

import it.beije.turing.rubrica.Contatto;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactDBManager {

    public static void showContactList(Statement statement, Scanner scan) throws SQLException {
        ResultSet resultSet = null;

        System.out.println("Enter 1 for showing contacts with names in alphabetical order. ");
        System.out.println("Enter 2 for showing contacts with surnames in alphabetical order. ");
        System.out.println("Enter any other number for showing contacts as in the database. ");
        switch (ScannerSwitch.scanner(scan)) {
            case 1:
                resultSet = statement.executeQuery("SELECT * FROM rubrica ORDER BY nome ASC");
                break;
            case 2:
                resultSet = statement.executeQuery("SELECT * FROM rubrica ORDER BY cognome ASC");
                break;
            default:
                resultSet = statement.executeQuery("SELECT * FROM rubrica");
        }

        while (resultSet.next()) {
            System.out.println("Nome: " + resultSet.getString("nome"));
            System.out.println("Cognome: " + resultSet.getString("cognome"));
            System.out.println("Email: " + resultSet.getString("email"));
            System.out.println("Telefono: " + resultSet.getString("telefono"));
            System.out.println("Note: " + resultSet.getString("note"));
            System.out.println("-------------------------------");
        }

        resultSet.close();
    }

    public static void searchContact(Statement statement, Scanner scan) throws SQLException {
        ResultSet resultSet = null;

        System.out.println("Enter 1 for searching contacts by name. ");
        System.out.println("Enter 2 for searching contacts by surname. ");
        System.out.println("Enter 3 for searching contacts by email. ");
        System.out.println("Enter 4 for searching contacts by telephone number. ");
        switch (ScannerSwitch.scanner(scan)) {
            case 1:
                System.out.println("Enter the name of the contact/s you're searching: ");
                resultSet = statement.executeQuery("SELECT * FROM rubrica WHERE nome = " + "'" + scan.next() + "'");
                break;
            case 2:
                System.out.println("Enter the surname of the contact/s you're searching: ");
                resultSet = statement.executeQuery("SELECT * FROM rubrica WHERE cognome = " + "'" + scan.next() + "'");
                break;
            case 3:
                System.out.println("Enter the email of the contact you're searching: ");
                resultSet = statement.executeQuery("SELECT * FROM rubrica WHERE email = " + "'" + scan.next() + "'");
                break;
            case 4:
                System.out.println("Enter the telephone number of the contact you're searching: ");
                resultSet = statement.executeQuery("SELECT * FROM rubrica WHERE telefono = " + "'" + scan.next() + "'");
                break;
            default:
                System.out.println("Number invalid, You'll return to the main menu. ");
                return;

        }

        printContact(resultSet);
        resultSet.close();
    }

    public static void printContact(ResultSet resultSet) throws SQLException {

        while (resultSet.next()) {
            System.out.println("Id: " + resultSet.getString("id"));
            System.out.println("Nome: " + resultSet.getString("nome"));
            System.out.println("Cognome: " + resultSet.getString("cognome"));
            System.out.println("Email: " + resultSet.getString("email"));
            System.out.println("Telefono: " + resultSet.getString("telefono"));
            System.out.println("Note: " + resultSet.getString("note"));
            System.out.println("-------------------------------");
        }
    }

    public static void addNewContact(Connection connection, Scanner scan) throws SQLException {
        Contatto contatto = Contatto.inputCreaContatto();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO rubrica VALUES (null, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, contatto.getNome());
        preparedStatement.setString(2, contatto.getCognome());
        preparedStatement.setString(3, contatto.getEmail());
        preparedStatement.setString(4, contatto.getTelefono());
        preparedStatement.setString(5, contatto.getNote());
        preparedStatement.executeUpdate();
    }

    public static void editContacts(Statement statement, Scanner scan) throws SQLException {
        int id = chooseId(statement, scan);

        if (id != 0) {
            System.out.println("Enter 1 for editing a contact's name. ");
            System.out.println("Enter 2 for editing a contact's surname. ");
            System.out.println("Enter 3 for editing a contact's email. ");
            System.out.println("Enter 4 for editing a contact's telephone number. ");
            System.out.println("Enter 5 for editing a contact's note");

            switch (ScannerSwitch.scanner(scan)) {
                case 1:
                    System.out.println("Enter the new name for the contact: ");
                    statement.executeUpdate("UPDATE rubrica SET nome = " + "'" + scan.next() + "'" + "WHERE id = " + id);
                    break;
                case 2:
                    System.out.println("Enter the new surname for the contact: ");
                    statement.executeUpdate("UPDATE rubrica SET cognome = " + "'" + scan.next() + "'" + "WHERE id = " + id);
                    break;
                case 3:
                    System.out.println("Enter the new email for the contact: ");
                    statement.executeUpdate("UPDATE rubrica SET email = " + "'" + scan.next() + "'" + "WHERE id = " + id);
                    break;
                case 4:
                    System.out.println("Enter the new telephone number for the contact: ");
                    statement.executeUpdate("UPDATE rubrica SET telefono = " + "'" + scan.next() + "'" + "WHERE id = " + id);
                    break;
                case 5:
                    System.out.println("Enter the new note for the contact: ");
                    statement.executeUpdate("UPDATE rubrica SET note = " + "'" + scan.next() + "'" + "WHERE id = " + id);
                    break;
                default:
                    break;

            }
        }
    }

    public static int chooseId(Statement statement, Scanner scan) throws SQLException {
        ArrayList<Integer> id = new ArrayList<>();
        id.add(0);
        boolean validId = false;
        int chooseId = 0;
        ResultSet resultSet = statement.executeQuery("SELECT id FROM rubrica");
        while (resultSet.next()) {
            id.add(Integer.valueOf(resultSet.getString("id")));
        }
        if (id.size() != 1) {
            resultSet = statement.executeQuery("SELECT * FROM rubrica");
            printContact(resultSet);

            do {
                System.out.println("Enter the id of the contact you want to modify/delete (Enter 0 to return to the main menu): ");
                if (scan.hasNextInt()) {
                    chooseId = scan.nextInt();
                    for (Integer i : id) {
                        if (chooseId == i) {
                            validId = true;
                        }
                    }
                } else {
                    System.out.println("Invalid input. ");
                }
            } while (!validId);
        } else {
            System.out.println("The database is empty, add a contact before you can delete it.");
        }

        return chooseId;
    }

    public static void deleteContact(Statement statement, Scanner scan) throws SQLException {
        int id = chooseId(statement, scan);
        if (id != 0) {
            statement.executeUpdate("DELETE FROM rubrica WHERE id = " + id);
            System.out.println("Contact deleted. ");
        }
    }

    public static void findDuplicateContact() {

    }

}
