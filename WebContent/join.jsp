<%@page import="join.Join"%>
<%@page import="join.Joininfo"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	request.setCharacterEncoding("UTF-8");
	String uId = request.getParameter("userId");
	String uPw = request.getParameter("userPw");
	
	String dbType = "com.mysql.cj.jdbc.Driver";
	String connectUrl = "jdbc:mysql://localhost:3306/jdbcprac2?serverTimezone=UTC";
	String connectId = "root";
	String connectPw = "mysql";
	
	ResultSet rs = null;
	
	try {
		Class.forName(dbType);
	
		Connection con = DriverManager.getConnection(connectUrl, connectId, connectPw);
		
		String sql = "SELECT*FROM userinfo WHERE user_id = ?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		

		pstmt.setString(1, uId);
		
		
		rs = pstmt.executeQuery();
		
		if(rs.next()){			
			String dbId = rs.getString(1);
			String dbPw =  rs.getString(2);
			String dbName = rs.getString(3);
			String dbMail =  rs.getString(4); 

			if(uPw.equals(dbPw)) {
						
session.setAttribute("s_id", uId);				response.sendRedirect("http://localhost:8181/JSPbasic/user/loginWelcome.jsp");
							
				} else {
						response.sendRedirect("http://localhost:8181/JSPbasic/user/userPwFail.jsp");
				}
		
			} else {
				response.sendRedirect("http://localhost:8181/JSPbasic/user/userIdFail.jsp");
			}
			
		
	} catch(Exception e){
		e.printStackTrace();
	}
%>
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
