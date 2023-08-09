import mysql from 'mysql';

// createConnection : 접속하고 싶은 DB정보 입력
var connection = mysql.createConnection({
    host: 'localhost',
    user: 'Team3',
    password: 'team3',
    database:'team3'
});
// DB 연결
connection.connect();


// DB 연결
connection.connect();
// 쿼리문 사용하기
connection.query('SQL');
// DB 종료
connection.end();