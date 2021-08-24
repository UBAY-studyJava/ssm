<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="bootstrap.jsp" %>
<%@include file="tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Detail Page</title>
</head>
<body>
<jsp:include page="/view/header.jsp"></jsp:include>
<div class="card-body">
	<h2>Detail Page</h2>
	<br>
	<p>Book ID : ${book.bookId }</p>
	<p>Title : ${book.name }</p>
	<p>Count : ${book.number }</p>
	<br>
</div>

<div class="card-body">
	<a href="../${book.bookId }/modify">Update Book Detail</a>
	&nbsp;&nbsp;&nbsp;
	<a href="../list">Back to Book List</a>
</div>

</body>
</html>


