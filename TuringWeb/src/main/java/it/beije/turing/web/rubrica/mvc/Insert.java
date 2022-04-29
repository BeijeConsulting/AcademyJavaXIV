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
@WebServlet("/insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int c;
     
  /**
   * @see HttpServlet#HttpServlet()
   */
  public Insert() {
      super();
      c = 0;
      System.out.println("Insert....");
    
  }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("insert doGet");
		
	//	String fname = request.getParameter("fname");
	//	String lname = request.getParameter("lname");
	
		HttpSession session = request.getSession();
		
		System.out.println("session : " + session.getId());
		

	
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String note = request.getParameter("note");	
		
		Contatto contatto = new Contatto();
		
		contatto.setNome(nome);
		
		contatto.setCognome(cognome);
		
		contatto.setTelefono(telefono);
		
		contatto.setEmail(email);
		
		contatto.setNote(note);
		
		JPARubricaManager.insert(contatto);
		
		System.out.println("contatto  " + contatto.toString());
		
	
	//	response.getWriter().append("<html><body>Served at: ")
	//	.append(request.getContextPath())
	//	.append("<br>").append("ID : ")
	//	.append(session.getId()).append("</body></html>");
		
		
		response.sendRedirect("show.jsp");

		response.getWriter().append("<html><body>Served at: ").append(request.getContextPath()).append("<br>").append("ID : ").append(session.getId()).append("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("rubrica doPost");
		// TODO Auto-generated method stub
		
		
		
		
//		String nome = request.getParameter("contatto");
//		
//
//		System.out.println("nome: " + nome);
//	
//		
//		HttpSession session = request.getSession();
//		
//		System.out.println("session : " + session.getId());
//		
//		session.setAttribute("name", nome);
//		
//		System.out.println("nome " + nome);

	
		
	//	response.getWriter().append("<html><body>")
	//	.append("fname : ").append(fname).append("<br>")
	//	.append("lname : ").append(lname).append("<br>")
	//	.append("</body></html>");
	
		response.sendRedirect("example.jsp");
		
		
	}
	}