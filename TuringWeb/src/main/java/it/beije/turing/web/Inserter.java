package it.beije.turing.web;

import java.io.IOException;
import java.util.List;

import main.java.it.beije.turing.web.RCInsert;
import main.java.it.beije.turing.web.RCViewer;
import it.beije.turing.web.Contatto;
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
@WebServlet("/inserter")
public class Inserter extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private int c;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inserter() {
        super();
        c = 0;
        System.out.println("TestServlet....");
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("inserter_form.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TuringWeb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Contatto contatto = new Contatto();
        contatto.setCognome((String)request.getParameter("surname"));
        contatto.setNome((String)request.getParameter("name"));
        contatto.setEmail((String)request.getParameter("email"));
        contatto.setTelefono((String)request.getParameter("phone"));
        contatto.setNote((String)request.getParameter("notes"));
        RCInsert.insert(entityManager, contatto);
        request.setAttribute("contatto", contatto);
        request.getRequestDispatcher("insert_contatto.jsp").forward(request, response); }

}
