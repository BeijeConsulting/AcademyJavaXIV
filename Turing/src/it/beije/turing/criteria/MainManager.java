package it.beije.turing.criteria;

import it.beije.turing.ContactsManager.ScannerSwitch;
import it.beije.turing.db.HBsessionFactory;
import it.beije.turing.rubrica.Contatto;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Scanner;

public class MainManager {

    public static void mainSwitch(String[] args) {
        boolean endProgram = false;
        Scanner scan = new Scanner(System.in);

        Session session = HBsessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Contatto> criteriaQuery = criteriaBuilder.createQuery(Contatto.class);
        Root<Contatto> root = criteriaQuery.from(Contatto.class);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("turing");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        while (!endProgram) {
            mainInterface();
            System.out.println("Enter the number of the desired option: ");
            switch (ScannerSwitch.scanner(scan)) {
                case 1:
                    ContactDBManager.showContactList(criteriaQuery, root, session, scan, criteriaBuilder);
                    break;
                case 2:
                    ContactDBManager.searchContact(criteriaQuery, root, session, scan, criteriaBuilder);
                    break;
                case 3:
                    ContactDBManager.addNewContact(true, null, entityManager, entityTransaction);
                    break;
                case 4:
                    ContactDBManager.updateContacts(criteriaQuery, root, session, scan, criteriaBuilder);
                    break;
                case 5:
                    ContactDBManager.deleteContact(criteriaQuery, root, session, scan, criteriaBuilder, true, 0);
                    break;
                case 6:
                    ContactDBManager.findDuplicateContact(criteriaQuery, root, session, scan, criteriaBuilder);
                    break;
                case 7:
                    ContactDBManager.combineDuplicateContacts(criteriaQuery, root, session, scan, criteriaBuilder);
                    break;
                case 8:
                    ContactDBManager.importXMLorCSV(scan, entityManager, entityTransaction);
                    break;
                case 9:
                    ContactDBManager.exportXMLorCSV(criteriaQuery, root, session, scan);
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
