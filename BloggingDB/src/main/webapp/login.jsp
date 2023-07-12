<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form  action="http://localhost:8080/BloggingDB/logincheck" method="post">
	<table>
	<tr>
		 <td>Enter Uid :</td>
		 <td><input type="text" name="uid"/></td>
	</tr>
	<tr>
		<td>Enter Pwd :</td>
		<td><input type="password" name="pwd"/></td>
	</tr>
	<tr>
	<td>
	<input type="Submit" value="login">
	</td>
	<td>
	<input type="reset" value="clear">
	</td>
	</tr>
	</table>
</form>

</body>
</html>