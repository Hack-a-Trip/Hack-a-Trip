package net.tncy.hackatrip;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.http.*;

import net.tncy.database.EMF;
import net.tncy.entity.Person;

@SuppressWarnings("serial")
public class Hack_a_TripServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		Person p = new Person();
		p.setFirstName("OLAF PD");
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
}
