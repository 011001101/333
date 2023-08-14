<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게임 상태창</title>
    <link rel="stylesheet" href="status.css">
    <style>

    </style>
</head>
<body>
    <div class="status-container">
        <div class="status">
        <p>ID : <span id="id"><%= session.getAttribute("userId") %></span></p>
        <p>레벨 : <span id="level"><%=session.getAttribute("exp")%></span></p>
        <p>경험치 : <span id="xp"><%=session.getAttribute("exp")%></span></p>
        <p>돈 : <span id="money"><%=session.getAttribute("point")%></span></p>
    </div>
</div>
</body>
</html>
