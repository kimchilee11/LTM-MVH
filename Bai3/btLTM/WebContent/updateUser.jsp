<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UPDATE </title>
</head>
<body>
	<%
		ResultSet kq = (ResultSet) request.getAttribute("list");
		kq.next();
	%>

	<form action="updateUser?id=<%=kq.getInt(1)%>" method="post">
		<div>
		First Name <input type="text" name= "firstName" value="<%= kq.getString(2) %>">
		</div>
		<div>
		Last Name <input type="text" name="lastName" value="<%= kq.getString(3) %>">
		</div>
		<div>
		Username <input type="text" name="username" value="<%=kq.getString(4) %>">
		</div>
		
		
		<input type="submit" value="UPDATE">
	</form>
	
	<h5></h5>
		
</body>
</html>

</body>
</html>