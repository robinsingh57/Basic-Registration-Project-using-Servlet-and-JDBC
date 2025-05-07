<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Student Registration Management </title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Admin Login Page</title>
</head>
<body>

	<h1 style="color: black; background-color: rgb(106, 173, 106); border: 5px solid " align="center">Admin Login Page</h1>

	<form action="checkAdmin.com">
		<table class="border table-bordered" align="center">
		
		<td style="color: red;">
		<%
		Object obj= request.getAttribute("MSG");
		if(obj != null){
			out.print(obj);
		}
		%>
		</td>

			<tr>
				<td class="btn btn-secondary" style="width: 200px; height: 40px;" >Username:</td> <br/> 
				<td><input type="text" name="username" required="true"></td>
			</tr>

			<tr>
				<td class="btn btn-secondary" style="width: 200px; height: 40px">Password:</td>
				<td><input type="password" name="password" required="true"> </td>
			</tr>
			
			<tr>
			<td align="right">
				<input class="btn btn-success" type="submit" value="Login" >
				</td>
			</tr>

			
		</table>
	</form>
</body>
</html>