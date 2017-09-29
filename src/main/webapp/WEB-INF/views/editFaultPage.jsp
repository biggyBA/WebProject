<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<link href="<c:url value="/resources/css/editFaultPage.css" />" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Edit fault</title>
	</head>
	
	
<body>

	<jsp:include page="navigationDrawer.jsp"></jsp:include>
	
	<div id="wrapper">
		
		
			<div id="leftBlock">
				<div id="leftBlockInner">
					<form:form action="" method="post" modelAttribute="fault">
						<table>
							<form:hidden path="idFault"/>
							<form:input path="faultStatus" type="hidden" value="UrgentToDo"/>
							
							<tr>
								<td>Product type:</td>
								<td>
									<form:select path="productType">
										<form:option value="0" label="Select"/>
										<form:options items="${productTypeList}"/>
									</form:select>
								</td>
							</tr>
							
							<tr>
								<td>Serial number:</td>
								<td><form:input path="productSerialNumber"/></td>
							</tr>
						
						</table>
					</form:form>
				</div> <!-- leftBlockInner end -->
			</div> <!-- leftBlock end -->
			
			
			
			<div id="rightBlock">
			
					<div>
						<label>Edit fault by JSON</label>
				    </div>
			</div> <!-- rightBlock end -->
		
			
	</div> <!-- wrapper end -->		



</body>
</html>