package net.tncy.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.UserServiceFactory;
import com.google.appengine.labs.repackaged.org.json.JSONException;

import net.tncy.database.EMF;
import net.tncy.entity.Travel;
import net.tncy.entity.Vote;
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
			String idTravel = req.getParameter("idTravel");
			
			int budget = Integer.valueOf(req.getParameter("budget"));
			//FAUT METTRE LA PREMIERE LETTRE EN MAJUSCULE
			char[] char_table = city.toCharArray();
			char_table[0]=Character.toUpperCase(char_table[0]);
			city = new String(char_table);
			//FIN
			
			if (city != null && !city.equals(""))
			{
				try
				{
					EntityManager em = EMF.getInstance().getEntityManager();
					Query q = em.createNamedQuery("findVoteByIdTravelAndByMember");
					q.setParameter("idTravel", idTravel);
					q.setParameter("member", UserServiceFactory.getUserService().getCurrentUser().getEmail());
					List<Vote> listVotes = q.getResultList();
					List<String> listLocationsVotedList = new ArrayList<String>();
					for(Vote v : listVotes)
						listLocationsVotedList.add(v.getIdLocation());

					test = new API_outpost_travel();
					test.getInfoLieux(city,budget);
					test.updateLocationsVoted(listLocationsVotedList);
					
					
					req.setAttribute("detailsTravel", test.getListe_item());
					req.setAttribute("idTravel", idTravel);
					req.setAttribute("budget", req.getParameter("budget"));
					req.setAttribute("listVotes", listVotes);
					
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