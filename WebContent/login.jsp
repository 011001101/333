<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<p><input type="text" name="id"> </p>
		<p><input type="password" name="password"></p>
		<c:if test="${ not empty no }">
		<p style="color: red">아이디나 비밀번호를 확인하세요</p>
		</c:if>
		<input type="submit">
	</form>
</body>
<%session.removeAttribute("no"); %>
</html>
