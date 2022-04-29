package it.beije.turing.web.rubrica;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletModifica
 */
@WebServlet("/ServletModifica")
public class ServletModifica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModifica() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		List<Contatto> contatto = JPACriteria.findContatto(id, EntityManagerSingleton.createEntityManager());
		if(contatto != null && contatto.size() > 0) {
			Contatto c = contatto.get(0);
			c.setCognome(request.getParameter("cognome"));
			c.setNome(request.getParameter("nome"));
			c.setEmail(request.getParameter("email"));
			c.setTelefono(request.getParameter("telefono"));
			c.setNote(request.getParameter("note"));
			JpaManager.modifyContatto(c, EntityManagerSingleton.createEntityManager());
			response.sendRedirect("http://localhost:8080/turing/contatto_modificato.jsp");
		}
		else {
			response.sendRedirect("http://localhost:8080/turing/contatto_not_found.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
