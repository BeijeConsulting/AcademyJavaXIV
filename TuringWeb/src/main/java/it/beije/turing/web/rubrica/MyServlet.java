//
//package it.beije.turing.web.rubrica;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class MyServlet
// */
//@WebServlet("/servlet")
//public class MyServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public MyServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		System.out.println("MyServlet doGet");
//		Contatto contatto = new Contatto();
//		
////		request.getSession().setAttribute("contatto", contatto);
//		
//		response.sendRedirect("insert_contatto.jsp");
//		
//		
////				contatto.setCognome("Rossi");
//		
//		
////		System.out.println("nome " + contatto.getNome());
////		System.out.println("cognome " + contatto.getCognome());
//
//		
//		
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
//
