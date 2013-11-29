<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="net.tncy.tool.User" %>


<%
if(!User.isConnected(session))
{
	RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
	request.setAttribute("error","e1");
%>	
	<jsp:forward page="index.jsp">
		<jsp:param name="lang" value="fr" />
	</jsp:forward>
<%
}
%>