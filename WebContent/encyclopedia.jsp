<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도감</title>
</head>
<body>
도감
<a href="main">되돌아가기</a>
<%
	Connection conn = null;

	try{
		String url = "jdbc:mysql://192.168.0.81:3306/team3";
		String id = "Team3";
		String pw = "team3";
		
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url,id,pw);
		out.println("연결됐니?");
		
	} catch(Exception e){
		out.println(e.getMessage());
	}
%>
</body>
</html>