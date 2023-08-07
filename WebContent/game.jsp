<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게임</title>
</head>
<body>
	게임
	<a href="main">되돌아가기</a>
	<p>
		<button id="0">버튼 0</button>
		<button id="1">버튼 1</button>
		<button id="2">버튼 2</button>
		<button id="3">버튼 3</button>
		<button id="4">버튼 4</button>
		<button id="5">버튼 5</button>
		<button id="6">버튼 6</button>
		<button id="7">버튼 7</button>
		<button id="8">버튼 8</button>
		<button id="9">버튼 9</button>
		<button id="10">버튼 10</button>
		<button id="11">버튼 11</button>
	</p>
	<p>
		<button id="12">버튼 12</button>
		<button id="13">버튼 13</button>
		<button id="14">버튼 14</button>
		<button id="15">버튼 15</button>
		<button id="16">버튼 16</button>
		<button id="17">버튼 17</button>
		<button id="18">버튼 18</button>
		<button id="19">버튼 19</button>
		<button id="20">버튼 20</button>
		<button id="21">버튼 21</button>
		<button id="22">버튼 22</button>
		<button id="23">버튼 23</button>
	</p>
</body>
<script>
const buttons = document.querySelectorAll("button");

buttons.forEach((button) => {
  button.addEventListener("click", () => {
    var buttonId = button.id;

    sessionStorage.setItem("buttonId", buttonId);
    window.location = "/333/inventory.jsp";
  });
});

<%Map<String, List<String>> m = (Map<String, List<String>>) session.getAttribute("gamein");
if (m.get("ok").size() > 0) {
	List<String> ok = m.get("ok");
	for (int i = 0; i < ok.size(); i++) {
		String a = ok.get(i);%>
	    const okButtonId = <%=a%>;
	    const okButton = document.getElementById(okButtonId);
	    if (okButton) {
	      okButton.innerHTML = '<img src="path/to/your/image_ok.jpg" alt="버튼 이미지1">';
	    }
	<%}
}%>
<%if (m.get("no").size() > 0) {
	List<String> no = m.get("no");
	for (int i = 0; i < no.size(); i++) {
		String a = no.get(i);%>
		const noButtonId = "<%=a%>";
	    const noButton = document.getElementById(noButtonId);
	    if (noButton) {
		    noButton.innerHTML = '<img src="path/to/your/image_no.jpg" alt="버튼 이미지2">';
		}
<%}
}%>
</script>
</html>