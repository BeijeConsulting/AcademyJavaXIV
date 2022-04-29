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
	private int a = 0;
//       private static final String form = "<form name=\"loginForm\" method=\"post\" action=\"ServletAggiungi\">\r\n"
//       		+ "    Nome: <input type=\"text\" name=\"nome\"/> <br/>\r\n"
//       		+ "    Cognome: <input type=\"text\" name=\"cognome\"/> <br/>\r\n"
//       		+ "    Telefono: <input type=\"text\" name=\"telefono\"/> <br/>\r\n"
//       		+ "    Email: <input type=\"text\" name=\"email\"/> <br/>\r\n"
//       		+ "    Note: <input type=\"text\" name=\"note\"/> <br/>\r\n"
//       		+ "    <input type=\"submit\" value=\"Login\" />\r\n"
//       		+ "</form>";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAggiungi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.getWriter().append("<html><body>").append(form).append("<html><body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("TestServlet doPost");
		// TODO Auto-generated method stub
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
		
		
		//HttpSession session = request.getSession();
		//session.setAttribute("fname", fname);
		//session.setAttribute("lname", lname);
		//response.getWriter().append("<html><body>Contatto inserito: <br>").append(contatto.toString()).append("<html><body>");

		
	}

}
