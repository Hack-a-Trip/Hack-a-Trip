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
		Organize a trip with your friend !<br/>
		A project develop in only 36h for the Telecom Nancy Hackathon 2013<br/><br/>
		<h3 style="text-align: center;">The team</h3>
		<table>
		<tr>
		<th>Project leader</th>
		<td rowspan=2><img src="http://www.cybercrimesunit.com/wp-content/plugins/rss-poster/cache/aa50c_dog-computer1.jpg"/></td>
		</tr>
		<tr>
		<td>Théo Biasutto--Lervat</td>
		</tr>
		<tr>
		<th>Web designer</th>
		<td rowspan=2><img src="http://b.imdoc.fr/1/animaux/animaux-2/photo/8704717870/20379892df7/animaux-2-chat-geek-img.jpg"/></td>
		</tr>
		<tr>
		<td>Clément Courtehoux</td>
		</tr>
		<tr>
		<th>J2E developper</th>
		<td rowspan=2><img src="http://cdn.cutestpaw.com/wp-content/uploads/2012/01/I-heard-hes-good-at-coding-l.jpg"/></td>
		</tr>
		<tr>
		<td>Alexandre Frantz</td>
		</tr>
		<tr>
		<th>Web developper</th>
		<td rowspan=2><img src="http://elearn.mpls.k12.mn.us/students/pluginfile.php/24916/course/section/5664/animal.jpg"/></td>
		</tr>
		<tr>
		<td>Simon Daget</td>
		</tr>
		</table>
	</p>
	</div>
	    
</div>
<!-- /container -->

<jsp:include page="footer.jsp"></jsp:include>
