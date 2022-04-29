package it.beije.turing.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.turing.web.rubrica.Contatto;
import it.beije.turing.web.rubrica.JPAmanager;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
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
		Contatto contatto = new Contatto();
		
		contatto.setNome(request.getParameter("name").trim());
		contatto.setCognome(request.getParameter("surname").trim());
		contatto.setIndirizzo(request.getParameter("address").trim());
		contatto.setDataDiNascita(request.getParameter("birthday").trim());
		contatto.setEmail(request.getParameter("email").trim());
		contatto.setTelefono(request.getParameter("phone").trim());
		contatto.setNote(request.getParameter("notes").trim());
		
		if(contatto.getNome().equals("") && contatto.getCognome().equals("") && contatto.getTelefono().equals("") && contatto.getEmail().equals("") && contatto.getDataDiNascita().equals("") && contatto.getIndirizzo().equals("") && contatto.getNote().equals("")) {
			response.sendRedirect("index");
		} else {			
			JPAmanager.insertToRubrica(contatto);
			
			response.sendRedirect("index");
		}
	}

}
