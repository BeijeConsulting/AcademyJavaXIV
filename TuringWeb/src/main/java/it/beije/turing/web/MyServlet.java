package main.java.it.beije.turing.web;

import main.java.it.beije.turing.JPAContactsManager.Contatto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/servlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("MyServlet doGet");

		List<Contatto> lista = new ArrayList<>();
		
		Contatto contatto = new Contatto();
		contatto.setNome("Pippo");
		contatto.setCognome("Rossi");

		Contatto contatto2 = new Contatto();
		contatto2.setNome("Pippo");
		contatto2.setCognome("Rossi");



		request.getSession().setAttribute("contatto", lista);
		
		response.sendRedirect("insert_contatto.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
