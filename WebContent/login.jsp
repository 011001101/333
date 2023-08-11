<%@page import="plant.Login"%>
<%@page import="plant.Loginfo"%>
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
  <title>Login</title>
  <link rel="stylesheet" href="login.css">
</head>
<body>
  <div class="a"></div>
  <div class="login-container">
    <h1>Login</h1>
    <form method="post">
      <input type="text" name="id" id="id" placeholder="id">
      <input type="password" name="password" id="password" placeholder="Password">
      <button type="submit" onclick="login()">Login</button>
    </form>
    <p id="message"></p>
  </div>
  <!-- <script src="login.js"></script> -->
</body>
</html>