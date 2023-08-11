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
  <style>
  </style>
</head>
<body>
  <div class="b"></div>
  <div class="join-container">
    <h1>Join</h1>
   <form action="Joininfo" method="post">
  <div class="tooltip" title="ID는 2~4자 사이 소문자, 숫자로만 이루어져야 합니다.">
    <input type="text" name="id" placeholder="ID">
  </div>
  <div class="tooltip" title="PW는 소문자, 숫자, 특수문자가 최소 1개 포함된  8자 이상이여야 합니다.">
    <input type="password" name="password" placeholder="비밀번호">
  </div>
  <button type="submit">가입하기</button>
</form>
    <p id="message"></p>
  </div>
  
  <div id="myModal" class="modal">
  <div class="modal-content">
    <span class="close">&times;</span>
    <p id="modal-message"></p>
    <button id="modal-main-button">Game start</button>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
  
  <script src="join.js"></script>
</body>
</html>
