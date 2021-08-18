<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="bootstrap.jsp" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>List of All Users</title>
</head>
<body>
	<table class="table">
		<thead>
			<tr>
				<th>User Name</th>
				<th>Register Date</th>
			</tr>
		</thead>
		<tbody>
			<tr th:each="user : ${users}">
        		<td th:text="${user.name}"></td>
      		</tr>
		</tbody>
	</table>
</body>
</html>