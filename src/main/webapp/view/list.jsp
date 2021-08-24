<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Book List</title>

</head>
<body>
	
<div class="card-body">
	<h2>Book List</h2>
	<br>
	
	<table style="border:1px solid black; border-collapse: collapse;" border="1">
	<thead style="text-align:center">
	<tr>
		<th width="100px">Book ID</th>
		<th width="200px">Title</th>
		<th width="100px">Count</th>
		<th width="100px">Delete</th>
		<th width="100px">Appoint</th>
	</tr>
	</thead>
	
	<tbody>
	<c:forEach var="book" items="${list }">
		<tr>
			<td>${book.bookId }</td>
			<td><a href="${book.bookId }/detail">${book.name }</a></td><!-- name click, go to detail page -->
			<td>${book.number }</td>
			<td><a href="${book.bookId }/delete">Delete</a></td><!-- Delete click, Delete row & go to Book List -->
			<td><a href="${book.bookId }/appoint">appoint test</a></td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	<br>
	<br>
	<button type="button" class="btn btn-primary" onclick="#">Insert New Book</button> <!-- User : Admin -->
	<button type="button" class="btn btn-secondary" onclick="#">My Book Appointment</button> <!-- User : student_id -->
																<!-- Admin : Whole Book Appointment List Page (?) -->
</div>

</body>
</html>