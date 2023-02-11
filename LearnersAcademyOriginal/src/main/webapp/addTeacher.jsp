<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body> <h1>Learning Management System</h1> <br>
	<hr>
	<hr>
	<h3> Add New Teacher</h3><br>
	<form action="./adminAddteacher" method="post"> <br>
	<table>
	<tr> <td colspan=2>	<h3> Add New Teacher </h3></td></tr>
	<tr> <td> Teacher Name: </td><td> <input type="text" name="teacherName"><br> </td></tr>
	<tr> <td>	Designation:</td><td> <input type="text" name="designation"><br> </td></tr>
	<tr> <td>	Skill:</td><td> <input type="text" name="skill"> <br> </td></tr>
	<tr> <td>	Address:</td><td> <input type="text" name="address"><br> </td></tr>
	<tr> <td>	Subject id:</td><td> <input type="text" name="subjectId"><br> </td></tr>
	<tr> <td colspan=2>	<input type="submit" value="Add Teacher"> </td></tr>
	</table>
	</form>
</body>
</html>