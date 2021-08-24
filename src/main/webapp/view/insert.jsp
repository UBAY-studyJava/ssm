<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<title>Insert New Book</title>
</head>
<body>
<div class="card-body">
  <h2>Insert New Book</h2>
  
  <form action="../book/inserted" method="POST">
	  <p>Book Title : <input type="text" name="name"></p>
	  <p>Number : <input type="text" name="number"></p>
	  <br>
	  <button type="submit" class="btn btn-primary">Insert New Book</button>
  </form>

</div>
</body>
</html>