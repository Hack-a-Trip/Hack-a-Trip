<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="header.jsp">
	<jsp:param name="noprotect" value="1" />
	<jsp:param name="title" value="Plan a travel" />
</jsp:include>

<div class="container">

	<c:if test="${not empty requestScope.error && requestScope.error == 'e1' }">
		<div class="alert alert-error">
			<a class="close" data-dismiss="alert">×</a>
			<strong>Vous devez être connecté(e) pour accéder au site</strong>
		</div>
	</c:if>
	
	<div class="hero-unit">
	<h1>Welcome in Hack-a-Trip</h1>
	<br/>
	<p>
		Work in progress...<br/><br/>
		<h3>The team</h3>
		Project leader 
		<img src="http://www.sureiscute.com/images/50360e401d41c87726000130.jpg"/><br/>
		Web designer
		<img src="http://b.imdoc.fr/1/animaux/animaux-2/photo/8704717870/20379892df7/animaux-2-chat-geek-img.jpg"/><br/>
		Programmer
		<img src="http://cdn.cutestpaw.com/wp-content/uploads/2012/01/I-heard-hes-good-at-coding-l.jpg"/><br/>
		System administrator
		<img src="http://cdni.wired.co.uk/620x413/d_f/dog-in-an-office.jpg"/><br/>
	</p>
	</div>
	    
</div>
<!-- /container -->

<jsp:include page="footer.jsp"></jsp:include>
