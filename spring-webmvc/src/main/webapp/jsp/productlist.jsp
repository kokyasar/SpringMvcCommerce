<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Product List</h1>  
<table border="2" width="70%" cellpadding="2">    
   <c:forEach var="list" items="${list}">   
   <tr>  
   <td>${list.id}</td>
   <td>${list.itemName}</td>  
   <td>${list.itemDetail}</td>  
   <td>${list.itemPrice}</td>  
   <td>${list.categoryId}</td>    
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
  <a href="login">Home</a>
</body>
</html>