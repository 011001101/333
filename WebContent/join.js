


function join() {
  const id = document.getElementById('id').value;
  const password = document.getElementById('password').value;
  const confirmPassword = document.getElementById('confirmPassword').value;

  // 간단한 회원가입 처리 로직을 여기에 추가
  // 비밀번호와 비밀번호 확인이 일치하는지 검사하는 로직
  if (password === confirmPassword) {
    document.getElementById('message').textContent = '회원가입 성공!';
  } else {
    document.getElementById('message').textContent = '비밀번호가 일치하지 않습니다. 다시 확인하세요.';
  }
}

function validateForm() {
  var idInput = document.getElementById("id");
  var passwordInput = document.getElementById("password");

  // ID와 비밀번호 유효성 검사를 수행하고 조건에 맞지 않으면 경고창을 띄움
  if (!validateId(idInput.value)) {
    alert("ID는 8~10글자 사이 영어, 숫자로만 이루어져야 합니다.");
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
  var pattern = /^[a-zA-Z0-9!@#$%^&*]{8,20}$/;
  return pattern.test(password);
}