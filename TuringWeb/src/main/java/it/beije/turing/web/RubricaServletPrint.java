package it.beije.turing.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import it.beije.turing.web.rubrica.EntityManagerFactorySingleton;
import it.beije.turing.web.rubrica.Contatto;
/**
 * Servlet implementation class RubricaServlet
 */
@WebServlet("/rubricaservletprint")
public class RubricaServletPrint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RubricaServletPrint() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Contatto> ris = new ArrayList<Contatto>();
		EntityManager entityManager = null;
		try {
			entityManager = EntityManagerFactorySingleton.createEntityManager();
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Contatto> cq = cb.createQuery(Contatto.class);
			Root<Contatto> from = cq.from(Contatto.class);
			cq.select(from);
			TypedQuery<Contatto> q = entityManager.createQuery(cq);
			ris = q.getResultList();
			
		} catch (HibernateException hbmEx) {
			hbmEx.printStackTrace();
			throw hbmEx;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				entityManager.close();
			}catch(NullPointerException npEx) {
				if(ris.size() == 0)
					npEx.printStackTrace();
			}
			
		}
	
		// TODO Auto-generated method stub
		for(Contatto c : ris) {
			response.getWriter().append("<contatto>").append(c.toString()).append("</contatto>").append("<br>");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
