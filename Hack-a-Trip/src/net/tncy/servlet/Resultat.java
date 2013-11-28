package net.tncy.servlet;

import java.io.IOException;
import java.util.ArrayList;


import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.*;

import com.google.appengine.labs.repackaged.org.json.JSONException;

import net.tncy.hackatrip.API_outpost_travel;

@SuppressWarnings("serial")
public class Resultat extends HttpServlet
{
	API_outpost_travel test;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		try {
			test = new API_outpost_travel();
			test.getInfoLieux("Paris");
			/*test.getInfoExperiences("Paris");
			resp.setContentType("text/plain");
			resp.getWriter().println(test.getP().toString("place"));*/
			RequestDispatcher rd = null;
			req.setAttribute("liste_item", test.getListe_item());
			rd = req.getRequestDispatcher("/resultat.jsp");
			rd.forward(req, resp);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}