package plant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbutil.DBUtil;

public class Login {
	public String loginst(String id, String password) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from student where id = ? and password = ?";

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, id);
			stmt.setString(2, password);

			rs = stmt.executeQuery();
			while (rs.next()) {
				String a = "yes";
				return a;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return null;
	}
}
