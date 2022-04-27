package it.beije.turing.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.turing.web.rubrica.CommandInterface;

/**
 * Servlet implementation class NewServlet
 */
@WebServlet("/main")
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommandInterface link;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
        link=CommandInterface.getInstance();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("<html><body><center><h>commands: print, new, modify</h><form action=\"./main\" method=\"post\">\r\n"
				+ "  <input type=\"text\" id=\"command\" name=\"command\" value=\"\"><br><br>\r\n"
				+ "  <input type=\"submit\" value=\"Submit\">\r\n"
				+ "</form></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		String id = null;
		if(command.contains(" "))
		{
			String[]tmp=command.split(" ");
			command=tmp[0];
			id=tmp[1];
		}
		switch (command) {
		case "print":
			response.getWriter().append("<html><body><center>")
			.append("<br>").append(link.print()).append("</center></body></html>");
			break;
		case "new":
			String[] tmp =getForm(request);
			if(request.getParameter("flag") == null)
			{
				response.sendRedirect("AddContatto.html");
			}
			else link.add(tmp[0],tmp[1],tmp[2],tmp[3],tmp[4]);
			break;
		case "modify":
			if(id!=null) {
			tmp =getForm(request);
			if(request.getParameter("flag") == null)
			{
				response.getWriter().append(makeForm());			
			}
			else link.add(tmp[0],tmp[1],tmp[2],tmp[3],tmp[4]);
			}
			break;
		default:
			break;
		}
		
		doGet(request, response);
	}

	private String makeForm() {
		return null;
		// TODO Auto-generated method stub
		
	}

	private String[] getForm(HttpServletRequest req)
	{
		String[] tmp = new String[5];
		tmp[0]=req.getParameter("nome");
		tmp[1]=req.getParameter("cognome");
		tmp[2]=req.getParameter("telefono");
		tmp[3]=req.getParameter("email");
		tmp[4]=req.getParameter("note");
		for(String s:tmp)
		{
			if(s==null)
			{
				s="";
			}
		}
		return tmp;
		
	}

	
}
