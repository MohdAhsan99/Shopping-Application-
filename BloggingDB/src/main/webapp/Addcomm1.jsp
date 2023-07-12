<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <form action="addC" >
    Enter comm : <input type="text"  name="comm"/>
    <input type="hidden" name="topicid" value="${param.tid}" />
   <input type="submit" value="Add Comment"/>
  
  </form>

</body>
</html>