function login(e) {
    e.preventDefault(); // 기본 동작 막음
  
    const id = document.getElementById('id').value;
    const password = document.getElementById('password').value;

    // Ajax 요청으로 서블릿 호출
    const xhr = new XMLHttpRequest();
    xhr.open('POST', 'Loginfo', true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                if (xhr.responseText === 'success') {
                    window.location.href = 'main.jsp'; // 로그인 성공 시 main.jsp로 이동
                } else if (xhr.responseText === 'fail') {
                    document.getElementById('message').textContent = '로그인 실패';
                } else {
                    document.getElementById('message').textContent = '올바른 ID/PW가 아닙니다.';
                }
            }
        }
    };
    xhr.send(`userId=${id}&userPassword=${password}`);
}
