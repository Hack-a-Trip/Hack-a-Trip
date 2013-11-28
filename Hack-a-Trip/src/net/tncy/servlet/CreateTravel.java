package net.tncy.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class CreateTravel extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		RequestDispatcher rd = null;
		
		req.getSession().setAttribute("connected", "true");
        if (net.tncy.tool.User.isConnected(req.getSession()))
        {
        	rd = req.getRequestDispatcher("/createTravel.jsp");
        }
        else
        {
        	rd = req.getRequestDispatcher("/index.html");
        }
        
        rd.forward(req, resp);
	}
}
