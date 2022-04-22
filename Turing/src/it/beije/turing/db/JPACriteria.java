package it.beije.turing.db;
import it.beije.turing.rubrica.Contatto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import java.util.List;


public class JPACriteria {

    static EntityManagerFactory emf= null;

    static EntityManager em=null;

    static CriteriaBuilder cb= null;

    static CriteriaQuery<Contatto> cq = null;

    static Root<Contatto> from = null;

    static  CriteriaQuery<Contatto> select= null;



    public static void openSession(){
        emf = Persistence.createEntityManagerFactory("turing");
        em = emf.createEntityManager();
        cb = em.getCriteriaBuilder();
        cq = cb.createQuery(Contatto.class);
        from = cq.from(Contatto.class);
    }

    public static void loadRubica(){
        System.out.println("Visualizzazione contatti");
        select = cq.select(from);
        TypedQuery<Contatto> typedQuery = em.createQuery(select);
        List<Contatto> resultlist = typedQuery.getResultList();
        printResults(resultlist);

        System.out.println("Fine contatti\n");
    }

    public static void sortRubrica(int choose){
        List<Contatto> resultlist=null;
        System.out.println("Contatti ordinati");
        CriteriaQuery<Contatto> select1 = cq.select(from);
        if (choose==1) {
            select1.orderBy(cb.asc(from.get("nome")));
        }
        else if (choose==2){
            select1.orderBy(cb.asc(from.get("cognome")));
        }
        TypedQuery<Contatto> typedQuery1 = em.createQuery(select);
        resultlist = typedQuery1.getResultList();
        printResults(resultlist);
        }
    public static void insertRubica(){
        Contatto newContatto = new Contatto();
        newContatto.setId(3);
	newContatto.setCognome("Corraro");
	newContatto.setNome("Mattia");
	newContatto.setEmail("m.corraro@beije.it");
		System.out.println("contatto PRE : " + newContatto);




    }

    private static void printResults(List<Contatto> resultlist) {
        for(Contatto cont:resultlist) {
            System.out.println("ID : " + ( cont).getId() + " Nome : " + (cont).getNome() + " Cognome : " + (cont).getCognome()+ " Telefono : " + (cont).getTelefono()+ " Email : " + (cont).getEmail()+ " Note : " + (cont).getNote());
        }
    }

    public static void closeSession(){
        em.close();
        emf.close();
    }

}

