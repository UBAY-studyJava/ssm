<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="bootstrap.jsp" %>
<%@include file="tag.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Book List</title>

</head>
<body>
<jsp:include page="/view/header.jsp"></jsp:include>
	
<div class="card-body">
	<h2>Book List</h2>
	<br>
	
	<form action="appoint" method="POST">
	<table style="border:1px solid black; border-collapse: collapse;" border="1">
	<thead style="text-align:center">
	<tr>
		<th width="50px"> </th>
		<th width="100px">Book ID</th>
		<th width="200px">Title</th>
		<th width="100px">Count</th>
		<th width="100px">Delete</th>
	</tr>
	</thead>
	
	<tbody>
	<c:forEach var="book" items="${list }">
		<tr>
			<td style="text-align:center">
				<input type="radio" name="bookId" value="${book.bookId }">		
			</td>
			<td>${book.bookId }</td>
			<td><a href="${book.bookId }/detail">${book.name }</a></td><!-- name click, go to detail page -->
			<td>${book.number }</td>
			<td><a href="${book.bookId }/delete">Delete</a></td><!-- Delete click, Delete row & go to Book List -->
		</tr>
	</c:forEach>
	</tbody>
	</table>
	<br><br><br>
	StudentID : <input type="text" name="studentId" >
	&nbsp;&nbsp;
	<button type="submit" class="btn btn-secondary">Book Appoint</button>
	</form>
	
</div>

<div class="card-body"> <!-- User : admin -->
	<button type="button" class="btn btn-primary" onclick="location='insert'">Insert New Book</button>
	<button type="button" class="btn btn-primary" onclick="location='appoint/list'">Check Appointment</button>
</div>

</body>
</html>