package it.beije.turing.web;



import it.beije.turing.web.db.Contatto;
import it.beije.turing.web.db.JPAManager;
import it.beije.turing.web.db.OpRubrica;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cerca")
public class CercaServlet extends HttpServlet {
    public CercaServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search=request.getParameter("parameter");

        OpRubrica op= new JPAManager();
        List<Contatto> c = op.search(search);

        HttpSession s= request.getSession();
        s.setAttribute("risultati",c);
        response.sendRedirect("risultati2.jsp");

    }
}