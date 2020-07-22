<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>User List</h1>  
<table border="2" width="70%" cellpadding="2">    
   <c:forEach var="user" items="${list}">   
   <tr>  
   <td>${user.username}</td>  
   <td>${user.password}</td>  
   <td>${user.firstname}</td>  
   <td>${user.lastname}</td> 
   <td>${user.email}</td>
   <td>${user.address}</td> 
   <td>${user.phone}</td>   
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
  <a href="login">Home</a>

</body>
</html>