<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>토끼 마을♥</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    <link rel="stylesheet" href="style.css">
    <script src='main.js'></script>
   <!-- JavaScript Bundle with Popper -->


</head>
<body>
<a href="insert.jsp">로그아웃</a>
<div class="map">

    <div class="LAND">
    <div class="Garden" name="Garden" data-description="화원으로" type="button" onclick="gamego()">
        <div class="MAP-inner">
            <div class="title">화원</div>
            <div class="description">화원으로 이동</div>
        </div>
    </div>
    <div class="Library" name="Library" data-description="도서관으로" type="button" onclick="encygo()">
        <div class="MAP-inner">
            <div class="title">도서관으로</div>
            <div class="description">도서관으로 이동</div>
        </div>
    </div>
    <div class="Shop" name="Shop" data-description="상점으로" type="button" onclick="shopgo()">
        <div class="MAP-inner">
            <div class="title">상점으로</div>
            <div class="description">상점으로 이동</div>
        </div>
    </div>
    <div class="NPC" name="NPC" data-description="토끼 집으로🔥" type="button" onclick="alert('준비중')">
        <div class="MAP-inner">
            <div class="title">토끼의 집</div>
            <div class="description">토끼 집으로 이동</div>
        </div>
    </div>
</div>
</div>

<footer><audio autoplay controls>
    <source src="audio/The_Weeknd-I_Feel_It_Coming(cover_byJ.Fla).mp3" type="audio/mp3">
</audio>
</footer>
</body>
</html>