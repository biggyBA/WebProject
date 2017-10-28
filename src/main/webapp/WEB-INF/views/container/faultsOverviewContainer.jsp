<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="<c:url value="/resources/css/containerFaultsOverviewContainer.css" />" rel="stylesheet">
		<title>Faults overview</title>
	</head>
	
	<body>
	
		<jsp:include page="../navigationDrawer.jsp"/>
		
		<div id="wrapper">
	
			<c:choose>
				
			    <c:when test="${empty role}">
			        Oops. Something went wrong.
			    </c:when>
			    
			    
			    <c:when test="${role=='admin'}">
			        <jsp:include page="../admin/adminFaultsOverview.jsp"/>
			    </c:when>
			    
			    
			    <c:when test="${role=='serviceman'}">
			        <jsp:include page="../serviceman/servicemanFaultsOverview.jsp"/>
			    </c:when>
			    
			    
			    <c:when test="${role=='user'}">
			        <jsp:include page="../user/userFaultsOverview.jsp"/>
			    </c:when>
			    
			</c:choose>
			
			
		<div id="bottomToolbar">${role} <a href="#wrapper">Top</a></div>	
		
		</div> <!-- end wrapper -->
	
	
		<div id="loading"></div>
	
	</body>


</html>