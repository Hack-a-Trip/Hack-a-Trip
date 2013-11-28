package net.tncy.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tncy.database.EMF;
import net.tncy.entity.Travel;

public class DisplayTravelStep1 extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		
		EntityManager em = EMF.getInstance().getEntityManager();

		Travel t = (Travel)em.createNamedQuery("findTravel").setParameter("travelId", Long.valueOf(req.getParameter("id"))).getSingleResult();

		RequestDispatcher rd = null;
		req.setAttribute("travel", t);
		rd = req.getRequestDispatcher("/displayTravelStep1.jsp");
		rd.forward(req, resp);
	}

}
