package it.beije.turing.myRubrica.db;

import it.beije.turing.myRubrica.interfaces.OpRubrica;
import it.beije.turing.myRubrica.interfaces.Order;
import it.beije.turing.rubrica.Contatto;



import javax.persistence.*;
import javax.persistence.criteria.*;
import javax.transaction.Transaction;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Giuseppe Raddato
 * Data: 21 apr 2022
 */
public class JPAManager implements OpRubrica {
    private EntityManagerFactory entityManagerFactory=null;
        public JPAManager(){
             entityManagerFactory = Persistence.createEntityManagerFactory("turing");
        }

    @Override
    public List<Contatto> showContact(Order order) {
        EntityManager   entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Contatto> criteriaQuery = criteriaBuilder.createQuery(Contatto.class);
        Root<Contatto> itemRoot = criteriaQuery.from(Contatto.class);
        criteriaQuery.select(itemRoot);
        if(order==Order.COGNOME){
            criteriaQuery.orderBy(criteriaBuilder.asc(itemRoot.get("cognome")));
        }
        if(order==Order.NOME){
            criteriaQuery.orderBy(criteriaBuilder.asc(itemRoot.get("nome")));
        }
        List <Contatto> c=entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        return c;
    }

    @Override
    public List<Contatto> search(String s) {
        EntityManager   entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Contatto> criteriaQuery = criteriaBuilder.createQuery(Contatto.class);

        Root<Contatto> itemRoot = criteriaQuery.from(Contatto.class);

        String like="%";
        String search= like + s + like;

        //TODO da sistemare

        Predicate pred1 = criteriaBuilder.like(itemRoot.get("nome"), search);
        Predicate pred2 = criteriaBuilder.like(itemRoot.get("cognome"),search );
        Predicate pred3 = criteriaBuilder.like(itemRoot.get("email"),search );
        Predicate pred4 = criteriaBuilder.like(itemRoot.get("telefono"),search );
        Predicate pred5 = criteriaBuilder.like(itemRoot.get("note"),search );

        criteriaQuery.select(itemRoot).where(new Predicate[]{pred1,pred2,pred3,pred4,pred5});

        List <Contatto> resultList=entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();

        return resultList;
    }

    @Override
    public boolean insert(Contatto c) {
        EntityManager   entityManager = entityManagerFactory.createEntityManager();

        entityManager.persist(c);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityTransaction.commit();

        return true;
    }

    @Override
    public boolean modificaContatto(Contatto c) {

        EntityManager   entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaUpdate<Contatto> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Contatto.class);
        Root<Contatto> itemRoot = criteriaUpdate.from(Contatto.class);

        criteriaUpdate.set("nome",c.getNome() );
        criteriaUpdate.set("cognome",c.getCognome() );
        criteriaUpdate.set("email",c.getEmail() );
        criteriaUpdate.set("telefono",c.getTelefono() );
        criteriaUpdate.set("note",c.getNote() );

        criteriaUpdate.where(criteriaBuilder.equal(itemRoot.get("id"), c.getId()));


        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.createQuery(criteriaUpdate).executeUpdate();

        entityTransaction.commit();

        return false;
    }

    @Override
    public boolean deleteContatto(Contatto c) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete<Contatto> criteriaDelete = criteriaBuilder.createCriteriaDelete(Contatto.class);
        Root<Contatto> root = criteriaDelete.from(Contatto.class);
        criteriaDelete.where(criteriaBuilder.equal(root.get("id"), c.getId()));

        Query query = entityManager.createQuery(criteriaDelete);
        query.executeUpdate();
        entityTransaction.commit();
        entityManager.close();
        return true;
    }

    @Override
    public List<Contatto> contattiDuplicati() {
            //TODO
        return null;
    }

    @Override
    public void unisciContatti() {
        //TODO
    }

    @Override
    public List<Contatto> importFromCVS(String path,String separator) {
        List<Contatto> list=OpRubrica.importFileCVS(path,separator);
        for (Contatto c:list) {
            insert(c);
        }
        return list;

    }

    @Override
    public List<Contatto> importFromXML(String path) {
            List<Contatto> list=OpRubrica.impotFileXML(path);

        for (Contatto c:list) {
            insert(c);
        }
        return list;
    }

    @Override
    public void exportFromCVS(String path, List<Contatto> contatti,String separator) {
        OpRubrica.exportFileCVS(path,contatti,separator);
    }

    @Override
    public void exportFromXML(String path, List<Contatto> contatti) {
         OpRubrica.exportFileXML(path,contatti);
    }


}
