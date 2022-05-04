package it.beije.turing.web.rubrica;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletRimuovi
 */
@WebServlet("/ServletRimuovi")
public class ServletRimuovi extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRimuovi() {
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
		List<Contatto> contatti = JPACriteria.findContatto(Integer.parseInt(request.getParameter("id")), EntityManagerSingleton.createEntityManager());
		if(contatti != null && contatti.size() > 0) {
			for(Contatto c : contatti)
				JpaManager.deleteContatto(c, EntityManagerSingleton.createEntityManager());
			response.sendRedirect("http://localhost:8080/turing/conferma_eliminazione.jsp");
		}
		
		else
			response.sendRedirect("http://localhost:8080/turing/contatto_not_found.jsp");
	}

}
