<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users List</title>
<style type="text/css">
.numStyle{
 display: inline-block;
    font-weight: 400;
    color: #212539;
    text-align: center;
    vertical-align: middle;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
    background-color: transparent;
    border: 1px solid transparent;
    padding: .375rem .75rem;
    font-size: 1rem;
    line-height: 1.5;
    border-radius: .25rem;
    transition: color .15s ease-in-out,background-color .15s ease-in-out,border-color .15s ease-in-out,box-shadow .15s ease-in-out;
}
.numStyle:hover{
color: #ddd;
    background-color: #6c757d;
    border-color: #6c757d;
    }
</style>
<link rel="stylesheet" type="text/css" href="./views/js/bootstrap.min.css">
<script type="text/javascript">
	function deleteconfirm() {

		return confirm("Are you Sure, you want to delete this  records..");
	}
	function updateConfirm() {
		return confirm("Are you Sure, You want to Update this records..")
	}
</script>
</head>
<body bgcolor="lightyellow">
	<a href="getForm" class="btn btn-outline-secondary btn-lg">AddUser</a> &nbsp;&nbsp;
	<a href="getAllUsers" class="btn btn-outline-warning btn-lg">GetALL</a>	
	<br><br>
	<div class="container">
	<div class="card">
	<div class="card-header">
	<h2 class="h4 text-center text-primary">Pagination</h2>
	</div>
	<div class="card-body">
	<table  class="table table-hover table-bordered">
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
					<td>${user.userId} </td>
					<td>${user.username}</td>
					<td>${user.email}</td>
					<td>${user.phno}</td>
					<td>${user.country}</td>
					<td>
					<a href="editUser?userId=${user.userId}"
						onclick="return updateConfirm()" class="btn btn-link">edit</a>
						&nbsp;|&nbsp; <a href="deleteUserFromPage?userId=${user.userId}&pn=${cp}"
						onclick="return deleteconfirm()" class="btn btn-link">delete</a>	
					</td>		
				</tr>
			</c:forEach>
		</tbody>
		
	</table>
	</div>
	</div>
	
	<div class="text-center">
	<c:if test="${cp >1 }">
		<a href="pagination?pn=${cp-1}" class="btn btn-outline-link">Previous</a>
	</c:if>
	<c:forEach begin="1" end="${tp}" var="i">
		<c:choose>
			<c:when test="${cp eq i}">
				<span class="numStyle btn-outline-secondary disabled " style="color:red;" ><c:out value="${i}"/></span>
			</c:when>
			<c:otherwise>
				<a  class="numStyle  btn-outline-secondary" href="pagination?pn=${i}"> ${i} </a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${cp<tp}">
		<a href="pagination?pn=${cp+1}" class="btn btn-outline-link">Next</a>
	</c:if>
	</div>
	</div>
	
	

</body>
</html>