<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page session="true"%>

<html>

	<head>
		<link href="<c:url value="/resources/css/servicemanServiceReport.css" />" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Service report</title>
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
			
					<form:form action="submitServiceReport" method="post" modelAttribute="serviceReport">
						<table>
							<!-- Date -->
						
							
							<tr>
								<!-- Client name -->
								<td><spring:message code="label.serviceReport.clientName"/></td>
								<td><form:input path="clientName" type="text" placeholder="Name"/></td>
								<td></td>
								<!-- Product id -->
								<td><spring:message code="label.serviceReport.productId"/></td>
								<td><form:input path="productId" type="text" placeholder="Product ID"/></td>
							</tr>
							<tr>
								<td></td>
								<td id="errorMessage"><form:errors path="clientName"/></td>
								<td></td>
								<td></td>
								<td id="errorMessage"><form:errors path="productId"/></td>
							</tr>
							
							
							
							<tr>
								<!-- Client street -->
								<td><spring:message code="label.serviceReport.clientStreet"/></td>
								<td><form:input path="clientStreet" type="text" placeholder="Street"/></td>
								<td></td>
								<!-- Product serial number -->
								<td><spring:message code="label.serviceReport.productSerialNumber"/></td>
								<td><form:input path="productSerialNumber" type="text" placeholder="S/N"/></td>
							</tr>
							<tr>
								<td></td>
								<td id="errorMessage"><form:errors path="clientStreet"/></td>
								<td></td>
								<td></td>
								<td id="errorMessage"><form:errors path="productSerialNumber"/></td>
							</tr>
							
							
							
							<tr>
								<!-- Client postal code -->
								<td><spring:message code="label.serviceReport.clientPostalCode"/></td>
								<td><form:input path="clientPostalCode" type="text" placeholder="Postal code"/></td>
								<td></td>
								<!-- Product buy date -->
								<td><spring:message code="label.serviceReport.productBuyDate"/></td>
								<td><form:input path="productBuyDate" type="text" placeholder="Buy date"/></td>
							</tr>
							<tr>
								<td></td>
								<td id="errorMessage"><form:errors path="clientPostalCode"/></td>
								<td></td>
								<td></td>
								<td id="errorMessage"><form:errors path="productBuyDate"/></td>
							</tr>
							
							
							<!-- Client place -->
							<tr>
								<td><spring:message code="label.serviceReport.clientPlace"/></td>
								<td><form:input path="clientPlace" type="text" placeholder="Place"/></td>
							</tr>
							<tr>
								<td></td>
								<td id="errorMessage"><form:errors path="clientPlace"/></td>
							</tr>
							
							<!-- Client phone one -->
							<tr>
								<td><spring:message code="label.serviceReport.clientPhoneOne"/></td>
								<td><form:input path="clientPhoneOne" type="text" placeholder="Phone #1"/></td>
							</tr>
							<tr>
								<td></td>
								<td id="errorMessage"><form:errors path="clientPhoneOne"/></td>
							</tr>
							
							<!-- Client phone two -->
							<tr>
								<td><spring:message code="label.serviceReport.clientPhoneTwo"/></td>
								<td><form:input path="clientPhoneTwo" type="text" placeholder="Phone #2"/></td>
							</tr>
							<tr>
								<td></td>
								<td id="errorMessage"><form:errors path="clientPhoneTwo"/></td>
							</tr>
							
							<!-- Client E-mail -->
							<tr>
								<td><spring:message code="label.serviceReport.clientEmail"/></td>
								<td><form:input path="clientEmail" type="text" placeholder="E-mail"/></td>
							</tr>
							<tr>
								<td></td>
								<td id="errorMessage"><form:errors path="clientEmail"/></td>
							</tr>
							
							<!-- Fault description -->
							<tr>
								<td><spring:message code="label.serviceReport.faultDescription"/></td>
								<td colspan="4"><form:textarea path="faultDescription" rows="5" placeholder="Fault description"/></td>
							</tr>
						
								
						</table>
					
					
					</form:form>
			
			
			
			</div> <!-- leftBlock end -->
		
			
		
		</div> <!-- wrapper end -->


<div id="loading"></div>
	

</body>
</html>