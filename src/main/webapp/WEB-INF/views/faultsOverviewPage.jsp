<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<link href="<c:url value="/resources/css/faultsOverviewTable.css" />" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Faults overview</title>
		
		
	</head>
	
<body>

	<jsp:include page="navigationDrawer.jsp"/>

	<div id="top">
		<div id="search"><input type="text" id="searchInput" onkeyup="searchFunction()" placeholder="Find by fault description..."></div>
		<div id="faultCount">${faultCount} fault(s) to do</div>
	</div> <!-- close top -->

	<div id="tableHolder">
	
            <table id="table-fill">
	            <thead>
	            	<tr class="header">
		                <th width="60px">Date</th>
		                <th width="70px">Time</th>
		                <th width="110px">Product type</th>
		                <th>Client</th>
		                <th>Street</th>
		                <th>Place</th>
		                <th>Phone #1</th>
		                <th>Phone #2</th>
		                <th width="260px">Fault description</th>
		                <th width="260px">Note</th>
		                <th>Fault issued to</th>
		                <th>Type of fault</th>
	                </tr> 
	             </thead>  
	               
                <c:forEach var="fault" items="${toDoFaults}" varStatus="status">
                	
                <tr>
                	<td><fmt:formatDate value="${fault.dateTime}" pattern="dd.MM.yyyy" /></td>
                	<td><fmt:formatDate value="${fault.dateTime}" pattern="HH:mm:ss" /></td>
                    <td>${fault.productType}</td>
                    <td>${fault.clientName}</td> 
                    <td>${fault.clientStreet}</td>
                    <td>${fault.clientPlace}</td>
                    <td>${fault.clientPhoneOne}</td>
                    <td>${fault.clientPhoneTwo}</td>
                    <td>${fault.faultDescription}</td> 
                    <td>${fault.faultNote}</td> 
                    <td>${fault.faultIssuedTo}</td>
                    <td>${fault.faultType}</td> 
                    <td><a href="${pageContext.request.contextPath}/editFault?id=${fault.idFault}">Edit</a></td>
                    <td><a href="${pageContext.request.contextPath}/editFault?id=${fault.idFault}">Archive</a></td>
                    <td><a href="${pageContext.request.contextPath}/editFault?id=${fault.idFault}">Delete</a></td>      
                </tr>
                </c:forEach>  
                           
            </table>
	</div> <!-- close tableHolder -->


</body>

<script>
function searchFunction() {
  // Declare variables 
  var input, filter, table, tr, td, i;
  input = document.getElementById("searchInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("table-fill");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[8];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    } 
  }
}
</script>
</html>