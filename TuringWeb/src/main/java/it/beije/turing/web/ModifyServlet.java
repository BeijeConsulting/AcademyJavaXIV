package it.beije.turing.web;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.turing.web.rubrica.Contatto;
import it.beije.turing.web.rubrica.JPAentityManagerFactory;
import it.beije.turing.web.rubrica.JPAmanager;

/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/modify")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt((String)request.getParameter("id"));
		EntityManager entityManager = JPAentityManagerFactory.openEntityManager();
		Contatto contatto = entityManager.find(Contatto.class, id);
		
		request.getSession().setAttribute("contatto", contatto);
		request.getSession().setAttribute("id", Integer.toString(id));
		
		response.sendRedirect("modify.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Contatto contatto = new Contatto();
		
		contatto.setNome(request.getParameter("name"));
		contatto.setCognome(request.getParameter("surname"));
		contatto.setIndirizzo(request.getParameter("address"));
		contatto.setDataDiNascita(request.getParameter("birthday"));
		contatto.setEmail(request.getParameter("email"));
		contatto.setTelefono(request.getParameter("phone"));
		contatto.setNote(request.getParameter("notes"));
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		JPAmanager.updateContattoRubrica(contatto, id);
		
		response.sendRedirect("index.jsp");
	}

}
