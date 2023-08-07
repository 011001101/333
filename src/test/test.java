package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbutil.DBUtil;

public class test {
	public static void main(String[] args) {
		byte[] a = item("aa");

		System.out.println(a.toString());
	}

	public static byte[] item(String id) {
		byte[] by = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT plantImage\r\n" + "FROM inventory AS a\r\n"
				+ "INNER JOIN plant AS b ON a.no = b.plantNo\r\n" + "WHERE a.userId = ? AND plantGroup LIKE '%씨앗주머니%';";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				by = rs.getBytes("plantImage");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return by;
	}
}
