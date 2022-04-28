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
	private final String jsp = "ModContatto.jsp";
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
		request.getSession().setAttribute("list", link.getList());
		response.sendRedirect(jsp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		if(command.contains(" "))
		{
			String[]tmp=command.split(" ");
			command=tmp[0];
		}
		switch (command) {
		case "back":
			request.getSession().setAttribute("mode", "main");
			response.sendRedirect(jsp);
			break;
			
			
		case "new":
			
			if(request.getParameter("flag")!=null)
				{
				String[] tmp = getForm(request);
					link.add(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4]);
					request.getSession().setAttribute("mode", "main");
				}
			
			else
			request.getSession().setAttribute("mode", "add");
			
			
			response.sendRedirect(jsp);
			break;
			
			
		case "modify":
			//tmp =getForm(request);
			if(request.getParameter("flag") == null)
			{
				response.sendRedirect(jsp);
				
			}
			//else link.modify(Integer.parseInt(tmp[0]),tmp[1],tmp[2],tmp[3],tmp[4],tmp[5]);
			break;
			
			
		case "delete":
			if(request.getParameter("flag") !=null)
			{
				String id=request.getParameter("id");
				if(id!=null)
				{
					link.delete(id);
					request.getSession().setAttribute("mode", "main");
				}
			}
			else
			{
			request.getSession().setAttribute("mode","delete");
			}
			
			response.sendRedirect(jsp);
		default:
			break;
		}
		
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
