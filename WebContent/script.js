var imglistJson = sessionStorage.getItem("imglistJ");
var imglist = JSON.parse(imglistJson);
var propertyCount = Object.keys(imglist).length;
 // 인벤 그리기 
 const inventorySize = 9;
 let inventory = Array.from({ length: inventorySize }, () => Array(inventorySize).fill(null));

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

            var imgIndex = (row * inventorySize) + col;
			if(propertyCount > imgIndex){
                const img = document.createElement("img");
                img.src = "data:image/png;base64," + imglist[imgIndex];
                cell.appendChild(img);
			}

            cell.addEventListener("click", toggleItem);
            inventoryContainer.appendChild(cell);
         }
     }
 }

 // 아이템 추가 또는 제거 

 //클릭시 각각의 셀로 상호작용 (안에 메소드 고쳐주시면 됩니다롱) 
 function toggleItem(event) {
     const row = parseInt(event.target.getAttribute("data-row"));
    const col = parseInt(event.target.getAttribute("data-col"));

    console.log("row:", row);
    console.log("col:", col);
 	const buttonId = sessionStorage.getItem("buttonId");
 	sessionStorage.setItem("buttonId", buttonId);
console.log(buttonId);
     
         // 여기에서 아이템 정보를 입력하면 됩니다.
         // 여기서는 단순히 "아이템"이라는 문자열을 추가합니다.
 			if(buttonId != null){
 		   		const r = (row*9)+col;
 		   		sessionStorage.setItem("invencl", r);
 				const xhr = new XMLHttpRequest();
 		   		xhr.open("POST", "/333/game", true);
 		   		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
 		   		xhr.onreadystatechange = function() {
 		      	if (xhr.readyState === 4 && xhr.status === 200) {
 		        	console.log(xhr.responseText);
 		        	window.location.href = "/333/game";
 		      		}
 		    	};
 		   		xhr.send("buttonId=" + encodeURIComponent(buttonId)+"&invencl=" + r);
 				}
     
     drawInventory();
 }

 // 인벤토리 초기화
 drawInventory();


 //인벤 다 그렸고 다 불러왔다

 //아이템과 상호작용 하는 함수


   // 처음 드래그 요소가 위치하고 있는 인벤 영역
   const Itemcell = document.querySelector(".cell");
   
   Itemcell.addEventListener("dragover", (e) => {
     e.preventDefault();
     //console.log(e);
     //console("드래그 요소가 '첫' 번째 박스 영역에 계속 위치하면 발생하는 이벤트");
   });
   Itemcell.addEventListener("drop", (e) => {
     e.preventDefault();
     //console.log(e);
     console.log("드래그 요소가 '첫' 번째 박스 영역에 드롭");
   });
   
   
   // 드래그 요소가 이동하여 위치할 우측 박스 영역
   const plantpot = document.querySelector(".plantpot");
   
   plantpot.addEventListener("dragover", (e) => {
     e.preventDefault();
     //console.log(e);
     //console("드래그 요소가 '두' 번째 박스 영역에 계속 위치하면 발생하는 이벤트");
   });
   plantpot.addEventListener("drop", (e) => {
     e.preventDefault();
     //console.log(e);
     console.log("드래그 요소가 '두' 번째 박스 영역에 드롭");
   });
     
     
   
     
   



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