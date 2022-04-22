package it.beije.turing.myRubrica.db;


import it.beije.turing.myRubrica.interfaces.OpRubrica;
import it.beije.turing.myRubrica.interfaces.Order;
import it.beije.turing.rubrica.Contatto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;


import java.util.List;

/**
 * @author Giuseppe Raddato
 * Data: 19 apr 2022
 */
public class HibernateManager implements OpRubrica {


    public HibernateManager(){
        HibernateSessionFactory.opSession().close();
    }

    @Override
    public List<Contatto> showContact(Order order) {

        Session opSession = HibernateSessionFactory.opSession();
        StringBuilder s = new StringBuilder( "SELECT c FROM Contatto as c");

        if(order==Order.NO){

        }else if(order==Order.COGNOME){
            s.append(" ORDER BY nome DESC");
        }else if(order==Order.NOME){
            s.append(" ORDER BY cognome DESC");
        }

        Query<Contatto> query = opSession.createQuery(s.toString());
        List<Contatto> contatti = query.getResultList();
        opSession.close();
        return contatti;
    }

    @Override
    public List<Contatto> search(String s) {
     /*   Session session= HibernateSessionFactory.opSession();
        Query spSQLQuery = session.createSQLQuery("SELECT * FROM user_master WHERE user_name = :param1");
        spSQLQuery.setString("param1","vicky.thakor");
        spSQLQuery.list();*/

        return null;
    }

    @Override
    public boolean insert(Contatto c) {
        Session session= HibernateSessionFactory.opSession();
        Transaction transaction = session.beginTransaction();
        session.save(c);
        transaction.commit();
        session.close();
        return session.getTransaction().getStatus() == TransactionStatus.COMMITTED;
    }

    @Override
    public boolean modificaContatto(Contatto c) {

        Session session=HibernateSessionFactory.opSession();
        session.save(c);
        session.close();

        return session.getTransaction().getStatus() == TransactionStatus.COMMITTED;
    }

    @Override
    public boolean deleteContatto(Contatto c) {
        Session session= HibernateSessionFactory.opSession();
        Transaction transaction = session.beginTransaction();
        session.delete(c);
        transaction.commit();
        session.close();
        return session.getTransaction().getStatus() == TransactionStatus.COMMITTED;

    }

    @Override
    public List<Contatto> contattiDuplicati() {
        return null;
    }

    @Override
    public void unisciContatti() {

    }

    @Override
    public List<Contatto> importFromCVS(String path, String separator) {
        return null;
    }


    @Override
    public List<Contatto> importFromXML(String path) {
        return null;
    }

    @Override
    public void exportFromCVS(String path, List<Contatto> contats, String separator) {

    }


    @Override
    public void exportFromXML(String path, List<Contatto> contatti) {

    }
}
