<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Map faults overview</title>
		<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyDiC6WFTBReLHHd7dPBhsBBSKYeezb-zYk"></script>
		<script type="text/javascript">
			  function loadMap() {
			    var latlng = new google.maps.LatLng(37.4224764, -122.0842499);
			    var myOptions = {
			      zoom: 15,
			      center: latlng,
			      mapTypeId: google.maps.MapTypeId.ROADMAP
			    };
			    var map = new google.maps.Map(document.getElementById("map_container"),myOptions);
			
			    var marker = new google.maps.Marker({
			      position: latlng,
			      map: map,
			      title:"my hometown, Malim Nawar!"
			    });

			    google.maps.event.addListener(marker , 'click', function(){
			        var infowindow = new google.maps.InfoWindow({
			          content:'Hello Title',
			          position: latlng,
			        });
			        infowindow.open(map);
			    });
			
			  }
		</script>
		<style type="text/css">
			div#map_container{
				width:100%;
				height:900px;
			}
		</style>
	</head>

<body onload="loadMap()">


	<div id="map_container"></div>

</body>
</html>