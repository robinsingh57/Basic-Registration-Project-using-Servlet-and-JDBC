<%@page import="com.register.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Student Registration Management</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

	<h1
		style="color: black; background-color: rgb(106, 173, 106); border: 5px solid"
		align="center">Student Update Form</h1>

	<form action="updateStudent.com">
		<table class="border table-bordered">

			<%
		Student stud = (Student) request.getAttribute("STUDENT");
		%>
			
			<tr>
			<td class="btn btn-secondary" style="width: 200px; height: 40px">ID:</td>
			<td> <input type="text" name="id" readonly="readonly" value=<%=stud.getId() %>> </td>
			</tr>

			<tr>
				<td class="btn btn-secondary" style="width: 200px; height: 40px">Name:</td>
				<td><input type="text" name="name" required="true" value=<%= stud.getName() %> >  </td>
			</tr>

			<tr>
				<td class="btn btn-secondary" style="width: 200px; height: 40px">City:</td>
				<td><input type="text" name="city" required="true" value=<%= stud.getCity() %> ></td>
			</tr>

			<tr>
				<td class="btn btn-secondary" style="width: 200px; height: 40px">Email:</td>
				<td><input type="email" name="email"  required="true" placeholder="Example@gmail.com" value= <%= stud.getEmail() %> > </td>
				
				<td style="color: red;">
					<%
					Object obj = request.getAttribute("dublicate");
					if(obj != null){
						out.print(obj);
					}
					%>
				<td>
			</tr>
				
				<tr>
				<td>Course:</td>
				<td>
				<input type="checkbox" name="course" value="Core Java" />Core Java <br /> 
				<input type="checkbox" name="course" value="Advance Java" />Advance Java <br /> 
				<input type="checkbox" name="course" value="Database" />Database <br />
				<input type="checkbox" name="course" value="Springboot" />Springboot <br />
				<input type="checkbox" name="course" value="HTML" />HTML <br />
				<input type="checkbox" name="course" value="CSS" />CSS<br />
				<input type="checkbox" name="course" value="Javascript" />Javascript <br />
				</td>
			</tr>
	
			<tr>
			<td align="right">
				<input class="btn btn-success" type="submit" value="SUBMIT" >
				</td>
			</tr>
			
		</table>

	</form>

</body>
</html>