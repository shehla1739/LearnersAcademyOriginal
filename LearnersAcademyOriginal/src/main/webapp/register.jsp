<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration </title>
</head>
<body>
<br> <h1>Learning Management System</h1> <br>
	<hr>
	<hr>
	<h3> User Registration </h3> <br>
	<form action="./register" method="post">
		Username 	:	 <input type="text" name="username"><br><br>
		Password 	: 	<input type="text" name="password"><br><br>
		UserType<select name="usertype">
			<option value="admin">Admin</option>
			<option value="user">User</option>
			</select>
		<br> <br> <input type="submit" value="Register">
	</form>
</body>
</html>