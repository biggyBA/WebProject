<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
	
			
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<jsp:include page="../admin/adminFaultsOverview.jsp"/>
			</sec:authorize>
			
			<sec:authorize access="hasRole('ROLE_SERVICEMAN')">
				<jsp:include page="../serviceman/servicemanFaultsOverview.jsp"/>
			</sec:authorize>
			
			<sec:authorize access="hasRole('ROLE_USER')">
				<jsp:include page="../user/userFaultsOverview.jsp"/>
			</sec:authorize>
				
			  
			<div id="bottomToolbar">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					${pageContext.request.userPrincipal.name}
				</c:if>
			
				<a href="#wrapper">Top</a>
			</div>	
		
		</div> <!-- end wrapper -->
	
	
		<div id="loading"></div>
	
	</body>


</html>