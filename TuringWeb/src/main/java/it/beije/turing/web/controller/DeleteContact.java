package it.beije.turing.web.controller;

import it.beije.turing.web.db.Contatto;
import it.beije.turing.web.db.JPAManager;
import it.beije.turing.web.db.OpRubrica;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteContact extends HttpServlet {
    public DeleteContact() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OpRubrica opRubrica= new JPAManager();
        int  id= Integer.parseInt(request.getParameter("ID"));
        String nome=request.getParameter("nome");
        String cognome=request.getParameter("cognome");
        String telefono=request.getParameter("tel");
        String email=request.getParameter("email");
        String note=request.getParameter("note");

        Contatto c= new Contatto();
        c.setId(id);
        c.setCognome(cognome);
        c.setNome(nome);
        c.setEmail(email);
        c.setTelefono(telefono);
        c.setNote(note);


        System.out.println(c);
        opRubrica.deleteContatto(c);
        response.getWriter().append("Contatto Cancellato Con successo");
    }
}