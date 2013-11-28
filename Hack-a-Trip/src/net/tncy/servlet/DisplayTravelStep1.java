package net.tncy.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tncy.entity.Travel;

public class DisplayTravelStep1 extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		Travel t = new Travel();
		t.setBeginDate(new Date());
		t.setEndDate(new Date());
		t.setCity("London");
		t.setCountry("United Kingdom");
		t.setMaxBudget(1000);
		
		RequestDispatcher rd = null;
		req.setAttribute("travel", t);
		rd = req.getRequestDispatcher("/displayTravelStep1.jsp");
		rd.forward(req, resp);
		
	}

}
