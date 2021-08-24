<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="bootstrap.jsp" %>
<%@include file="tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of All Users</title>
</head>
<body>
	<jsp:include page="/view/header.jsp"></jsp:include>
	<div class="container d-flex h-100">
		<div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<th class="text-center">User Names</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${list}">
					<tr>
						<td>${user}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>
</body>
</html>