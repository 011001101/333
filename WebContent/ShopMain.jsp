<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang ="ko">

<head class="hidden-header">

<meta charset="UTF-8" />


<link rel="stylesheet" href="ShopMain.css">
<link rel="stylesheet" href="inven.css">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />

  
  </head>

<body>

 
        <div class="rabbit" id="rabbit">
         
          <div class="goBack" id="goBack" onclick="goBack()"></div>
    
    
            <div class="Status" id="Status">상태창 자리</div>
      


            <div class="rabbitFace" id="rabbitFace" ></div>
              
      

    
            <div class="BUY"><a href="#">  
             
              <div class="get_buy"></div>
            <div class="text">구매하기</div>
           
            </div>
            
            
            
            <div class="SELL" id="menu"><a href="#">  
             
              <div class="get_sell"></div>
              <div class="text">판매하기</div>
            </div>


            <div class="dialogBox" id="dialogBox">
          
              <div class="output" id="output">
                <h1 class="cursor"></h1>
                <p></p>
              </div>
    
              </div>
  </div>

  


  <!-- 구매용 -->

      
  <div class="menu_bg"></div>
  <div class="sidebar_menu">
       <div class="close_btn"><a href="#">       
           <img src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0Ij48cGF0aCBkPSJNMjMuOTU0IDIxLjAzbC05LjE4NC05LjA5NSA5LjA5Mi05LjE3NC0yLjgzMi0yLjgwNy05LjA5IDkuMTc5LTkuMTc2LTkuMDg4LTIuODEgMi44MSA5LjE4NiA5LjEwNS05LjA5NSA5LjE4NCAyLjgxIDIuODEgOS4xMTItOS4xOTIgOS4xOCA5LjF6Ii8+PC9zdmc+">
           </a>
       </div>
       <ul class="menu_wrap">
      <div class="BuyInventory" id="BuyInventory">
        <!-- 각 칸에 해당하는 div 요소들을 동적으로 생성할 예정 -->
       </ul>
      </div>
  </div>


    <!-- 판매용 -->

  <div class="menu_bg2">
  <div class="sidebar_menu2">
       <div class="close_btn2"><a href="#">       
           <img src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0Ij48cGF0aCBkPSJNMjMuOTU0IDIxLjAzbC05LjE4NC05LjA5NSA5LjA5Mi05LjE3NC0yLjgzMi0yLjgwNy05LjA5IDkuMTc5LTkuMTc2LTkuMDg4LTIuODEgMi44MSA5LjE4NiA5LjEwNS05LjA5NSA5LjE4NCAyLjgxIDIuODEgOS4xMTItOS4xOTIgOS4xOCA5LjF6Ii8+PC9zdmc+">
           </a>
       </div>
       <ul class="menu_wrap2">
        <div class="SellInventory" id="SellInventory">
        </ul>
      </div>
    </div>       
       
  </div>
  

           <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
      <script src="shopMain.js"></script>
      <script src="script.js"></script>


    
</body>
