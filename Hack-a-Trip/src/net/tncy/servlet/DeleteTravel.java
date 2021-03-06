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
import net.tncy.entity.Bind;
import net.tncy.entity.Travel;
import net.tncy.tool.User;

public class DeleteTravel extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		RequestDispatcher rd = null;
		
		if(User.isConnected(req.getSession()))
		{
			EntityManager em = EMF.getInstance().getEntityManager();
			Travel t = (Travel) em.createNamedQuery("findTravel").setParameter("travelId", Long.valueOf(req.getParameter("id"))).getSingleResult();
	
			List<Bind> binds = em.createNamedQuery("findBind").setParameter("travelId", Long.valueOf(req.getParameter("id"))).getResultList();
	
			for (int i = 0; i < binds.size(); i++)
			{
				em.getTransaction().begin();
				em.remove(binds.get(i));
				em.getTransaction().commit();
			}
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
	
			resp.sendRedirect("/");
		}
		else
		{
			rd = req.getRequestDispatcher("/");
			req.setAttribute("error","e1");
			rd.forward(req, resp);
		}
	}

}