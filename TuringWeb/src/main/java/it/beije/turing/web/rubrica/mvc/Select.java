package it.beije.turing.web.rubrica.mvc;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
* Servlet implementation class TestServlet
*/
@WebServlet("/select")
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int c;
     
  /**
   * @see HttpServlet#HttpServlet()
   */
  public Select() {
      super();
      c = 0;
      System.out.println("Select....");
    
  }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("select doGet");
		
	
		HttpSession session = request.getSession();
		
		System.out.println("session : " + session.getId());
		

	
		String query = request.getParameter("query");
		
		System.out.println(query);
		
		JPARubricaManager.select(query);
		
		
		response.sendRedirect("show.jsp");

		response.getWriter().append("<html><body>Served at: ").append(request.getContextPath()).append("<br>").append("ID : ").append(session.getId()).append("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("rubrica doPost");
		
		
	}
	}