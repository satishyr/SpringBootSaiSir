<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
<style type="text/css">
body {
	background-color: lightyellow;
}

.error {
	color: red;
}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
<script type="text/javascript" src="./views/js/app.js"></script>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	<h3 class="h3 text-left text-success">${msg}</h3>
	<h1 class=" h1 text-info text-center">Register Here...!!</h1>

	<form:form id="userForm" action="register" method="post"
		cssClass="form-group" modelAttribute="user">

		<label class="h3 text-left text-secondary">Enter User Name:</label>
		<form:input path="username" cssClass="form-control" />
		<br>


		<label class="h3 text-left text-secondary">Enter User
			Password:</label>
		<form:password path="pazzword" cssClass="form-control" />
		<br>

		<label class="h3 text-left text-secondary">Enter Your Mail Id:</label>
		<form:input path="email" cssClass="form-control" />
		<br>

		<label class="h3 text-left text-secondary">Enter Your Phone
			Number:</label>
		<form:input path="phno" cssClass="form-control" />
		<br>

		<label class="h3 text-left text-secondary">Choose Country
			Name:</label>
		<form:select path="country" items="${countries}"
			cssClass="form-control"></form:select>
		<br>
		<input type="reset" value="Reset Form" class="btn btn-outline-danger" />
		<input type="submit" value="Register" class="btn btn-outline-success" />
	</form:form>
	<a href="getAllUsers" class="btn btn-outline-dark btn-lg">Get All
		users List</a>
	<a href="pagination?pn=1" class="btn btn-outline-primary btn-lg">User
		Data in Pagination</a>
</body>
</html>