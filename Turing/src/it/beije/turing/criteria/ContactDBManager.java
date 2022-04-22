package it.beije.turing.criteria;

import it.beije.turing.ContactsManager.ScannerSwitch;
import it.beije.turing.file.ReadFile;
import it.beije.turing.file.WriteFile;
import it.beije.turing.rubrica.Contatto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactDBManager {

    public static void showContactList(EntityManagerFactory entityManagerFactory, Scanner scan, CriteriaBuilder criteriaBuilder) {
        CriteriaQuery<Contatto> criteriaQuery = criteriaBuilder.createQuery(Contatto.class);
        Root<Contatto> root = criteriaQuery.from(Contatto.class);
        EntityManager session = entityManagerFactory.createEntityManager();
        TypedQuery<Contatto> contattoTypedQuery = null;
        List<Contatto> results = null;

        System.out.println("Enter 1 for showing contacts with names in alphabetical order. ");
        System.out.println("Enter 2 for showing contacts with surnames in alphabetical order. ");
        System.out.println("Enter any other number for showing contacts as in the database. ");
        switch (ScannerSwitch.scanner(scan)) {
            case 1:
                criteriaQuery.orderBy(criteriaBuilder.asc(root.get("nome")));
                contattoTypedQuery = session.createQuery(criteriaQuery);
                results = contattoTypedQuery.getResultList();
                break;
            case 2:
                criteriaQuery.orderBy(criteriaBuilder.asc(root.get("cognome")));
                contattoTypedQuery = session.createQuery(criteriaQuery);
                results = contattoTypedQuery.getResultList();
                break;
            default:
                criteriaQuery.select(root);
                contattoTypedQuery = session.createQuery(criteriaQuery);
                results = contattoTypedQuery.getResultList();
        }

        for (Contatto contatto : results) {
            System.out.println(contatto.toString());
        }

        session.close();
    }

    public static void searchContact(EntityManagerFactory entityManagerFactory, Scanner scan, CriteriaBuilder criteriaBuilder) {
        CriteriaQuery<Contatto> criteriaQuery = criteriaBuilder.createQuery(Contatto.class);
        Root<Contatto> root = criteriaQuery.from(Contatto.class);
        EntityManager session = entityManagerFactory.createEntityManager();
        TypedQuery<Contatto> contattoTypedQuery = null;
        List<Contatto> results = null;

        System.out.println("Enter 1 for searching contacts by name. ");
        System.out.println("Enter 2 for searching contacts by surname. ");
        System.out.println("Enter 3 for searching contacts by email. ");
        System.out.println("Enter 4 for searching contacts by telephone number. ");
        switch (ScannerSwitch.scanner(scan)) {
            case 1:
                System.out.println("Enter the name of the contact/s you're searching: ");
                criteriaQuery.select(root).where(root.get("nome").in(scan.next()));
                contattoTypedQuery = session.createQuery(criteriaQuery);
                results = contattoTypedQuery.getResultList();
                break;
            case 2:
                System.out.println("Enter the surname of the contact/s you're searching: ");
                criteriaQuery.select(root).where(root.get("cognome").in(scan.next()));
                contattoTypedQuery = session.createQuery(criteriaQuery);
                results = contattoTypedQuery.getResultList();
                break;
            case 3:
                System.out.println("Enter the email of the contact you're searching: ");
                criteriaQuery.select(root).where(root.get("email").in(scan.next()));
                contattoTypedQuery = session.createQuery(criteriaQuery);
                results = contattoTypedQuery.getResultList();
                break;
            case 4:
                System.out.println("Enter the telephone number of the contact you're searching: ");
                criteriaQuery.select(root).where(root.get("telefono").in(scan.next()));
                contattoTypedQuery = session.createQuery(criteriaQuery);
                results = contattoTypedQuery.getResultList();
                break;
            default:
                System.out.println("Invalid Number, You'll return to the main menu. ");
                return;
        }

        for (Contatto contatto : results) {
            System.out.println(contatto.toString());
        }

        session.close();
    }

    public static void addNewContact(boolean createContact, Contatto contatto, EntityManagerFactory entityManagerFactory) {
        EntityManager session = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = session.getTransaction();
        if (createContact) {
            contatto = Contatto.inputCreaContatto();
        }

        entityTransaction.begin();
        session.persist(contatto);
        entityTransaction.commit();

        System.out.println("The contact has been added.");
        session.close();
    }

    public static void updateContacts(EntityManagerFactory entityManagerFactory, Scanner scan, CriteriaBuilder criteriaBuilder) {
        CriteriaQuery<Contatto> criteriaQuery = criteriaBuilder.createQuery(Contatto.class);
        Root<Contatto> root = criteriaQuery.from(Contatto.class);
        EntityManager session = entityManagerFactory.createEntityManager();
        int id = chooseId(criteriaQuery, root, session, scan);

        if (id != 0) {
            System.out.println("Enter 1 for editing a contact's name. ");
            System.out.println("Enter 2 for editing a contact's surname. ");
            System.out.println("Enter 3 for editing a contact's email. ");
            System.out.println("Enter 4 for editing a contact's telephone number. ");
            System.out.println("Enter 5 for editing a contact's note");

            switch (ScannerSwitch.scanner(scan)) {
                case 1: {
                    updateContactsCriteria(session, scan, criteriaBuilder, "Enter the new name for the contact: ", "nome", id);
                    break;
                }
                case 2: {
                    updateContactsCriteria(session, scan, criteriaBuilder, "Enter the new surname for the contact: ", "cognome", id);
                    break;
                }
                case 3: {
                    updateContactsCriteria(session, scan, criteriaBuilder, "Enter the new email for the contact: ", "email", id);
                    break;
                }
                case 4: {
                    updateContactsCriteria(session, scan, criteriaBuilder, "Enter the new telephone number for the contact: ", "telefono", id);
                    break;
                }
                case 5: {
                    updateContactsCriteria(session, scan, criteriaBuilder, "Enter the new note for the contact: ", "note", id);
                    break;
                }
                default:
                    System.out.println("Invalid Number, You'll return to the main menu. ");
                    break;
            }
        }

        session.close();
    }

    public static void updateContactsCriteria(EntityManager entityManager, Scanner scan, CriteriaBuilder criteriaBuilder, String print, String contactsVariable, int id) {
        CriteriaUpdate<Contatto> contattoCriteriaUpdate = criteriaBuilder.createCriteriaUpdate(Contatto.class);
        Root<Contatto> contattoRoot = contattoCriteriaUpdate.from(Contatto.class);

        System.out.println(print);
        contattoCriteriaUpdate.set(contactsVariable, scan.next());
        contattoCriteriaUpdate.where(criteriaBuilder.equal(contattoRoot.get("id"), id));

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.createQuery(contattoCriteriaUpdate).executeUpdate();
        transaction.commit();
    }

    public static int chooseId(CriteriaQuery criteriaQuery, Root root, EntityManager session, Scanner scan) {
        ArrayList<Integer> id = new ArrayList<>();
        id.add(0);
        boolean validId = false;
        int chooseId = 0;
        TypedQuery<Contatto> contattoTypedQuery = null;
        List<Contatto> results = null;

        criteriaQuery.select(root);
        contattoTypedQuery = session.createQuery(criteriaQuery);
        results = contattoTypedQuery.getResultList();

        results.forEach(c -> id.add(c.getId()));

        if (id.size() != 1) {

            results.forEach(c -> System.out.println(c.toString()));

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
            System.out.println("The database is empty, add a contact before you can modify/delete it.");
        }

        return chooseId;
    }

    public static void deleteContact(EntityManagerFactory entityManagerFactory, Scanner scan, CriteriaBuilder criteriaBuilder, boolean chooseId, int deleteId) {
        CriteriaQuery<Contatto> criteriaQuery = criteriaBuilder.createQuery(Contatto.class);
        Root<Contatto> root = criteriaQuery.from(Contatto.class);
        EntityManager session = entityManagerFactory.createEntityManager();
        CriteriaDelete<Contatto> contattoCriteriaDelete = criteriaBuilder.createCriteriaDelete(Contatto.class);
        Root<Contatto> contattoRoot = contattoCriteriaDelete.from(Contatto.class);
        int id = 0;
        if (chooseId) {
            id = chooseId(criteriaQuery, root, session, scan);
        } else {
            id = deleteId;
        }

        if (id != 0) {
            contattoCriteriaDelete.where(contattoRoot.get("id").in(id));

            EntityTransaction transaction = session.getTransaction();
            transaction.begin();
            session.createQuery(contattoCriteriaDelete).executeUpdate();
            transaction.commit();
            System.out.println("Contact deleted. ");
        }

        session.close();
    }

    public static ArrayList<Integer> findDuplicateContact(EntityManagerFactory entityManagerFactory, Scanner scan, CriteriaBuilder criteriaBuilder) {
        CriteriaQuery<Contatto> criteriaQuery = criteriaBuilder.createQuery(Contatto.class);
        Root<Contatto> root = criteriaQuery.from(Contatto.class);
        EntityManager session = entityManagerFactory.createEntityManager();
        TypedQuery<Contatto> contattoTypedQuery = null;
        List<Contatto> results = null;
        boolean duplicateContact = false;
        ArrayList<Integer> duplicateId = new ArrayList<>();

        criteriaQuery.select(root);
        contattoTypedQuery = session.createQuery(criteriaQuery);
        results = contattoTypedQuery.getResultList();

        for (Contatto contatto : results) {
            for (Contatto contatto1 : results) {
                if (contatto.getId() != contatto1.getId()) {
                    duplicateContact = contatto.isDuplicateContact(contatto1);
                }

                addContact(duplicateContact, duplicateId, contatto);
                addContact(duplicateContact, duplicateId, contatto1);
            }
        }

        if (duplicateId.size() != 0) {
            System.out.println("The duplicate contacts are: ");

            for (Contatto contatto : results) {
                for (int id : duplicateId) {
                    if (contatto.getId() == id) {
                        System.out.println(contatto);
                    }
                }
            }
        } else {
            System.out.println("There aren't any duplicate Contact.");
        }
        session.close();
        return duplicateId;
    }

    public static void addContact(boolean duplicateContact, List<Integer> duplicateId, Contatto contatto) {
        boolean idAlreadyVerified = false;

        if (duplicateContact) {
            idAlreadyVerified = duplicateId
                    .stream()
                    .anyMatch(id -> id == contatto.getId());

            if (!idAlreadyVerified) {
                duplicateId.add(contatto.getId());
            }
        }
    }

    public static void combineDuplicateContacts(EntityManagerFactory entityManagerFactory, Scanner scan, CriteriaBuilder criteriaBuilder) {
        CriteriaQuery<Contatto> criteriaQuery = criteriaBuilder.createQuery(Contatto.class);
        Root<Contatto> root = criteriaQuery.from(Contatto.class);
        EntityManager session = entityManagerFactory.createEntityManager();
        TypedQuery<Contatto> contattoTypedQuery = null;
        List<Contatto> results = null;
        boolean duplicateContact = false;
        List<Contatto> contactList = new ArrayList<>();
        List<Integer> idDeleted = new ArrayList<>();
        boolean alreadyDeleteId = false;

        criteriaQuery.select(root);
        contattoTypedQuery = session.createQuery(criteriaQuery);
        results = contattoTypedQuery.getResultList();

        for (Contatto contatto : results) {
            contactList.add(contatto);
        }

        for (Contatto contatto : contactList) {
            for (Contatto contatto1 : contactList) {
                if (contatto.getId() != contatto1.getId()) {
                    duplicateContact = contatto.isDuplicateContact(contatto1);
                }

                if (duplicateContact) {
                    for (int id : idDeleted) {
                        if (id == contatto1.getId()) {
                            alreadyDeleteId = true;
                        }
                    }

                    if (!alreadyDeleteId) {
                        idDeleted.add(contatto.getId());
                        idDeleted.add(contatto1.getId());
                        deleteContact(entityManagerFactory, scan, criteriaBuilder, false, contatto1.getId());
                    } else {
                        alreadyDeleteId = false;
                    }
                }
            }
        }
        session.close();
    }

    public static void importXMLorCSV(Scanner scan, EntityManagerFactory entityManagerFactory) {
        System.out.println("Enter 1 for importing Contacts from XML ");
        System.out.println("Enter 2 for importing Contacts from CSV ");
        System.out.println("Enter any other number to return to the main menu. ");
        switch (ScannerSwitch.scanner(scan)) {
            case 1:
                importXML(scan, entityManagerFactory);
                break;
            case 2:
                importCSV(scan, entityManagerFactory);
                break;
            default:
                return;
        }
    }

    public static void importCSV(Scanner scan, EntityManagerFactory entityManagerFactory) {
        System.out.println("Enter the path to the CSV file: ");
        List<Contatto> contattoList = ReadFile.loadRubricaFromCSV(scan.next(), ";");

        for (Contatto contatto : contattoList) {
            addNewContact(false, contatto, entityManagerFactory);
        }
    }

    public static void importXML(Scanner scan, EntityManagerFactory entityManagerFactory) {
        System.out.println("Enter the path to the XML file: ");
        List<Contatto> contattoList = ReadFile.loadRubricaFromXML(scan.next());

        for (Contatto contatto : contattoList) {
            addNewContact(false, contatto, entityManagerFactory);
        }
    }

    public static void exportXMLorCSV(EntityManagerFactory entityManagerFactory, Scanner scan, CriteriaBuilder criteriaBuilder) {
        CriteriaQuery<Contatto> criteriaQuery = criteriaBuilder.createQuery(Contatto.class);
        Root<Contatto> root = criteriaQuery.from(Contatto.class);
        System.out.println("Enter 1 for exporting Contacts into a XML file");
        System.out.println("Enter 2 for exporting Contacts into a CSV file");
        System.out.println("Enter any other number to return to the main menu. ");
        switch (ScannerSwitch.scanner(scan)) {
            case 1:
                exportXML(criteriaQuery, root, entityManagerFactory, scan);
                break;
            case 2:
                exportCSV(criteriaQuery, root, entityManagerFactory, scan);
                break;
            default:
                return;
        }
    }

    public static void exportCSV(CriteriaQuery criteriaQuery, Root root, EntityManagerFactory entityManagerFactory, Scanner scan) {
        EntityManager session = entityManagerFactory.createEntityManager();
        TypedQuery<Contatto> contattoTypedQuery = null;
        List<Contatto> results = null;

        criteriaQuery.select(root);
        contattoTypedQuery = session.createQuery(criteriaQuery);
        results = contattoTypedQuery.getResultList();

        System.out.println("Enter a path that indicates where to save the CSV file (If the file already exists the contacts will be added): ");
        WriteFile.writeRubricaCSV(results, scan.next(), ";", false);
        session.close();
    }

    public static void exportXML(CriteriaQuery criteriaQuery, Root root, EntityManagerFactory entityManagerFactory, Scanner scan) {
        EntityManager session = entityManagerFactory.createEntityManager();
        TypedQuery<Contatto> contattoTypedQuery = null;
        List<Contatto> results = null;

        criteriaQuery.select(root);
        contattoTypedQuery = session.createQuery(criteriaQuery);
        results = contattoTypedQuery.getResultList();

        System.out.println("Enter a path that indicates where to save the XML file (If the file already exists the contacts will be added): ");
        WriteFile.writeRubricaXML(results, scan.next(), false);
        session.close();
    }

//    public static ArrayList<Integer> findDuplicateContact(CriteriaQuery criteriaQuery, Root root, Session session, Scanner scan, CriteriaBuilder criteriaBuilder) {
//        TypedQuery<Contatto> contattoTypedQuery = null;
//        List<Contatto> results = null;
//        boolean duplicateContact = false;
//        ArrayList<Integer> duplicateId = new ArrayList<>();
//
//        criteriaQuery.select(criteriaBuilder.count(criteriaQuery.from(Contatto.class)));
//        criteriaQuery.groupBy(root.get("nome"), root.get("cognome"), root.get("telefono"), root.get("email"));
//        contattoTypedQuery = session.createQuery(criteriaQuery);
//        results = contattoTypedQuery.getResultList();
//
//        for(Contatto contatto: results) {
//            System.out.println(contatto.toString());
//        }
//
//        return duplicateId;
//    }
}
