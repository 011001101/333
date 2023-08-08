<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
>>>>>>> branch 'master' of https://github.com/011001101/333.git
<!DOCTYPE html>
<html>
<head>
<<<<<<< HEAD
<title>Login</title>
<link rel="stylesheet" href="login.css">
=======
<meta charset="UTF-8">
<title>Insert title here</title>
>>>>>>> branch 'master' of https://github.com/011001101/333.git
</head>
<body>
<<<<<<< HEAD
	<div class="a"></div>
	<div class="login-container">
		<h1>Login</h1>
		<form>
			<input type="text" id="id" placeholder="id" name="id"> <input
				type="password" id="password" placeholder="Password" name="pw">
			<button type="submit">Login</button>
		</form>
		<%
			String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		Login login = new Login();
		session.setAttribute("userid", id);
		boolean sucsess = login.loginst(id, pw);
		if (sucsess) {

			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}
		%>


		<%--
    <p id="message"></p>
  </div>
  <script src="login.js"></script>
   --%>
=======
	<form method="post">
		<p>아이디 <input type="text" name="id"> </p>
		<p>비밀번호 <input type="password" name="password"></p>
		<c:if test="${ not empty no }">
		<p style="color: red">아이디나 비밀번호를 확인하세요</p>
		</c:if>
		<input type="submit">
	</form>
	<a href="insert.jsp">되돌아가기</a>
>>>>>>> branch 'master' of https://github.com/011001101/333.git
</body>
<%session.removeAttribute("no"); %>
</html>
