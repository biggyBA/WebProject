<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  		<link href="<c:url value="/resources/css/faultsOverviewTable.css" />" rel="stylesheet">
  		<style>
			  /* Popover */
			  .popover {
			      border: 2px black;
			  }
			  /* Popover Header */
			  .popover-title {
			      background-color: #73AD21; 
			      color: #FFFFFF; 
			      font-size: 28px;
			      text-align:center;
			  }
			  /* Popover Body */
			  .popover-content {
			      background-color: #f2f2f2;
			      color: black;
			      padding: 15px;
			  }
			  /* Popover Arrow */
			  .arrow {
			      border-right-color: red !important;
			  }
		  </style>
		  
		  <style type="text/css">
			#wrapper {
	    		display: none;
			}
			
			#loading {
				display: block;
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
			#faultCount{
			    color:#D5DDE5;
			    font-size:18px;
			    float: right;
			    width: 9%;
			    padding-top: 10px;
			}
			
			#search{
			    width: 50%;
			    float: left;
			}
			
			#top{
			    width: 100%;
			    display: inline-block;
			    padding-top: 10px;
			}
		</style>
  		
		
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Faults overview</title>
		<script>
			function searchFunction() {
			  // Declare variables 
			  var input, filter, table, tr, td, i;
			  input = document.getElementById("searchInput");
			  filter = input.value.toUpperCase();
			  table = document.getElementById("table-fill");
			  tr = table.getElementsByTagName("tr");
			
			  // Loop through all table rows, and hide those who don't match the search query
			  for (i = 0; i < tr.length; i++) {
			    td = tr[i].getElementsByTagName("td")[8];
			    if (td) {
			      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
			        tr[i].style.display = "";
			      } else {
			        tr[i].style.display = "none";
			      }
			    } 
			  }
			}

			
			
			function getAlert(){
				var bpmnJsonString = '${obj}';
				var bpmn = JSON.parse(bpmnJsonString);
				var bpmnXML = bpmn.lng;
				alert(bpmnXML)

			}
		</script>
		
		<script type="text/javascript">
			function onReady(callback) {
			    var intervalID = window.setInterval(checkReady, 1000);
			
			function checkReady() {
			    if (document.getElementsByTagName('body')[0] !== undefined) {
			            window.clearInterval(intervalID);
			            callback.call(this);
			        }
			    }
			}
			
			function show(id, value) {
			    document.getElementById(id).style.display = value ? 'block' : 'none';
			}
			
			onReady(function () {
			    show('wrapper', true);
			    show('loading', false);
			});
		</script>
	</head>
	
<body>

	<jsp:include page="navigationDrawer.jsp"/>
	
	<div id="wrapper">

	<div id="top">
		<div id="search"><input type="text" id="searchInput" onkeyup="searchFunction()" placeholder="Find by fault description..."></div>
		<div id="faultCount">${faultCount} fault(s) to do</div>
	</div> <!-- close top -->

	<div id="tableHolder">
	
            <table id="table-fill">
	            <thead>
	            	<tr class="header">
		                <th width="60px">Date</th>
		                <th width="70px">Time</th>
		                <th width="110px">Product type</th>
		                <th>Client</th>
		                <th>Street</th>
		                <th>Place</th>
		                <th>Phone #1</th>
		                <th>Phone #2</th>
		                <th width="260px">Fault description</th>
		                <th width="260px">Note</th>
		                <th>Fault issued to</th>
		                <th>Type of fault</th>
	                </tr> 
	             </thead>  
	             
	             <tbody>
	                <c:forEach var="fault" items="${toDoFaults}" varStatus="status">	
		                <tr>
		                	<td style="display:none;">${fault.idFault}</td>
		                	<td class="mytable tr"><fmt:formatDate value="${fault.dateTime}" pattern="dd.MM.yyyy" /></td>
		                	<td><fmt:formatDate value="${fault.dateTime}" pattern="HH:mm:ss" /></td>
		                    <td>${fault.productType}</td>
		                    <td>${fault.clientName}</td> 
		                    <td>${fault.clientStreet}</td>
		                    <td>${fault.clientPlace}</td>
		                    <td>${fault.clientPhoneOne}</td>
		                    <td>${fault.clientPhoneTwo}</td>
		                    <td>${fault.faultDescription}</td> 
		                    <td>${fault.faultNote}</td> 
		                    <td>${fault.faultIssuedTo}</td>
		                    <td>${fault.faultType}</td> 
		                    <td><a href="${pageContext.request.contextPath}/viewFaultDetails?id=${fault.idFault}"><img src="resources/images/ic_location_on_black.png" alt="Map" width="30" height="30" ></a></td>
		                    <td><a href="${pageContext.request.contextPath}/editFault?id=${fault.idFault}">Edit</a></td>
		                    <td><a href="${pageContext.request.contextPath}/archiveFault?id=${fault.idFault}">Archive</a></td>
		                    <td><a href="${pageContext.request.contextPath}/deleteFault?id=${fault.idFault}">Delete</a></td>      
		                </tr>
	                </c:forEach>
                 </tbody>     
            </table>
            
	</div> <!-- close tableHolder -->
	
	</div>

<div id="loading"></div>


<script>

$(document).ready(function(){

	$("#table-fill").on('click','.btnSelect',function(){
        // get the current row
        var currentRow=$(this).closest("tr"); 
        
        var rowId=currentRow.find("td:eq(0)").text(); 
        return rowId
        //alert(rowId);
   });


	
	
    $('[data-toggle="popoverDelete"]').popover({
    	placement: 'left',
    	html: true,
        content: function() {
        	return $('#deleteFaultPopover').html();
    	}

    }); 
});




</script>

</body>


</html>