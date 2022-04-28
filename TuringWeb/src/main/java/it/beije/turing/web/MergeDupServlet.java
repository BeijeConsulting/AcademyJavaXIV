package it.beije.turing.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.turing.web.rubrica.Contatto;
import it.beije.turing.web.rubrica.GestoreFunction;
import it.beije.turing.web.rubrica.JPAmanager;

/**
 * Servlet implementation class MergeDupServlet
 */
@WebServlet("/mergedup")
public class MergeDupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MergeDupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Contatto> contattiDup = GestoreFunction.trovaContattiDuplicati();
		
		while(contattiDup.size() > 1) {
			JPAmanager.deleteContattoRubrica(contattiDup.get(0).getId());
			contattiDup.remove(0);
		}
		
		response.sendRedirect("index.jsp");
	}

}
