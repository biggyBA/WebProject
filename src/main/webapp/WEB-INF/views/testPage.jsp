<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Test page</title>
		<style>
		#errorMessage{
		color: red;
		}
		</style>
	</head>
	
	
<body>
	
	<div align="center">
        
        <table border="0" width="90%">
        <form:form action="login" commandName="fault">
                <tr>
                    <td align="left" width="20%">Email: </td>
                    <td align="left" width="40%"><form:input path="clientEmail" size="30"/></td>
                </tr>
                <tr>
                	<td width="20%"/>
                    <td align="left" width="40%" id="errorMessage"><form:errors path="clientEmail" cssClass="error"/></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><form:password path="faultDescription" size="30"/></td>
                    <td><form:errors path="faultDescription" cssClass="error"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td align="center"><input type="submit" value="Login"/></td>
                    <td></td>
                </tr>
        </form:form>
        </table>
        
        <spring:message code="label.lastName" />
    </div>
	
	
	
	
	
	
	
		
		
		

</body>
</html>