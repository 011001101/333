<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="plant.Login"%>
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
      <input type="text" id="id" placeholder="id" name="id">
      <input type="password" id="password" placeholder="Password" name="pw">
      <button type="submit">Login</button>
    </form>
    <%
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    
    Login login = new Login();
    
    boolean sucsess = login.loginst(id, pw);
    if (sucsess) {
    	
        request.getRequestDispatcher("/main.jsp").forward(request, response);
    }
    
    %>

    	
  <%--
    <p id="message"></p>
  </div>
  <script src="login.js"></script>
   --%>
</body>
</html>