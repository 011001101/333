$(document).ready(function(){
 
  $('.BUY>a').on('click', function(){
      $('.menu_bg').show(); 
      $('.rabbitFace').show().animate({

        left: '-' + 0 + '%'

      });
      $('.sidebar_menu').show().animate({
          right:0
      });  
  });
  $('.close_btn>a').on('click', function(){
      $('.menu_bg').hide(); 
      $('.rabbitFace').show().animate({

        left: '+' + 38 + '%'

      });
      $('.sidebar_menu').animate({
          right: '-' + 50 + '%'
                 },function(){
$('.sidebar_menu').hide(); 
}); 
  });
});

  $(document).ready(function(){
  $('.SELL>a').on('click', function(){
      $('.menu_bg2').show(); 
      $('.rabbitFace').show().animate({

        left: '-' + 0 + '%'

      });
      $('.sidebar_menu2').show().animate({
          right:0
      });  
  });
  $('.close_btn2>a').on('click', function(){
      $('.menu_bg2').hide(); 
      $('.rabbitFace').show().animate({

        left: '+' + 38 + '%'

      });
      $('.sidebar_menu2').animate({
          right: '-' + 50 + '%'
                 },function(){
$('.sidebar_menu2').hide(); 
}); 
  });

});



// 인벤 그리기 
var imglistShopJson = sessionStorage.getItem("imglistShop");
var imglistShop = JSON.parse(imglistShopJson);
var propertyCount1= 0;
if(imglistShop != null){
propertyCount1 = Object.keys(imglistShop).length;
}

var imglistInvJson = sessionStorage.getItem("imglistInv");
var imglistInv = JSON.parse(imglistInvJson);
var propertyCount2 = 0;
if(imglistInv != null){
	propertyCount2 = Object.keys(imglistInv).length;
}

const inventorySize = 5;
let inventory = Array.from({ length: inventorySize }, () => Array(inventorySize).fill(null));

// 인벤토리 그리기
function drawInventory() {
   const inventoryContainer = document.getElementById("BuyInventory");
    inventoryContainer.innerHTML = "";
    for (let row = 0; row < inventorySize; row++) {
        for (let col = 0; col < inventorySize; col++) {
            const cell = document.createElement("div");
          
            cell.classList.add("cell");
            
            cell.setAttribute("data-rowon", row);
            cell.setAttribute("data-colon", col);
			 cell.draggable=true;
			var imgIndex = (row * inventorySize) + col;
			if(propertyCount1 > imgIndex){
				console.log("사용");
               	const img = document.createElement("img");
                img.src = "data:image/png;base64," + imglistShop[imgIndex];
                cell.appendChild(img);
			}

            cell.addEventListener("click", toggleItem);
            inventoryContainer.appendChild(cell);
        }
    }
}



// 인벤토리 그리기2


function drawInventory2() {
  const inventoryContainer = document.getElementById("SellInventory");
    inventoryContainer.innerHTML = "";

  for (let row = 0; row < inventorySize; row++) {
      for (let col = 0; col < inventorySize; col++) {
          const cell = document.createElement("div");
        
          cell.classList.add("cell");
          
          cell.setAttribute("data-row", row);
          cell.setAttribute("data-col", col);
      	  cell.draggable=true;
			

          var imgIndex = (row * inventorySize) + col;
			if(propertyCount2 > imgIndex){
               	const img = document.createElement("img");
                img.src = "data:image/png;base64," + imglistInv[imgIndex];
                cell.appendChild(img);
			}

          cell.addEventListener("click", toggleItem2);
          inventoryContainer.appendChild(cell);
      }
  }
}


function toggleItem(event) {
     const row = parseInt(event.target.parentElement.getAttribute("data-rowon"));
   	 const col = parseInt(event.target.parentElement.getAttribute("data-colon"));

if (inventory[row][col]) {
         inventory[row][col] = null;
     } else {
var point = 0;
	if(row == 0 && col == 0){
		point = 100;
	}else if(row == 0 && col == 1){
		point = 60;
	}else if(row == 0 && col == 2){
		point = 20;
	}else if(row == 0 && col == 3){
		point = 30;
	}else if(row == 0 && col == 4){
		point = 80;
	}else if(row == 1 && col == 0){
		point = 40;
	}else if(row == 1 && col == 1){
		point = 65;
	}else if(row == 1 && col == 2){
		point = 70;
	}else if(row == 1 && col == 3){
		point = 85;
	}
	if(point != 0){
var userInput = prompt("몇 개 구매 하시나용?"+"");
var num1;
num1 = userInput;
var byit = num1 * point;
var userpoint = sessionStorage.getItem("point");
if(userpoint >= byit){
	alert(userInput+"개 구매 완.");
	sessionStorage.removeItem("invencltw");
	
 	sessionStorage.setItem("invenclon", byit);
 	sessionStorage.setItem("pointnum", point);
 	const xhr = new XMLHttpRequest();
 	xhr.open("POST", "/333/shop", true);
 	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
 	xhr.onreadystatechange = function() {
 	if (xhr.readyState === 4 && xhr.status === 200) {
        console.log(xhr.responseText);
	    window.location.href = "/333/shop";
    	}
 	};
 	xhr.send("invenclon=" + encodeURIComponent(byit)+"&pointnum=" + encodeURIComponent(point));
}else{
	alert(userInput+"개 구매 할 돈이 없습니다.");
}
  drawInventory();
}
}
}

function toggleItem2(event) {
  const row = parseInt(event.target.parentElement.getAttribute("data-row"));
  const col = parseInt(event.target.parentElement.getAttribute("data-col"));

if (inventory[row][col]) {
         inventory[row][col] = null;
     } else {

 	const r = (row*inventorySize)+col;
	if(propertyCount2 > r){
	sessionStorage.removeItem("invenclon");
 	sessionStorage.setItem("invencltw", r);
 	const xhr = new XMLHttpRequest();
 	xhr.open("POST", "/333/shop", true);
 	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
 	xhr.onreadystatechange = function() {
 	if (xhr.readyState === 4 && xhr.status === 200) {
    		console.log(xhr.responseText);
			window.location.href = "/333/shop";
    	}
 	};
 	xhr.send("invencltw=" + r);
}
}
  drawInventory2();
}


// 인벤토리 초기화
drawInventory();
drawInventory2();