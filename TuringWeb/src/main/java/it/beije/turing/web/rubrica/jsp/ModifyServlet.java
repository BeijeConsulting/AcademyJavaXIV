package it.beije.turing.web.rubrica.jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.turing.web.rubrica.Contatto;

/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/modify_servlet")
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		int realId = -1;
		try{
			realId = Integer.parseInt(id);
		}catch(NumberFormatException nfEx) {
			System.out.println("Inserire un ID valido");
			throw nfEx;
		}
		String name = request.getParameter("name");
		String surname = request.getParameter("lname");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String note = request.getParameter("note");
		
		Contatto c = new Contatto();
		c.setId(realId);
		c.setNome(name);
		c.setCognome(surname);
		c.setTelefono(tel);
		c.setEmail(email);
		c.setNote(note);
		session.setAttribute("contatto", c);
		response.sendRedirect("./modify.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
