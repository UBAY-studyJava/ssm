<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="bootstrap.jsp" %>
<%@include file="tag.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Products</title>
</head>
<body>
	<jsp:include page="/view/header.jsp"></jsp:include>
		<div class="container">
		<div class="jumbotron">
			<div class="container">
				<h1>商品のおすすめ</h1>
				<p>あなたの心にぴったりと合う商品をご用意しております</p>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbotron" style="padding-top: 20px:">
				<form method="post" action="productWrite.jsp">
					<input type="submit" class="btn btn-primary form-control" value="登録">
				</form>
			</div>
		</div>
		<div class="col-lg-4"></div>
	</div>
</body>
</html>