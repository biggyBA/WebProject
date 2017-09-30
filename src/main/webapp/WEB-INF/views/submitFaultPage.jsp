<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

	<head>
		<link href="<c:url value="/resources/css/submitFaultPage.css" />" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script type="text/javascript">
			var nowDateTime = new Date();
			var labelDateTime = document.getElementById("dateTimeLabel");
			labelDateTime.value = nowDateTime;
		</script>
		
		
		
		<title>Submit fault</title>
	</head>
	
	<body>
		<jsp:include page="navigationDrawer.jsp"></jsp:include>

		<div id="wrapper">
		
			<div id="leftBlock">
			
					<form:form action="saveFault" method="post" modelAttribute="fault">
							
							<table>
								<!-- Date and time now -->
								<form:input path="dateTime" type="hidden" id="dateTimeLabel"/>
								
					
								<!-- Fault status -->
					        	<form:input path="faultStatus" type="hidden" value="UrgentToDo"/>
					        	
					        	<!-- Product id -->
					        	<tr>
					        		<td>Product ID</td>
					        		<td>
					        			<form:select path="productId">
											<form:option value="" label="Select product type"/>
										    <form:options  items="${productTypeList}"/>
										</form:select>
					        		</td>
					        	</tr>
					        	
					        	<!-- Product serial number -->
					        	<tr>
					        		<td>Product S/N</td>
					        		<td>
					        			<form:input path="productSerialNumber" type="text" placeholder="Serial number"/>
					        		</td>
					        	</tr>
					        	
					        	<!-- Client name -->
								<tr>
									<td>Client name</td>
									<td>
										<form:input path="clientName" type="text" placeholder="Name"/>
									</td>
								</tr>
								
								<!-- Client street -->
								<tr>
									<td>Client street</td>
									<td>
										<form:input path="clientStreet" type="text" placeholder="Street"/>
									</td>
								</tr>
								
								<!-- Client place -->
								<tr>
									<td>Client place</td>
									<td>
										<form:input path="clientPlace" type="text" placeholder="Place"/>
									</td>
								</tr>
								
								<!-- Client phone number one -->
								<tr>
									<td>Client Phone #1</td>
									<td>
										<form:input path="clientPhoneOne" type="text" placeholder="Phone #1"/>
									</td>
								</tr>
								
								<!-- Client phone number two --> 
								<tr>
									<td>Client Phone #2</td>
									<td>
										<form:input path="clientPhoneTwo" type="text" placeholder="Phone #2"/>
									</td>
								</tr>
								
								<!-- Client email --> 
								<tr>
									<td>Client E-mail</td>
									<td>
										<form:input path="clientEmail" type="text" placeholder="E-mail"/>
									</td>
						    	</tr>
						    	
						    	<!-- Fault description --> 
								<tr>
									<td>Fault description</td>
									<td>
										<form:textarea path="faultDescription" cols="30" rows="5" placeholder="Fault description"/>
						   			</td>
						   		</tr>
						    
						    	<!-- Fault note --> 
								<tr>
									<td>Fault note</td>
									<td>
										<form:textarea path="faultNote" cols="30" rows="5" placeholder="Fault note"/>
									</td>
						      	</tr>
						    
						    	<!-- Fault issued to -->
						    	<tr>
						    		<td>Fault issued to</td>
						    		<td>
						            	<form:select path="faultIssuedTo">
											<form:option value="" label="Select"/>
										    <form:options  items="${usersList}"/>
										</form:select>	
		            		 		</td>
		            		 	</tr>
		            		
		            			<!-- Fault issued by -->
						    	<tr>
						    		<td>Fault issued by</td>
						    		<td>
						            	<form:select path="faultIssuedBy">
											<form:option value="" label="Select"/>
										    <form:options  items="${usersList}"/>
										</form:select>	
		            				</td>
		            		 	</tr>
		            		
		            			<!-- Fault type -->
						    	<tr>
						    		<td>Fault type</td>
						    		<td>
						            	<form:select path="faultType">
											<form:option value="" label="Select"/>
										    <form:options  items="${usersList}"/>
										</form:select>	
		            				</td>
		            		 	</tr>
		            		
			            		<!-- Fault priority -->
							    <tr>
						    		<td>Fault type</td>
						    		<td>
						            	<form:select path="faultPriority">
											<form:option value="" label="Select"/>
										    <form:options  items="${usersList}"/>
										</form:select>	
		            				</td>
		            		 	</tr>  
		            		 	
							</table>
						
							<input type="submit" value="Submit fault" id="submitBtn"/>
						
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
					        		<td>Product ID</td>
					        		<td>
					        			<form:select path="productId">
											<form:option value="" label="Select product type"/>
										    <form:options  items="${productTypeList}"/>
										</form:select>
					        		</td>
					        	</tr>
					        	
					        	<!-- Product serial number -->
					        	<tr>
					        		<td>Product S/N</td>
					        		<td>
					        			<form:input path="productSerialNumber" type="text" placeholder="Serial number"/>
					        		</td>
					        	</tr>
					        	
					        	<!-- Client name -->
								<tr>
									<td>Client name</td>
									<td>
										<form:input path="clientName" type="text" placeholder="Name"/>
									</td>
								</tr>
								
								<!-- Client street -->
								<tr>
									<td>Client street</td>
									<td>
										<form:input path="clientStreet" type="text" placeholder="Street"/>
									</td>
								</tr>
								
								<!-- Client place -->
								<tr>
									<td>Client place</td>
									<td>
										<form:input path="clientPlace" type="text" placeholder="Place"/>
									</td>
								</tr>
								
								<!-- Client phone number one -->
								<tr>
									<td>Client Phone #1</td>
									<td>
										<form:input path="clientPhoneOne" type="text" placeholder="Phone #1"/>
									</td>
								</tr>
								
								<!-- Client phone number two --> 
								<tr>
									<td>Client Phone #2</td>
									<td>
										<form:input path="clientPhoneTwo" type="text" placeholder="Phone #2"/>
									</td>
								</tr>
								
								<!-- Client email --> 
								<tr>
									<td>Client E-mail</td>
									<td>
										<form:input path="clientEmail" type="text" placeholder="E-mail"/>
									</td>
						    	</tr>
						    	
						    	<!-- Fault description --> 
								<tr>
									<td>Fault description</td>
									<td>
										<form:textarea path="faultDescription" cols="30" rows="5" placeholder="Fault description"/>
						   			</td>
						   		</tr>
						    
						    	<!-- Fault note --> 
								<tr>
									<td>Fault note</td>
									<td>
										<form:textarea path="faultNote" cols="30" rows="5" placeholder="Fault note"/>
									</td>
						      	</tr>
						    
						    	<!-- Fault issued to -->
						    	<tr>
						    		<td>Fault issued to</td>
						    		<td>
						            	<form:select path="faultIssuedTo">
											<form:option value="" label="Select"/>
										    <form:options  items="${usersList}"/>
										</form:select>	
		            		 		</td>
		            		 	</tr>
		            		
		            			<!-- Fault issued by -->
						    	<tr>
						    		<td>Fault issued by</td>
						    		<td>
						            	<form:select path="faultIssuedBy">
											<form:option value="" label="Select"/>
										    <form:options  items="${usersList}"/>
										</form:select>	
		            				</td>
		            		 	</tr>
		            		
		            			<!-- Fault type -->
						    	<tr>
						    		<td>Fault type</td>
						    		<td>
						            	<form:select path="faultType">
											<form:option value="" label="Select"/>
										    <form:options  items="${usersList}"/>
										</form:select>	
		            				</td>
		            		 	</tr>
		            		
			            		<!-- Fault priority -->
							    <tr>
						    		<td>Fault type</td>
						    		<td>
						            	<form:select path="faultPriority">
											<form:option value="" label="Select"/>
										    <form:options  items="${usersList}"/>
										</form:select>	
		            				</td>
		            		 	</tr>  
		            		 	
							</table>
						
							<input type="submit" value="Submit fault by JSON" id="submitBtnJSON"/>
						
						</form:form>
					
			</div> <!-- rightBlock end -->
		
		</div> <!-- wrapper end -->





</body>



</html>