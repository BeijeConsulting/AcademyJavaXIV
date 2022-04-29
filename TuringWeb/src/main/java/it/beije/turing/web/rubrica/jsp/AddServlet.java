package it.beije.turing.web.rubrica.jsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.turing.web.rubrica.Contatto;
import it.beije.turing.web.rubrica.RubricaManager;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/add_servlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		//RubricaManager rm = (RubricaManager)session.getAttribute("rubricaManager");
		RubricaManager rm = new RubricaManager();
		String name = request.getParameter("name");
		String surname = request.getParameter("lname");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String note = request.getParameter("note");
		
		if(name == null || surname == null || tel == null || email == null) {
			response.sendRedirect("./main");
			return;
		}
		
		Contatto c = new Contatto();
		c.setNome(name);
		c.setCognome(surname);
		c.setTelefono(tel);
		c.setNote(note);
		c.setEmail(email);
		List<Contatto> ris = rm.AggiungiContatto(c.getNome(), c.getCognome(), c.getTelefono(), c.getEmail(), c.getNote());
		rm.setAllContatti(rm.writeRubricaOnDB(ris));
		session.setAttribute("contatto", rm.getAllContatti().get(rm.getAllContatti().size()-1));
		response.sendRedirect("./add.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
