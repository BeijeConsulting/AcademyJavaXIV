package it.beije.turing.web;

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
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int c;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        c = 0;
        System.out.println("TestServlet....");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		System.out.println("TestServlet doGet");
		//...
//		System.out.println("c :" + ++c);
//		String fname = request.getParameter("fname");
//		String lname = request.getParameter("lname");

		HttpSession session = request.getSession();

		System.out.println("session : " + session.getId());
		String fname = (String)session.getAttribute("fname");
		String lname = (String)session.getAttribute("lname");
		String telefono = (String)session.getAttribute("telefono");
		String email = (String)session.getAttribute("email");
		String note = (String)session.getAttribute("note");

		System.out.println("fname : " + fname);
		System.out.println("lname : " + lname);
		System.out.println("telefono : " + telefono);
		System.out.println("email : " + email);
		System.out.println("note : " + note);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
		

		response.getWriter().append("<html><body>Served at: ").append(request.getContextPath()).append("<br>").append("ID : ").append(session.getId()).append("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		System.out.println("TestServlet doPost");

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String note = request.getParameter("note");


		
		System.out.println("fname : " + fname);
		System.out.println("lname : " + lname);
		System.out.println("telefono : " + telefono);
		System.out.println("email : " + email);
		System.out.println("note : " + note);
		
		HttpSession session = request.getSession();
		System.out.println("session : " + session.getId());

		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
		session.setAttribute("fname", fname);
		session.setAttribute("lname", lname);
		session.setAttribute("telefono", telefono);
		session.setAttribute("email", email);
		session.setAttribute("note", note);


		response.getWriter().append("<html><body>")
		.append("fname : ").append(fname).append("<br>")
		.append("lname : ").append(lname).append("<br>")
		.append("telefono : ").append(telefono).append("<br>")
		.append("email : ").append(email).append("<br>")
		.append("note : ").append(note).append("<br>")
		.append("</body></html>");
	}

}
