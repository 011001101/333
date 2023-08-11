<%@page import="encyDao.encyGetSet"%>
<%@page import="java.util.List"%>
<%@page import="encyDao.encyclopediaInfo"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Page Title</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' type='text/css' media='screen' href='ency.css'>
<script
	src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/hammer.js/2.0.8/hammer.min.js'></script>
<script src='ency.js'></script>
</head>
<body>
	<div id="book">
		<div class="cover">
			<h1>토끼마을 식물 도감</h1>
		</div>
	</div>

	<div id="controls">
		<label for="page-number">Page:</label> <input type="text" size="3"
			id="page-number"> of <span id="number-pages"></span>
	</div>

</body>
<script type="text/javascript">
var p;
	// Sample using dynamic pages with turn.js

	var numberOfPages = 60;

	// Adds the pages that the book will need
	function addPage(page, book) {
		// 	First check if the page is already in the book
		if (!book.turn('hasPage', page)) {
			// Create an element for this page
			var element = $('<div />', {
				'class' : 'page ' + ((page % 2 == 0) ? 'odd' : 'even'),
				'id' : 'page-' + page
			}).html('<i class="loader"></i>');
			// If not then add the page
			book.turn('addPage', element, page);
			// Let's assum that the data is comming from the server and the request takes 1s.
			element
					.html('<div class="data">여기다가 db에서 가져온 정보를 뱉으시오 퉤에 </div> <div class="pageNumber">'
							+ page + '</div>');
		}
	}
	$(window).ready(function() {
		$('#book').turn({
			acceleration : true,
			pages : numberOfPages,
			elevation : 50,
			gradients : !$.isTouch,
			when : {
				turning : function(e, page, view) {
					p = page;
						console.log(p + '이거맞니?');
						/*sessionStorage.setItem("p", p);
						const xhr = new XMLHttpRequest();
						xhr.onreadystatechange = function(){
						xhr.open("POST", "/333/ency", true);
						xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
							if(xhr.readyState === 4 && xhr.status === 200){
								console.log(xhr.responseText);
								console.log('ㅎㅎ..');
							}
						};
						xhr.send("p=" + p);*/
					// Gets the range of pages that the book needs right now
					var range = $(this).turn('range', page);

					// Check if each page is within the book
					for (page = range[0]; page <= range[1]; page++)
						addPage(page, $(this));

				},

				turned : function(e, page) {
					$('#page-number').val(page);
				}
			}
		});
		/*function sendRequestWithPValue() {
	        // p 값을 사용하여 AJAX 요청을 보낼 수 있음
	        $.ajax({
	            url: 'http://localhost:8080/333/ency?p=' + p, // p 값을 URL 파라미터로 추가
	            method: 'POST',
	            dataType: 'json',
	            success: function(data) {
	                // 서버 응답을 처리하는 로직
	            },
	            error: function(xhr, status, error) {
	                console.error(error);
	            }
	        });
	    }*/

		$('#number-pages').html(numberOfPages);

		$('#page-number').keydown(function(e) {

			if (e.keyCode == 13)
				$('#book').turn('page', $('#page-number').val());

		});
	});

	$(window).bind('keydown', function(e) {

		if (e.target && e.target.tagName.toLowerCase() != 'input')
			if (e.keyCode == 37)
				$('#book').turn('previous');
			else if (e.keyCode == 39)
				$('#book').turn('next');

	});

	/*$.ajax({
		url : 'http://localhost:8080/333/ency?p='+ p, // 서버의 주소와 서블릿 이름
		method : 'POST', // GET 또는 POST
		dataType : 'json', // 응답 데이터 타입
		success : function(data) {
			console.log("연결됐니?");
			// 서버에서 전달한 JSON 데이터를 사용하여 원하는 작업 수행
		},
		error : function(xhr, status, error) {
			console.error(error);
		}
	});*/
</script>
</html>
