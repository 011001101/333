<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>게임 화면</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <div class="game-container">
        <h1>게임 제목</h1>
        <canvas id="game-canvas" width="800" height="600"></canvas>
        <button id="start-button" onclick="startGame()">시작</button>
        <button id="pause-button" onclick="pauseGame()">일시정지</button>
    </div>
    <script src="game.js"></script>
</body>
</html>
