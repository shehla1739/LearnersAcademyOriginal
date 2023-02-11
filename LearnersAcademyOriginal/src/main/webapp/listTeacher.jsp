<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ksk.lms.entities.Teacher"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher Details</title>
</head>
<body>
<h2> Welcome to Learners Academy </h2> <hr> <hr>
	<h3> List of Teachers</h3> <hr> <hr>
	<%
		List<Teacher> teachers=(List<Teacher>)request.getAttribute("teachers");
	%>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Designation</th>
			<th>Skill</th>
			<th>Address</th>
		</tr>
		<%
			for(Teacher teacher:teachers)
			{
		%>
				<tr>
					<td><%=teacher.getTid()%></td>
					<td><%=teacher.getName()%></td>
					<td><%=teacher.getDesignation()%></td>
					<td><%=teacher.getSkill()%></td>
					<td><%=teacher.getAddress()%></td>					
					<%
						session.setAttribute("tid", teacher.getTid());
					%>
					<td><form action="./adminUpdateTeacher" method="Post">
						<input type="hidden" name="teacherId1" value=<%=teacher.getTid()%> />
 						<input type="submit" value="Update">  
					</form></td>
					<td><form action="./adminDeleteTeacher" method="Post">
						<input type="hidden" name="teacherId2" value=<%=teacher.getTid()%> />
 						<input type="submit" value="Delete">  
					</form></td>
					
				</tr>
		<%	
			}
		%>
	</table>
	<h3> <td><a href="addTeacher.jsp">Add New Teacher</a></td></h3>
	<h3><a href="adminHome.jsp">Back to Admin Page</a> </br></h3>
</body>
</html>