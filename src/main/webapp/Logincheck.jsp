<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <div style="color:bisque; background-color:blue;"><h1 style="margin-left: 30%;">Welcome to Shopping Cart</h1></div>
    <div >
    <form action="http://localhost:8080/ShoppingDB/logincheck" method="post">
		<table style="margin-left: 37%;">
			<tr>
				<td>Enter uid:</td>
				<td><input type="text" name="uid"></td>
			</tr>
			<tr>
				<td>Enter pwd:</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit" /></td>
				<td><input type="reset" value="clear" /></td>
			</tr>
			<tr>
			<td>
			
			</td>
			<td>
			<a href='/ShoppingDB/signup.jsp' style='color: red;'> signup</a>
			</td>
			</tr>
		</table>
	</form>
	
	
</div>



</body>
</html>