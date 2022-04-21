package it.beije.turing.db;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.xml.sax.SAXException;

import it.beije.turing.file.XMLManager;
import it.beije.turing.file.CSVManager;
import it.beije.turing.file.XMLReaderWriter;
import it.beije.turing.rubrica.Contatto;


public class MyHBManager {

    public static List<Contatto> getRubrica() {
        List<Contatto> contatti = new ArrayList<Contatto>();

        Session session = null;
        try {
            session = HBsessionFactory.openSession();

            Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
            contatti = query.getResultList();
        } catch (HibernateException hbmEx) {
            hbmEx.printStackTrace();
            throw hbmEx;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            session.close();
        }

        return contatti;
    }

    public static void importFromCSV(String path, String separatore, boolean virgolette) throws IOException {
        List<Contatto> contatti = CSVManager.loadRubricaFromCSV(path, separatore, virgolette);

        saveIntoDB(contatti);
    }

    public static void importFromXML(String path) throws ParserConfigurationException, IOException, SAXException {
        List<Contatto> contatti = XMLManager.loadRubricaFromXML(path);

        saveIntoDB(contatti);
    }

    public static void saveIntoDB(List<Contatto> contatti) {
        Session session = null;
        try {
            session = HBsessionFactory.openSession();

            //INSERT
            //Transaction transaction = session.beginTransaction();
            Transaction transaction = session.getTransaction();
            transaction.begin();


            for(Contatto c : contatti) {
                session.save(c);
            }

            transaction.commit();
        } catch (HibernateException hbmEx) {
            hbmEx.printStackTrace();
            throw hbmEx;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            session.close();
        }
    }

    public static void updateDB(Contatto contattoNuovo, int id) {
        Session session = null;
        try {
            session = HBsessionFactory.openSession();

            Transaction transaction = session.beginTransaction();

            Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
            List<Contatto> contatti = query.getResultList();

            Contatto contatto = null;
            for (Contatto c : contatti) {
                if (c.getId() == id) contatto = c;
            }


            //UPDATE

            System.out.println(contattoNuovo.getNome());
            if(!contattoNuovo.getNome().equals("")) {
                contatto.setNome(contattoNuovo.getNome());
            }
            if(!contattoNuovo.getCognome().equals("")) {
                contatto.setCognome(contattoNuovo.getCognome());
            }
            if(!contattoNuovo.getTelefono().equals("")) {
                contatto.setTelefono(contattoNuovo.getTelefono());
            }
            if(!contattoNuovo.getEmail().equals("")) {
                contatto.setEmail(contattoNuovo.getEmail());
            }
            if(!contattoNuovo.getNote().equals("")) {
                contatto.setNote(contattoNuovo.getNote());
            }

            session.save(contatto);

            transaction.commit();
        } catch (HibernateException hbmEx) {
            hbmEx.printStackTrace();
            throw hbmEx;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            session.close();
        }
    }

    public static void deleteDB(int id) {
        Session session = null;
        try {
            session = HBsessionFactory.openSession();

            Transaction transaction = session.beginTransaction();

            Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
            List<Contatto> contatti = query.getResultList();

            Contatto contatto = null;
            for (Contatto c : contatti) {
                if (c.getId() == id) contatto = c;
            }

            session.remove(contatto);

            transaction.commit();
        } catch (HibernateException hbmEx) {
            hbmEx.printStackTrace();
            throw hbmEx;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            session.close();
        }
    }

    public static void main(String[] args) {

//        List<Contatto> contatti = new ArrayList<Contatto>();
//
//        Contatto contatto = new Contatto();
//        contatto.setNome("Alessio");
//        contatto.setCognome("Marazzini");
//        contatto.setEmail("alessio@beije.com");
//        contatto.setTelefono("3497007275");
//        contatto.setNote("Quinto contatto");
//        contatti.add(contatto);

        List<Contatto> newContatti = getRubrica();
        for(Contatto c : newContatti) {
            System.out.println(c);
        }


    }
}
