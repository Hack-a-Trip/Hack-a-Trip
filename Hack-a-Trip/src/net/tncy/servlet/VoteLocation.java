package net.tncy.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserServiceFactory;

import net.tncy.database.EMF;
import net.tncy.entity.Travel;
import net.tncy.entity.Vote;
import net.tncy.tool.User;

public class VoteLocation extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		RequestDispatcher rd = null;
		if(User.isConnected(req.getSession()))
		{
			String idTravel = req.getParameter("idTravel");
			String idLocation = req.getParameter("idLocation");
			String city = req.getParameter("city");
			String member = UserServiceFactory.getUserService().getCurrentUser().getEmail();
			String budget = req.getParameter("budget");
			String action = req.getParameter("action");
			EntityManager em = EMF.getInstance().getEntityManager();
			
			if(action.equals("vote"))
			{
				em.getTransaction().begin();
				Vote v = new Vote();
				v.setIdTravel(idTravel);
				v.setIdLocation(idLocation);
				v.setMember(member);
				em.persist(v);
				em.getTransaction().commit();
				
				req.setAttribute("idTravel", idTravel);
				req.setAttribute("city", city);
				req.setAttribute("budget", budget);
				
				rd = req.getRequestDispatcher("/DisplayDetailsTravel");
			}
			// On annule le vote
			else
			{
				Query q = em.createNamedQuery("findVoteByIdTravelAndByMember");
				q.setParameter("idTravel", idTravel);
				q.setParameter("member", UserServiceFactory.getUserService().getCurrentUser().getEmail());
				List<Vote> listVotes = q.getResultList();
				em.getTransaction().begin();
				em.remove(listVotes.get(0));
				em.getTransaction().commit();
				
				req.setAttribute("idTravel", idTravel);
				req.setAttribute("city", city);
				req.setAttribute("budget", budget);
				
				rd = req.getRequestDispatcher("/DisplayDetailsTravel");
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
