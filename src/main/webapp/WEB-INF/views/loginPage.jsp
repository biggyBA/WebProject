<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
      
    <head>
        <title>Login</title>
    </head>
    
    
    
    
    <body>
        
        
        
        <form:form action="login" method="post" modelAttribute="user">
        
        <table>
        
        <tr>
        <td>
        <form:input path="username"/>
        <td>
        </tr>
        
        
        <tr>
        <td>
        <form:input path="password" type="password"/>
        </td>
        </tr>
        
        
        <tr>
        <td>
        <input type="submit" value="Login"/>
        </td>
        </tr>
        </table>
        
        </form:form>
        
        
        
        
        
        
        
    </body>
</html>