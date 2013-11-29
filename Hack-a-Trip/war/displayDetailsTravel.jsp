<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.ArrayList"%>
<%@page import="net.tncy.hackatrip.Items"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="header.jsp">
	<jsp:param name="title" value="View details of Travel" />
</jsp:include>

<c:if test="${not empty requestScope.errors }">
	<c:forEach var="error" items="${requestScope.errors}">
		<div class="alert alert-error">
			<a class="close" data-dismiss="alert">×</a> <strong>${error}</strong>
		</div>
	</c:forEach>
</c:if>

<%
ArrayList<Items> liste = (ArrayList<Items>) request.getAttribute("detailsTravel");
%>

<form class="form-signin" style="width: 40%" action="/Resultat"
	method="get">
	<h2 class="form-signin-heading">Resultats</h2>
	<div class="container">
		<div class="CSSTableGenerator">
			<table>
				<%
				for (Items e : liste)
				{
				%>
					<tr>
						<td><%=e.getOrigin()%></td>
						<td>Prix : <%=e.getPrice()%> euros
						</td>
					</tr>
					<td><img src="<%=e.getUrl()%>" /></td>
				<%
				}
				%>
			</table>
		</div>
	</div>
</form>

<jsp:include page="footer.jsp"></jsp:include>