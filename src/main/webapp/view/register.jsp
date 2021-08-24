<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@include file="bootstrap.jsp" %>
<%@include file="tag.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Register New User</title>
</head>
<body>
	<jsp:include page="/view/header.jsp"></jsp:include>
	<div class="container d-flex h-100">
		<form action="apply" method="post">
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<th colspan="2" class="text-center">New User Information</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><label name="name">User Name: </label></td>
							<td><input type="text" name="name"></td>
						</tr>
						<tr>
							<td><label name="pwd">Password: </label></td>
							<td><input type="text" name="pwd"></td>
						</tr>
						<tr>
							<td></td>
							<td><button type="submit" class="btn btn-primary">Submit</button></td>
						</tr>
					</tbody>
				</table>
			</div>
		</form>
	</div>
</body>
</html>