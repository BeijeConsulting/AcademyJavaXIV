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

@WebServlet("/searchsingle")
public class SearchSingleContactServlet extends HttpServlet {


    public SearchSingleContactServlet() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString=request.getParameter("idPar");
         String type=request.getParameter("type");
        Contatto trovato=null;
        try {
            int idPAr=Integer.parseInt(idString);
            OpRubrica opRubrica=new JPAManager();
            List<Contatto> contattos=opRubrica.showContact(Order.NO);
            for (Contatto c:contattos) {
                if(c.getId()==idPAr){
                    trovato=c;
                }
            }
        }catch (NumberFormatException numberFormatException){
            trovato=null;
        }finally {
            HttpSession session= request.getSession();
            System.out.println(trovato);
            session.setAttribute("contatto",trovato);

            String redirect="";
            if(type.equals("edit")){
                redirect="./modifica.jsp";
            }

            if(type.equals("delete")){
                redirect="./delete.jsp";
            }
            response.sendRedirect(redirect);
        }


    }
}