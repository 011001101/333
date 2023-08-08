package src.shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbutil.DBUtil;
import shop.itemInfo;

public class shopData {

	public List<itemInfo> getItem(int num) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<itemInfo> itemList = new ArrayList<>();

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM shop WHERE no = ?");
			stmt.setInt(1, num);

			rs = stmt.executeQuery();

			if (rs.next()) {
				int itemNum = rs.getInt("no");
				String itemName = rs.getString("itemName");
				int itemPoint = rs.getInt("itemPoint");
				String itemEffect = rs.getString("itemEffect");
				
				itemList.add(new itemInfo(itemNum, itemName, itemPoint, itemEffect));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return itemList;

	}

	
}
