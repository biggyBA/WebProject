<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page session="true"%>

<html>

	<head>
		<link href="<c:url value="/resources/css/_mAdminSubmitFault.css" />" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Submit fault</title>
		<script>
		function showLoader(){
			var wrapper = document.getElementById("wrapper");
			var loader = document.getElementById("loading");
			loader.style.display = "block";
			wrapper.style.display = "none";
		}
		</script>
	</head>
	
<body>
	<jsp:include page="../../navigationDrawer.jsp"></jsp:include>
	
	<div id="wrapper">
		
			<div id="leftBlock">
			
					<form:form action="submitFault" method="post" modelAttribute="fault">
							
							<table>
								<!-- Date and time now -->
								<form:input path="dateTime" type="hidden" id="dateTimeLabel"/>
								<script type="text/javascript">
									var nowDateTime = new Date();
									var labelDateTime = document.getElementById("dateTimeLabel");
									labelDateTime.value = nowDateTime;
								</script>
					
								<!-- Fault status -->
					        	<form:input path="faultStatus" type="hidden" value="UrgentToDo"/>
					        	
					        	<!-- Product id -->
					        	<tr>
					        		<td>
					        			<form:select path="productId">
											<form:option value="" label="Select product type"/>
										    <form:options  items="${productTypeList}"/>
										</form:select>
					        		</td>
					        	</tr>
					        	<tr>
					        		<td id="errorMessage"><form:errors path="productId"/></td>
					        	</tr>
					        	
					        	
					        	<!-- Product serial number -->
					        	<tr>
					        		<td>
					        			<form:input path="productSerialNumber" type="text" placeholder="Serial number"/>
					        		</td>
					        	</tr>
					        	<tr>
					        		<td id="errorMessage"><form:errors path="productSerialNumber"/></td>
					        	</tr>
					        	
					        	
					        	<!-- Client name -->
								<tr>
									<td>
										<form:input path="clientName" type="text" placeholder="Name"/>
									</td>
								</tr>
								<tr>
					        		<td id="errorMessage"><form:errors path="clientName"/></td>
					        	</tr>
					        	
								
								<!-- Client street -->
								<tr>
									<td>
										<form:input path="clientStreet" type="text" placeholder="Street"/>
									</td>
								</tr>
								<tr>
					        		<td id="errorMessage"><form:errors path="clientStreet"/></td>
					        	</tr>
					        	
					        	
					        	<!-- Postal code -->
								<tr>
									<td>
										<form:input path="clientPostalCode" type="text" placeholder="Postal code"/>
									</td>
								</tr>
								
					        	
								
								<!-- Client place -->
								<tr>
									<td>
										<form:input path="clientPlace" type="text" placeholder="Place"/>
									</td>
								</tr>
								<tr>
					        		<td id="errorMessage"><form:errors path="clientPlace"/></td>
					        	</tr>
					        	
								
								<!-- Client phone number one -->
								<tr>
									<td>
										<form:input path="clientPhoneOne" type="text" placeholder="Phone #1"/>
									</td>
								</tr>
								<tr>
					        		<td id="errorMessage"><form:errors path="clientPhoneOne"/></td>
					        	</tr>
					        	
								
								<!-- Client phone number two --> 
								<tr>
									<td>
										<form:input path="clientPhoneTwo" type="text" placeholder="Phone #2"/>
									</td>
								</tr>
								
								<!-- Client email --> 
								<tr>
									<td>
										<form:input path="clientEmail" type="text" placeholder="E-mail"/>
									</td>
						    	</tr>
						    	<tr>
					        		<td id="errorMessage"><form:errors path="clientEmail"/></td>
					        	</tr>
					        	
						    	
						    	<!-- Fault description --> 
								<tr>
									<td>
										<form:textarea path="faultDescription" cols="30" rows="5" placeholder="Fault description"/>
						   			</td>
						   		</tr>
						   		<tr>
					        		<td id="errorMessage"><form:errors path="faultDescription"/></td>
					        	</tr>
					        	
						    
						    	<!-- Fault note --> 
								<tr>
									<td>
										<form:textarea path="faultNote" cols="30" rows="5" placeholder="Fault note"/>
									</td>
						      	</tr>
						    
						    
						    	<!-- Fault issued to -->
						    	<tr>
						    		<td>
						            	<form:select path="faultIssuedTo">
											<form:option value="" label="Select"/>
										    <form:options  items="${servicemanList}"/>
										</form:select>	
		            		 		</td>
		            		 	</tr>
		            		 	<tr>
					        		<td id="errorMessage"><form:errors path="faultIssuedTo"/></td>
					        	</tr>
					        	
		            		
		            			<!-- Fault issued by -->
						    	<tr>
						    		<td>
						            	<form:select path="faultIssuedBy">
											<form:option value="" label="Select"/>
										    <form:options  items="${adminList}"/>
										</form:select>	
		            				</td>
		            		 	</tr>
		            		 	<tr>
					        		<td id="errorMessage"><form:errors path="faultIssuedBy"/></td>
					        	</tr>
					        	
		            		
		            			<!-- Fault type -->
						    	<tr>
						    		<td>
						            	<form:select path="faultType">
											<form:option value="" label="Select"/>
										    <form:options  items="${typeOfServiceList}"/>
										</form:select>	
		            				</td>
		            		 	</tr>
		            		 	<tr>
					        		<td id="errorMessage"><form:errors path="faultType"/></td>
					        	</tr>
					        	
		            		
			            		<!-- Fault priority -->
							    <tr>
						    		<td>
						            	<form:select path="faultPriority">
											<form:option value="" label="Select"/>
										    <form:options  items="${typeOfServiceList}"/>
										</form:select>	
		            				</td>
		            		 	</tr>
		            		 	<tr>
		            		 		<td id="errorMessage"><form:errors path="faultPriority"/></td>
		            		 	</tr>
		            		 	  
		            		 	
							</table>
						
							<input type="submit" value=<spring:message code="label.submitButton"/> id="submitBtn" onclick="showLoader()"/>
						
						</form:form>
			
			
			
			</div> <!-- leftBlock end -->
		
			
		
		</div> <!-- wrapper end -->


<div id="loading"></div>

</body>
</html>