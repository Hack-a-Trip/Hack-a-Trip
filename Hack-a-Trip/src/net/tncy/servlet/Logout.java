package net.tncy.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Logout extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		RequestDispatcher rd = null;
		
		req.getSession().invalidate();
        rd = req.getRequestDispatcher("/index.jsp");
		
		rd.forward(req, resp);
	}
}
