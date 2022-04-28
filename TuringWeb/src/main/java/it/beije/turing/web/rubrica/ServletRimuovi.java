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
	private static final String form = "<form name=\"loginForm\" method=\"post\" action=\"ServletRimuovi\">\r\n"
       		+ "    Nome: <input type=\"text\" name=\"nome\"/> <br/>\r\n"
       		+ "    <input type=\"submit\" value=\"CANCELLA\" />\r\n"
       		+ "</form>";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRimuovi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append(form);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Contatto> contatti = JPACriteria.findContatto(request.getParameter("nome"), EntityManagerSingleton.createEntityManager(), 2);
		for(Contatto c : contatti)
			JpaManager.deleteContatto(c, EntityManagerSingleton.createEntityManager());
		response.sendRedirect("http://localhost:8080/turing/mostracontatti.jsp");
	}

}
