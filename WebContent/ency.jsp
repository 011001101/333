<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>이게뭐누</title>
</head>
<body>
    <div>
        <div id="leftPage"></div>
        <div id="rightPage"></div>
    </div>
    <button type="button" id="pre">왼쪽</button>
    <button type="button" id="next">오른쪽</button>
</body>
<script>
    let leftPage = document.querySelector("#leftPage");
    let rightPage = document.querySelector("#rightPage");
    let pre = document.querySelector("#pre");
    let right = document.querySelector("#next");

    var currentPage = 1;
    requestJson(currentPage);

    pre.addEventListener("click", changePageNum);
    right.addEventListener("click", changePageNum);

    function changePageNum(e) {
        if (e.target === pre) {
            currentPage--;
        } else {
            currentPage++;
        }

        if (currentPage < 1) {
            currentPage = 1;
        }

        requestJson(currentPage);
    }

    function requestJson(page) {
    fetch("http://localhost:8080/333/ency?page=" + page)
        .then((resp) => resp.json())
        .then((list) => {
            let leftObj = list[0];
            let rightObj = list[1];

            leftPage.innerHTML = ""
            leftPage.appendChild(createDocument(leftObj));
            rightPage.innerHTML = ""
            rightPage.appendChild(createDocument(rightObj));
        })
}

function createDocument(obj) {
    let box = document.createElement("div");
    let title = document.createElement("h1");
    let content = document.createElement("p");

    title.innerText = obj.title;
    content.innerText = obj.content;
    
    box.append(title);
    box.append(content);

    return box;
}
</script>
</html>