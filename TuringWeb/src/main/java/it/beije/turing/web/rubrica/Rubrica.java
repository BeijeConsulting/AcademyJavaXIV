//package it.beije.turing.web.rubrica;
//
//import java.io.IOException;
//import java.time.LocalDateTime;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import it.beije.turing.web.rubrica.Contatto;
//
///**
// * Servlet implementation class TestServlet
// */
//@WebServlet("/test")
//public class Rubrica extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	
//	private int c;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public Rubrica() {
//        super();
//        c = 0;
//        System.out.println("TestServlet....");
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("TestServlet doGet");
//		//...
////		System.out.println("c :" + ++c);
////		String fname = request.getParameter("fname");
////		String lname = request.getParameter("lname");
//
//		HttpSession session = request.getSession();
//		System.out.println("session : " + session.getId());
//		
//		String nome = (String)session.getAttribute("nome");
//		String cognome = (String)session.getAttribute("cognome");	
//		String telefono = (String)session.getAttribute("telefono");
//		String email = (String)session.getAttribute("email");	
//		String note = (String)session.getAttribute("note");
//		
//		
//	
//		System.out.println("nome : " + nome);
//		System.out.println("cognome : " + cognome);
//		System.out.println("telefono : " + telefono);
//		System.out.println("email : " + email);
//		System.out.println("note : " + note);
//		
//		
//		
//
//		response.getWriter().append("<html><body>Served at: ").append(request.getContextPath()).append("<br>").append("ID : ").append(session.getId()).append("</body></html>");
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("TestServlet doPost");
//		// TODO Auto-generated method stub
//		String nome = request.getParameter("nome");
//		String cognome = request.getParameter("cognome");
//		String telefono = request.getParameter("telefono");
//		String email = request.getParameter("email");
//		String note = request.getParameter("note");
//		
//		
//		Contatto c = new Contatto();
//		c.setNome(nome);
//		c.setCognome(cognome);
//		c.setTelefono(telefono);
//		c.setEmail(email);
//		c.setNote(note);
//		
//		JPARubricaManager.insert(c);
//		
//		System.out.println("nome : " + nome);
//		System.out.println("cognome : " + cognome);
//		System.out.println("telefono : " + telefono);
//		System.out.println("email : " + email);
//		System.out.println("note : " + note);
//		
//		HttpSession session = request.getSession();
//		System.out.println("session : " + session.getId());
//		session.getAttribute("nome");
//		session.getAttribute("cognome");	
//		session.getAttribute("telefono");
//		session.getAttribute("email");	
//		session.getAttribute("note");
//
//		
//		response.getWriter().append("<html><body>")
//		.append("nome : ").append(nome).append("<br>")
//		.append("cognome : ").append(cognome).append("<br>")
//		.append("telefono : ").append(telefono).append("<br>")
//		.append("email : ").append(email).append("<br>")
//		.append("note : ").append(note).append("<br>")
//		.append("</body></html>");
//	}
//
//}