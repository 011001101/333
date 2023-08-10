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
          document.getElementById('message').textContent = 'success';
        } else {
          document.getElementById('message').textContent = 'fail';
        }
      }
    }
  };
  xhr.send(`id=${id}&password=${password}`);
}
