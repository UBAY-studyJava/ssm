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
		<div class="raw">
			<form method="post" action="productWtiteAction,jsp">
				<table class="table table-striped" style="text-align: center; border: 1px solid	#dddddd">
					<thead>
						<tr>
							<th colspan="2" style="backgrountd-color: #eeeeee; text-align: center;">商品登録</th>
						</tr>
					</thead>
					<tbody>
						<tr>
						<td><input type="text" class="form-control" placeholder="商品名" name="productName" maxlength="45"></td>
						</tr>
						<tr>
						<td><textarea class="form-control" placeholder="商品内容" name="productDetail" maxlength="255" style="height: 350px;"></textarea></td>
						</tr>
					</tbody>
				</table>
				<input type="submit" class="btn btn-primary pull-right" value="登録">
			</form>
		</div>	
	</div>	
</body>
</html>