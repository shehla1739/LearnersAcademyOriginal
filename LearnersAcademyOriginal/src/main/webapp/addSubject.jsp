<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Subject</title>
</head>
<body>
<h1>Learning Management System</h1> <br>
	<hr>
	<hr>
	<h3> Add New Subject</h3>
 <br>
	<form action="./adminAddSubject" method="post"> <br>
	<table>
	<tr> <td colspan=2>	<h3> Add New Subject </h3></td></tr>
	<tr> <td> Subject Name: </td><td> <input type="text" name="subjectName"><br> </td></tr>
	<tr> <td> Teacher ID:</td><td> <input type="text" name="teacherId"><br> </td></tr>	
	<tr> <td colspan=2>	<input type="submit" value="Add Subject"> </td></tr>
	</table>
	</form>
	
</body>
</html>