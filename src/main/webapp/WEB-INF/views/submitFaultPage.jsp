<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>

	<head>
		<link href="<c:url value="/resources/css/submitFaultPage.css" />" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<style type="text/css">
		#errorMessage{
			color: red;
			padding-left: 22px;
			font-size: 0.75em;
		}
		
		#loading{
			display: none;
			position: absolute;
			top: 0;
			left: 0;
			z-index: 100;
			width: 100vw;
			height: 100vh;
			background-color: rgba(192, 192, 192, 0.5);
			background-image: url("http://i.stack.imgur.com/MnyxU.gif");
			background-repeat: no-repeat;
			background-position: center;
		}
		</style>
		
		<script>
		function myFunction() {
		    alert("Function is not implemented");
		}

		function showLoader(){
			var wrapper = document.getElementById("wrapper");
			var loader = document.getElementById("loading");
			loader.style.display = "block";
			wrapper.style.display = "none";
		}
		</script>
		
		<title>Submit fault</title>
	</head>
	
	<body>
		<jsp:include page="navigationDrawer.jsp"></jsp:include>

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
										    <form:options  items="${usersList}"/>
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
										    <form:options  items="${usersList}"/>
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
		            		 	
							</table>
						
							<input type="submit" value=<spring:message code="label.submitButton"/> id="submitBtn" onclick="showLoader()"/>
						
						</form:form>
			
			
			
			</div> <!-- leftBlock end -->
		
			
			
			
			
			<div id="rightBlock"> 
					
						<form:form action="saveFaultJSON" method="post" modelAttribute="fault">
							
							<table>
								<!-- Date and time now -->
								<form:input path="dateTime" type="hidden" id="dateTimeLabel"/>
								
					
								<!-- Fault status -->
					        	<form:input path="faultStatus" type="hidden" value="UrgentToDo"/>
					        	
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
					        	
					        	<!-- Product serial number -->
					        	<tr>
					        		<td><spring:message code="label.productSerialNumber"/></td>
					        		<td>
					        			<form:input path="productSerialNumber" type="text" placeholder="Serial number"/>
					        		</td>
					        	</tr>
					        	
					        	<!-- Client name -->
								<tr>
									<td><spring:message code="label.clientName"/></td>
									<td>
										<form:input path="clientName" type="text" placeholder="Name"/>
									</td>
								</tr>
								
								<!-- Client street -->
								<tr>
									<td><spring:message code="label.clientStreet"/></td>
									<td>
										<form:input path="clientStreet" type="text" placeholder="Street"/>
									</td>
								</tr>
								
								<!-- Client place -->
								<tr>
									<td><spring:message code="label.clientPlace"/></td>
									<td>
										<form:input path="clientPlace" type="text" placeholder="Place"/>
									</td>
								</tr>
								
								<!-- Client phone number one -->
								<tr>
									<td><spring:message code="label.clientPhoneOne"/></td>
									<td>
										<form:input path="clientPhoneOne" type="text" placeholder="Phone #1"/>
									</td>
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
						    	
						    	<!-- Fault description --> 
								<tr>
									<td><spring:message code="label.faultDescription"/></td>
									<td>
										<form:textarea path="faultDescription" cols="30" rows="5" placeholder="Fault description"/>
						   			</td>
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
										    <form:options  items="${usersList}"/>
										</form:select>	
		            		 		</td>
		            		 	</tr>
		            		
		            			<!-- Fault issued by -->
						    	<tr>
						    		<td><spring:message code="label.faultIssuedBy"/></td>
						    		<td>
						            	<form:select path="faultIssuedBy">
											<form:option value="" label="Select"/>
										    <form:options  items="${usersList}"/>
										</form:select>	
		            				</td>
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
		            		 	
							</table>
							<!--  
							<input type="submit" value=<spring:message code="label.submitButtonByJSON"/> id="submitBtnJSON"/>
							-->
							
						</form:form>
						<button id="submitBtnJSON" onclick="myFunction()" ><spring:message code="label.submitButtonByJSON"/></button>
					
			</div> <!-- rightBlock end -->
		
		</div> <!-- wrapper end -->


<div id="loading"></div>


</body>




</html>