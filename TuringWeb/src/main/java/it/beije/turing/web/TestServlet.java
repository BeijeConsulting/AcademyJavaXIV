package it.beije.turing.web;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//...
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		
		System.out.println("fname : " + fname);
		System.out.println("lname : " + lname);

		response.getWriter().append("<html><body>Served at: ").append(request.getContextPath()).append("<br>").append(LocalDateTime.now().toString()).append("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		
		System.out.println("fname : " + fname);
		System.out.println("lname : " + lname);
		
		response.getWriter().append("<html><body>")
		.append("fname : ").append(fname).append("<br>")
		.append("lname : ").append(lname).append("<br>")
		.append("</body></html>");
	}

}
