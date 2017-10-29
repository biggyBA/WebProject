<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page session="true"%>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="<c:url value="/resources/css/adminFaultsOverview.css" />" rel="stylesheet">
		<title>Faults overview</title>
	</head>
	
	<body>
	
		<div id="tableHolder">
	
            <table id="table-fill">
	            <thead>
	            	<tr class="header">
		                <th width="60px">Date</th>
		                <th width="110px">Product Id</th>
		                <th>Client</th>
		                <th>Street</th>
		                <th>Place</th>
		                <th>Phone #1</th>
		                <th>Phone #2</th>
		                <th width="260px">Fault description</th>
		                <th width="260px">Note</th>
		                <th>Fault issued to</th>
		                <th>Type of fault</th>
		                <th></th>
		                <th></th>
		                <th></th>
		                <th></th>
	                </tr> 
	             </thead>  
	             
	             <tbody>
	                <c:forEach var="fault" items="${toDoFaults}" varStatus="status">	
		                <tr>
		                	<td style="display:none;">${fault.idFault}</td>
		                	<td class="mytable tr"><fmt:formatDate value="${fault.dateTime}" pattern="dd.MM.yyyy" /></td>
		                    <td>${fault.productId}</td>
		                    <td>${fault.clientName}</td> 
		                    <td>${fault.clientStreet}</td>
		                    <td>${fault.clientPlace}</td>
		                    <td>${fault.clientPhoneOne}</td>
		                    <td>${fault.clientPhoneTwo}</td>
		                    <td>${fault.faultDescription}</td> 
		                    <td>${fault.faultNote}</td> 
		                    <td>${fault.faultIssuedTo}</td>
		                    <td>${fault.faultType}</td> 
		                    <td><a href="${pageContext.request.contextPath}/viewFaultDetails?id=${fault.idFault}"><img src="resources/images/ic_location_on_white.png" alt="Map" width="30" height="30" ></a></td>
		                    <td><a class="button" href="${pageContext.request.contextPath}/editFault?id=${fault.idFault}">Edit</a></td>
		                    <td><a class="button" href="${pageContext.request.contextPath}/archiveFault?id=${fault.idFault}">Archive</a></td>
		                    <td><a class="button" href="${pageContext.request.contextPath}/deleteFault?id=${fault.idFault}">Delete</a></td>      
		                </tr>
	                </c:forEach>
                 </tbody>     
            </table>
            
		</div> <!-- close tableHolder -->


	</body>
	
</html>