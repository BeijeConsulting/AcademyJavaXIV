package it.beije.turing.web.rubrica;

import java.io.IOException;
import java.util.ArrayList;
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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doppi = trovaDuplicati();
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
	
	
	public static List<Contatto> trovaDuplicati() {
		List<Contatto> contatti = JPACriteria.findAll(EntityManagerSingleton.createEntityManager(), 1);
		List<Contatto> contattiCercati = new ArrayList<>();
		List<Contatto> doppi = new ArrayList<>();

		for (Contatto contatto : contatti) {
			System.out.println(contatto);
			if (isDoppio(contatto, contattiCercati)) {
				doppi.add(contatto);
				System.out.println("Doppio trovato.");
			} else {
				contattiCercati.add(contatto);
			}
		}
		return doppi;
	}

	public static boolean isDoppio(Contatto contatto, List<Contatto> cerca) {
		for (Contatto c : cerca) {
			if (isContattoEqual(contatto, c))
				return true;
		}
		return false;
	}

	public static boolean isContattoEqual(Contatto c1, Contatto c2) {
		if (c1.getCognome() != null && c2.getCognome() != null && c1.getNome() != null && c2.getNome() != null
				&& c1.getEmail() != null && c2.getEmail() != null && c1.getTelefono() != null
				&& c2.getTelefono() != null && c1.getNote() != null && c2.getNote() != null) {

			if (c1.getCognome().equals(c2.getCognome()) && c1.getNome().equals(c2.getNome())
					&& c1.getEmail().equals(c2.getEmail()) && c1.getTelefono().equals(c2.getTelefono())
					&& c1.getNote().equals(c2.getNote())) {
				return true;
			}
		}
		return false;
	}

}
