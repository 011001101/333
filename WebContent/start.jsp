<!DOCTYPE html>
<html lang="ko">
<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="start.css" />
    <style>
        /* CSS 스타일로 캔버스를 화면 중앙에 배치하고 투명화 */
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-image: linear-gradient(to bottom right, #2c4c28, #294a24); /* 그라데이션 배경 추가 */
        }

        /* 캔버스 스타일 */
        .canvas {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            /* background-image: url('garden.svg'); SVG 배경 이미지 추가 */
            background-size: cover; /* 이미지 크기 조절 */
            background-repeat: no-repeat; /* 이미지 반복 제거 */
            /* background-color: transparent; */ /* 캔버스 투명화 */
            z-index: -1; /* SVG를 캔버스 아래로 배치 */
        }

        /* 버튼 스타일 */
        button {
            /* 원하는 버튼 스타일을 설정합니다. */
            padding: 20px 40px; /* 크기 조정 */
            font-size: 50px; /* 크기 조정 */
            border: 2px solid transparent;
            background-color: transparent;
            border-radius: 5px;
            transition: all 0.3s ease; /* 확대/축소 효과를 부드럽게 만듭니다. */

            /* 캔버스 내에서 버튼을 가운데로 정렬합니다. */
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);

            /* 원하는 폰트를 지정합니다. */
            font-family: 'Pacifico', cursive; /* Google Fonts에서 가져온 Pacifico 폰트를 사용합니다. */

            /* 원하는 폰트 컬러를 지정합니다. */
            color: white; /* 빨간색 폰트 */
        }

        /* 버튼 마우스 오버 시 확대 */
        button:hover {
            transform: translate(-50%, -50%) scale(1.2); /* 버튼 크기를 1.2배 확대합니다. */
        }

    </style>
</head>
<body>
    <!-- 캔버스 -->
    <div class="canvas"></div> <!-- SVG 배경 이미지를 가진 빈 요소 -->

    <!-- 버튼 추가 -->
    <button onclick="myFunction()">START</button>

    <script>
            function myFunction() {
            // 여기에 이동할 URL을 지정합니다.
            var url = "/WEB-INF/insert.jsp";
            window.location.href = url;
        }
    </script>

    <script src="start.js"></script>
</body>
</html>
