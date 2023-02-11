<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<%@ page import="com.ksk.lms.entities.Student"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> Welcome to Learners Academy </h2> <hr> <hr>
	<h3> List of Students</h3> <hr> <hr>
<%
		List<Student> students=(List<Student>)request.getAttribute("students");
	%>
	<table border="1">
		<tr>
			<th>Student ID</th>
			<th>Student Name</th>			
			<th>Address </th>
			<th>Age </th>
			<th> Class Name </th>
			
		</tr>
		<%
			for(Student student:students)
			{
		%>
				<tr>
				<td><%=student.getStuId()%></td>
				<td><%=student.getName()%></td>
				<td><%=student.getAddress()%></td>
				<td><%=student.getAge()%></td>
				<td><%=student.getAcademicClass().getName()%></td>
									
					<%
						session.setAttribute("tempStudent", student);
					
					%>
					<td><form action="./adminUpdateStudent" method="Post">
						<input type="hidden" name="stubjectId1" value=<%=student.getStuId()%> />
 						<input type="submit" value="Update">  
					</form></td>
					<td><form action="./adminDeleteStudent" method="Post">
						<input type="hidden" name="stubjectId2" value=<%=student.getStuId()%> />
 						<input type="submit" value="Delete">  
					</form></td>
					
				</tr>
		<%	
			}
		%>
	</table>
	<h3> <a href="addStudent.jsp">Add New Student</a></h3><br>
	<h3><a href="adminHome.jsp">Back to Admin Page</a></h3> <br>
</body>
</html>