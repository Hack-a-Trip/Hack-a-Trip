<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="net.tncy.entity.Vote"%>
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
String textButtonVote = "";
String typeSubmit = "";
String buttonClass = "";
int totalMembers =(Integer) request.getAttribute("totalMembers");
%>

<div class="container">
	<div class="hero-unit">
		<h2 class="form-signin-heading">Resultats</h2>
		<div class="CSSTableGenerator">
			<%
			for (Items e : liste)
			{
			%>
				<table>
					<tr>
						<td style="width:70%"><%=e.getOrigin()%></td>
						<td>Prix : <%=e.getPrice()%>&#8364; / night
						</td>
					</tr>
					<tr>
						<td style="width:70%"><img src="<%=e.getUrl()%>" /></td>
						<td>
							<span style="float:left;" class="badge"><%=e.getVotes()%>/<%=totalMembers%></span>
							<div class="progress progress-striped active">
								<div class="bar" style="float:left; width: <%=(e.getVotes()*100)/totalMembers%>%;"></div>
							</div>
							<form class="form-bind" style="margin: 0 auto 20px" action="/VoteLocation" method="post">
								<input name="idTravel" type="hidden" value="<%=request.getAttribute("idTravel")%>"/>
								<input name="city" type="hidden" value="<%=e.getOrigin()%>"/>
								<input name="idLocation" type="hidden" value="<%=e.getNid()%>"/>
								<input name="budget" type="hidden" value="<%=request.getAttribute("budget") %>"/>
								<%
									if(e.isVoted())
									{
										textButtonVote = "Cancel my vote";
										typeSubmit = "cancel";
										buttonClass = "btn";
									}
									else
									{
										textButtonVote = "Vote for this room !";
										typeSubmit = "vote";
										buttonClass = "btn btn-large btn-primary";
									}
								%>
								<input name="action" type="hidden" value="<%=typeSubmit%>"/>
								<button style="display:block; margin: auto;" class="<%=buttonClass %>" name="submit" type="submit"><%=textButtonVote %></button>
							</form>
							<br/><br/>
							<button class="btn" onclick="javascript:view_location('<%=e.getNid()%>');">View details</button>
							<button class="btn" onclick="javascript:book('<%=e.getLink()%>');">Book</button>
						</td>
					</tr>
				</table>
			<%
			}
			%>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
