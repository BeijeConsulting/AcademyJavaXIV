package it.beije.turing.web;
import it.beije.turing.web.rubrica.Contatto;
import it.beije.turing.web.rubrica.JPACriteriaManager;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/delete")
public class DeleteContatto extends HttpServlet{

    public DeleteContatto() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("TestServlet doGet");
        HttpSession session = request.getSession();

        response.getWriter().append("<html><body>Served at: ").append(request.getContextPath()).append("<br>").append("ID : ").append(session.getId()).append("</body></html>");

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TestServlet doPost");

        int id = Integer.parseInt(request.getParameter("id"));


        System.out.println("id : " + id);


        HttpSession session = request.getSession();
        System.out.println("session : " + session.getId());
        List<Contatto> contatti = JPACriteriaManager.getRubrica();
        String fname = null, lname = null, email = null, telefono = null, note = null;
        for (Contatto c:contatti){
            if (c.getId()==id){
                fname = c.getNome();
                lname = c.getCognome();
                email = c.getEmail();
                telefono = c.getTelefono();
                note = c.getNote();

            }
        }

        session.setAttribute("id", id);

        JPACriteriaManager.deleteDB(id);
        response.getWriter().append("<html><body>")
                .append("Contatto eliminato : <br>")
                .append("fname : ").append(fname).append("<br>")
                .append("lname : ").append(lname).append("<br>")
                .append("telefono : ").append(telefono).append("<br>")
                .append("email : ").append(email).append("<br>")
                .append("note : ").append(note).append("<br>")
                .append("<div class=\"container\">\n" +
                        "    <form action=\"../TuringWeb\" method=\"post\"><input type=\"submit\" value=\"Torna indietro\">\n" +
                        "    </form>\n" +
                        "</div></body></html>");
    }
}
