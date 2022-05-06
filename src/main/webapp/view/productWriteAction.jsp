<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.soecode.lyf.dao.ProductDao" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8");  %>
<jsp:setProperty name="com.soecode.lyf.Product" property="productId" />
<jsp:setProperty name="com.soecode.lyf.Product" property="productDetail" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>uBay Bank Project</title>
</head>
<body>
	<%
		String user_id =null;
		if(session.getAttribute("user_id") != null) {
			user_id = (String) session.getAttribute("user_id");
		}
		if(user_id != null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('お先にログインしてください。')");
			script.println("location.href = 'login.jsp'");
			script.println("</script>");
		} else { 
			if (user.getUser_id() == null || user.getUser_pwd() == null ||user.getUser_name() == null) {
						PrintWriter script = response.getWriter();
						script.println("<script>");
						script.println("alert('入力されていない事項があります。')");
						script.println("history.back()");
						script.println("</script>");
					} else {
						UsersDao userDao = new UsersDao();
						int result = userDao.join(users);
						if (result == -1) {
							PrintWriter script = response.getWriter();
							script.println("<script>");
							script.println("alert('存在するIDです。')");
							script.println("history.back()");
							script.println("</script>");
						}
						else {
							session.setAttribute("user_id", user.getUser_id());
							PrintWriter script = response.getWriter();
							script.println("<script>");
							script.println("location.href = 'main.jsp'");
							script.println("</script>");
						}
					}	
		}
		
	 %>
</body>
</html>