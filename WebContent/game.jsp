<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
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
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"
	type="text/javascript"></script>
<link
	href='//fonts.googleapis.com/css?family=Abel|Lato:100,300,400,700,900|Cabin:400,500,600,700'
	rel='stylesheet' type='text/css'>
<link
	href='//code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css'
	rel='stylesheet' type='text/css'>

</head>


<body>

	<header>
		<div class="container">
			<span id="menu"><span class="ion-navicon-round"></span></span>
          <div class="goBack" id="goBack" onclick="goBack()"></div>
            

		</div>
	</header>




	<div class="Status">
<iframe src = "status.jsp" width = "400" height = "200" ></iframe></div>
	<div class="Whatis" >
	<img src="img/게임설명창.png" alt="Whatis"></div>
	







	<div class="Light">

		<div class="sun"></div>

		<div class="Lightpot" name="pot">
			<div class="plantpot" name="plant1" type="button">
				<div class="plant" name="green1" type="button"></div>
			</div>
			<div class="plantpot" name="plant2" type="button">
				<div class="plant" name="green2" type="button"></div>
			</div>

			<div class="plantpot" name="plant3" type="button">
				<div class="plant" name="green3" type="button"></div>
			</div>

			<div class="plantpot" name="plant4" type="button">
				<div class="plant" name="green4" type="button"></div>
			</div>

			<div class="plantpot" name="plant5" type="button">
				<div class="plant" name="green5" type="button"></div>
			</div>

			<div class="plantpot" name="plant6" type="button">
				<div class="plant" name="green6" type="button"></div>
			</div>

			<div class="plantpot" name="plant7" type="button">
				<div class="plant" name="green7" type="button"></div>
			</div>

			<div class="plantpot" name="plant8" type="button">
				<div class="plant" name="green8" type="button"></div>
			</div>

			<div class="plantpot" name="plant9" type="button">
				<div class="plant" name="green9" type="button"></div>
			</div>

			<div class="plantpot" name="plant10" type="button">
				<div class="plant" name="green10" type="button"></div>
			</div>

			<div class="plantpot" name="plant11" type="button">
				<div class="plant" name="green11" type="button"></div>
			</div>

			<div class="plantpot" name="plant12" type="button">
				<div class="plant" name="green12" type="button"></div>
			</div>



		</div>


	</div>


	<div class="Dark">
		<div class="star">

			<svg width="1961px" height="927px" viewBox="-797 -97 1961 927"
				version="1.1" xmlns="http://www.w3.org/2000/svg"
				xmlns:xlink="http://www.w3.org/1999/xlink">
            <g id="Group" stroke="none" stroke-width="1" fill="none"
					fill-rule="evenodd" transform="translate(-797.000000, -97.000000)">
                <polygon id="star21" fill="#F8BF1C"
					points="15.5 254 6.38932859 258.944272 8.129312 248.472136 0.758623997 241.055728 10.9446643 239.527864 15.5 230 20.0553357 239.527864 30.241376 241.055728 22.870688 248.472136 24.6106714 258.944272"></polygon>
                <polygon id="star16" fill="#F8BF1C"
					points="1177.5 405 1168.38933 409.944272 1170.12931 399.472136 1162.75862 392.055728 1172.94466 390.527864 1177.5 381 1182.05534 390.527864 1192.24138 392.055728 1184.87069 399.472136 1186.61067 409.944272"></polygon>
                <polygon id="star14" fill="#F8BF1C"
					points="1306 87.483871 1300.12215 90.6737238 1301.24472 83.9175071 1296.48943 79.1327278 1303.06107 78.1470091 1306 72 1308.93893 78.1470091 1315.51057 79.1327278 1310.75528 83.9175071 1311.87785 90.6737238"></polygon>
                <polygon id="star9" fill="#F8BF1C"
					points="599 544.483871 593.122147 547.673724 594.244717 540.917507 589.489435 536.132728 596.061074 535.147009 599 529 601.938926 535.147009 608.510565 536.132728 603.755283 540.917507 604.877853 547.673724"></polygon>
                <g id="stargroup3"
					transform="translate(228.000000, 449.000000)">
                    <polygon id="star11" fill-opacity="0.623811141"
					fill="#F8BF1C"
					points="244.5 24 235.389329 28.9442719 237.129312 18.472136 229.758624 11.0557281 239.944664 9.52786405 244.5 0 249.055336 9.52786405 259.241376 11.0557281 251.870688 18.472136 253.610671 28.9442719"></polygon>
                    <polygon id="star7" fill-opacity="0.623811141"
					fill="#F8BF1C"
					points="15.5 355 6.38932859 359.944272 8.129312 349.472136 0.758623997 342.055728 10.9446643 340.527864 15.5 331 20.0553357 340.527864 30.241376 342.055728 22.870688 349.472136 24.6106714 359.944272"></polygon>
                    <polygon id="star6" fill-opacity="0.623811141"
					fill="#F8BF1C"
					points="142.5 229 133.389329 233.944272 135.129312 223.472136 127.758624 216.055728 137.944664 214.527864 142.5 205 147.055336 214.527864 157.241376 216.055728 149.870688 223.472136 151.610671 233.944272"></polygon>
                    <polyline id="Path-2" stroke="#FAD771"
					points="20.3603131 346.251302 143.666204 224.362721 248.084281 12.7690798"></polyline>
                </g>
                <polygon id="star5" fill="#F8BF1C"
					points="408.5 238 399.389329 242.944272 401.129312 232.472136 393.758624 225.055728 403.944664 223.527864 408.5 214 413.055336 223.527864 423.241376 225.055728 415.870688 232.472136 417.610671 242.944272"></polygon>
                <polygon id="star4" fill="#F8BF1C"
					points="228.5 631 219.389329 635.944272 221.129312 625.472136 213.758624 618.055728 223.944664 616.527864 228.5 607 233.055336 616.527864 243.241376 618.055728 235.870688 625.472136 237.610671 635.944272"></polygon>
                <polygon id="star25" fill="#F8BF1C"
					points="618.5 728 609.389329 732.944272 611.129312 722.472136 603.758624 715.055728 613.944664 713.527864 618.5 704 623.055336 713.527864 633.241376 715.055728 625.870688 722.472136 627.610671 732.944272"></polygon>
                <polygon id="star24" fill="#F8BF1C"
					points="534.5 919 525.389329 923.944272 527.129312 913.472136 519.758624 906.055728 529.944664 904.527864 534.5 895 539.055336 904.527864 549.241376 906.055728 541.870688 913.472136 543.610671 923.944272"></polygon>
                <polygon id="star23" fill="#F8BF1C"
					points="1488.5 903 1479.38933 907.944272 1481.12931 897.472136 1473.75862 890.055728 1483.94466 888.527864 1488.5 879 1493.05534 888.527864 1503.24138 890.055728 1495.87069 897.472136 1497.61067 907.944272"></polygon>
                <polygon id="star22" fill="#F8BF1C"
					points="156 380.483871 150.122147 383.673724 151.244717 376.917507 146.489435 372.132728 153.061074 371.147009 156 365 158.938926 371.147009 165.510565 372.132728 160.755283 376.917507 161.877853 383.673724"></polygon>
                <g id="stargroup1"
					transform="translate(700.000000, 72.000000)">
                    <polygon id="star13" fill-opacity="0.623811141"
					fill="#F8BF1C"
					points="61.5 231 52.3893286 235.944272 54.129312 225.472136 46.758624 218.055728 56.9446643 216.527864 61.5 207 66.0553357 216.527864 76.241376 218.055728 68.870688 225.472136 70.6106714 235.944272"></polygon>
                    <polygon id="star12" fill-opacity="0.623811141"
					fill="#F8BF1C"
					points="211.5 102 202.389329 106.944272 204.129312 96.472136 196.758624 89.0557281 206.944664 87.527864 211.5 78 216.055336 87.527864 226.241376 89.0557281 218.870688 96.472136 220.610671 106.944272"></polygon>
                    <polygon id="star10" fill-opacity="0.623811141"
					fill="#F8BF1C"
					points="227.5 263 218.389329 267.944272 220.129312 257.472136 212.758624 250.055728 222.944664 248.527864 227.5 239 232.055336 248.527864 242.241376 250.055728 234.870688 257.472136 236.610671 267.944272"></polygon>
                    <polygon id="star8" fill-opacity="0.623811141"
					fill="#F8BF1C"
					points="15.5 24 6.38932859 28.9442719 8.129312 18.472136 0.758623997 11.0557281 10.9446643 9.52786405 15.5 0 20.0553357 9.52786405 30.241376 11.0557281 22.870688 18.472136 24.6106714 28.9442719"></polygon>
                    <polygon id="star2" fill-opacity="0.623811141"
					fill="#F8BF1C"
					points="210.5 449 201.389329 453.944272 203.129312 443.472136 195.758624 436.055728 205.944664 434.527864 210.5 425 215.055336 434.527864 225.241376 436.055728 217.870688 443.472136 219.610671 453.944272"></polygon>
                    <polyline id="Path-3" stroke="#FAD771"
					points="69.2446344 221.794057 213.945143 444.687604 227.90612 260.369932 213.414857 91.0834491 22.1166968 18.048644"></polyline>
                </g>
                <polygon id="star1" fill="#F8BF1C"
					points="890.5 744 881.389329 748.944272 883.129312 738.472136 875.758624 731.055728 885.944664 729.527864 890.5 720 895.055336 729.527864 905.241376 731.055728 897.870688 738.472136 899.610671 748.944272"></polygon>
                <polygon id="star17" fill="#F8BF1C"
					points="1777.5 405 1768.38933 409.944272 1770.12931 399.472136 1762.75862 392.055728 1772.94466 390.527864 1777.5 381 1782.05534 390.527864 1792.24138 392.055728 1784.87069 399.472136 1786.61067 409.944272"></polygon>
                <polygon id="star18" fill="#F8BF1C"
					points="1808.5 24 1799.38933 28.9442719 1801.12931 18.472136 1793.75862 11.0557281 1803.94466 9.52786405 1808.5 0 1813.05534 9.52786405 1823.24138 11.0557281 1815.87069 18.472136 1817.61067 28.9442719"></polygon>
                <g id="stargroup2"
					transform="translate(1280.000000, 198.000000)">
                    <polygon id="star20" fill="#F8BF1C"
					points="264.5 323 255.389329 327.944272 257.129312 317.472136 249.758624 310.055728 259.944664 308.527864 264.5 299 269.055336 308.527864 279.241376 310.055728 271.870688 317.472136 273.610671 327.944272"></polygon>
                    <polygon id="star19" fill="#F8BF1C"
					points="360.5 24 351.389329 28.9442719 353.129312 18.472136 345.758624 11.0557281 355.944664 9.52786405 360.5 0 365.055336 9.52786405 375.241376 11.0557281 367.870688 18.472136 369.610671 28.9442719"></polygon>
                    <polygon id="star18" fill="#F8BF1C"
					points="133.5 111 124.389329 115.944272 126.129312 105.472136 118.758624 98.0557281 128.944664 96.527864 133.5 87 138.055336 96.527864 148.241376 98.0557281 140.870688 105.472136 142.610671 115.944272"></polygon>
                    <polygon id="star15" fill="#F8BF1C"
					points="15.5 441 6.38932859 445.944272 8.129312 435.472136 0.758623997 428.055728 10.9446643 426.527864 15.5 417 20.0553357 426.527864 30.241376 428.055728 22.870688 435.472136 24.6106714 445.944272"></polygon>
                    <polyline id="Path-4" stroke="#F8BE1C"
					points="131.360103 106.177807 362.410409 17.7839998 267.248227 312.420384 22.6708146 433.47015"></polyline>
                </g>
                <polygon id="star3" fill="#F8BF1C"
					points="1082.5 919 1073.38933 923.944272 1075.12931 913.472136 1067.75862 906.055728 1077.94466 904.527864 1082.5 895 1087.05534 904.527864 1097.24138 906.055728 1089.87069 913.472136 1091.61067 923.944272"></polygon>
                <polygon id="star27" fill="#F8BF1C"
					points="1951 795.483871 1945.12215 798.673724 1946.24472 791.917507 1941.48943 787.132728 1948.06107 786.147009 1951 780 1953.93893 786.147009 1960.51057 787.132728 1955.75528 791.917507 1956.87785 798.673724"></polygon>
                <polygon id="star26" fill="#F8BF1C"
					points="1808.5 671 1799.38933 675.944272 1801.12931 665.472136 1793.75862 658.055728 1803.94466 656.527864 1808.5 647 1813.05534 656.527864 1823.24138 658.055728 1815.87069 665.472136 1817.61067 675.944272"></polygon>
            </g>
        </svg>
		</div>
		<div class="contain-page">
			<div id="contain-all-moon">
				<svg style="isolation: isolate" viewBox="0 0 400 400" width="100%"
					height="100%">
                <g id="moon-group">
                    <g id="aura-group" fill="#EBEBEB" fill-opacity=".16">
                        <path
						d="M90.138 200c0-60.634 49.228-109.862 109.862-109.862 60.634 0 109.862 49.228 109.862 109.862 0 60.634-49.228 109.862-109.862 109.862-60.634 0-109.862-49.228-109.862-109.862z"
						id="aura-1" />
                        <path
						d="M70.638 200c0-71.397 57.965-129.362 129.362-129.362 71.397 0 129.362 57.965 129.362 129.362 0 71.397-57.965 129.362-129.362 129.362-71.397 0-129.362-57.965-129.362-129.362z"
						id="aura-2" />
                        <path
						d="M51.333 200c0-82.051 66.616-148.667 148.667-148.667S348.667 117.949 348.667 200 282.051 348.667 200 348.667 51.333 282.051 51.333 200z"
						id="aura-3" />
                    </g>
    
                <!-- 	moon		 -->
                    <radialGradient id="_rgradient_0" fx=".5" fy=".5"
						cx=".5" cy=".5" r=".5"
						gradientTransform="translate(107.867 107.867) scale(184.265)"
						gradientUnits="userSpaceOnUse">
                        <stop offset="88.69218161%" stop-color="#ffe" />
                        <stop offset="100%" stop-color="#fff" />
                    </radialGradient>
                    <path
						d="M107.867 200c0-50.849 41.284-92.133 92.133-92.133s92.133 41.284 92.133 92.133-41.284 92.133-92.133 92.133-92.133-41.284-92.133-92.133z"
						id="moon" fill="" />
                <!-- end moon -->
    
                    <g id="crater-group" fill="#D9D9BE">
                        <path
						d="M228.897 143.209c0-2.827 2.295-5.122 5.122-5.122s5.122 2.295 5.122 5.122-2.295 5.122-5.122 5.122-5.122-2.295-5.122-5.122z"
						id="crater-1" />
                        <path
						d="M217.866 197.184c0-6.088 4.943-11.031 11.031-11.031 6.089 0 11.032 4.943 11.032 11.031 0 6.088-4.943 11.031-11.032 11.031-6.088 0-11.031-4.943-11.031-11.031z"
						id="crater-2" />
                        <path
						d="M239.929 218.065c0-11.525 9.356-20.881 20.881-20.881 11.524 0 20.88 9.356 20.88 20.881 0 11.524-9.356 20.881-20.88 20.881-11.525 0-20.881-9.357-20.881-20.881z"
						id="crater-3" />
                        <path
						d="M202.895 245.643c0-11.524 9.356-20.881 20.881-20.881 11.524 0 20.881 9.357 20.881 20.881 0 11.525-9.357 20.881-20.881 20.881-11.525 0-20.881-9.356-20.881-20.881z"
						id="crater-4" />
                    </g>
                </g>
            </svg>
			</div>
		</div>
		<div class="Darkpot">




			<div class="plantpot" name="plant13" type="button">
				<div class="plant" name="green13" type="button"></div>
			</div>


			<div class="plantpot" name="plant14" type="button">
				<div class="plant" name="green14" type="button"></div>
			</div>

			<div class="plantpot" name="plant15" type="button">
				<div class="plant" name="green15" type="button"></div>
			</div>

			<div class="plantpot" name="plant16" type="button">
				<div class="plant" name="green16" type="button"></div>
			</div>

			<div class="plantpot" name="plant17" type="button">
				<div class="plant" name="green17" type="button"></div>
			</div>

			<div class="plantpot" name="plant18" type="button">
				<div class="plant" name="green18" type="button"></div>
			</div>

			<div class="plantpot" name="plant19" type="button">
				<div class="plant" name="green19" type="button"></div>
			</div>

			<div class="plantpot" name="plant20" type="button">
				<div class="plant" name="green20" type="button"></div>
			</div>

			<div class="plantpot" name="plant21" type="button">
				<div class="plant" name="green21" type="button"></div>
			</div>

			<div class="plantpot" name="plant22" type="button">
				<div class="plant" name="green22" type="button"></div>
			</div>

			<div class="plantpot" name="plant23" type="button">
				<div class="plant" name="green23" type="button"></div>
			</div>

			<div class="plantpot" name="plant24" type="button">
				<div class="plant" name="green24" type="button"></div>
			</div>


		</div>

	</div>


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


