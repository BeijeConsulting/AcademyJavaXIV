package it.beije.turing.web.controller;


import it.beije.turing.web.db.Contatto;
import it.beije.turing.web.db.JPAManager;
import it.beije.turing.web.db.OpRubrica;
import it.beije.turing.web.db.Order;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/showall")
public class AllContactsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public AllContactsServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        String ordina = request.getParameter("ordina");
        Order chose = Order.NO;
        if (ordina != null && !ordina.isEmpty()){
            switch (ordina) {
                case "nessuno":
                    chose = Order.NO;
                    break;
                case "nome":
                    chose = Order.NOME;
                    break;
                case "cognome":
                    chose = Order.COGNOME;
                    break;
                default:
                    chose = Order.NO;
                    break;
            }
        }

        OpRubrica op= new JPAManager();
        List<Contatto> c = op.showContact(chose);
        HttpSession s= request.getSession();
        s.setAttribute("risultati",c);
        s.setAttribute("order",chose);
        System.out.println(chose);
        response.sendRedirect("mostratutti.jsp");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}