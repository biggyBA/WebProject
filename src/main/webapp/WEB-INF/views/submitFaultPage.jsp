<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Submit fault</title>
	</head>
	
	<body>
		<jsp:include page="navigationDrawer.jsp"></jsp:include>

		<div id="wrapper">
		
			<div id="leftBlock">
			
				<div id="leftBlockInner">
			
					<form:form action="saveFault" method="post" modelAttribute="fault">
					
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
					        <div>	
					        	<form:select path="productId">
									<form:option value="" label="Select product type"/>
								    <form:options  items="${productTypeList}"/>
								</form:select>
							</div>
							
							<!-- Product serial number -->
							<div>
								<form:input path="productSerialNumber" type="text" placeholder="Serial number"/>
							</div>
						
							
						
						
							<!-- Client name -->
							<div>
								<form:input path="clientName" type="text" placeholder="Name"/>
							</div>
								
							<!-- Client street -->
							<div>
								<form:input path="clientStreet" type="text" placeholder="Street"/>
							</div>
								
							<!-- Client place -->
							<div>
								<form:input path="clientPlace" type="text" placeholder="Place"/>
							</div>
								
							<!-- Client phone number one -->
							<div>
								<form:input path="clientPhoneOne" type="text" placeholder="Phone #1"/>
							</div>
								
							<!-- Client phone number two --> 
							<div>
								<form:input path="clientPhoneTwo" type="text" placeholder="Phone #2"/>
							</div>
								
							<!-- Client email --> 
							<div>
								<form:input path="clientEmail" type="text" placeholder="E-mail"/>
						    </div>
					    
					    
					    
					    
						    <!-- Fault description --> 
							<div>
								<form:textarea path="faultDescription" cols="30" rows="5" placeholder="Fault description"/>
						    </div>
						    
						    <!-- Fault note --> 
							<div>
								<form:textarea path="faultNote" cols="30" rows="5" placeholder="Fault note"/>
						    </div>  
						    
						    <!-- Fault issued to -->
						    <div>
				            	<form:select path="faultIssuedTo">
									<form:option value="" label="Select"/>
								    <form:options  items="${usersList}"/>
								</form:select>	
		            		</div> 
		            		
		            		<!-- Fault issued by -->
						    <div>
				            	<form:select path="faultIssuedBy">
									<form:option value="" label="Select"/>
								    <form:options  items="${usersList}"/>
								</form:select>	
		            		</div>
		            		
		            		<!-- Fault type -->
						    <div>
				            	<form:select path="faultType">
									<form:option value="" label="Select"/>
								    <form:options  items="${usersList}"/>
								</form:select>	
		            		</div>
		            		
		            		<!-- Fault priority -->
						    <div>
				            	<form:select path="faultPriority">
									<form:option value="" label="Select"/>
								    <form:options  items="${usersList}"/>
								</form:select>	
		            		</div>  
					     
							<input type="submit" value="Submit fault" id="submitBtn"/>
					      
					      
					
					</form:form>
			
				</div> <!-- leftBlockInner end -->
			
			
			</div> <!-- leftBlock end -->
		
			
			<div id="rightBlock">
			<!-- Client email --> 
					<div>
						<label>Submit fault by JSON</label>
				    </div>
			</div> <!-- rightBlock end -->
		
		
		</div> <!-- wrapper end -->





</body>

<style type="text/css">

#wrapper{
	width: 100%;
    height:100%;
}

#leftBlock {
	width: 50%;
	height:100%;
	display: block;
    background-color: #000033;
    float:left; 
    overflow-y: scroll;
}

#leftBlockInner{
	width: 70%;
  	margin: 0 auto;
	height:100%;
}

#rightBlock {
	width: 50%;
	height:100%;
	display: block;
    background-color: #000033; 
    float:left;
    overflow-y: scroll;
}

#submitBtn {
    background: rgb(242, 247, 247);
    border: 1px solid black;
    font-family: 'Merriweather', sans-serif;
    color: black; 
    font-size: 15px;
}

select {
     border:0; outline:0;
     padding: 1em;
     border-radius: 8px;
     display: block;
     margin-top: 1em;
     font-family: 'Merriweather', sans-serif;
     resize: none;
     position: relative;
     display: block;
     margin : 10 auto;
     width: 88%;
  }
  
textarea {
     border:0; outline:0;
     padding: 1em;
     border-radius: 8px;
     display: block;
     margin-top: 1em;
     font-family: 'Merriweather', sans-serif;
     resize: none;
     position: relative;
     display: block;
     margin : 10 auto;
     width: 88%;
  }

input{
     border:0; outline:0;
     padding: 1em;
     border-radius: 8px;
     display: block;
     margin-top: 1em;
     font-family: 'Merriweather', sans-serif;
     resize: none;
     position: relative;
     display: block;
     margin : 10 auto;
     width: 88%;
  }
  
label{
	display: block;
	margin-top: 5px;
	margin-left: 15px;
	font-family: 'Merriweather', sans-serif;
	color: white;
	font-weight: bold;
}
  




</style>

</html>