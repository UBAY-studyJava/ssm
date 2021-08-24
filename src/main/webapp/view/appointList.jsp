<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="bootstrap.jsp" %>
<%@include file="tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Appointment Page</title>
</head>
<body>
<jsp:include page="/view/header.jsp"></jsp:include>

<div class="card-body">
	<h2>Check Appointment</h2>
	<br>
	
	<table style="border:1px solid black; border-collapse: collapse;" border="1">
	<thead style="text-align:center">
	<tr>
		<th width="100px">Student ID</th>
		<th width="100px">Book ID</th>
		<th width="200px">Title</th>
		<th width="300px">Appoint Time</th>
	</tr>
	</thead>
	
	<tbody>
	<c:forEach var="appoint" items="${list }">
		<tr>
			<td>${appoint.studentId }</td>
			<td>${appoint.bookId }</td>
			<td>${appoint.book.name }</td>
			<td>${appoint.appointTime }</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	<br>
	<a href="../list">Back to Book List</a>
</div>
</body>
</html>