package it.beije.turing.web;

/**
 * @author Giuseppe Raddato
 * Data: 27 apr 2022
 */

import it.beije.turing.myRubrica.db.JPAManager;
import it.beije.turing.myRubrica.interfaces.OpRubrica;
import it.beije.turing.rubrica.Contatto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insert")
public class InsertRubrica extends HttpServlet {
    OpRubrica rubrica;
    public InsertRubrica() {
        super();
     rubrica= new JPAManager();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome=request.getParameter("nome");
        String cognome=request.getParameter("cognome");
        String telefono=request.getParameter("tel");
        String email=request.getParameter("email");
        String note=request.getParameter("note");
            Contatto c= new Contatto();
            c.setCognome(cognome);
            c.setNome(nome);
            c.setEmail(email);
            c.setTelefono(telefono);
            c.setNote(note);
            rubrica.insert(c);
            System.out.println(c);
        if(c.getId()!=0){
            response.getWriter().append("Aggiunto Con successo");
        }else {
            response.getWriter().append("Non Aggiunto");
        }
        //doGet(request, response);
    }
}