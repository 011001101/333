<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Login</title>
  <link rel="stylesheet" href="login.css">
</head>
<body>
  <div class="a"></div>
  <div class="login-container">
    <h1>Login</h1>
    <form>
      <input type="text" id="id" placeholder="id">
      <input type="password" id="password" placeholder="Password">
      <button type="button" onclick="login()">Login</button>
    </form>
    <p id="message"></p>
  </div>
  <script src="login.js"></script>
</body>
</html>