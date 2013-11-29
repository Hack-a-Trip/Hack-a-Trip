package net.tncy.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.labs.repackaged.org.json.JSONException;

import net.tncy.hackatrip.API_outpost_travel;
import net.tncy.tool.User;

@SuppressWarnings("serial")
public class DisplayDetailsTravel extends HttpServlet
{
	API_outpost_travel test;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		RequestDispatcher rd = null;
		
		if(User.isConnected(req.getSession()))
		{
			String city = req.getParameter("city");
			if (city != null && !city.equals(""))
			{
				try
				{
					test = new API_outpost_travel();
					test.getInfoLieux(city);
					req.setAttribute("detailsTravel", test.getListe_item());
					rd = req.getRequestDispatcher("/displayDetailsTravel.jsp");
				}
				catch (JSONException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				rd = req.getRequestDispatcher("/index.jsp");
			}
		}
		else
		{
			req.setAttribute("error", "e1");
			rd = req.getRequestDispatcher("/index.jsp");
		}

		rd.forward(req, resp);
	}
}