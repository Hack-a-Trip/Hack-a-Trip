<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="net.tncy.tool.Constant"%>
<%@ page import="com.google.appengine.api.users.User"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ page import="javax.persistence.EntityManager"%>
<%@ page import="net.tncy.database.EMF"%>
<%@ page import="net.tncy.entity.Travel"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:if test="${empty param.noprotect}">
	<jsp:include page="protect.jsp"></jsp:include>
</c:if>

<head>
<title>Hack a Trip</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>
<!-- Bootstrap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">

</head>

<body>
	<%
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
	%>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".navbar-responsive-collapse"> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
				</a> <a class="brand" href="/">Hack a Trip</a>
				<div class="nav-collapse collapse navbar-responsive-collapse">
					<ul class="nav">
						<%
							if (user == null)
							{
						%>
						<li><a
							href="<%=userService.createLoginURL(request.getRequestURI())%>">Log
								in</a></li>
					</ul>
					<%
						}
						else
						{
					%>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Travel<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="/CreateTravel">New</a></li>
							<li class="divider"></li>
							<!-- foreach trip do -->
							<%
							EntityManager em = EMF.getInstance().getEntityManager();
							List<Long> list = em.createNamedQuery("findTravelIdByEmail").setParameter("userEmail", user.getEmail()).getResultList();
								for( int i=0; i<list.size(); i++) {
									Travel t = (Travel)em.createNamedQuery("findTravel").setParameter("travelId", list.get(i)).getSingleResult();
							%>
								<li><a href="/DisplayTravelStep1?id=<%=t.getId()%>"><%= t.getName() %></a></li>
							<%	} %>
							<!-- end foreach -->
						</ul></li>
					<li><a
						href="<%=userService.createLogoutURL("/Logout")%>">Log
							out</a></li>
					</ul>
					<p class="navbar-text pull-right">
						Log as
						<%=user.getNickname()%>
					</p>
					<%
						}
					%>

				</div>
				<!-- /.nav-collapse -->
			</div>
		</div>
		<!-- /navbar-inner -->
	</div>
	<!-- /navbar -->
	<div class="container-fluid">
