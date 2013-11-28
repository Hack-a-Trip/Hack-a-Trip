<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="header.jsp">
	<jsp:param name="noprotect" value="1" />
	<jsp:param name="title" value="Plan a travel" />
</jsp:include>

<form class="form-signin" style="width:40%">
	<h2 class="form-signin-heading">Plan a travel</h2>
	<input name="city" type="text" class="input-block-level" placeholder="City">
	<input name="country" type="password" class="input-block-level" placeholder="Country">
	<input name="beginDate" type="text" class="input-block-level" placeholder="Begin Date (dd/mm/yyyy)">
	<input name="endDate" type="text" class="input-block-level" placeholder="End Date (dd/mm/yyyy)">
	<button class="btn btn-large btn-primary" type="submit">Create</button>
</form>

<jsp:include page="footer.jsp"></jsp:include>