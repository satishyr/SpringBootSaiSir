   <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users List</title>

<link rel="stylesheet" type="text/css"
	href="./views/js/bootstrap.min.css">

<script type="text/javascript" src="./views/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="./views/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="./views/js/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css" href="./views/js/jquery-ui.css">
<script type="text/javascript" src="./views/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#myTable').DataTable();
		$(".callData").click(function(){
			var id=event.target.attributes[0].value;
			debugger;
			$("#popup").find('tr').remove();
			let flag=confirm("Are you sure ,want to view This Record");
			console.log(flag)
			if(flag)
				viewConfim(id);	
			else{
					return false;
				}	
			});
		});

	function viewConfim(id){
		$.ajax({
			url: "getOneUser",
			data :{
				userId : id
				},
			dataType :'json',
			success :function(result){
				console.log(result)
				let txt="";
				$.each(result,function(key,value){
						console.log(key ,value);
						if(!(key=='pazzword'))
						txt += "<tr><th>"+key+"</th><td>"+value+"</td></tr>";	
					});
				 $("#popup").append(txt).removeClass("hidden");
				}	

			});
	}
	
	
	function deleteconfirm() {

		return confirm("Are you Sure, you want to delete this  records..");
	}
	function updateConfirm() {
		return confirm("Are you Sure, You want to Update this records..")
	}
</script>
</head>
<body bgcolor="lightyellow">
	<a href="getForm" class="btn btn-outline-secondary btn-lg">+ ADD
		Another User </a> &nbsp;&nbsp;
	<a href="pagination?pn=1" class="btn btn-outline-warning btn-lg">User
		Data in Pagination</a>
	<br>
	<br>
	<h2 class="h2 text-center text-success">All Users List In Table
		Format</h2>
	<table id="myTable"
		class="display dataTable table table-striped table-bordered">
		<thead>
			<tr>
				<th>S.NO.</th>
				<th>User Id</th>
				<th>UserName</th>
				<th>Email</th>
				<th>Phone No.</th>
				<th>Country</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user" varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${user.userId}</td>
					<td>${user.username}</td>
					<td>${user.email}</td>
					<td>${user.phno}</td>
					<td>${user.country}</td>
					<td>
						<button name=${user.userId } class="btn btn-primary callData"
							data-toggle="modal" data-target="#exampleModal">View</button>&nbsp;|&nbsp;
						<a href="editUser?userId=${user.userId}"
						onclick="return updateConfirm()" class="btn btn-warning">EDiT</a>
						&nbsp;|&nbsp; <a href="deleteUser?userId=${user.userId}"
						onclick="return deleteconfirm()" class="btn btn-danger">DELETE</a>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">User Data</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<table class="table table-striped table-bordered" id="popup">

					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>