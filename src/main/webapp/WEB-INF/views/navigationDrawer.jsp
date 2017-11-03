<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<div id="mySidenav" class="sidenav">
	<a href="#"><img src="/resources/images/icon_add_file.png"/><spring:message code="label.nav.submitFault"/></a>
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="${pageContext.request.contextPath}/submitFault">Submit fault</a>
  <a href="${pageContext.request.contextPath}/container/faultsOverview">Faults overview</a>
  <a href="${pageContext.request.contextPath}/user/faultsOverviewMap">Map faults overview</a>
  <sec:authorize access="hasRole('ROLE_SERVICEMAN')">
  	<a href="${pageContext.request.contextPath}/serviceman/myServices">My services</a>
	<a href="${pageContext.request.contextPath}/serviceman/serviceReport">Service report</a>					
  </sec:authorize>
  <a href="${pageContext.request.contextPath}/test">Test</a>
  <c:if test="${pageContext.request.userPrincipal.name != null}">
     | &nbsp;
     <a href="${pageContext.request.contextPath}/logout">Logout</a>
  </c:if>
</div>

<span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;</span>
<style>
body {
    font-family: "Lato", sans-serif;
}

.sidenav {
    height: 100%;
    width: 0;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    background-color: #111;
    overflow-x: hidden;
    transition: 0.3s;
    padding-top: 60px;
}

.sidenav a {
    padding: 8px 8px 8px 32px;
    text-decoration: none;
    font-size: 25px;
    color: #818181;
    display: block;
    transition: 0.3s;
}

.sidenav a:hover {
    color: #f1f1f1;
}

.sidenav .closebtn {
    position: absolute;
    top: 0;
    right: 25px;
    font-size: 36px;
    margin-left: 50px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
</style>

<script>
function openNav() {
    document.getElementById("mySidenav").style.width = "300px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}
</script>

