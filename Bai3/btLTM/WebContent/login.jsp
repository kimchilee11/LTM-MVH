<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<%
	String temp = "temp";
	session.setAttribute("temp", temp);
%>
<form action="CheckLoginServlet" method="post">
	username: <input type="text" name= "username">
	passwordL: <input type="password" name="password">
	<input type="submit" value="Login">
</form>

<h4><a href= "createUser">REGISTER</a>
</h4>

</body>
</html>