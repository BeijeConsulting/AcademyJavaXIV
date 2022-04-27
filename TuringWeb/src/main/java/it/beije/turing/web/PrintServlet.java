package it.beije.turing.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.turing.web.rubrica.Contatto;
import it.beije.turing.web.rubrica.JPAcriteriaManager;

/**
 * Servlet implementation class Stampa
 */
@WebServlet("/print")
public class PrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Stampa contatti");
		
		List<Contatto> contatti = JPAcriteriaManager.getRubrica();
		
		StringBuilder build = new StringBuilder();
		
		build.append("<!DOCTYPE html>"
				+ "<html>"
				+ "	<head>"
				+ "		<meta charset=\"ISO-8859-1\">"
				+ "		<title>Beije Stampa Rubrica</title>"
				+ "		<style type=\"text/css\">"
				+ "			h1 {"
				+ "				text-align:center;"
				+ "			}"
				+ "			table {"
				+ "				width: 50%;"
				+ "				margin:auto;"
				+ "			}"
				+ "			input {"
				+ "				display:block;"
				+ "				width:200px;"
				+ "				margin: 20px auto;"
				+ "				padding:10px;"
				+ "				font-size:20px;"
				+ "				border-radius:10px;"
				+ "				box-shadow: 0px 2px 5px gray;"
				+ "				border: none;"
				+ "				border: 1px solid black;"
				+ "			}"
				+ "		</style>"
				+ " <head>"
				+ "	<body>"
				+ "		<h1>Stampa rubrica</h1>"
				+ "		<table>"
				+ "  		<tr>"
				+ "    			<th>Id</th>"
				+ "    			<th>Nome</th>"
				+ "    			<th>Cognome</th>"
				+ "				<th>Indirizzo</th>"
				+ "				<th>Data di nascita</th>"
				+ "				<th>Email</th>"
				+ "				<th>Telefono</th>"
				+ "				<th>Note</th>"
				+ "  		</tr>");
		
		for(Contatto contatto : contatti) {
			build.append("<tr>\"\n"
					+ "    			<td>"+contatto.getId()+"</td>"
					+ "    			<td>"+contatto.getNome()+"</td>"
					+ "    			<td>"+contatto.getCognome()+"</td>"
					+ "				<td>"+contatto.getIndirizzo()+"</td>"
					+ "				<td>"+contatto.getDataDiNascita()+"</td>"
					+ "				<td>"+contatto.getEmail()+"</td>"
					+ "				<td>"+contatto.getTelefono()+"</td>"
					+ "				<td>"+contatto.getNote()+"</td>"
					+ "  		</tr>");
		}
		
		build.append("</table>"
				+ "	<form action=\"/TuringWeb\">\n"
				+ "		<input type=\"submit\" value=\"Ritorna alla home\">"
				+ "	</form>"
				+ "	</body>"
				+ "</html>");
		
		response.getWriter().append(build.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
