package main.java.it.beije.turing.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/test")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int c=0;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
		super();
		System.out.println("apro myservlet");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("MyServlet doGet");

		Contatto contatto = new Contatto();
		contatto.setNome("Pippo");
		contatto.setCognome("Rossi");

		request.getSession().setAttribute("contatto", contatto);

		//response.sendRedirect("insert_contatto.jsp");
		response.getWriter().append("served nella get: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Nelle doPost");
		List<Contatto> sessionContatti= new ArrayList<>();
		Contatto contatto = new Contatto();
		contatto.setNome((String) request.getParameter("fname"));
		contatto.setCognome("Rossi");
		sessionContatti.add(contatto);
		HttpSession session = request.getSession();
		session.setAttribute("fname", contatto.getNome());
		response.sendRedirect("prova.jsp");
	}
}