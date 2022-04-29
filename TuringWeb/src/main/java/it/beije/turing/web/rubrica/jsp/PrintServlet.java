package it.beije.turing.web.rubrica.jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.turing.web.rubrica.RubricaManager;

/**
 * Servlet implementation class PrintServlet
 */
@WebServlet("/print_servlet")
public class PrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		//RubricaManager rm = (RubricaManager)session.getAttribute("rubricaManager");
		RubricaManager rm = new RubricaManager();
		String value = request.getParameter("type");
		if (value == null) {
			value = "N";
		}
		rm.setAllContatti(rm.sort(rm.getAllContatti(), value));
		if (value.toUpperCase().startsWith("N")) {
			System.out.print("Contatti ordinati per nome");
		}else if (value.toUpperCase().startsWith("S")) {
			System.out.print("Contatti ordinati per cognome");
		}
		session.setAttribute("allContatti", rm.getAllContatti());
		response.sendRedirect("./print.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
