<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Learning Management System</h1> <br>
	<hr>
	<hr>
	<h3> Add New Student</h3>
 <br>
	<form action="./adminAddStudent" method="post"> <br>
	<table>
	<tr> <td colspan=2>	<h3> Add New Student </h3></td></tr>
	<tr> <td> Student Name: </td><td> <input type="text" name="studentName"><br> </td></tr>
	<tr> <td> Address: </td><td> <input type="text" name="address"><br> </td></tr>
	<tr> <td> Age: </td><td> <input type="text" name="age"><br> </td></tr>
	<tr> <td> Academic Class Id: </td><td> <input type="text" name="academicClassId"><br> </td></tr>
	
	<tr> <td colspan=2>	<input type="submit" value="Add Student"> </td></tr>
	</table>
	</form>
	
</body>
</html>