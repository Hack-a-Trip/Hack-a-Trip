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

import com.google.appengine.api.users.UserServiceFactory;

public class BindTravel extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Bind b = new Bind();
		b.setTravel(Long.valueOf(req.getParameter("id")));
		b.setMember(req.getParameter("email"));
		b.setOwner(false);
		EntityManager em = EMF.getInstance().getEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		
		Travel t = (Travel)em.createNamedQuery("findTravel").setParameter("travelId", Long.valueOf(req.getParameter("id"))).getSingleResult();

		List<String> members = (List<String>)em.createNamedQuery("findMembers").setParameter("travelId", Long.valueOf(req.getParameter("id"))).getResultList();
		
		
		req.setAttribute("travel", t);
		req.setAttribute("members", members);
		RequestDispatcher rd = req.getRequestDispatcher("/displayTravel.jsp");
		rd.forward(req, resp);
		
		
		
	}
	
}
