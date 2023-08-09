<%@page import="encyDao.encyGetSet"%>
<%@page import="java.util.List"%>
<%@page import="encyDao.encyclopediaInfo"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관</title>
</head>
<body>
   <form>
      <button type="submit" name="action" value="prev">이전</button>
      <button type="submit" name="action" value="next">다음</button>
   </form>

   <%
      encyclopediaInfo ency = new encyclopediaInfo();

   int paramValue = encyGetSet.getCurrent();

   String action = request.getParameter("action");

   out.println(paramValue);
   if (action == null) {
      action = "";
   }

   // "다음" 버튼을 누르면 2씩 증가, "이전" 버튼을 누르면 2씩 감소
   if (action.equals("next")) {
      paramValue = encyGetSet.getCurrent();
      encyGetSet.setCurrent(paramValue + 2);
   } else if (action.equals("prev")) {
      paramValue = encyGetSet.getCurrent();
      encyGetSet.setCurrent(paramValue - 2);
   }

   // 최소값을 보정 (0 미만으로 내려가지 않도록)
   if (encyGetSet.getCurrent() < -1) {
      encyGetSet.setCurrent(0);
      // 팝업 창을 띄우는 JavaScript 함수 정의
      out.println("<script>");
      out.println("function openPopup() {");
      out.println("    alert('이전 페이지가 존재하지 않아요!');");
      out.println("}");
      out.println("</script>");
      // "이전" 버튼을 눌렀을 때 openPopup() 함수를 호출하도록 JavaScript 코드 추가
      out.println("<script>");
      out.println("openPopup();");
      out.println("</script>");
   }

   // 최대값을 제한 (58 이상으로 올라가지 않도록)
   if (paramValue > 58) {
      paramValue = 58;
   }

   %>



</body>
</html>