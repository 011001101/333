package encyData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class encyRepository {
	private List<ency> list;
	
	public encyRepository() {
		list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			String url = "jdbc:mysql://192.168.0.81:3306/team3";
			String id = "Team3";
			String pw = "team3";

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);


			stmt = conn.prepareStatement("SELECT * FROM plant;");
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				ency Ency = new ency();
				Ency.setPlantNo(rs.getString("plantNo"));
				Ency.setPlantOrigin(rs.getString("plantOrigin"));
				Ency.setPlantFamily(rs.getString("plantFamily"));
				Ency.setPlantGroup(rs.getString("plantGroup"));
				Ency.setPlantLuminous(rs.getString("plantLuminous"));
				Ency.setPlantWatering(rs.getString("plantWatering"));
				Ency.setPlantPoint(rs.getString("plantPoint"));
				
				list.add(Ency);
			
			}
		
	}catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	} finally {
		// 리소스 해제
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
	public ency getById(int id) {
		return list.get(id);
	}
	public static void main(String[] args) {
		encyRepository ee = new encyRepository();
		System.out.println(ee.list.get(1));
	}

}
