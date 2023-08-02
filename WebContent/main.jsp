<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
	<button id="shop" onclick="shopgo()">상점</button>
	<button id="encyclopedia" onclick="encygo()">도감</button>
	<button id="game" onclick="gamego()">게임</button>
	<a href="insert.jsp">로그아웃</a>
</body>
<script>
	function shopgo() {
		window.location.href = "shop.jsp";
	}

	function encygo() {
		window.location.href = "encyclopedia.jsp";
	}

	function gamego() {
		window.location.href = "game.jsp";
	}
</script>
</html>