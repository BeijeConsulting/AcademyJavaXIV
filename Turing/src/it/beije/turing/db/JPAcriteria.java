package it.beije.turing.db;



import it.beije.turing.rubrica.Contatto;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JPAcriteria {
    private Session session;
    public JPAcriteria(){

        session = HBsessionFactory.openSession();

    }

    public  List<Contatto> JPACriteriaLeggiContatti(){

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Contatto> cr = cb.createQuery(Contatto.class);
        Root<Contatto> root = cr.from(Contatto.class);
        cr.select(root);

        Query<Contatto> query = session.createQuery(cr);
        List<Contatto> results = query.getResultList();

        return  results;
    }
}
