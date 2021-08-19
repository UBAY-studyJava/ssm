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
	<div style="width:80%">
		<table class="table">
			<thead>
				<tr>
					<th>User Name</th>
				</tr>
			</thead>
			<tbody>
				<tr th:each="user : ${list}">
		        	<td><span th:text="${user}">Title</span></td>
		      	</tr>
			</tbody>
		</table>
	</div>
</body>
</html>