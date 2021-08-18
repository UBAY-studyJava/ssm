<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Book List</title>
</head>
<body>
	
<div class="card-body">
	<h2>Book List</h2>
	<br>
	
	<form action="#" method="POST">
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
			<td>
				<input type="radio" name="id" value="${book.bookId }" style="text-align:middle">		
			</td>
			<td>${book.bookId }</td>
			<td><a href="${book.bookId }/detail">${book.name }</a></td><!-- name click, go to detail page -->
			<td>${book.number }</td>
			<td><a href="#">Delete</a></td><!-- Delete click, Delete row & go to Book List -->
		</tr>
	</c:forEach>
	</tbody>
	</table>
	
	<br>
	<br>
	<input type="submit" value="Update Info">
	</form>	
	<button type="button" class="btn btn-primary" onclick="#">Insert New Book</button>
</div>

</body>
</html>