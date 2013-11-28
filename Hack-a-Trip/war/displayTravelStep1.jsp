<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="net.tncy.entity.Travel" %>

<% 
Travel t = (Travel)request.getAttribute("travel");
%>



<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBuKu1d_CQx7M1re0CRQusjLHRmn84VGyk&sensor=true"></script>
<script type="text/javascript">
	var map;
	function initialize() {
        var mapOptions = {
          center: new google.maps.LatLng(-34.397, 150.644),
          zoom: 8
        };
        map = new google.maps.Map(document.getElementById("map-canvas"),
            mapOptions);
      }
      
      function codeAddress(address) {
   	 	geocoder.geocode( { 'address': address}, function(results, status) {
      	if (status == google.maps.GeocoderStatus.OK) {
        	map.setCenter(results[0].geometry.location);
        	var marker = new google.maps.Marker({
            	map: map,
            	position: results[0].geometry.location
        	});
      	} else {
        	alert("Geocode was not successful for the following reason: " + status);
      	}
    	});
    	alert('code addrress');
  }
 		
      google.maps.event.addDomListener(window, 'load', initialize);
      codeAddress('<%= t.getCountry() %>, <%= t.getCity() %>');
</script>

<jsp:include page="header.jsp">
	<jsp:param name="noprotect" value="1" />
	<jsp:param name="title" value="Plan a travel" />
</jsp:include>



<h1><%= t.getName() %></h1>
<div style="height: 100%" id="map-canvas"/>

<jsp:include page="footer.jsp"></jsp:include>
