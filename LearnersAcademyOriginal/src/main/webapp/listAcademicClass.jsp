<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.ksk.lms.entities.AcademicClass"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Academic Classes</title>
</head>
<body>
<h2> Welcome to Learners Academy </h2> <hr> <hr>
	<h3> List of AcademicClasss</h3> <hr> <hr>
	<%
		List<AcademicClass> academicClasss=(List<AcademicClass>)request.getAttribute("academicClasss");
	%>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Duration</th>
		</tr>
		<%
			for(AcademicClass academicClass:academicClasss)
			{
		%>
				<tr>
					<td><%=academicClass.getCid()%></td>
					<td><%=academicClass.getName()%></td>
					<td><%=academicClass.getDuration()%></td>
									
					<%
						session.setAttribute("cid", academicClass.getCid());
					%>
					<td><form action="./adminUpdateAcademicClass" method="Post">
						<input type="hidden" name="academicClassId1" value=<%=academicClass.getCid()%> />
 						<input type="submit" value="Update">  
					</form></td>
					<td><form action="./adminDeleteAcademicClass" method="Post">
						<input type="hidden" name="academicClassId2" value=<%=academicClass.getCid()%> />
 						<input type="submit" value="Delete">  
					</form></td>
					
				</tr>
		<%	
			}
		%>
	</table>
	<h3> <td><a href="addAcademicClass.jsp">Add New AcademicClass</a></td></h3>
	<h3><a href="adminHome.jsp">Back to Admin Page</a> </br></h3>
</body>
</html>