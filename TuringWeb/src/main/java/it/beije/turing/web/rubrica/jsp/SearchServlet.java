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
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search_servlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
		if(name == null || surname == null || tel == null || email == null) {
			response.sendRedirect("./main");
			return;
		}
		Contatto contatto = new Contatto();
		contatto.setNome(name);
		contatto.setCognome(surname);
		contatto.setEmail(email);
		contatto.setTelefono(tel);
		contatto.setNote("");
		
		List<Contatto> ris = rm.cercaContatto(rm.getAllContatti(), contatto.getNome(), contatto.getCognome(), contatto.getTelefono(), contatto.getEmail());
		session.setAttribute("contatto", contatto);
		session.setAttribute("allContatti", ris);
		response.sendRedirect("./search.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}