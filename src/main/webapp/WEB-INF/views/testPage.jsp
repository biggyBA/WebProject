<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>

	<head>
	
	 
	

		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Test page</title>
	
	
	</head>
	
	
<body>
		
		<form:form action="updateFault" method="post" modelAttribute="fault">
	        
		        <table>
		        	<form:hidden path="id"/>
		        	<form:input path="status" type="hidden" value="UrgentToDo"/>
		            
		            <tr>
		                <td>Date:</td>
		                <td>
							<script> document.write(new Date().toLocaleDateString()); </script>
						</td>
		            </tr>
		            
		            <tr>
		                <td>Time:</td>
		                <td>
							<script> document.write(new Date().toLocaleDateString()); </script>
						</td>
		            </tr>
		            
		            <tr>
		                <td>Product type:</td>
		                <td><form:input path="ident" /></td>
		            </tr>
		            
		            <tr>
		                <td>Serial number:</td>
		                <td><form:input path="serialNumber" /></td>
		            </tr>
		            
		            <tr>
		                <td>Client:</td>
		                <td><form:input path="client" /></td>
		            </tr>
		            
		            <tr>
		                <td>Street:</td>
		                <td><form:input path="street" /></td>
		            </tr>
		            
		            <tr>
		                <td>Place:</td>
		                <td><form:input path="place" /></td>
		            </tr>
		            
		            <tr>
		                <td>Phone #1:</td>
		                <td><form:input path="phoneOne" /></td>
		            </tr>
		            
		            <tr>
		                <td>Phone #2:</td>
		                <td><form:input path="phoneTwo"/></td>
		            </tr>
		            
		            <tr>
		                <td>Fault description:</td>
		                <td><form:textarea path="faultDescription" cols="30" rows="5" /></td>
		            </tr>
		            
		            <tr>
		                <td>Note:</td>
		                <td><form:textarea path="note" cols="30" rows="5" /></td>
		            </tr>
		            
		            <tr>
		            	<td>Serviceman:</td>
		            	<td>
		            		<form:select path="serviceman">
				            	<form:option value="0" label="Select"/>
				            	<form:options  items="${servicemanList}"/>
							</form:select>
						</td>
		            </tr>
		            
		            <tr>
		            	<td>Fault submitted by:</td>
		            	<td>
		            		<form:select path="orderBy">
				            	<form:option value="0" label="Select"/>
				            	<form:options  items="${usersList}"/>
							</form:select>
						</td>
		            </tr>
		            
		            <tr>
		            	<td>Type of service:</td>
		            	<td>
		            		<form:select path="typeOfService">
				            	<form:option value="0" label="Select"/>
				            	<form:options  items="${typeOfServiceList}"/>
							</form:select>
						</td>
		            </tr>
		            
		            
		            
		            <tr>
		                <td colspan="2" align="center"><input type="submit" value="Save"></td>
		            </tr>
		        </table>
	        </form:form>
	
		

</body>
</html>