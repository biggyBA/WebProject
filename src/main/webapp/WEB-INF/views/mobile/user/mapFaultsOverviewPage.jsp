<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Map faults overview</title>
		<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyDiC6WFTBReLHHd7dPBhsBBSKYeezb-zYk"></script>
		<script type="text/javascript">

			  function loadMap() {

					//get the string from model
					var faultList = '${faultList}';
					
					//convert string to JSON
					var faultListJSON = JSON.parse(faultList);

					
				    var map = new google.maps.Map(document.getElementById('map_container'), {
				      zoom: 10,
				      center: new google.maps.LatLng(50, 7),
				      mapTypeId: google.maps.MapTypeId.ROADMAP
				    });

					var infowindow = new google.maps.InfoWindow();


					
					var marker, i;
						faultListJSON.forEach( function (arrayItem)
								{
						    var lat = arrayItem.faultLat;
						    var lng = arrayItem.faultLng;


						    marker = new google.maps.Marker({
						        position: new google.maps.LatLng(lat, lng),
						        map: map
						      });


						   
						    //alert(lng);
						    });



/*
						google.maps.event.addListener(marker, 'click', (function(marker, i) {
					        return function() {
					          infowindow.setContent(locations[i][0]);
					          infowindow.open(map, marker);
					        }
					      })(marker, i));

*/

					    
						

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
	<jsp:include page="../../navigationDrawer.jsp"></jsp:include>

	<div id="map_container"></div>
	<button onClick="mapCoordinates()">Try me</button>

</body>
</html>