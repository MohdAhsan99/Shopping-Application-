<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
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
	<c:forEach var="topic" items="${topics}">
		<a href="getText?tid=${topic.tid}"> ${topic.tname}  </a> <br/>
		  
		       <c:forEach var="comm" items="${Comment1}">
		       <c:if test="${comm.topicid == topic.tid}"><p>${comm.text} </p>  </c:if>
		           
		       
		       </c:forEach>
	</c:forEach>
	 <a href="login.jsp">Login</a>
</body>
</html>