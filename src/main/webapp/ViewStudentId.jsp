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

	<h1
		style="color: black; background-color: rgb(182, 208, 226); border: 5px solid"
		align="center">Welcome to JTC India</h1>

	<form action="ViewStudentById.com">
		<table class="border table-bordered">
			<tr>
				<h3>View by ID</h3>
				
				<td class="btn btn-secondary" style="width: 200px; height: 40px">ID
					:</td>
				<td><input type="text" name="id" required="true"></td>

				<td align="right"><input class="btn btn-success" type="submit"
					value="View"></td>

				<td style="color: red;">
					<%
					Object obj = request.getAttribute("MSG");
					if (obj != null) {
						out.print(obj);
					}
					%>
				</td>
			</tr>
		</table>
	</form>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

</body>
</html>