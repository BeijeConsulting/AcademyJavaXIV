package it.beije.turing.web;

import it.beije.turing.web.rubrica.Contatto;
import it.beije.turing.web.rubrica.JPACriteriaManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import it.beije.turing.web.TestServlet;

@WebServlet("/rubrica")
public class AggiungiContatto extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("Rubrica doGet");

        List<Contatto> contatti = JPACriteriaManager.getRubrica();

        //...
//		System.out.println("c :" + ++c);
//		String fname = request.getParameter("fname");
//		String lname = request.getParameter("lname");

        HttpSession session = request.getSession();
        System.out.println("session : " + session.getId());

        for (Contatto c:contatti){
            response.getWriter().append(c.toString());
        }




    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("Rubrica doPost");


//        String fname = request.getParameter("fname");
//        String lname = request.getParameter("lname");
//        String telefono = request.getParameter("telefono");
//        String email = request.getParameter("email");
//        String note = request.getParameter("note");
//
////        Contatto contatto = new Contatto();
////        contatto.setNome(fname);
////        contatto.setCognome(lname);
////        contatto.setTelefono(telefono);
////        contatto.setEmail(email);
////        contatto.setNote(note);
////
////        JPACriteriaManager.insertContatto(contatto);
//
//
//
//        System.out.println("fname : " + fname);
//        System.out.println("lname : " + lname);
//        System.out.println("telefono : " + telefono);
//        System.out.println("email : " + email);
//        System.out.println("note : " + note);
//
//        HttpSession session = request.getSession();
//        System.out.println("session : " + session.getId());
//
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
//        session.setAttribute("fname", fname);
//        session.setAttribute("lname", lname);
//        session.setAttribute("telefono", telefono);
//        session.setAttribute("email", email);
//        session.setAttribute("note", note);
//
//
//        response.getWriter().append("<html><body>")
//                .append("fname : ").append(fname).append("<br>")
//                .append("lname : ").append(lname).append("<br>")
//                .append("telefono : ").append(telefono).append("<br>")
//                .append("email : ").append(email).append("<br>")
//                .append("note : ").append(note).append("<br>")
//                .append("</body></html>");
    }
}
