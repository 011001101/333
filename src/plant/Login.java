package plant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;

import DButil.dbutil;


public class Login {
	public boolean loginst(String id, String password) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM user WHERE userId = ? AND userPassword = ?";

		try {
			conn = dbutil.getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, id);
			stmt.setString(2, password);

			rs = stmt.executeQuery();
			while (rs.next()) {
				String memberId = rs.getString("userId");
				String memberPw = rs.getString("userPassword");
				if(id.equals(memberId) && password.equals(memberPw)) {
					return true;
				} 
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbutil.close(rs);
			dbutil.close(stmt);
			dbutil.close(conn);
		}
		return false;
	}
}
