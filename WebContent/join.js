function join() {
  const id = document.getElementById('id').value;
  const password = document.getElementById('password').value;
  const confirmPassword = document.getElementById('confirmPassword').value;

  // 간단한 회원가입 처리 로직을 여기에 추가
  // 예를 들면, 비밀번호와 비밀번호 확인이 일치하는지 검사하는 로직
  if (password === confirmPassword) {
    document.getElementById('message').textContent = '회원가입 성공!';
  } else {
    document.getElementById('message').textContent = '비밀번호가 일치하지 않습니다. 다시 확인하세요.';
  }
}

// 검사로직 ㅁㄹ겟음