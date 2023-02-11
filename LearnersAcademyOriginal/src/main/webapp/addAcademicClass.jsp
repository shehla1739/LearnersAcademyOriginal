<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new class</title>
</head>
<body>
<h1>Learning Management System</h1> <br>
	<hr>
	<hr>
	<h3> Add New Academic Class</h3>
 <br>
	<form action="./adminAddAcademicClass" method="post"> <br>
	<table>
	<tr> <td colspan=2>	<h3> Add New Academic Class </h3></td></tr>
	<tr> <td> Class Name: </td><td> <input type="text" name="academicClassName"><br> </td></tr>
	<tr> <td> Duration:</td><td> <input type="text" name="duration"><br> </td></tr>	
	<tr> <td colspan=2>	<input type="submit" value="Add Academic Class"> </td></tr>
	</table>
	</form>

</body>
</html>