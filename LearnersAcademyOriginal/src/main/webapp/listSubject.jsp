<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.ksk.lms.entities.Subject"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
<h2> Welcome to Learners Academy </h2> <hr> <hr>
	<h3> List of Subjects</h3> <hr> <hr>
<%
		List<Subject> subjects=(List<Subject>)request.getAttribute("subjects");
	%>
	<table border="1">
		<tr>
			<th>Subjec ID</th>
			<th>Subjec Name</th>			
			<th>Teacher Id </th>
			<th>Teacher Name </th>
			
		</tr>
		<%
			for(Subject subject:subjects)
			{
		%>
				<tr>
				<td><%=subject.getSid()%></td>
				<td><%=subject.getName()%></td>
					<td><%=subject.getTeacher().getTid()%></td>
					<td><%=subject.getTeacher().getName()%></td>
									
					<%
						session.setAttribute("tempSubject", subject);
					
					%>
					<td><form action="./adminUpdateSubject" method="Post">
						<input type="hidden" name="stubjectId1" value=<%=subject.getSid()%> />
 						<input type="submit" value="Update">  
					</form></td>
					<td><form action="./adminDeleteSubject" method="Post">
						<input type="hidden" name="stubjectId2" value=<%=subject.getSid()%> />
 						<input type="submit" value="Delete">  
					</form></td>
					
				</tr>
		<%	
			}
		%>
	</table>
	<h3> <a href="addSubject.jsp">Add New Subject</a></h3><br>
	<h3><a href="adminHome.jsp">Back to Admin Page</a></h3> <br>
</body>
</html>