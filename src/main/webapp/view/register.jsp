<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register New User</title>
</head>
<body>
	<form action="register" method="post">
		<input type="text" name="name" value="${User.name}">
		<input type="text" name="pwd" value="${User.pwd}">
		<input type="submit" value="Confirm">
	</form>
</body>
</html>