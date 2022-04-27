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
	private static final String form = "<form name=\"loginForm\" method=\"post\" action=\"ServletAggiungi\">\r\n"
       		+ "    <input type=\"submit\" value=\"AggiungiContatto\" />\r\n"
       		+ "</form>";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRubrica() {
        super();
        System.out.println("TestServletRubrica....");
        System.out.println("TestServletRubrica....");
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
		response.getWriter().append("<html><body>").append(form).append("<html><body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
