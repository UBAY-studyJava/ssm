<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail Page</title>
</head>
<body>

<div class="card-body">
	<h2>Detail Page</h2>
	<br>
	<p>Book ID : ${book.bookId }</p>
	<p>Title : ${book.name }</p>
	<p>Count : ${book.number }</p>
	<br>
	<br>
</div>

<div class="card-body">
	<a href="#">Update Book Detail</a>
</div>

</body>
</html>