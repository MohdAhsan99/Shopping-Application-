<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="1" >
<tr>
		<td>Topic id</td>
		<td>User id</td>
		<td>Comment</td>
		</tr>
<c:forEach var="comm" items="${Comment}">
		
		
		  <tr>
		  <td>${comm.topicid}</td>
		  <td>${comm.uid}</td>
		  <td>${comm.text}</td>
		  </tr>
		
</c:forEach>
</table>

</body>
</html>