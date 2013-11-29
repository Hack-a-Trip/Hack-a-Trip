<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="net.tncy.entity.Travel"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
	Travel t = (Travel) request.getAttribute("travel");
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
%>



<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBuKu1d_CQx7M1re0CRQusjLHRmn84VGyk&sensor=true"></script>
<script type="text/javascript">
	var map;
	var geocoder;
	function initialize() {
		geocoder = new google.maps.Geocoder();
        var mapOptions = {
          center: new google.maps.LatLng(-34.397, 150.644),
          zoom: 8
        };
        
        map = new google.maps.Map(document.getElementById("map-canvas"),
            mapOptions);
            codeAddress('<%=t.getCountry()%>, <%=t.getCity()%>');

	}

	function codeAddress(address) {
		geocoder.geocode({
			'address' : address
		}, function(results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				map.setCenter(results[0].geometry.location);
				var marker = new google.maps.Marker({
					map : map,
					position : results[0].geometry.location
				});
			} else {
				alert("Geocode was not successful for the following reason: "
						+ status);
			}
		});

	}

	google.maps.event.addDomListener(window, 'load', initialize);
</script>

<jsp:include page="header.jsp">
	<jsp:param name="title" value="Plan a travel" />
</jsp:include>


<div class="container">
	<h1 style="text-align: center;"><%=t.getName()%></h1>
	<div style="width: 100%; height: 40%" id="map-canvas" />
</div>
</br>
</br>
<div class="details">
	<table style="width: 50%">
		<tr>
			<th style="font-size: 1.5em;">Start date</th>
			<th style="font-size: 1.5em;">End date</th>
			<th style="font-size: 1.5em;">Budget</th>
		</tr>
		<tr>
			<td style="font-size: 1.5em; text-align: center"><%=df.format(t.getBeginDate())%></td>
			<td style="font-size: 1.5em; text-align: center"><%=df.format(t.getEndDate())%></td>
			<td style="font-size: 1.5em; text-align: center"><%=t.getMaxBudget()%></td>
		</tr>
	</table>
	<br/>
	<span style="font-size: 1.5em;">Members :</span>
	</span>
		<c:if test="${not empty requestScope.members }">
			<c:forEach var="member" items="${requestScope.members}">
				${member} 
			</c:forEach>
		</c:if>
	<span>
	<form class="form-bind" style="width:40%;margin: 0 auto 20px" action="/BindTravel" method="post">
		<input name="email" type="email" class="input-block-level" placeholder="Guest email">
		<input name="id" type="hidden" value="<%=t.getId()%>">
		<button class="btn btn-large btn-primary" type="submit">add</button>
	</form>
	<form class="form-bind" style="width:40%;margin: 0 auto 20px" action="/DisplayDetailsTravel" method="post">
		<input name="city" type="hidden" value="<%=t.getCity() %>"/>
		<button class="btn btn-large btn-primary" type="submit">view details</button>
	</form>
</div>

<div>
	<br/>
</div>

<div id="disqus_thread"></div>
<script type="text/javascript">
	/* * * CONFIGURATION VARIABLES: EDIT BEFORE PASTING INTO YOUR WEBPAGE * * */
	var disqus_shortname = 'hackatrip-admin'; // required: replace example with your forum shortname

	/* * * DON'T EDIT BELOW THIS LINE * * */
	(function() {
		var dsq = document.createElement('script');
		dsq.type = 'text/javascript';
		dsq.async = true;
		dsq.src = '//' + disqus_shortname + '.disqus.com/embed.js';
		(document.getElementsByTagName('head')[0] || document
				.getElementsByTagName('body')[0]).appendChild(dsq);
	})();
</script>
<noscript>
	Please enable JavaScript to view the <a
		href="http://disqus.com/?ref_noscript">comments powered by Disqus.</a>
</noscript>
<a href="http://disqus.com" class="dsq-brlink">comments powered by <span
	class="logo-disqus">Disqus</span></a>

<jsp:include page="footer.jsp"></jsp:include>