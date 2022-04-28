package main.java.it.beije.turing.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        File db = new File("C:\\Users\\gemel\\OneDrive\\Desktop\\EsercitazzioniPSR\\11.6PSR\\WebContent\\db");
        FileOutputStream fos = new FileOutputStream(db);
        PrintStream ps = new PrintStream(fos);
        ps.println("Nome: " + req.getParameter("firstname"));
        ps.println("Cognome: " + req.getParameter("lastname"));
        ps.println("Email: " + req.getParameter("email"));
        ps.println("Username: " + req.getParameter("user"));
        ps.println("Password: " + req.getParameter("pw"));

        ps.close();
        String firstname = req.getParameter("firstname");
        res.setContentType("text/plain; charset=utf-8");
        PrintWriter pw = res.getWriter();
        pw.print(firstname + ", la tua registrazione è avvenuta con successo.");
        pw.flush(); // svuotamento del buffer utilizzato
    }

}
