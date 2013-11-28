package net.tncy.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.http.*;

import com.google.appengine.labs.repackaged.org.json.JSONException;

import net.tncy.database.EMF;
import net.tncy.entity.Person;
import net.tncy.hackatrip.API_outpost_travel;

@SuppressWarnings("serial")
public class Resultat extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		try {
			API_outpost_travel test = new API_outpost_travel();
			test.getInfoLieux("Paris");
			test.getInfoExperiences("Paris");
			resp.setContentType("text/plain");
			resp.getWriter().println(test.getA().toString("activite"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}