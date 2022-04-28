package it.beije.turing.myRubrica.db;

import it.beije.turing.myRubrica.interfaces.OpRubrica;
import it.beije.turing.myRubrica.interfaces.Order;
import it.beije.turing.rubrica.Contatto;

import javax.persistence.*;
import javax.persistence.criteria.*;
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
        EntityManager  entityManager = entityManagerFactory.createEntityManager();
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
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction();


        String beginStatement = "SELECT c FROM Contatto as c WHERE " +
                " c.nome LIKE \'%"+s+"%\' OR " +
                " c.cognome LIKE \'%"+s+"%\' OR"+
                " c.note LIKE \'%"+s+"%\' OR"+
                " c.telefono LIKE \'%"+s+"%\' OR"+
                " c.cognome LIKE \'%"+s+"%\'";


        Query query = entityManager.createQuery(beginStatement);
        return query.getResultList();
    }

   /* @Override
    public List<Contatto> search(String s) {
        /**
         *Non è molto elegante come soluzione ma con i creteria non gira
         */
        /*EntityManager   entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Contatto> criteriaQuery = criteriaBuilder.createQuery(Contatto.class);

        Root<Contatto> itemRoot = criteriaQuery.from(Contatto.class);
``*/

       /* Predicate pred1 = criteriaBuilder.like(itemRoot.get("nome"), search);
        Predicate pred2 = criteriaBuilder.like(itemRoot.get("cognome"),search );
        Predicate pred3 = criteriaBuilder.like(itemRoot.get("email"),search );
        Predicate pred4 = criteriaBuilder.like(itemRoot.get("telefono"),search );
        Predicate pred5 = criteriaBuilder.like(itemRoot.get("note"),search );

        criteriaQuery.select(itemRoot).where(new Predicate[]{pred1,pred2,pred3,pred4,pred5});*/
      // criteriaQuery.select(itemRoot).where(pred1);
/*


        String q="Select c from Contatto as c where "+
                "cognome LIKE '"+search+"' OR " +
                "email LIKE '"+search+"' OR "+
                "telefono LIKE '"+search+"' OR "+
                "note LIKE '"+search+"'s";
        q="Select c from Contatto as c";
        Query query = entityManager.createQuery(q);
        query.executeUpdate();


        entityManager.close();
        List <Contatto> resultList=entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();

        List<Contatto> resultList=new ArrayList<>();
        List<Contatto> contattos= showContact(Order.NO);
if(s!=null){
        for (Contatto contatto: contattos) {
            boolean t=false;
            if(contatto.getNome().contains(s)){
                t=true;
            }
            if(contatto.getCognome().contains(s)){
                t=true;
            }
            if(contatto.getEmail().contains(s)){
                t=true;
            }
            if(contatto.getNote().contains(s)){
                t=true;
            }

            if(contatto.getTelefono().contains(s)){
                t=true;
            }
            if(t){
                resultList.add(contatto);
            }
        }}

        return resultList;
    }

*/
    @Override
    public boolean insert(Contatto c) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

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
    public  List<List<Contatto>> contattiDuplicati() {
        EntityManager   entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Contatto> criteriaQuery = criteriaBuilder.createQuery(Contatto.class);
        Root<Contatto> itemRoot = criteriaQuery.from(Contatto.class);
        List <Contatto> resultList=entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        List<List <Contatto>> r= new ArrayList<>();

        for (int i=0;i<resultList.size()-2;i++){
            List<Contatto> contattos= new ArrayList<>();
            contattos.add(resultList.get(i));

            for (int j = i; j <resultList.size()-1 ; j++) {

                if( resultList.get(i).getId()!=resultList.get(j).getId() &&
                (resultList.get(i).getEmail().equalsIgnoreCase(resultList.get(j).getEmail()) || resultList.get(i).getTelefono().equalsIgnoreCase(resultList.get(j).getTelefono()))
                && (!resultList.get(i).getEmail().isEmpty() && !resultList.get(i).getTelefono().isEmpty() && resultList.get(j).getEmail().isEmpty() && !resultList.get(j).getTelefono().isEmpty())
                ){
                    contattos.add(resultList.get(j));
                }
            }
            if(contattos.size()>1){
                r.add(contattos);
            }
        }

        return r;
    }

    @Override
    public void unisciContatti(List<List<Contatto>> l) {
        for (int i = 0; i < l.size(); i++) {
            Contatto c= l.get(i).get(0);

            for (int j = 1; j < l.get(i).size(); j++) {
                Contatto temp=l.get(i).get(j);

                if(c.getCognome().isEmpty()){
                    if(!temp.getCognome().isEmpty()){
                        c.setCognome(temp.getCognome());
                    }
                }
                if(c.getNome().isEmpty()){
                    if(!temp.getNome().isEmpty()){
                        c.setNome(temp.getNome());
                    }
                }

                if(c.getEmail().isEmpty()){
                    if(!temp.getEmail().isEmpty()){
                        c.setEmail(temp.getEmail());
                    }
                }
                if(c.getTelefono().isEmpty()){
                    if(!temp.getTelefono().isEmpty()){
                        c.setEmail(temp.getTelefono());
                    }
                }
                if(c.getNote().isEmpty()){
                    if(!temp.getNote().isEmpty()){
                        c.setNote(temp.getTelefono());
                    }
                }
                deleteContatto(temp);

            }
        }
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
