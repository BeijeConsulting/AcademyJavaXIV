package it.beije.turing.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.turing.web.rubrica.Contatto;
import it.beije.turing.web.rubrica.JPAcriteriaManager;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String order = (String)request.getParameter("order");
		List<Contatto> contatti = new ArrayList<>();
		
		if(order != null && order.equals("nome")) {
			contatti = JPAcriteriaManager.getOrderedByNameRubrica();
		} else if(order != null && order.equals("cognome")) {
			contatti = JPAcriteriaManager.getOrderedByCognomeRubrica();
		} else {
			contatti = JPAcriteriaManager.getRubrica();
		}
		
		request.getSession().setAttribute("contatti", contatti);
		
		response.sendRedirect("home.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
