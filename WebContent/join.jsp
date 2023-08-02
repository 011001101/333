<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	아이디 : 영대소문자와 숫자를 조합해 2 ~ 4자<br>
	 비번 : 특수문자 !@#$%^&* 영대소문자와 숫자를 조합해 8 ~ 20자
	<form method="post">
		<p>
			<label>아이디 <input type="text" name="id"></label>
		</p>
		<p>
			<label>비밀번호 <input type="password" name="pw"></label>
		</p>
		<input type=submit value="가입하기">
	</form>
	<a href="insert.jsp">되돌아가기</a>
	<c:if test="${ not empty fal }">
		<p style="color: red">
		<%= session.getAttribute("fal") %>
		</p>
	</c:if>
</body>
<%session.removeAttribute("fal"); %>
</html>