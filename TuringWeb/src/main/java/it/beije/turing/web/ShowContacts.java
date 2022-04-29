package main.java.it.beije.turing.web;

import main.java.it.beije.turing.JPAContactsManager.ContactDBManager;
import main.java.it.beije.turing.JPAContactsManager.Contatto;
import org.hibernate.SharedSessionBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/show_contacts")
public class ShowContacts extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowContacts() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        //		Contatto contatto = new Contatto();
//		contatto.setNome("Pippo");
//		contatto.setCognome("Rossi");
//
//		request.getSession().setAttribute("contatto", contatto);

        List<Contatto> contatto = ContactDBManager.ShowContacts();

        request.getSession().setAttribute("contatto", contatto);
        response.sendRedirect("show.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}