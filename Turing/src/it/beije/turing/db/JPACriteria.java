package it.beije.turing.db;
import it.beije.turing.file.CSVreader;
import it.beije.turing.rubrica.Contatto;
import it.beije.turing.rubrica.ScannerCheck;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class JPACriteria {

    private static EntityManagerFactory emf = null;

    private static EntityManager em = null;

    private static CriteriaBuilder cb = null;

    private static CriteriaQuery<Contatto> cq = null;

    private static Root<Contatto> from = null;

    private static CriteriaQuery<Contatto> select = null;

    private static EntityTransaction et = null;

    private static Scanner sc = new Scanner(System.in);


    public static void openSession() {
        emf = Persistence.createEntityManagerFactory("turing");
        em = emf.createEntityManager();
        cb = em.getCriteriaBuilder();
        cq = cb.createQuery(Contatto.class);
        from = cq.from(Contatto.class);
    }

    public static List<Contatto> getResultList(){
        select = cq.select(from);
        TypedQuery<Contatto> typedQuery = em.createQuery(select);
        List<Contatto> resultlist = typedQuery.getResultList();
        return resultlist;
    }
    public static void loadRubica() {
        System.out.println("Visualizzazione contatti");
        List<Contatto> resultlist= getResultList();
        printResults(resultlist);
        System.out.println("Fine contatti\n");
    }

    public static void sortRubrica(int choose) {
        List<Contatto> resultlist = getResultList();
        System.out.println("Contatti ordinati");
        CriteriaQuery<Contatto> select1 = cq.select(from);
        if (choose == 1) {
            select1.orderBy(cb.asc(from.get("nome")));
        } else if (choose == 2) {
            select1.orderBy(cb.asc(from.get("cognome")));
        }
        TypedQuery<Contatto> typedQuery1 = em.createQuery(select);
        resultlist = typedQuery1.getResultList();
        printResults(resultlist);
    }

    public static void insertRubrica() {
        et = em.getTransaction();
        et.begin();
        Contatto c = insertModifyContact();
        em.persist(c);
        et.commit();
    }

    public static void importRubrica(Contatto c) {
        et = em.getTransaction();
        et.begin();
        em.persist(c);
        et.commit();
    }
    public static void modifyRubrica() {
        et = em.getTransaction();
        et.begin();
        System.out.println("Selezionare contatto sul quale effettuare modifica (inserire id): ");
        int choose = ScannerCheck.checkNumber(sc.next());
        Contatto contatto = em.find(Contatto.class, choose);
        if (contatto != null) {
            System.out.println("Inserire cognome");
            contatto.setCognome(sc.next());
            System.out.println("Inserire nome");
            contatto.setNome(sc.next());
            System.out.println("Inserire email");
            contatto.setEmail(sc.next());
            System.out.println("Inserire telefono");
            contatto.setTelefono(sc.next());
            System.out.println("Inserire Note");
            contatto.setNote(sc.next());
            em.persist(contatto);
            et.commit();
        } else {
            System.out.println("Contatto non esistente");
        }
    }

    public static void searchRubrica(int choose) {
        et = em.getTransaction();
        et.begin();
        List<Contatto> contactResults= null;
        Query query= null;
        if (choose==1) {
            System.out.println("Inserire id del contatto da ricercare: ");
            int contId = ScannerCheck.checkNumber(sc.next());
            cq.select(from).where(cb.equal(from.get("id"), contId));
            query= em.createQuery(cq);
            contactResults = query.getResultList();
        }
        else if (choose==2){
            System.out.println("Inserire nome del contatto da ricercare: ");
            cq.select(from).where(cb.equal(from.get("nome"), sc.next()));
             query = em.createQuery(cq);
            contactResults = query.getResultList();
        }
        else{
            System.out.println("Inserire cognome del contatto da ricercare: ");
            cq.select(from).where(cb.equal(from.get("cognome"), sc.next()));
            query = em.createQuery(cq);
            contactResults = query.getResultList();
        }
        if (contactResults.size()==0) {
            System.out.println("Nessun contatto trovato");
        } else {
            for (Contatto c : contactResults) {
                System.out.println(c);
            }        }
        et.commit();
    }




    public static void delateRubrica() {
        et = em.getTransaction();
        et.begin();
        System.out.println("Eliminazione contatto (inserire id): ");
        int choose = ScannerCheck.checkNumber(sc.next());
        Contatto contatto = em.find(Contatto.class, choose);
        if (contatto != null) {
            em.remove(contatto);
            System.out.println("contatto eliminato");

        } else {
            System.out.println("Contatto non esistente");
        }
        et.commit();
    }

    private static Contatto insertModifyContact() {

        String nome = null;
        String cognome = null;
        String telefono = null;
        String email = null;
        String note = null;

        Contatto newContatto = new Contatto();
        System.out.println("Inserire cognome");
        newContatto.setCognome(sc.next());
        System.out.println("Inserire nome");
        newContatto.setNome(sc.next());
        System.out.println("Inserire email");
        newContatto.setEmail(sc.next());
        System.out.println("Inserire telefono");
        newContatto.setTelefono(sc.next());
        System.out.println("Inserire Note");
        newContatto.setNote(sc.next());
        return newContatto;
    }

    private static void printResults(List<Contatto> resultlist) {
        for (Contatto cont : resultlist) {
            System.out.println("ID : " + cont.getId() + " Nome : " + cont.getNome() + " Cognome : " + cont.getCognome() + " Telefono : " + cont.getTelefono() + " Email : " + cont.getEmail() + " Note : " + cont.getNote());
        }
    }


    public static void manageDuplicate(int choose) {

        List<Contatto> sameElement = new ArrayList<>();
        List<Contatto> conList = getResultList();
        Contatto dup = null;
        for (Contatto c : conList) {
            for (Contatto c1 : conList) {
                if (c.getId() != c1.getId()) {
                    if (c.getNome().equals(c1.getNome()) && c.getCognome().equals(c1.getCognome()) && c.getTelefono().equals(c1.getTelefono()) && c.getEmail().equals(c1.getEmail()) && c.getEmail().equals(c1.getEmail())) {
                        dup = c1;
                        sameElement.add(dup);
                        break;
                    }
                }
            }
        }
        if (choose == 1) {
            if (sameElement.size()==0){
                System.out.println("nessun duplicato");
            }
            else{
                System.out.println("Duplicati trovati: ");
                printResults(sameElement);

            }
        } else {
            et = em.getTransaction();
            et.begin();
            if(sameElement.size()==0){
                System.out.println("nessun duplicato");
            }
            else {
                System.out.println("Eliminazione duplicati");
                System.out.println(sameElement.size());
                for (int i = 1; i < sameElement.size(); i++) {
                    Contatto contatto = em.find(Contatto.class, sameElement.get(i).getId());
                    em.remove(contatto);
                    et.commit();
                }
            }
        }
    }

    public static void importTodbFromCsv(){


    }

    public static void closeSession() {
        em.close();
        emf.close();
    }

}

