<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JTC India</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<style>
thead, tbody, tfoot {
	text-align: center;
}
</style>
<body style="background-color: rgb(240, 255, 255);">

<h1 style="color: black; background-color: rgb(182, 208, 226); border: 5px solid" align="center">Welcome to JTC India</h1>


<form action="ViewStudentByDate.com">
		<table class="border table-bordered">
		<h3>View by Date</h3>
			<tr>
				<td class="btn btn-secondary" style="width: 200px; height: 40px" >From :</td>
				<td><input type="date" name="start" required="true"></td>
			
				<td class="btn btn-secondary" style="width: 200px; height: 40px" >To :</td>
				<td><input type="date" name="end" required="true"></td>
			
			<td align="right">
				<input class="btn btn-success" type="submit" value="View" >
				</td>
			</tr>
			</table>
			</form>