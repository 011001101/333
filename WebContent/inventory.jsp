<%@page import="java.sql.Blob"%>
<%@page import="java.util.List"%>
<%@page import="plant.Game"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title></title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='inven.css'>
    <link rel='stylesheet' type='text/css' media='screen' href='game.css'>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>
    <link href='//fonts.googleapis.com/css?family=Abel|Lato:100,300,400,700,900|Cabin:400,500,600,700' rel='stylesheet' type='text/css'>
    <link href='//code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css' rel='stylesheet' type='text/css'>
 
    <script src='game.js'></script>
     <script src='script.js'></script>
</head>
<body>


	<header>
		<div class="container">
			<span id="menu"><span class="ion-navicon-round"></span></span>
		</div>
	</header>


	<menu>
		<span id="close-menu"><span class="ion-close-round"></span></span>
		<div class="container">
			<div class="box">
				<div class="inventory" id="inventory">
					<!-- 각 칸에 해당하는 div 요소들을 동적으로 생성할 예정 -->
				</div>

			</div>
		</div>
	</menu>
</body>
</html>