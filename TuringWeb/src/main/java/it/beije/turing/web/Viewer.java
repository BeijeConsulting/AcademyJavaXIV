package it.beije.turing.web;

import java.io.IOException;
import java.util.List;

import main.java.it.beije.turing.web.RCViewer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/viewer")
public class Viewer extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private int c;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Viewer() {
        super();
        c = 0;
        System.out.println("TestServlet....");
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("viewer_form.jsp");
       }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TuringWeb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String command = (String)request.getParameter("order");
        List<it.beije.turing.web.Contatto> contatti = RCViewer.view(entityManager, command);
        request.setAttribute("contatti",contatti);
        request.getRequestDispatcher("view_contatto.jsp").forward(request, response); }

}
