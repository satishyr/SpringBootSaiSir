<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
<style type="text/css">
.error {
	color: yellow;
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
	<div class="container">
		<div class="card">
			<h3 class="h3 text-left text-success">${msg}</h3>
				<div class="card-header bg-info text-white">
				<h2>Welcome to Shipment Type Register page!!</h2>
			</div>
		
		</div>
		<div class="card-body">
			<form:form id="userForm" action="register" method="post"
				cssClass="form-group" modelAttribute="user">
				<div class="row">
					<div class="col-4">
						<label for="username" class="h3 text-left text-secondary">Enter
							Your UserName </label>
					</div>
					<div class="col-4">
						<form:input path="username" cssClass="form-control" />
					</div>
				</div>
				<br>

				<div class="row">
					<div class="col-4">

						<label for="pazzword" class="h3 text-left text-secondary">Enter
							Your Password </label>
					</div>
					<div class="col-4">
						<form:password path="pazzword" cssClass="form-control" />

					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-4">

						<label for="email" class="h3 text-left text-secondary">Enter
							Your Email Id </label>
					</div>
					<div class="col-4">
						<form:input path="email" cssClass="form-control" />

					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-4">

						<label for="phno" class="h3 text-left text-secondary">Enter
							Your Phone No </label>
					</div>
					<div class="col-4">
						<form:input path="phno" cssClass="form-control" />
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-4">

						<label for="country" class="h3 text-left text-secondary">Enter
							Your Country Name </label>
					</div>
					<div class="col-4">
						<form:select path="country" items="${countries}"
							cssClass="form-control"></form:select>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-4">

						<input type="reset" value="Reset Form"
							class="btn btn-outline-danger" />
					</div>
					<div class="col-4">
						<input type="submit" value="Register"
							class="btn btn-outline-success" />
					</div>
				</div>
			</form:form>
		</div>
		<div class="card-footer">
			<a href="getAllUsers" class="btn btn-outline-dark btn-lg">Get All
				users List</a> <a href="pagination?pn=1"
				class="btn btn-outline-primary btn-lg">User Data in Pagination</a>
		</div>
	</div>
</body>
</html>