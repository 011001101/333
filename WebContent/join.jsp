<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>íìê°ì</title>
</head>
<body>
	ìì´ë : ìëìë¬¸ìì ì«ìë¥¼ ì¡°í©í´ 2 ~ 4ì<br>
	 ë¹ë² : í¹ìë¬¸ì !@#$%^&* ìëìë¬¸ìì ì«ìë¥¼ ì¡°í©í´ 8 ~ 20ì
	<form method="post">
		<p>
			<label>ìì´ë <input type="text" name="id"></label>
		</p>
		<p>
			<label>ë¹ë°ë²í¸ <input type="password" name="pw"></label>
		</p>
		<input type=submit value="ê°ìíê¸°">
	</form>
	<a href="insert.jsp">ëëìê°ê¸°</a>
	<c:if test="${ not empty fal }">
		<p style="color: red">
		<%= session.getAttribute("fal") %>
		</p>
	</c:if>
</body>
<%session.removeAttribute("fal"); %>
</html>