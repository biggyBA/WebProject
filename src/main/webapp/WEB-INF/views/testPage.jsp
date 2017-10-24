<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Test page</title>
		<style type="text/css">
div#map_container{
	width:100%;
	height:900px;
}
</style>
<script type="text/javascript"
   src="http://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyDiC6WFTBReLHHd7dPBhsBBSKYeezb-zYk"></script>

<script type="text/javascript">
  function loadMap() {
    var latlng = new google.maps.LatLng(50.780258, 7.261953);
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

  }
</script>
	</head>
	
	
<body onload="loadMap()">
	
	${title}
	${message}
		

</body>
</html>