function login(e) {
    e.preventDefault();

    const id = document.getElementById('id').value;
    const password = document.getElementById('password').value;

    console.log("전송 데이터:", id, password); // 전송되는 데이터 확인

    const xhr = new XMLHttpRequest();
    xhr.open('POST', 'Loginfo', true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                console.log("서버 응답:", xhr.responseText); // 서버 응답 확인

                if (xhr.responseText === 'success') {
                    window.location.href = 'main.jsp';
                } else if (xhr.responseText === 'fail') {
                    document.getElementById('message').textContent = '로그인 실패';
                } else {
                    document.getElementById('message').textContent = '올바른 ID/PW가 아닙니다.';
                }
            }
        }
    };

    // Send data as JSON
    const data = {
        userId: id,
        userPassword: password
    };
    xhr.send(JSON.stringify(data));
}
