package it.beije.turing.web.rubrica;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContattiDoppi
 */
@WebServlet("/ServletContattiDoppi")
public class ServletContattiDoppi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Contatto> doppi = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletContattiDoppi() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doppi = RubricaManager.trovaDuplicatiServlet();
		request.setAttribute("contatti", doppi);
		request.getRequestDispatcher("/contatti_doppi.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(doppi != null) {
			for (Contatto c : doppi)
				JpaManager.deleteContatto(c, EntityManagerSingleton.createEntityManager());
		}
		response.sendRedirect("http://localhost:8080/turing/conferma_eliminazione.jsp");

	}

}
