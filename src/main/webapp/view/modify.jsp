<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<title>Modify Book Details</title>
</head>
<body>

<div class="card-body">
	<h2>Modify Details</h2>
	<br>
	
	<form action="../${book.bookId }/modified" method="POST">

		<p>Book ID : ${book.bookId }</p>
		<p>Title : 
		<input type="text" name="name" value="${book.name }">
		</p>
		<p>Count : 
		<input type="text" name="number" value="${book.number }">
		</p>
		<br>
		<input type="hidden" name="bookId" value="${book.bookId }">
		<button type="submit" class="btn btn-secondary">Modify Details</button>
	</form>

</div>

</body>
</html>