<script>


//1단계, 2단계일때는 마우스 상호작용 불가능하게 만들고, 3단계(다 컸음)일때만 상호작용 되도록

//흙일 때 클릭 후, 인벤토리 꺼내서 씨앗 심기
//심으면 불룩 나온 흙 (0단계)

//1단계 (새싹)
//2단계 (줄기 나옴)

//3단게 수확 
//뽑으면서 동시에 뽑는 애니메이션 넣고, 인벤토리에 값 반환(+1)
for(var i = 1; i <= 27; i++) {
 var duration = 1 + Math.random() * 3;
 $("#star" + i).css({
   "animation" : duration + "s gleam infinite ease"
 })
}
//이건 별 그리는 함수임 



function seed(o){


 function openInven(){


     



 };

 openInven();
/*    //인벤토리 불러오기

 //씨앗 선택하기

 //씨앗 정보 json으로 뭉쳐서 db로 보내주기


 //이미지 바꾸기*/

 $('.plant').replaceWith('<img src="불룩한 흙" />');
}






function harvest(o){
 $(o).animate( { top:'-=200', opacity:0 }, 200, function(){
     $(this).remove(); // 애니메이션이 끝나면 제거
 });
}

$(function() {

 var w = $(window).width(),
   h = $(window).height();
 //$('section').width(w);
 $('section').height(h);
 $('menu .container').height(h - 60);
 $('body').prepend('<div id="overlay">');

 $('.plant').click(function() {$('html').addClass('active');});
 $('#close-menu').click(function() {$('html').removeClass('active');});
 $('#overlay').click(function() {$('html').removeClass('active');});
 $(window).resize(function() {
   var w = $(window).width(),
     h = $(window).height();
   //$('section').width(w);
   $('section').height(h);
   $('menu .container').height(h - 60);
 });

});


