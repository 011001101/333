function login() {
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
          document.getElementById('message').textContent = '로그인 성공';
        } else {
          document.getElementById('message').textContent = '로그인 실패. 유효한 사용자 이름과 비밀번호를 입력하세요.';
        }
      }
    }
  };
  xhr.send(`id=${id}&password=${password}`);
}
