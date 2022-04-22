package it.beije.turing.criteria;

import it.beije.turing.ContactsManager.ScannerSwitch;
import it.beije.turing.db.HBsessionFactory;
import org.hibernate.Session;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Scanner;

public class MainManager {

    public static void mainSwitch(String[] args) {
        boolean endProgram = false;
        Scanner scan = new Scanner(System.in);

        Session session = HBsessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("turing");

        while (!endProgram) {
            mainInterface();
            System.out.println("Enter the number of the desired option: ");
            switch (ScannerSwitch.scanner(scan)) {
                case 1:
                    ContactDBManager.showContactList(entityManagerFactory, scan, criteriaBuilder);
                    break;
                case 2:
                    ContactDBManager.searchContact(entityManagerFactory, scan, criteriaBuilder);
                    break;
                case 3:
                    ContactDBManager.addNewContact(true, null, entityManagerFactory);
                    break;
                case 4:
                    ContactDBManager.updateContacts(entityManagerFactory, scan, criteriaBuilder);
                    break;
                case 5:
                    ContactDBManager.deleteContact(entityManagerFactory, scan, criteriaBuilder, true, 0);
                    break;
                case 6:
                    ContactDBManager.findDuplicateContact(entityManagerFactory, scan, criteriaBuilder);
                    break;
                case 7:
                    ContactDBManager.combineDuplicateContacts(entityManagerFactory, scan, criteriaBuilder);
                    break;
                case 8:
                    ContactDBManager.importXMLorCSV(scan, entityManagerFactory);
                    break;
                case 9:
                    ContactDBManager.exportXMLorCSV(entityManagerFactory, scan, criteriaBuilder);
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
        System.out.println("Case 8: Import Contacts from a XML or CSV file");
        System.out.println("Case 9: Export Contacts from a XML or CSV file");
        System.out.println("Press any other number to close the program.");
    }
}
