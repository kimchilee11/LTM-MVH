<%@page import="java.sql.ResultSet"%>
<%@page import="model.PhongBan"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>

	<table>
		<tr>
			<td>ID </td>
			<td>Fist Name</td>
			<td>Last Name</td>
			<td>Username</td>
			<td>Role</td>
			<td>DELETE</td>
			<td>UPDATE</td>
		</tr>
	<%
		ResultSet kq = (ResultSet) request.getAttribute("list");
		while(kq.next()) {
	%>
		<tr>
			<td><%= kq.getInt(1) %> </td>
			<td><%= kq.getString(2) %></td>
			<td><%= kq.getString(3) %></td>
			<td><%= kq.getString(4) %></td>
			<td><%= kq.getString(5) %></td>
			<td>  <a href="/btLTM/DeleteUser?id=<%= kq.getInt(1)%>"	>Delete</a></td>
			<td>  <a href="/btLTM/UpdateUser?id=<%= kq.getInt(1)%>"	>Update</a></td>
		</tr>
	<%
		}
	%>
		
	</table>

   
</body>
</html>