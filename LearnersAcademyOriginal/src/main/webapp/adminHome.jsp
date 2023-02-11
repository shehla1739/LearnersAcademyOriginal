<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
<table>
<tr>
	<h2> Welcome to Learners Academy </h2> <hr> <hr>
	<h3> Admin Page</h3> <hr> <hr>
	<!-- <h4>Hi,${sessionScope.user.username} welcome to FlyAir Management System</h4> </hr><br> -->
</tr>
<tr> 
	<td> <form action="./adminListOTeachers" method="Post"> </td>
	<td> <h3> Teacher Details :  </td> <td> </h3><input type="submit" value="List of Teacher"> </td> 
	</form>
</tr>
<tr>
	<td><form action="./adminListOSubjects" method="Post"></td>
	<td><h3> Subject Details :  </td> <td> </h3><input type="submit" value="List of Subjects"></td>  
	</form>
</tr>
<tr>
	<td><form action="./adminListOfClasses" method="Post"></td>
	<td><h3> Academic Class Details : </td> <td> </h3><input type="submit" value="List of Classes"></td>  
	</form>
</tr>
<tr>
	<td><form action="./adminListOfStudents" method="Post"></td>
	<td><h3> Student Details : </td> <td> </h3><input type="submit" value="List of Students">  </td>
	</form>
</tr>
</table>
</body>
</html>