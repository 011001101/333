function join(e) {
  e.preventDefault(); // 기본 동작 막음

  const id = document.getElementById('id').value;
  const password = document.getElementById('password').value;
  const confirmPassword = document.getElementById('confirmPassword').value;

  console.log('ID:', id);
  console.log('Password:', password);
  console.log('Confirm Password:', confirmPassword);

  if (password === confirmPassword) {
    if (validateId(id) && validatePassword(password)) {
      // 회원가입 로직
      sendJoinRequest(id, password);
    } else {
      document.getElementById('message').textContent = '아이디와 비밀번호를 형식에 맞게 입력하세요.';
    }
  } else {
    document.getElementById('message').textContent = '비밀번호가 일치하지 않습니다. 다시 확인하세요.';
  }
}

function sendJoinRequest(id, password) {
  // AJAX 요청을 생성
  var xhr = new XMLHttpRequest();
  xhr.open("POST", "Joininfo", true); // Joininfo 서블릿과 연동되도록 설정
  xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

  // 요청 완료 후 처리
  xhr.onload = function() {
    if (xhr.status === 200) {
      // 서버로부터 받은 응답 처리
      var response = xhr.responseText;
      document.getElementById("message").textContent = response;
      showSuccessModal(); // 성공 모달 표시
    }
  };

  // 서버로 보낼 데이터를 생성
  var data = "id=" + encodeURIComponent(id) + "&password=" + encodeURIComponent(password);

  // 요청 전송
  xhr.send(data);
  e.preventDefault(); // 폼 제출 중지
}

function validateForm() {
  var idInput = document.getElementById("id");
  var passwordInput = document.getElementById("password");

  // ID와 비밀번호 유효성 검사를 수행하고 조건에 맞지 않으면 경고창을 띄움
  if (!validateId(idInput.value)) {
    alert("ID는 2~4글자 사이 영어, 숫자로만 이루어져야 합니다.");
    return false; // 폼 제출 중지
  }

  if (!validatePassword(passwordInput.value)) {
    alert("PW는 영어, 숫자, 특수문자가 최소 1개 포함되어야 합니다.");
    return false; // 폼 제출 중지
  }

  // 조건에 맞을 경우 폼 제출을 진행
  return true;
}

function validateId(id) {
  var pattern = /^[A-Za-z0-9]{2,4}$/;
  return pattern.test(id);
}

function validatePassword(password) {
  var pattern = /^[a-zA-Z0-9!@#$%^&*]{8,12}$/;
  return pattern.test(password);
}

// HTML에서 호출 시 join 함수에 이벤트 객체를 전달하는 예시:
const joinButton = document.getElementById('joinButton');
joinButton.addEventListener('click', function(e) {
  join(e);
});