var okButtonId = null;
<%Map<String, List<String>> m = (Map<String, List<String>>) session.getAttribute("gamein");
if (m.get("ok") != null) {
	List<String> ok = m.get("ok");
	for (int i = 0; i < ok.size(); i++) {
		String a = ok.get(i);%>
	okButtonId = "<%=a%>";
sessionStorage.setItem("ok<%=i%>", okButtonId);
sessionStorage.setItem("setok", <%=i + 1%>);
console.log(okButtonId);
<%}
}
if (m.get("no") != null) {
List<String> no = m.get("no");
for (int i = 0; i < no.size(); i++) {
String a = no.get(i);%>
okButtonId = "<%=a%>";
sessionStorage.setItem("no<%=i%>", okButtonId);
sessionStorage.setItem("setno", <%=i + 1%>);
console.log(okButtonId);
<%}
}%>





var imglist = '<%=session.getAttribute("imglistJ")%>';

sessionStorage.setItem("imglistJ", imglist);

	var set = sessionStorage.getItem("setok");
	var ok = null;
	if(set != 0){
	for (var i = 0; i < set; i++) {
	    ok = sessionStorage.getItem("ok" + i);
	    // 클래스 이름이 ok의 값과 일치하는 요소를 선택
	    console.log(ok);
	    var elements = document.querySelectorAll(".plant");
	    for (var j = 0; j < elements.length; j++) {
	        if (elements[j].getAttribute("name") === ok) {
	        	console.log("여기");
	            elements[j].style.backgroundImage = "url('img/Pplant.svg')";
	        }
	    }
	    sessionStorage.removeItem("ok" + i);
	}
	}
	var setno = sessionStorage.getItem("setno");
	var no = null;
	if(setno != 0){
	for (var i = 0; i <= setno; i++) {
	    no = sessionStorage.getItem("no" + i);
	    // 클래스 이름이 ok의 값과 일치하는 요소를 선택
	    var elementsno = document.querySelectorAll(".plant");
	    for (var j = 0; j < elementsno.length; j++) {
	        if (elementsno[j].getAttribute("name") === no) {
	            elementsno[j].style.backgroundImage = "url('img/seedplant.svg')";
	        }
	    }
	    sessionStorage.removeItem("no" + i);
	}
	}
	
	
	const plantpots = document.querySelectorAll('.plant');
	plantpots.forEach((plantpot) => {
	    plantpot.addEventListener('click', () => {
	    	var buttonId = plantpot.getAttribute('name');
	        sessionStorage.setItem("buttonId", buttonId);
	        const computedStyle = window.getComputedStyle(plantpot);
	        const backgroundImage = computedStyle.getPropertyValue('background-image');
	        const urlRegex = /url\("(.+)"\)/;
	        const matches = backgroundImage.match(urlRegex);
	        
	        if (matches && matches.length > 1) {
	            const imageUrl = decodeURIComponent(matches[1]); // URL 디코딩
		            if (imageUrl.includes('img/seedplant.svg')) {
		    	    	alert('기다려!');
		    	    	window.location.href = "/333/game";
		    	    } else if (imageUrl.includes('img/Pplant.svg')) {
		    			// 수확 가능 db에서 수확 했다고 바꾸기
		    			sessionStorage.setItem("plant", "plant");
		    	        const xhr = new XMLHttpRequest();
		    	   		xhr.open("POST", "/333/game", true);
		    	   		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		    	   		xhr.onreadystatechange = function() {
		    	      	if (xhr.readyState === 4 && xhr.status === 200) {
	//	    	        	console.log(xhr.responseText);
		    	        	window.location.href = "/333/game";
		    	      		}
		    	    	};
		    	    	xhr.send("buttonId=" + encodeURIComponent(buttonId)+"&plant=" + "plant");
		    	    	
		    	    } else {
		    	    	sessionStorage.removeItem("plant");
		    	    }
	            }
	    });
	});
	function goBack() {
		  // main.jsp로 페이지 이동
		  window.location.href = 'main.html';
		}
</script>
	<script src="script.js"></script>
</body>

</html>