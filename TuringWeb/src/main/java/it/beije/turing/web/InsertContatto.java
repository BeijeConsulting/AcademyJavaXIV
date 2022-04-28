package it.beije.turing.web;

import it.beije.turing.web.rubrica.Contatto;
import it.beije.turing.web.rubrica.JPACriteriaManager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/insert")
public class InsertContatto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int c;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertContatto() {
        super();
        c = 0;
        System.out.println("TestServlet....");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TestServlet doGet");
		HttpSession session = request.getSession();

		

		response.getWriter().append("<html><body>Served at: ").append(request.getContextPath()).append("<br>").append("ID : ").append(session.getId()).append("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TestServlet doPost");

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		String note = request.getParameter("note");

		
		System.out.println("fname : " + fname);
		System.out.println("lname : " + lname);
		System.out.println("email : " + email);
		System.out.println("telefono : " + telefono);
		System.out.println("note : " + note);
		
		HttpSession session = request.getSession();
		System.out.println("session : " + session.getId());
		session.setAttribute("fname", fname);
		session.setAttribute("lname", lname);
		session.setAttribute("email", email);
		session.setAttribute("telefono", telefono);
		session.setAttribute("note", note);

		Contatto contatto = new Contatto();
		contatto.setNome(fname);
		contatto.setCognome(lname);
		contatto.setEmail(email);
		contatto.setTelefono(telefono);
		contatto.setNote(note);


		JPACriteriaManager.insertContatto(contatto);

		response.getWriter().append("<html><body>")
		.append("fname : ").append(fname).append("<br>")
		.append("lname : ").append(lname).append("<br>")
		.append("telefono : ").append(telefono).append("<br>")
		.append("email : ").append(email).append("<br>")
		.append("note : ").append(note).append("<br>")
		.append("<div class=\"container\">\n" +
				"    <form action=\"../TuringWeb\" method=\"post\"><input type=\"submit\" value=\"Torna indietro\">\n" +
				"    </form>\n" +
				"</div></body></html>");

	}

}
