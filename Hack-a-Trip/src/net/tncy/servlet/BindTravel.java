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
import net.tncy.hackatrip.InvitationMail;
import net.tncy.tool.User;

public class BindTravel extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		
		if(User.isConnected(req.getSession()))
		{
			Bind b = new Bind();
			b.setTravel(Long.valueOf(req.getParameter("id")));
			b.setMember(req.getParameter("email"));
			b.setOwner(false);
			EntityManager em = EMF.getInstance().getEntityManager();
			em.getTransaction().begin();
			em.persist(b);
			em.getTransaction().commit();
			
			Travel t = (Travel)em.createNamedQuery("findTravel").setParameter("travelId", Long.valueOf(req.getParameter("id"))).getSingleResult();
			InvitationMail.send(req.getParameter("email"), t);
			resp.sendRedirect("/DisplayTravel?id="+t.getId());
		}
		else
		{
			rd = req.getRequestDispatcher("/");
			req.setAttribute("error","e1");
			rd.forward(req, resp);
		}
	}
	
}
