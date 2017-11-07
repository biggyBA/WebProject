<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page session="true"%>

<html>

	<head>
		<link href="<c:url value="/resources/css/containerFaultDetailsMapContainer.css" />" rel="stylesheet">
		<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyDiC6WFTBReLHHd7dPBhsBBSKYeezb-zYk"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script>
		function showLoader(){
			var wrapper = document.getElementById("wrapper");
			var loader = document.getElementById("loading");
			loader.style.display = "block";
			wrapper.style.display = "none";
		}
		</script>
		<title>Fault details</title>
	</head>
	
	<body onload="initMap()">
		<jsp:include page="../../navigationDrawer.jsp"></jsp:include>

		<div id="wrapper">
		
			<div id="leftBlock">
				<!-- This div holds the map -->
			</div> <!-- leftBlock end -->
		
			
			<div id="rightBlock"> 
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<jsp:include page="../admin/adminFaultDetails.jsp"/>
					</sec:authorize>
					
					<sec:authorize access="hasRole('ROLE_SERVICEMAN')">
						<jsp:include page="../serviceman/servicemanFaultDetails.jsp"/>
					</sec:authorize>
					
					<sec:authorize access="hasRole('ROLE_USER')">
						<jsp:include page="../user/userFaultDetails.jsp"/>
					</sec:authorize>
					
			</div> <!-- rightBlock end -->
		
		</div> <!-- wrapper end -->


<div id="loading"></div>

	<script>
      var map;
      function initMap() {

		//get the string from model
		var faultDetails = '${faultDetails}';
		//convert string to JSON
		var faultDetailsJSON = JSON.parse(faultDetails);
		//get needed values from object
		var latCoordinate = faultDetailsJSON.faultLat;
		var lngCoordinate = faultDetailsJSON.faultLng;

		var myLatLng = {lat: latCoordinate, lng: lngCoordinate};
		
        map = new google.maps.Map(document.getElementById('leftBlock'), {
          center: myLatLng,
          zoom: 12
        });

        
        //add marker to map
        var marker = new google.maps.Marker({
            position: myLatLng,
            map: map,
          });

        marker.addListener('click', function() {
            infowindow.open(map, marker);
          });

       	//create fault info string
        var contentString = 
        	'<label><b>Product type: </b></label>' + faultDetailsJSON.productId +
            '</br><label><b>Name: </b></label>' + faultDetailsJSON.clientName +
            '</br><label><b>Phone #1: </b></label>' + faultDetailsJSON.clientPhoneOne +
            '</br><label><b>Phone #2: </b></label>' + faultDetailsJSON.clientPhoneTwo +
            '</br><label><b>Fault description: </b></label>' + faultDetailsJSON.faultDescription +
            '</br><label><b>Note: </b></label>' + faultDetailsJSON.faultNote;
        
		//add info string to marker
	    var infowindow = new google.maps.InfoWindow({
	      content: contentString,
	      maxWidth: 600
	    });
	    infowindow.open(map, marker);

        
      }
    </script>
</body>




</html>