<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<link href="<c:url value="/resources/css/adminEditFault.css" />" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<style type="text/css">
		#errorMessage{
		color: red;
		padding-left: 22px;
		font-size: 0.75em;
		}
		</style>
		<title>Edit fault</title>
	</head>
	
	
<body>

	<jsp:include page="../../navigationDrawer.jsp"></jsp:include>
	
	<div id="wrapper">
		
			<div id="formHolder">
				<form:form action="editFault" method="post" modelAttribute="fault">
				<form:hidden path="idFault"/>			
							<table>
							
								<!-- Date and time now -->
								<form:input path="lastEdit" type="hidden" id="lastEditLabel"/>
								<script type="text/javascript">
									var nowDateTime = new Date();
									var labelDateTime = document.getElementById("lastEditLabel");
									labelDateTime.value = nowDateTime;
								</script>
					
					        	
					        	<!-- Product id -->
					        	<tr>
					        		<td><spring:message code="label.productID"/></td>
					        		<td>
					        			<form:select path="productId">
											<form:option value="" label="Select product type"/>
										    <form:options  items="${productTypeList}"/>
										</form:select>
					        		</td>
					        	</tr>
					        	<tr><td></td>
					        	<td id="errorMessage"><form:errors path="productId"/></td>
					        	</tr>
					        	
					        	<!-- Product serial number -->
					        	<tr>
					        		<td><spring:message code="label.productSerialNumber"/></td>
					        		<td>
					        			<form:input path="productSerialNumber" type="text" placeholder="Serial number"/>
					        		</td>
					        	</tr>
					        	<tr><td></td>
					        	<td id="errorMessage"><form:errors path="productSerialNumber"/></td>
					        	</tr>
					        	
					        	
					        	<!-- Client name -->
								<tr>
									<td><spring:message code="label.clientName"/></td>
									<td>
										<form:input path="clientName" type="text" placeholder="Name"/>
									</td>
								</tr>
								<tr><td></td>
					        	<td id="errorMessage"><form:errors path="clientName"/></td>
					        	</tr>
					        	
								
								<!-- Client street -->
								<tr>
									<td><spring:message code="label.clientStreet"/></td>
									<td>
										<form:input path="clientStreet" type="text" placeholder="Street"/>
									</td>
								</tr>
								<tr><td></td>
					        	<td id="errorMessage"><form:errors path="clientStreet"/></td>
					        	</tr>
					        	
					        	<!-- Postal code -->
								<tr>
									<td><spring:message code="label.clientPostalCode"/></td>
									<td>
										<form:input path="clientPostalCode" type="text" placeholder="Postal code"/>
									</td>
								</tr>
								
								<!-- Client place -->
								<tr>
									<td><spring:message code="label.clientPlace"/></td>
									<td>
										<form:input path="clientPlace" type="text" placeholder="Place"/>
									</td>
								</tr>
								<tr><td></td>
					        	<td id="errorMessage"><form:errors path="clientPlace"/></td>
					        	</tr>
					        	
								
								<!-- Client phone number one -->
								<tr>
									<td><spring:message code="label.clientPhoneOne"/></td>
									<td>
										<form:input path="clientPhoneOne" type="text" placeholder="Phone #1"/>
									</td>
								</tr>
								<tr><td></td>
					        	<td id="errorMessage"><form:errors path="clientPhoneOne"/></td>
					        	</tr>
					        	
								
								<!-- Client phone number two --> 
								<tr>
									<td><spring:message code="label.clientPhoneTwo"/></td>
									<td>
										<form:input path="clientPhoneTwo" type="text" placeholder="Phone #2"/>
									</td>
								</tr>
								
								<!-- Client email --> 
								<tr>
									<td><spring:message code="label.clientEmail"/></td>
									<td>
										<form:input path="clientEmail" type="text" placeholder="E-mail"/>
									</td>
						    	</tr>
						    	<tr><td></td>
					        	<td id="errorMessage"><form:errors path="clientEmail"/></td>
					        	</tr>
					        	
						    	
						    	<!-- Fault description --> 
								<tr>
									<td><spring:message code="label.faultDescription"/></td>
									<td>
										<form:textarea path="faultDescription" cols="30" rows="5" placeholder="Fault description"/>
						   			</td>
						   		</tr>
						   		<tr><td></td>
					        	<td id="errorMessage"><form:errors path="faultDescription"/></td>
					        	</tr>
					        	
						    
						    	<!-- Fault note --> 
								<tr>
									<td><spring:message code="label.faultNote"/></td>
									<td>
										<form:textarea path="faultNote" cols="30" rows="5" placeholder="Fault note"/>
									</td>
						      	</tr>
						    
						    
						    	<!-- Fault issued to -->
						    	<tr>
						    		<td><spring:message code="label.faultIssuedTo"/></td>
						    		<td>
						            	<form:select path="faultIssuedTo">
											<form:option value="" label="Select"/>
										    <form:options  items="${servicemanList}"/>
										</form:select>	
		            		 		</td>
		            		 	</tr>
		            		 	<tr><td></td>
					        	<td id="errorMessage"><form:errors path="faultIssuedTo"/></td>
					        	</tr>
					        	
		            		
		            			<!-- Fault issued by -->
						    	<tr>
						    		<td><spring:message code="label.faultIssuedBy"/></td>
						    		<td>
						            	<form:select path="faultIssuedBy">
											<form:option value="" label="Select"/>
										    <form:options  items="${adminList}"/>
										</form:select>	
		            				</td>
		            		 	</tr>
		            		 	<tr><td></td>
					        	<td id="errorMessage"><form:errors path="faultIssuedBy"/></td>
					        	</tr>
					        	
		            		
		            			<!-- Fault type -->
						    	<tr>
						    		<td><spring:message code="label.faultType"/></td>
						    		<td>
						            	<form:select path="faultType">
											<form:option value="" label="Select"/>
										    <form:options  items="${usersList}"/>
										</form:select>	
		            				</td>
		            		 	</tr>
		            		 	<tr><td></td>
					        	<td id="errorMessage"><form:errors path="faultType"/></td>
					        	</tr>
					        	
		            		
			            		<!-- Fault priority -->
							    <tr>
						    		<td><spring:message code="label.faultPriority"/></td>
						    		<td>
						            	<form:select path="faultPriority">
											<form:option value="" label="Select"/>
										    <form:options  items="${usersList}"/>
										</form:select>	
		            				</td>
		            		 	</tr>
		            		 	<tr><td></td>
					        	<td id="errorMessage"><form:errors path="faultPriority"/></td>
					        	</tr>
					        	
					        	<tr>
					        		<td colspan="2">
					        			<input type="submit" value=<spring:message code="label.submitButton"/> id="submitBtn"/>
					        		</td>
					        	</tr>  
		            		 	
							</table>
						
							
						
						</form:form>
						
					</div> <!-- end formHolder -->
	
		<div id="bottomToolbar"></div>
	
	</div> <!-- wrapper end -->		



</body>
</html>