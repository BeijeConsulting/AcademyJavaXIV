package it.beije.turing.rubrica;

import it.beije.turing.db.JPAEntityFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyJPAManager {

    public static List<Contatto> importRubrica() {
        EntityManager entityManager = null;
        List<Contatto> contacts = null;

        try {
            entityManager = JPAEntityFactory.createJPAEntityManager("turing");
            contacts = new ArrayList<>();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Contatto> criteriaQuery = criteriaBuilder.createQuery(Contatto.class);

            Root<Contatto> from = criteriaQuery.from(Contatto.class);

            //SELECT ALL
            CriteriaQuery<Contatto> select = criteriaQuery.select(from);
            TypedQuery<Contatto> typedQuery = entityManager.createQuery(select);

            contacts = typedQuery.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            System.out.println("IMPORTED");
        }

        return contacts;
    }

    public static void exportRubrica(List<Contatto> contacts) {
        EntityManager entityManager = null;

        try {
            entityManager = JPAEntityFactory.createJPAEntityManager("turing");

            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            for (Contatto c : contacts) {
                entityManager.persist(c);
            }

            entityTransaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            System.out.println("EXPORTED");
        }

    }

    public static List<Contatto> searchContactBy(String word) {

        EntityManager entityManager = null;
        List<Contatto> contacts = null;

        try {
            entityManager = JPAEntityFactory.createJPAEntityManager("turing");

            contacts = new ArrayList<>();
            String[] cols = {"nome", "cognome", "telefono", "email", "note", };

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Contatto> criteriaQuery = criteriaBuilder.createQuery(Contatto.class);

            Root<Contatto> from = criteriaQuery.from(Contatto.class);

            //SEARCH
            for (String colName : cols) {
                String toSearch = "%" + word + "%";

                CriteriaQuery<Contatto> select = criteriaQuery.select(from).where(
                        criteriaBuilder.like(from.get(colName), toSearch)
                );
                TypedQuery<Contatto> typedQuery = entityManager.createQuery(select);

                List<Contatto> resultList = typedQuery.getResultList();

                contacts = filterDuplicateAfterSearch(resultList, contacts);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

        return  contacts;
    }

    public static void addContact(Contatto newContact) {
        EntityManager entityManager = null;

        try {
            entityManager = JPAEntityFactory.createJPAEntityManager("turing");

            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            entityManager.persist(newContact);

            entityTransaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            System.out.println("CONTACT ADDED");
        }

    }

    public static void deleteContacts(Contatto contact) {
        EntityManager entityManager = null;

        try {
            entityManager = JPAEntityFactory.createJPAEntityManager("turing");

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaDelete<Contatto> criteriaDelete = criteriaBuilder.createCriteriaDelete(Contatto.class);
            Root<Contatto> root = criteriaDelete.from(Contatto.class);
            criteriaDelete.where(criteriaBuilder.equal(root.get("id"), contact.getId()));

            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            entityManager.createQuery(criteriaDelete).executeUpdate();
            entityTransaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public static void deleteDuplicates(List<Contatto> duplicates) {
        EntityManager entityManager = null;
        List<Contatto> duplicatesToDelete = null;

        try {
            entityManager = JPAEntityFactory.createJPAEntityManager("turing");
            duplicatesToDelete = new ArrayList<>();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Contatto> criteriaQuery = criteriaBuilder.createQuery(Contatto.class);

            Root<Contatto> from = criteriaQuery.from(Contatto.class);

            for (Contatto duplicate : duplicates) {
                //SELECT DUPLICATE
                Predicate equalPhone = criteriaBuilder.equal(from.get("telefono"), duplicate.getTelefono());
                Predicate noEqualId = criteriaBuilder.notEqual(from.get("id"), duplicate.getId());

                CriteriaQuery<Contatto> select = criteriaQuery.select(from)
                        .where(criteriaBuilder.and(equalPhone, noEqualId)
                );

                TypedQuery<Contatto> typedQuery = entityManager.createQuery(select);

                List<Contatto> resultList = typedQuery.getResultList();
                duplicatesToDelete.addAll(resultList);
            }

            for (Contatto c : duplicatesToDelete) {
                deleteContacts(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            System.out.println("DUPLICATES DELETED");
        }

    }

    public static List<Object[]> findDuplicates() {
        EntityManager entityManager = null;
        List<Object[]> duplicates = null;

        try {
            entityManager = JPAEntityFactory.createJPAEntityManager("turing");
            duplicates = new ArrayList<>();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);

            Root<Contatto> from = criteriaQuery.from(Contatto.class);

            //SELECT DUPLICATE
            CriteriaQuery<Object[]> multiselect = criteriaQuery.multiselect(from, criteriaBuilder.count(from))
                    .groupBy(from.get("telefono"))
                    .having(criteriaBuilder.gt(criteriaBuilder.count(from), 1)
            );

            TypedQuery<Object[]> typedQuery = entityManager.createQuery(multiselect);

            duplicates = typedQuery.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();

        }

        System.out.println("DUPLICATE SEARCHED");
        /*if ((contacts.size() > 1) && !collectDuplicates(contacts).isEmpty()) {
            duplicates = collectDuplicates(contacts);
        } else {
            System.out.println("No contact duplicates found.");
        }*/
        return duplicates;
    }

    /*public static List<Contatto> collectDuplicates(List<Contatto> contacts) {
        List<Contatto> duplicates = new ArrayList<>();

        for (int i = 0; i < contacts.size(); i++) {
            if (duplicates.contains(contacts.get(i))) continue;

            List<Contatto> tempDuplicates = new ArrayList<>();
            tempDuplicates.add(contacts.get(i));

            for (int j = i + 1; j < contacts.size(); j++) {
                Contatto currentContact = contacts.get(i);
                String phone = contacts.get(j).getTelefono();

                if (currentContact.getTelefono().equalsIgnoreCase(phone)) {
                    tempDuplicates.add(contacts.get(j));
                }
            }

            if (tempDuplicates.size() > 1) {
                duplicates.addAll(tempDuplicates);
            }
        }

        return duplicates;
    }*/

    private static List<Contatto> filterDuplicateAfterSearch(List<Contatto> resultList, List<Contatto> contacts) {
        for (Contatto c : resultList) {
            if (contacts.contains(c)) continue;
            contacts.add(c);
        }
        return contacts;
    }

    public static void updateContact(Scanner scanner, int id) {
        EntityManager entityManager = null;
        String[] fields = new String[5];
        try {
            entityManager = JPAEntityFactory.createJPAEntityManager("turing");

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaUpdate<Contatto> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Contatto.class);
            Root<Contatto> from = criteriaUpdate.from(Contatto.class);

            fields[0] = Rubrica.takeInput(scanner, "Type new name:");
            fields[1] = Rubrica.takeInput(scanner, "Type new surname:");
            fields[2] = Rubrica.takeInput(scanner, "Type new email:");
            fields[3] = Rubrica.takeInput(scanner, "Type new phone number:");
            fields[4] = Rubrica.takeInput(scanner, "Type new note:");

            criteriaUpdate.set("nome", fields[0]);
            criteriaUpdate.set("cognome", fields[1]);
            criteriaUpdate.set("email", fields[2]);
            criteriaUpdate.set("telefono", fields[3]);
            criteriaUpdate.set("note", fields[4]);

            criteriaUpdate.where(criteriaBuilder.equal(from.get("id"), id));

            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            entityManager.createQuery(criteriaUpdate).executeUpdate();
            entityTransaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

        System.out.println("CONTACT UPDATED");
    }

}
