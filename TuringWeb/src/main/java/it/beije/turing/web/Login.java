package main.java.it.beije.turing.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
    private String name, surname, output;
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        File db = new File("C:\\Users\\gemel\\OneDrive\\Desktop\\EsercitazzioniPSR\\11.6PSR\\WebContent\\db");
        FileInputStream fis = new FileInputStream(db);
        Scanner scanfis = new Scanner(fis);

        String line = scanfis.nextLine();
        if (line.startsWith("N"))
            name = line.substring(5).trim();
        line = scanfis.nextLine();
        if (line.startsWith("C"))
            surname = line.substring(9).trim();

        /*
         * @WebServlet ("/protected/welcome") manda in esecuzione la servlet welcome
         * solo se si mette quell'url
         * il 12.4 si deve cambiare solo il codice del filtro (fare getSession sul messaggio di richiesta)
         */

        PrintWriter pw = res.getWriter();
        boolean login = pw.equals(surname);
        if (login) {
            Cookie c = new Cookie("AuthToken", "0192837465");
            c.setMaxAge(100);
        }

        if (name.equalsIgnoreCase(req.getParameter("firstname"))
                && surname.equalsIgnoreCase(req.getParameter("lastname"))) {
            output = "<HTML>" + "<HEAD>" + "<TITLE>" + "Login" + "</TITLE>" + "</HEAD>" + "<BODY>" + "<H2>"
                    + req.getParameter("firstname") + " complimenti, accesso avvenuto con successo." + "</H2>"
                    + "</BODY>" + "</HTML>";
        } else {
            output = "<HTML>" + "<HEAD>" + "<TITLE>" + "Login" + "</TITLE>" + "</HEAD>" + "<BODY>" + "<H2>"
                    + req.getParameter("firstname") + " spiacenti, accesso non avvenuto con successo." + "</H2>"
                    + "</BODY>" + "</HTML>";
        }

        pw.print(output);
        pw.flush();
    }

}
