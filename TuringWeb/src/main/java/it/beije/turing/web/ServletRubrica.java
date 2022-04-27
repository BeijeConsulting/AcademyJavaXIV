package it.beije.turing.web;

import it.beije.turing.myRubrica.db.JPAManager;
import it.beije.turing.myRubrica.interfaces.OpRubrica;
import it.beije.turing.myRubrica.interfaces.Order;
import it.beije.turing.rubrica.Contatto;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rubrica")
public class ServletRubrica extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public ServletRubrica() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
     OpRubrica rubrica= new JPAManager();

        List<Contatto> listC=rubrica.showContact(Order.NO);
        StringBuilder html= new StringBuilder();
        html.append("<html>\n" +
                "<head>\n" +
                "<style>\n" +
                "table, th, td {\n" +
                "  border: 1px solid black;\n" +
                "align:center;"+
                "}\n" +
                "table.center {\n" +
                "  margin-left: auto;\n" +
                "  margin-right: auto;\n" +
                "}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body><H1>I MIEI NUMERI DI TELEFONO</H1>");
        html.append("<table style='width:100%  border:1px solid black'>" +
                "  <tr>\n" +
                "    <th>Numero</th>\n" +
                "    <th>Nome</th>\n" +
                "    <th>Cognome</th>\n" +
                "    <th>email</th>\n" +
                "    <th>telefono</th>\n" +
                "    <th>note</th>\n" +
                "  </tr>\n");
        int i=0;
        for (Contatto t:listC) {
            html.append(
                    "  <tr>\n" +
                    "    <td>"+(++i)+"</td>\n" +
                    "    <td>"+t.getNome()+"</td>\n" +
                    "    <td>"+t.getCognome()+"</td>\n" +
                    "    <td>"+t.getEmail()+"</td>\n" +
                    "    <td>"+t.getTelefono()+"</td>\n" +
                    "    <td>"+t.getNote()+"</td>\n" +
                    "  </tr>\n");
            ;
        }
        html.append("</table>");
        System.out.println("Hello");
        response.getWriter().append(html);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}