

// 1단계, 2단계일때는 마우스 상호작용 불가능하게 만들고, 3단계(다 컸음)일때만 상호작용 되도록

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
    //인벤토리 불러오기

    //씨앗 선택하기

    //씨앗 정보 json으로 뭉쳐서 db로 보내주기


    //이미지 바꾸기

    $('.plant').replaceWith('<img src="불룩한 흙" />');
}






function harvest(o){
    $(o).animate( { top:'-=200', opacity:0 }, 200, function(){
        $(this).remove(); // 애니메이션이 끝나면 제거
    });
}