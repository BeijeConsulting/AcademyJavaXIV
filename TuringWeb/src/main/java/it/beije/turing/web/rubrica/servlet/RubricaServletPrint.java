package it.beije.turing.web.rubrica.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;

import it.beije.turing.web.rubrica.EntityManagerFactorySingleton;
import it.beije.turing.web.rubrica.Contatto;
/**
 * Servlet implementation class RubricaServlet
 */
@WebServlet("/rubrica_servlet_print")
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
		//HttpSession session = request.getSession();
		//System.out.println("session : " + session.getId());
		//String value = (String)session.getAttribute("type");	
		String value = request.getParameter("type");
		if(value.equalsIgnoreCase("name")) {
			ris = sort(ris,"N");
		}else {
			ris = sort(ris,"S");
		}
		
		for(Contatto c : ris) {
			response.getWriter().append(c.toString()).append("<br>");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void swap(List<Contatto> contatti, int i) {
		Contatto tmp = contatti.get(i);
		Contatto tmp2 = contatti.get(i+1);
		contatti.remove(i+1);
		contatti.remove(i);
		contatti.add(i,tmp2);
		contatti.add(i+1,tmp);
	}

	public List<Contatto> sort(List<Contatto> allContatti, String type) {
		boolean swapped = true;
		List<Contatto> ris = new ArrayList<>(allContatti);

		switch(type.toUpperCase().charAt(0)) {
		case 'N':
			while(swapped) {
				swapped = false;
				for(int i = 0; (i+1) < ris.size(); i++) {
					if(ris.get(i).getNome().toUpperCase().compareTo(ris.get(i+1).getNome().toUpperCase()) >= 0) {
						if(ris.get(i).getNome().toUpperCase().compareTo(ris.get(i+1).getNome().toUpperCase()) == 0) {
							continue;
						}
						swap(ris,i);
						swapped = true;
					}
				}
			}
			break;
		default:
			System.out.println("Tipo invalido, ordinamento per Cognome.");
		case 'S':
			while(swapped) {
				swapped = false;
				for(int i = 0; (i+1) < ris.size(); i++) {
					if(ris.get(i).getCognome().toUpperCase().compareTo(ris.get(i+1).getCognome().toUpperCase()) >= 0) {
						if(ris.get(i).getCognome().toUpperCase().compareTo(ris.get(i+1).getCognome().toUpperCase()) == 0) {
							continue;
						}
						swap(ris,i);
						swapped = true;
					}
				}
			}
			break;
		}
		return ris;
	}
	
}
