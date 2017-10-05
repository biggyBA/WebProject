<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<link href="<c:url value="/resources/css/faultsOverviewTable.css" />" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Faults overview</title>
		<style>
			/* The Modal (background) */
			.modal {
			    display: none; /* Hidden by default */
			    position: fixed; /* Stay in place */
			    z-index: 1; /* Sit on top */
			    padding-top: 100px; /* Location of the box */
			    left: 0;
			    top: 0;
			    width: 100%; /* Full width */
			    height: 100%; /* Full height */
			    overflow: auto; /* Enable scroll if needed */
			    background-color: rgb(0,0,0); /* Fallback color */
			    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
			}
			
			/* Modal Content */
			.modal-content {
			    position: relative;
			    background-color: #fefefe;
			    margin: auto;
			    padding: 0;
			    border: 1px solid #888;
			    width: 80%;
			    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);
			    -webkit-animation-name: animatetop;
			    -webkit-animation-duration: 0.4s;
			    animation-name: animatetop;
			    animation-duration: 0.4s
			}
			
			/* Add Animation */
			@-webkit-keyframes animatetop {
			    from {top:-300px; opacity:0} 
			    to {top:0; opacity:1}
			}
			
			@keyframes animatetop {
			    from {top:-300px; opacity:0}
			    to {top:0; opacity:1}
			}
			
			/* The Close Button */
			.close {
			    color: white;
			    float: right;
			    font-size: 28px;
			    font-weight: bold;
			}
			
			.close:hover,
			.close:focus {
			    color: #000;
			    text-decoration: none;
			    cursor: pointer;
			}
			
			.modal-header {
			    padding: 2px 16px;
			    background-color: #5cb85c;
			    color: white;
			}
			
			.modal-body {padding: 2px 16px;}
			
			.modal-footer {
			    padding: 2px 16px;
			    background-color: #5cb85c;
			    color: white;
			}
					
		</style>
		
	</head>
	
<body>

	<jsp:include page="navigationDrawer.jsp"/>

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
	               
                <c:forEach var="fault" items="${toDoFaults}" varStatus="status">
                	
                <tr>
                	<td><fmt:formatDate value="${fault.dateTime}" pattern="dd.MM.yyyy" /></td>
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
                    <td><button id="myBtn">Open Modal</button></td>
                    <td><a href="${pageContext.request.contextPath}/editFault?id=${fault.idFault}">Edit</a></td>
                    <td><a href="${pageContext.request.contextPath}/archiveFault?id=${fault.idFault}">Archive</a></td>
                    <td><a href="${pageContext.request.contextPath}/deleteFault?id=${fault.idFault}">Delete</a></td>      
                </tr>
                </c:forEach>  
                           
            </table>
	</div> <!-- close tableHolder -->


<!-- Trigger/Open The Modal -->
<button id="my1Btn">Open Modal</button>

<!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <div class="modal-header">
      <span class="close">&times;</span>
      <h2>Modal Header</h2>
    </div>
    <div class="modal-body">
      <p>Some text in the Modal Body</p>
      <p>Some other text...</p>
    </div>
    <div class="modal-footer">
      <h3>Modal Footer</h3>
    </div>
  </div>

</div>

<script>
// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>

</body>

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
</script>
</html>