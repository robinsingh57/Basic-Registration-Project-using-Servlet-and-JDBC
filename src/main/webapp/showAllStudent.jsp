<!DOCTYPE html>
<%@page import="com.register.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>

<style>
thead {
	background-color: rgb(110, 110, 212);
	color: black;
}

tbody {
	background-color: yellow;
}

tfoot {
	background-color: grey;
}
</style>

	<h1 style="color: black; background-color: rgb(106, 173, 106); border: 5px solid " align="center">All Student list.</h1>

<body>
	<table border="">

		<thead>
			<th>Id</th>
			<th>Name</th>
			<th>City</th>
			<th>Email</th>
			<th>Date of Enrollment</th>
			<th>Course</th>
			<th colspan="2"></th>
			<th> </th>
		</thead>

		<tbody align="center">
			
			<%
			List<Student> student = (List<Student>) request.getAttribute("STUDENT");
			if (student != null) {
				for (Student stud : student) {
			%>

			<tr>
				<td><%=stud.getId()%></td>
				<td><%=stud.getName()%></td>
				<td><%=stud.getCity()%></td>
				<td><%=stud.getEmail()%></td>
				<td><%=stud.getDoe()%></td>
				<td><%=stud.getCourse()%></td>

				<td>
				<a style="color: green;" href="EditForm.com?id=<%=stud.getId()%>">Edit</a>
				</td>
				<td>
				<a style="color: red;" href="DeleteStudent.com?id=<%=stud.getId()%>">Delete</a>
				</td>
			</tr>
			<%
			}
			}
			%>

		</tbody>

		<tfoot align="center">
			<td colspan="7">@copywright All right reserved JTC.</td>

		</tfoot>
	</table>
</body>
</html>