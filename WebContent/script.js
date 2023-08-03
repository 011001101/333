
// 인벤 그리기 

const inventorySize = 9;
let inventory = Array.from({ length: inventorySize }, () => Array(inventorySize).fill(null));



// 아이템 추가 또는 제거 

// 인벤토리 그리기
	function drawInventory() {
	    const inventoryContainer = document.getElementById("inventory");
	    inventoryContainer.innerHTML = "";

	    for (let row = 0; row < inventorySize; row++) {
	        for (let col = 0; col < inventorySize; col++) {
	            const cell = document.createElement("div");
	            cell.classList.add("cell");
	            cell.setAttribute("data-row", row);
	            cell.setAttribute("data-col", col);

	            if (inventory[row][col]) {
					
	                cell.textContent = inventory[row][col];
	            }

	            cell.addEventListener("click", toggleItem);
	            inventoryContainer.appendChild(cell);
	        }
	    }
	}

// 인벤토리 초기화
drawInventory();

//클릭시 각각의 셀로 상호작용 (안에 메소드 고쳐주시면 됩니다롱) 
	function toggleItem(event) {
	    const row = parseInt(event.target.getAttribute("data-row"));
	    const col = parseInt(event.target.getAttribute("data-col"));
		
		const buttonId = sessionStorage.getItem("buttonId");
		sessionStorage.setItem("buttonId", buttonId);
		
	    if (inventory[row][col]) {
	        inventory[row][col] = null;
	    } else {
	        // 여기에서 아이템 정보를 입력하면 됩니다.
	        // 여기서는 단순히 "아이템"이라는 문자열을 추가합니다.
	        inventory[row][col] = "아이템";
			if(buttonId != null){
			const xhr = new XMLHttpRequest();
	   		xhr.open("POST", "/333/game", true);
	   		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

	    	xhr.onreadystatechange = function() {
	      	if (xhr.readyState === 4 && xhr.status === 200) {
	        	console.log(xhr.responseText);
	      		}
	    	};
	   		xhr.send("buttonId=" + encodeURIComponent(buttonId));
			}
	    }
	    drawInventory();
	}
//인벤 다 그렸고 다 불러왔다



//여기는 메뉴판 스무스하게 움직이게 하는거라 손 안대셔도 됩니당
$(function() {

    var w = $(window).width(),
      h = $(window).height();
    //$('section').width(w);
    $('section').height(h);
    $('menu .container').height(h - 60);
    $('body').prepend('<div id="overlay">');
  
    $('#menu').click(function() {$('html').addClass('active');});
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