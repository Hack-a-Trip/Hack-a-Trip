<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.google.appengine.api.users.User"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>

<html>

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
				</a> <a class="brand" href="#">Hack a Trip</a>
				<div class="nav-collapse collapse navbar-responsive-collapse">
					<ul class="nav">
						<%
							if (user == null) {
						%>
						<li><a
							href="<%=userService.createLoginURL(request.getRequestURI())%>">Log
								in</a></li>
					</ul>
					<%
						} else {
					%>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Travel<b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="/CreateTravel">New</a></li>
								<li class="divider"></li>
								<!-- foreach trip do -->
								<li><a href="#">Trip i</a></li>
								<!-- end foreach -->
							</ul></li>
						<li><a
							href="<%=userService.createLogoutURL(request.getRequestURI())%>">Log
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

	</div>

	<div class="container">

		<h1>Welcome in hack a trip</h1>
		<p>
			This one will be a fucking project !<br> Soon...
		</p>

	</div>
	<!-- /container -->

	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>

</html>