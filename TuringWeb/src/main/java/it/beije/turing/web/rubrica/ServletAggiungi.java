package it.beije.turing.web.rubrica;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletRubrica
 */
@WebServlet("/ServletAggiungi")
public class ServletAggiungi extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAggiungi() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contatto contatto = new Contatto();
		contatto.setCognome(request.getParameter("cognome"));
		contatto.setNome(request.getParameter("nome"));
		contatto.setEmail(request.getParameter("email"));
		contatto.setTelefono(request.getParameter("telefono"));
		contatto.setNote(request.getParameter("note"));
		JpaManager.addContatti(contatto);
		request.setAttribute("contatto", contatto);
		System.out.println("Nuovo contatto inserito:");
		System.out.print(contatto);
		request.getRequestDispatcher("/contatto_inserito.jsp").forward(request, response);	
	}

}
