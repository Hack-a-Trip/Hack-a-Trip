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