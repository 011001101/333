package join;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.annotation.WebServlet;

import dbutil.DBUtil;

@WebServlet("/join")
public class Join {
	public boolean joinst(String id, String password) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO `team3`.`user` (`userId`, `userPassword`) VALUES (?, ?);";

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, id);
			stmt.setString(2, password);

			int rowsAffected = stmt.executeUpdate();

			if (rowsAffected > 0) {
				// 회원 가입이 성공적으로 이루어졌으므로, 반환할 메시지를 설정합니다.
				return true;
			} else {
				// 회원 가입이 실패한 경우, 반환할 메시지를 설정합니다.a
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return false;
	}

	public static boolean validateId(String id) {
		// 영소문자, 대문자, 숫자로만 구성되어야 함
		Pattern pattern = Pattern.compile("[A-Za-z0-9]{2,4}");
		Matcher matcher = pattern.matcher(id);
		return matcher.matches();
	}

	// 비밀번호 패턴 검증 메소드
	public static boolean validatePassword(String password) {
		// 영소문자, 대문자, 숫자, 특수문자가 최소 1개 이상 포함되어야 함
		Pattern pattern = Pattern.compile("[a-zA-Z0-9!@#$%^&*]{8,20}");
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}

	public boolean duplication(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			// 데이터베이스 연결
			conn = DBUtil.getConnection();

			// SQL 쿼리 작성
			String sql = "select * from student where id = ? ";

			// SQL 쿼리 실행
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);

			rs = stmt.executeQuery();

			// 결과 확인
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return false;
	}
}
