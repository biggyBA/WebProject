<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true"%>
      
    <head>
    	<link href="<c:url value="/resources/css/_mLoginPage.css" />" rel="stylesheet">
        <title>Login</title>
    </head>
    
    
    <body>
    
    
		<div class="login-page">
		  <div class="form">
		    
		    <form:form action="login" method="post" modelAttribute="user" class="login-form">
		        
		        <form:input path="username" type="text" placeholder="username"/>
		        
		        <form:input path="password" type="password" placeholder="password"/>
		        
		        <input type="submit" value="Login" id="submitButton"/>
		  
		     </form:form>
		     
		     <c:if test="${param.error == 'true'}">
		     	<div class="error">
		          ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		        </div>
		    </c:if>
		    
		  </div>
		</div>

 	</body>
</html>