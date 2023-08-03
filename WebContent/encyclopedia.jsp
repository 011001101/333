<%@page import="java.util.List"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<title>도감</title>
</head>
<body>
	도감
	<h1>식물 백과사전</h1>
	<table>
		<tr>
			<th>식물 번호</th>
			<th>식물 이름</th>
			<th>원산지</th>

		</tr>
		<c:forEach items="${encyList}" var="plant">
			<tr>
				<td>${plant}</td>

			</tr>
		</c:forEach>
	</table>
	<a href="main">되돌아가기</a>
	<form method="post">
		<input type="hidden" id="valueInput" name="value" value="0">
		<button type="button" name="beforeBtn" onclick="decrementValue()">이전</button>
		<button type="button" name="nextBtn" onclick="incrementValue()">다음</button>
		<button type="submit" name="submitBtn">전송</button>
	</form>
	<div id="result">이동할 페이지 No. 0</div>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
    function incrementValue() {
        var valueInput = document.getElementById("valueInput");
        valueInput.value = parseInt(valueInput.value) + 2;
        updateResult();
    }

    function decrementValue() {
        var valueInput = document.getElementById("valueInput");
        valueInput.value = parseInt(valueInput.value) - 2;
        if (parseInt(valueInput.value) < 0) {
            alert("이전 페이지가 존재하지 않습니다.");
            valueInput.value = 0; // 값을 0으로 다시 설정하여 최소값 0을 유지
        }
        updateResult();
    }

    function updateResult() {
        var value = document.getElementById("valueInput").value;
        $("#result").text("이동할 페이지 No. " + value);
    }
</script>
</body>
</html>