<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="net.tncy.entity.Travel" %>

<html>

<head>
<script src="http://code.jquery.com/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<!-- <script src="js/HackMap.js"></script>-->
	<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBuKu1d_CQx7M1re0CRQusjLHRmn84VGyk&sensor=true"></script>
	   <script type="text/javascript">
	   var HackMap = function(){
	var map;
	this.initialize = function (x,y,z){
		google.maps.event.addDomListener(window, 'load', this.initMap(x,y,z));
	}
	
	this.initMap = function(x,y,z) {
	    var mapOptions = {
	       center: new google.maps.LatLng(x,y),
	       zoom: z
	    };
	    
	    map = new google.maps.Map(document.getElementById("map-canvas"),mapOptions);
	}
	
	/*this.addMarker = function(x,y, t){
		var infowindow = new google.maps.InfoWindow({
		    content: '<h1>test</h1>'
		  });

		var marker = new google.maps.Marker({
	        position: new google.maps.LatLng(x,y),
	        map: map,
	        title:t
	      });
		
		google.maps.event.addListener(marker, 'click', function() {
		    infowindow.open(marker.get('map'), marker);
		  });

		
	}*/
}
		var map = new HackMap();
		map.initialize(0, 0, 6);
    </script> 
</head>

<body>

	<div style="container" id="map-canvas"></div>

		

	
</body>

</html>