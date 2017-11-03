<link href='https://fonts.googleapis.com/css?family=Saira+Semi+Condensed' rel='stylesheet' type='text/css'>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>




<div class="horizontal-menu">
	<table>
		<tr><td><a href="#"><img src="resources/images/icon_add_file.png"/><spring:message code="label.nav.submitFault"/></a></td>
		<td><a href="#"><img src="resources/images/icon_bulleted_list.png"/><spring:message code="label.nav.faultsOverview"/></a></td>
		<td><a href="#"><img src="resources/images/icon_map_marker.png"/><spring:message code="label.nav.mapOverview"/></a></td>
		<td><a href="#"><img src="resources/images/icon_edit_file.png"/><spring:message code="label.nav.serviceReport"/></a></td>
		<td><a href="#"><img src="resources/images/icon_documents_folder.png"/><spring:message code="label.nav.archive"/></a></td></tr>
	</table>
  
</div>



<style>
body {
    margin: 0;
}

img{
	width: 30px;
	height: 30px;
	margin-right: 2vh;
	margin-bottom: -3%;
}

.horizontal-menu {
    width: 100%;
    height: 6%;
    background-color: #eee;
    border-bottom: 0.5px solid #b4b6ba;
}

.horizontal-menu a {
    background-color: #eee; /* Grey background color */
    color: #b4b6ba; /* Black text color */
    display: block; /* Make the links appear below each other */
    padding: 12px; /* Add some padding */
    text-decoration: none; /* Remove underline from links */
}

.horizontal-menu a:hover {
    background-color: #ccc; /* Dark grey background on mouse-over */
    color: black;
}

.horizontal-menu a.active {
    background-color: #4CAF50; /* Add a green color to the "active/current" link */
    color: white;
}

.horizontal-menu a{
	font-family: 'Saira Semi Condensed', serif;
    font-size: 14px;
}


td{
	width: 10%;
	border-right: 1px solid black;
	padding-top: 0px;
	padding-bottom: 0px;
	border-color: #b4b6ba;
}



</style>