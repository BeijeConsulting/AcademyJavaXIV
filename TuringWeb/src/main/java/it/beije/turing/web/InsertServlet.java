package it.beije.turing.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.turing.web.rubrica.Contatto;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		StringBuilder build = new StringBuilder();
		
		build.append("<!DOCTYPE html>"
				+ "<html>"
				+ "	<head>"
				+ "		<meta charset=\"ISO-8859-1\">"
				+ "		<title>Beije Stampa Rubrica</title>"
				+ "		<style type=\"text/css\">"
				+ "			h1, label {"
				+ "				text-align:center;"
				+ "			}"
				+ "			label {"
				+ "				display:block;"
				+ "				font-size:20px;"
				+ "			}"
				+ "			.container {"
				+ "				width: 55%;"
				+ "				margin:auto;"
				+ "			}"
				+ "			input {"
				+ "				display:block;"
				+ "				width:200px;"
				+ "				margin: 10px auto;"
				+ "				padding:10px;"
				+ "				font-size:15px;"
				+ "				border-radius:10px;"
				+ "				box-shadow: 0px 2px 5px gray;"
				+ "				border: none;"
				+ "				border: 1px solid black;"
				+ "			}"
				+ "		</style>"
				+ " <head>"
				+ "	<body>"
				+ "		<h1>Inserisci contatto</h1>"
				+ "		<div class=\"container\">"
				+ "			<form action=\"/insert\" method\"post\">"
				+ "				<label for=\"name\">Nome</label><br>\n"
				+ "  			<input type=\"text\" id=\"name\" name=\"name\" value=\"\"><br>\n"
				+ "  			<label for=\"surname\">Cognome</label><br>\n"
				+ "  			<input type=\"text\" id=\"surname\" name=\"surname\" value=\"\"><br>"
				+ "				<label for=\"address\">Indirizzo</label><br>\n"
				+ "  			<input type=\"text\" id=\"address\" name=\"address\" value=\"\"><br>\n"
				+ "  			<label for=\"birthday\">Data di nascita</label><br>\n"
				+ "  			<input type=\"text\" id=\"birthday\" name=\"birthday\" value=\"\"><br>"
				+ "				<label for=\"email\">Email</label><br>\n"
				+ "  			<input type=\"text\" id=\"email\" name=\"email\" value=\"\"><br>\n"
				+ "  			<label for=\"phone\">Telefono</label><br>\n"
				+ "  			<input type=\"text\" id=\"phone\" name=\"phone\" value=\"\"><br>"
				+ "				<label for=\"notes\">Note</label><br>\n"
				+ "  			<input type=\"text\" id=\"notes\" name=\"notes\" value=\"\"><br>\n"
				+ "				<input type=\"submit\" class=\"esc\" value=\"Aggiungi Contatto\">"
				+ "			</form>"
				+ "		</div>"
				+ "	</body>"
				+ "</html>");
		
		response.getWriter().append(build.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Contatto contatto = new Contatto();
		
		contatto.setNome(request.getParameter("name"));
	}

}
