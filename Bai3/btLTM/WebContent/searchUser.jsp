<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="SearchUser" method="post">
	<label for="field">Choose a field:</label>

	<select name="field" id="field">
	  <option value="firstName">Fisrt Name</option>
	  <option value="lastName">Last Name</option>
	  <option value="username">Username</option>
	</select>
	
	<div>
	Nhap Thong Tin <input type="text" name="value">
	</div>
	<input type="submit" value="SEARCH">
</form>
	
</body>
</html>