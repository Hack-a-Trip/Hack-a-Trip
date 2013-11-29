package net.tncy.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tncy.database.EMF;
import net.tncy.entity.Travel;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;

public class DisplayTravel extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{

		EntityManager em = EMF.getInstance().getEntityManager();

		Travel t = (Travel) em.createNamedQuery("findTravel").setParameter("travelId", Long.valueOf(req.getParameter("id"))).getSingleResult();

		List<String> members = (List<String>) em.createNamedQuery("findMembers").setParameter("travelId", Long.valueOf(req.getParameter("id"))).getResultList();
		User user = UserServiceFactory.getUserService().getCurrentUser();

		RequestDispatcher rd = null;

		if (user != null && members.contains(user.getEmail()))
		{
			req.setAttribute("travel", t);
			req.setAttribute("members", members);
			rd = req.getRequestDispatcher("/displayTravel.jsp");
		}
		else
		{
			rd = req.getRequestDispatcher("/");
		}
		rd.forward(req, resp);
	}
}