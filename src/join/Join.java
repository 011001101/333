package join;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dbutil.DBUtil;

public class Join {
	public String joinst(String id, String password) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "insert into join (id, password) values (?,?);";

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, id);
			stmt.setString(2, password);

			int rowsAffected = stmt.executeUpdate();

			if (rowsAffected > 0) {
				// 회원 가입이 성공적으로 이루어졌으므로, 반환할 메시지를 설정합니다.
				return "회원가입에 성공했습니다.";
			} else {
				// 회원 가입이 실패한 경우, 반환할 메시지를 설정합니다.
				return "회원가입에 실패했습니다.";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return "회원가입에 실패했습니다.";
	}

	public static boolean validateId(String id) {
		// 영소문자, 대문자, 숫자로만 구성되어야 함
		Pattern pattern = Pattern.compile("[A-Za-z0-9]{2,4}");
		Matcher matcher = pattern.matcher(id);
		return matcher.matches();
	}

	// 비밀번호 패턴 검증 메소드
	private static boolean validatePassword(String password) {
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
