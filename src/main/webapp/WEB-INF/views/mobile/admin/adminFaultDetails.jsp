<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page session="true"%>

<html>

	<head>
		<link href="<c:url value="/resources/css/adminFaultDetails.css" />" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Fault details</title>
	</head>

<body>

	<div class="tab">
	  <button class="tablinks" onclick="openTab(event, 'TabOne')"><img src="resources/images/ic_person_white.png" alt="Client info" width="30" height="30" ></button>
	  <button class="tablinks" onclick="openTab(event, 'TabTwo')"><img src="resources/images/ic_info_white.png" alt="Info" width="30" height="30" ></button>
	  <button class="tablinks" onclick="openTab(event, 'TabThree')"><img src="resources/images/ic_history_white.png" alt="History" width="30" height="30" ></button>
	</div>

	<div id="TabOne" class="tabcontent">
	  <table>
	  	<tr>
	  		<td><img src="resources/images/ic_person_white.png" alt="Client info" class="tablePics" ></td>
	  		<td>${fault.clientName}</td>
	  	</tr>
	  	<tr>
	  		<td><img src="resources/images/ic_location_on_white.png" alt="Street" class="tablePics" ></td>
	  		<td>${fault.clientStreet}</td>
	  	</tr>
	  	<tr>
	  		<td><img src="resources/images/ic_location_on_white.png" alt="Postal code" class="tablePics" ></td>
	  		<td>${fault.clientPostalCode}</td>
	  	</tr>
	  	<tr>
	  		<td><img src="resources/images/ic_location_on_white.png" alt="Place" class="tablePics" ></td>
	  		<td>${fault.clientPlace}</td>
	  	</tr>
	  	<tr>
	  		<td><img src="resources/images/ic_local_phone_white.png" alt="Phone" class="tablePics" ></td>
	  		<td>${fault.clientPhoneOne}</td>
	  	</tr>
	  	<tr>
	  		<td><img src="resources/images/ic_local_phone_white.png" alt="Phone" class="tablePics" ></td>
	  		<td>${fault.clientPhoneTwo}</td>
	  	</tr>
	  	<tr>
	  		<td><img src="resources/images/ic_email_white.png" alt="E-mail" class="tablePics" ></td>
	  		<td>${fault.clientEmail}</td>
	  	</tr>
	  </table>
	</div> <!-- end TabOne -->
	
	
	
	<div id="TabTwo" class="tabcontent">
	  <table>
			<tr>
		  		<td><img src="resources/images/ic_description_white.png" alt="Description" class="tablePics" ></td>
		  		<td>${fault.faultDescription}</td>
	  		</tr>
	  		<tr>
		  		<td><img src="resources/images/ic_note_white.png" alt="Note" class="tablePics" ></td>
		  		<td>${fault.faultNote}</td>
	  		</tr>
	  		<tr>
		  		<td><img src="resources/images/ic_person_white.png" alt="Issued by" class="tablePics" ></td>
		  		<td>${fault.faultIssuedBy}</td>
	  		</tr>
	  		<tr>
		  		<td><img src="resources/images/ic_person_white.png" alt="Issued to" class="tablePics" ></td>
		  		<td>${fault.faultIssuedTo}</td>
	  		</tr>
		</table>
	</div> <!-- end TabTwo -->
		
		
		
	<div id="TabThree" class="tabcontent">
	  <p>History</p>

	</div> <!-- end TabThree -->



<script>
function openTab(evt, tabName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
}
</script>

</body>
</html>