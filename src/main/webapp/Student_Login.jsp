<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Student Registration Management</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

	<h1 style="color: black; background-color: rgb(106, 173, 106); border: 5px solid " align="center">Login Form</h1>
		<h3 style="color: red;">Please put your email id who taken at the time of registration. </h3>
		
		<h5 style="color: red;">
			<%
		Object obj = request.getAttribute("MSG");
		if(obj != null){
			out.print(obj); }
			%>
		</h5>

	<form action="StudentLogin.com">
		<table class="border table-bordered">
		
			<tr>
				<td class="btn btn-secondary" style="width: 200px; height: 40px" >Email ID:</td>
				<td><input type="text" name="email" required="true"></td>
			</tr>
			
			<tr>
				<td class="btn btn-secondary" style="width: 200px; height: 40px" >OTP:</td>
				<td><input type="number" name="otp" required="true"></td>
			</tr>
			
			<tr>
			<td align="right">
				<input class="btn btn-success" type="submit" value="Login now" >
				</td>
			</tr>
			</table>
			</form>

</body>
</html>