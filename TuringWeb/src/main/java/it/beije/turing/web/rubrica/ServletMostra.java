package it.beije.turing.web.rubrica;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletMostra
 */
@WebServlet("/ServletMostra")
public class ServletMostra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMostra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Contatto> contatti = JPACriteria.findAll(EntityManagerSingleton.createEntityManager(), 0);
		request.setAttribute("contatti", contatti);
		request.getRequestDispatcher("/mostra_contatti.jsp").forward(request, response);
		//TODO Questo metodo deve ottenere una lista di contatti e passarla a una jsp per l'elaborazione
		//Creare quindi una jsp "mostra contatti" che cicla sulla lista per mostrare i vari contatti contenuti in rubrica e poi mettere un'opzione
		//Per tornare alla home
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	//Vecchio metodo usato prima dell'esercizio MVC 
//	public static void writer(List<Contatto> contatti, HttpServletResponse response) throws ServletException, IOException {
//		for(Contatto contatto : contatti) {
//			response.getWriter().append(contatto.toString()).append("<br>");
//			response.getWriter().append("<br>\n");
//		}
//	}

}
