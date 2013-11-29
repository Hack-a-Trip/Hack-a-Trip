package net.tncy.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class CreateTravel extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		RequestDispatcher rd = null;
		if(User.isConnected(req.getSession()))
		{
	        if (net.tncy.tool.User.isConnected(req.getSession()))
	        {
	        	rd = req.getRequestDispatcher("/createTravel.jsp");
	        }
	        else
	        {
	        	req.setAttribute("error", "e1");
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
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		RequestDispatcher rd = null;
		String nameForm = req.getParameter("name");
		String cityForm = req.getParameter("city");
		String countryForm = req.getParameter("country");
		String beginDateForm = req.getParameter("beginDate");
		String endDateForm = req.getParameter("endDate");
		
		
		Date beginDate = null;
		Date endDate = null;
		
		ArrayList<String> errors = new ArrayList<String>();
		ArrayList<String> notifications = new ArrayList<String>();
		
		if(nameForm.equals(""))
			errors.add("Please enter a name for your travel");
		if(cityForm.equals(""))
			errors.add("Please enter a valid city");
		if(countryForm.equals(""))
			errors.add("Please enter a valid country");
			
		Integer budgetForm = 0;
		try{
			budgetForm =	Integer.valueOf(req.getParameter("budget"));
		}catch(NumberFormatException nfe){
			errors.add("Please enter the budget as an integer");
		}
			
		if(budgetForm <= 0)
			errors.add("Please enter a true budget");
		try
		{
			beginDate = new SimpleDateFormat("dd/MM/yyyy").parse(beginDateForm);
		}
		catch (ParseException e)
		{
			errors.add("Begin date is invalid");
		}
		try
		{
			endDate = new SimpleDateFormat("dd/MM/yyyy").parse(endDateForm);
		}
		catch (ParseException e)
		{
			errors.add("End date is invalid");
		}
		if(beginDate != null && endDate != null && beginDate.compareTo(endDate) >= 0)
			errors.add("Begin date must by strictly lower than end date");
		
		if(errors.isEmpty())
		{
			Travel t = new Travel();
			t.setName(nameForm);
			t.setCity(cityForm);
			t.setCountry(countryForm);
			t.setBeginDate(beginDate);
			t.setEndDate(endDate);
			t.setMaxBudget(budgetForm);
			EntityManager em = EMF.getInstance().getEntityManager();
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
			
			Bind b = new Bind();
			b.setTravel(t.getId());
			b.setOwner(true);
			b.setMember(UserServiceFactory.getUserService().getCurrentUser().getEmail());
			em.getTransaction().begin();
			em.persist(b);
			em.getTransaction().commit();
			
			notifications.add("Travel added successfully");
			req.setAttribute("notifications", notifications);
			req.setAttribute("id", t.getId());
//			rd = req.getRequestDispatcher("/index.jsp");
			rd = req.getRequestDispatcher("/DisplayTravel");
		}
		else
		{
			req.setAttribute("errors", errors);
			rd = req.getRequestDispatcher("/createTravel.jsp");
		}
		
		rd.forward(req, resp);
	}	
}
