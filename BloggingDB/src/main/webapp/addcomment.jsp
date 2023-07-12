<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<c:forEach var="topic" items="${topics}">
  <tr>
		<td>${topic.tname}</td>
		<c:forEach var="comm" items="${Comment}">
 			<c:if test="${comm.topicid == topic.tid}"><td><ul><li>${comm.text}</li></ul> </td>  </c:if>	
		
		</c:forEach>
		<td><a href="Addcomm1.jsp?tid=${topic.tid}">add comment</a></td>
		</tr>
</c:forEach>
</table>
</body>
</html>