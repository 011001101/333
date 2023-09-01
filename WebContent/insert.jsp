<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main</title>
    <link rel="stylesheet" href="insert.css">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Staatliches&display=swap');
        @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@100&display=swap');

        .box {
            position: absolute;
            left: 70px;
            top: 70px;
            width: 200px;
            height: 200px;
            background-color: transparent;
            offset: path('M0,100c10,-50 82.095,-82.507 127.089,0c19.734,-79.314 119.195,-102.241 151.559,0c5.526,-77.735 101.322,-104.262 149.192,-52.888') auto;
            animation: moveto 10s infinite ease; 
}


    </style>
</head>
<body>
    <div class="text-box">
        <div class="coloring">
            <div class="text-wrap">
                <svg width="700" height="700" viewBox="0 0 700 700">
                    <text x="70" y="55%">R</text>
                    <text x="130" y="55%">a</text>
                    <text x="180" y="55%">b</text>
                    <text x="240" y="55%">b</text>
                    <text x="295" y="55%">i</text>
                    <text x="320" y="55%">t</text>
                    <text x="380" y="55%">g</text>
                    <text x="430" y="55%">a</text>
                    <text x="480" y="55%">r</text>
                    <text x="535" y="55%">d</text>
                    <text x="590" y="55%">e</text>
                    <text x="640" y="55%">n</text>
                </svg>
                <div class="box"></div>
                
                <img src="sign.svg" alt="표지판" class="sign-img">
                
            </div>
        </div>
    </div>
 <div class="button-container">
        <button id="loginButton" class="custom-button">Login</button>
        <button id="joinButton" class="custom-button">Join</button>
    </div>
    <script >
    <%if(session.getAttribute("true") != null){
    %>
    alert("회원가입이 완료되었습니다.");
    <%session.removeAttribute("true");
    }%>
    </script>
    <script>
        document.getElementById("loginButton").addEventListener("click", function() {
            window.location.href = "Loginfo";
        });
        document.getElementById("joinButton").addEventListener("click", function() {
            window.location.href = "Joininfo";
        });
    </script>
</body>
</html>
