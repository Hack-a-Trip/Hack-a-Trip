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
			<a class="close" data-dismiss="alert">�</a>
			<strong>Vous devez �tre connect�(e) pour acc�der au site</strong>
		</div>
	</c:if>

	<h1>Welcome in hack a trip</h1>
	<p>
		This one will be a fucking project !<br> Soon...
	</p>
	    
</div>
<!-- /container -->

<jsp:include page="footer.jsp"></jsp:include>
