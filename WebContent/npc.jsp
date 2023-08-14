<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang ="ko">
<head class="hidden-header">
<meta charset="UTF-8" />
<link rel="stylesheet" href="npc.css">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />

<body>
        <div class="rabbit" id="rabbit">
         
          <div class="goBack" id="goBack" >
            <button id="goBackButton" onclick="goBack()">
              <img src="img/home.png" alt="Home">
            </button>
            
            </div>
            <div class="usaginpc" id="usaginpc" ></div>

            <div class="dialogBox" id="dialogBox">
          
              <div class="output" id="output">
                <h1 class="cursor"></h1>
                <p></p>
              </div>
  </div>

  </div>
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
      <script src="npc.js"></script>
</body>