<%@page import="join.Join"%>
<%@page import="join.Joininfo"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8"> 
  <title>Join</title>
<link rel="stylesheet" href="join.css">
</head>
<body>
  <div class="b"></div>
  <div class="join-container">
    <h1>Join</h1>
   <form method="post">
  <div class="tooltip" title="ID는 2~4자 사이 소문자, 숫자로만 이루어져야 합니다.">
    <input type="text" name="id" placeholder="ID">
  </div>
  <div class="tooltip" title="PW는 소문자, 숫자RK 포함된  8~12자 이여야 합니다.">
    <input type="password" name="password" placeholder="password">
  </div>
  <button type="submit" id="joinButton">가입하기</button>

</form>
    <p id="message"></p>
  </div>
  <script src="join.js"></script>
  <!-- 
   -->
</body>
</html>
