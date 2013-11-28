<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="net.tncy.tool.Constant" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:if test="${empty param.noprotect}">
	<jsp:include page="protect.jsp"></jsp:include>
</c:if>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="bootstrap/css/bootstrap.css" type="text/css" />
		<title><c:out value="${param.title}" default="<%=Constant.TITLE_APPLICATION %>"/></title>
	</head>
	<body>
		<div class="container-fluid">