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
@WebServlet("/ServletRubrica")
public class ServletRubrica extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ADD = "<form name=\"loginForm\" method=\"get\" action=\"ServletAggiungi\">\r\n"
       		+ "    <input type=\"submit\" value=\"Aggiungi Contatto\" />\r\n"
       		+ "</form>";
	
	private static final String SHOW = "<form name=\"loginForm\" method=\"get\" action=\"ServletMostra\">\r\n"
       		+ "    <input type=\"submit\" value=\"Mostra Contatti\" />\r\n"
       		+ "</form>";
	
	private static final String FIND = "<form name=\"loginForm\" method=\"get\" action=\"ServletTrova\">\r\n"
       		+ "    <input type=\"submit\" value=\"Trova Contatti\" />\r\n"
       		+ "</form>";
	
	private static final String DELETE = "<form name=\"loginForm\" method=\"get\" action=\"ServletRimuovi\">\r\n"
       		+ "    <input type=\"submit\" value=\"Cancella Contatti\" />\r\n"
       		+ "</form>";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRubrica() {
        super();
        System.out.println("TestServletRubrica....");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("<html><body>").append(ADD).append("<html><body>");
		response.getWriter().append("<html><body>").append(SHOW).append("<html><body>");
		response.getWriter().append("<html><body>").append(FIND).append("<html><body>");
		response.getWriter().append("<html><body>").append(DELETE).append("<html><body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
