function login() {
  const id = document.getElementById('id').value;
  const password = document.getElementById('password').value;
  
// 가상의 사용자 데이터 (실제로는 DB에서 가져와야 함)
const users = [
  { id: 'user1', password: 'pass1' },
  { id: 'user2', password: 'pass2' },, 
  // DB랑 연결해야함 (모르겟음)
  // login() 함수는 입력된 사용자 이름과 비밀번호를확인
  // users 배열에 등록된 사용자와 일치하는지 확인하고 로그인 결과를 출력
];

  // 입력한 사용자 정보와 일치하는 사용자를 찾기
  const matchedUser = users.find(user => user.id === id && user.password === password);

  if (matchedUser) {
    document.getElementById('message').textContent = '로그인 성공';
  } else {
    document.getElementById('message').textContent = '로그인 실패. 유효한 사용자 이름과 비밀번호를 입력하세요.';
  }
}
