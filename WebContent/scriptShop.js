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
            
            cell.setAttribute("data-row", row);
            cell.setAttribute("data-col", col);
        
				var imgIndex = (row * inventorySize) + col;
				if(propertyCount1 > imgIndex){
               		const img = document.createElement("img");
                	img.src = "data:image/png;base64," + imglistShop[imgIndex];
                	cell.appendChild(img);
				}
                cell.textContent = inventory[row][col];

            cell.addEventListener("click", toggleItem);
            inventoryContainer.appendChild(cell);
        }
    }
}



// 인벤토리 그리기2
var imglistInvJson = sessionStorage.getItem("imglistInv");
var imglistInv = JSON.parse(imglistInvJson);
var propertyCount2 = 0;
if(imglistInv != null){
	propertyCount2 = Object.keys(imglistInv).length;
}

function drawInventory2() {
  const inventoryContainer = document.getElementById("SellInventory");
  inventoryContainer.innerHTML = "";

  for (let row = 0; row < inventorySize; row++) {
      for (let col = 0; col < inventorySize; col++) {
          const cell = document.createElement("div");
        
          cell.classList.add("cell");
          
          cell.setAttribute("data-row", row);
          cell.setAttribute("data-col", col);
      
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
  const row = parseInt(event.target.getAttribute("data-row"));
  const col = parseInt(event.target.getAttribute("data-col"));

  if (inventory[row][col]) {
      inventory[row][col] = null;
  } else {
      // 여기에서 아이템 정보를 입력하면 됩니다.
      // 여기서는 단순히 "아이템"이라는 문자열을 추가합니다.
      inventory[row][col] = "아이템"+[row]+[col];
  }

  drawInventory();
}


function toggleItem2(event) {
  const row = parseInt(event.target.getAttribute("data-row"));
  const col = parseInt(event.target.getAttribute("data-col"));

  if (inventory[row][col]) {
      inventory[row][col] = null;
  } else {
      // 여기에서 아이템 정보를 입력하면 됩니다.
      // 여기서는 단순히 "아이템"이라는 문자열을 추가합니다.
      inventory[row][col] = "아이템"+[row]+[col];
  }

  drawInventory2();
}


// 인벤토리 초기화
drawInventory();
drawInventory2();