<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Join</title>
  <link rel="stylesheet" href="join.css">
  <style>
  </style>
</head>
<body>
  <div class="b"></div>
  <div class="join-container">
    <h1>Join</h1>
    <form>
      <div class="tooltip" title="ID는 2~4글자 사이 영어, 숫자로만 이루어져야 합니다.">
        <input type="text" id="id" placeholder="ID">
      </div>
      <div class="tooltip" title="PW는 영어, 숫자, 특수문자가 최소 1개 포함되어야 합니다.">
        <input type="password" id="password" placeholder="비밀번호">
      </div>
      <button type="submit" onclick="join()">가입하기</button>
    </form>
    <p id="message"></p>
  </div>
  <script src="join.js"></script>
</body>
</html>
