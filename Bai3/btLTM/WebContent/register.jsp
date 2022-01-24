<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action="createUser" method="post">
	<div>
	First Name <input type="text" name= "firstName">
	</div>
	<div>
	Last Name <input type="text" name="lastName">
	</div>
	<div>
	Username <input type="text" name="userName">
	</div>
	<div>
	PassWord <input type="text" name="password">
	</div>
	<div>
	Role <select name="role" id="role">
	  <option value="admin">admin</option>
	  <option value="user">user</option>
	</select>
	</div>
	<input type="submit" value="REGISTER">
</form>

</body>
</html>