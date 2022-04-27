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
		System.out.println("TestServlet doGet");
		//...
//		System.out.println("c :" + ++c);
//		String fname = request.getParameter("fname");
//		String lname = request.getParameter("lname");

		HttpSession session = request.getSession();
		System.out.println("session : " + session.getId());
		String fname = (String)session.getAttribute("fname");
		String lname = (String)session.getAttribute("lname");	
		System.out.println("fname : " + fname);
		System.out.println("lname : " + lname);
		

		response.getWriter().append("<html><body>Served at: ").append(request.getContextPath()).append("<br>").append("ID : ").append(session.getId()).append("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TestServlet doPost");
		// TODO Auto-generated method stub
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		System.out.println("fname : " + fname);
		System.out.println("lname : " + lname);
		
		HttpSession session = request.getSession();
		System.out.println("session : " + session.getId());
		session.setAttribute("fname", fname);
		session.setAttribute("lname", lname);

		
		response.getWriter().append("<html><body>")
		.append("fname : ").append(fname).append("<br>")
		.append("lname : ").append(lname).append("<br>")
		.append("</body></html>");
	}

}
