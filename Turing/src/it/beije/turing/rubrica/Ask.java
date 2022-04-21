package it.beije.turing.rubrica;

import java.util.Scanner;

public class Ask {

    /*public static void
    * Domande da fare all'utente:
    * 1) Scegli operazione da eseguire:
     *       - 1 - Import
     *              - 1 From CSV
     *              - 2 From XML
     *              - 3 From DB
     *                      - 1 With JDBC
     *                      - 1 With Hibernate
     *                      - 1 With JPA
     *       - 2 - Export
     *              - 1 To CSV
     *              - 2 To XML
     *              - 3 To DB
     *                      - 1 With JDBC
     *                      - 1 With Hibernate
     *                      - 1 With JPA
     *       - 3 - Search
     *              - 1 In CSV
     *              - 2 In XML
     *              - 2 In DB
     *                      - 1 With JDBC
     *                      - 1 With Hibernate
     *                      - 1 With JPA
     *       - 4 - Add
     *              - 1 To CSV
                    - 2 To XML
     *              - 3 To DB
     *                      - 1 With JDBC
     *                      - 1 With Hibernate
     *                      - 1 With JPA
     *       - 0 - Exit
     * DOPO IL SEARCH
     *       - 5 - Edit
     *       - 6 - Delete

    * */

    public static void genericsOperation() {
        System.out.println("Choose operation number:");
        System.out.println("1 - Import");
        System.out.println("2 - Export");
        System.out.println("3 - Search");
        System.out.println("4 - Add");
        System.out.println("0 - Exit");
    }

    public static void importOperation() {
        System.out.println("1 - From CSV");
        System.out.println("2 - From XML");
        System.out.println("3 - From DB");
    }

    public static void exportOperation() {
        System.out.println("1 - To CSV");
        System.out.println("2 - To XML");
        System.out.println("3 - To DB");
    }

    public static void searchOperation() {
        System.out.println("1 - In CSV");
        System.out.println("2 - In XML");
        System.out.println("3 - In DB");
    }

    public static void addOperation() {
        System.out.println("1 - To CSV");
        System.out.println("2 - To XML");
        System.out.println("3 - To DB");
    }

    public static void DBOperation() {
        System.out.println("1 - With JDBC");
        System.out.println("2 - With Hibernate");
        System.out.println("3 - With JPA");
    }

    public static void TODOWithContactFound() {
        System.out.println("1 - Edit");
        System.out.println("2 - Delete");
    }

    public static Contatto newContact(Scanner scanner) {
        Contatto contact = new Contatto();

        System.out.println("Type contact name:");
        String name = scanner.next();
        System.out.println("Type contact surname:");
        String surname = scanner.next();
        System.out.println("Type contact phone number:");
        String phone = scanner.next();
        System.out.println("Type contact email:");
        String email = scanner.next();
        System.out.println("Type contact notes:");
        String notes = scanner.next();

        if (!name.equals("")) contact.setNome(name);
        if (!surname.equals("")) contact.setCognome(surname);
        if (!phone.equals("")) contact.setTelefono(phone);
        if (!email.equals("")) contact.setEmail(email);
        if (!notes.equals("")) contact.setNote(notes);

        return contact;
    }

}
