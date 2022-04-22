package it.beije.turing.rubrica;

import java.util.Scanner;

public class Ask {

    /*
    * Domande da fare all'utente:
    * 1) Scegli operazione da eseguire:
     *       - 1 - Import
     *              - 1 From CSV
     *              - 2 From XML
     *              - 3 From DB
     *       - 2 - Export
     *              - 1 To CSV
     *              - 2 To XML
     *              - 3 To DB
     *       - 3 - Search
     *              - 1 In CSV
     *              - 2 In XML
     *              - 2 In DB
     *       - 4 - Add
     *              - 1 To CSV
                    - 2 To XML
     *              - 3 To DB
             - 5 - Show all
     *              - 1 From CSV
     *              - 2 From XML
     *              - 3 From DB
     *                      - 1 - Update
     *                      - 2 - Delete
     *       - 5 - Show duplicate
     *              - 1 From CSV
     *              - 2 From XML
     *              - 3 From DB
     *       - 0 - Exit
     *
     * DOPO IL SEARCH
     *       - 1 - Edit
     *       - 2 - Delete
     *       - 3 - Nothing
     * DOPO IL SHOW DUPLICATE
     *       - 1 - Delete duplicate
     *       - 2 - Nothing
    * */

    public static void genericsOperation() {
        System.out.println();
        System.out.println("Choose operation number:");
        System.out.println("1 - Import");
        System.out.println("2 - Export");
        System.out.println("3 - Search");
        System.out.println("4 - Add");
        System.out.println("5 - Show all");
        System.out.println("6 - Show duplicate");
        System.out.println("0 - Exit");
    }

    public static void fromOperation() {
        System.out.println();
        System.out.println("1 - From CSV");
        System.out.println("2 - From XML");
        System.out.println("3 - From DB");
    }

    public static void inOperation() {
        System.out.println();
        System.out.println("1 - In CSV");
        System.out.println("2 - In XML");
        System.out.println("3 - In DB");
    }

    public static void toOperation() {
        System.out.println();
        System.out.println("1 - To CSV");
        System.out.println("2 - To XML");
        System.out.println("3 - To DB");
    }

/*    public static void DBOperation() {
        System.out.println("1 - With JDBC");
        System.out.println("2 - With Hibernate");
        System.out.println("3 - With JPA");
    }*/

    public static void TODOWithContactFound() {
        System.out.println();
        System.out.println("What to do with contacts found:");
        System.out.println("1 - Edit");
        System.out.println("2 - Delete");
        System.out.println("3 - Nothing");
    }

    public static void TODOWithDuplicate() {
        System.out.println();
        System.out.println("What to do with contacts found:");
        System.out.println("1 - Delete duplicate");
        System.out.println("2 - Nothing");
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
