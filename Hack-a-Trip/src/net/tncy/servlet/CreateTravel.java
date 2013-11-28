package net.tncy.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import net.tncy.database.EMF;
import net.tncy.entity.Travel;

@SuppressWarnings("serial")
public class CreateTravel extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		RequestDispatcher rd = null;
		
		req.getSession().setAttribute("connected", "true");
        if (net.tncy.tool.User.isConnected(req.getSession()))
        {
        	rd = req.getRequestDispatcher("/createTravel.jsp");
        }
        else
        {
        	rd = req.getRequestDispatcher("/index.html");
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
			errors.add("Please enter a name for your traval");
		if(cityForm.equals(""))
			errors.add("Please enter a valid city");
		if(countryForm.equals(""))
			errors.add("Please enter a valid country");
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
			t.setCity(cityForm);
			t.setCountry(countryForm);
			t.setBeginDate(beginDate);
			t.setEndDate(endDate);
			EntityManager em = EMF.getInstance().getEntityManager();
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
			
			notifications.add("Travel added successfully");
			req.setAttribute("notifications", notifications);
			rd = req.getRequestDispatcher("/index.jsp");
		}
		else
		{
			req.setAttribute("errors", errors);
			rd = req.getRequestDispatcher("/createTravel.jsp");
		}
		
		rd.forward(req, resp);
	}	
}
