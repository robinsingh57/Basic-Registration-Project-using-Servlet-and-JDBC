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

	<form action="ViewStudentByCourse.com">
		<table class="border table-bordered">
			<tr>
				<h3>View by Course</h3>
			<tr>
				<td class="btn btn-secondary" style="width: 200px; height: 40px">Course:</td>
				<td><select name="course" required="true">
						<option disabled selected style="display: none;">Select
							Course</option>
						<option name="course" value="Core Java">Core Java</option>
						<option name="course" value="Advance Java">Advance Java</option>
						<option name="course" value="Database">Database</option>
						<option name="course" value="Springboot">Springboot</option>
						<option name="course" value="HTML">HTML</option>
						<option name="course" value="CSS">CSS</option>
						<option name="course" value="Javascript">Javascript</option>
				</select></td>

				<td align="right"><input class="btn btn-success" type="submit"
					value="View"></td>
			</tr>
		</table>
	</form>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

</body>
</html>