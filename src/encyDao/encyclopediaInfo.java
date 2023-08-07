package encyDao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbutil.DBUtil;


public class encyclopediaInfo extends HttpServlet {

	private encyGetSet ency = new encyGetSet();
	private int value;
	private final static int A = 2;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/encyclopedia.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String valueStr = req.getParameter("value");
//		System.out.println(valueStr);
//		value = Integer.parseInt(valueStr);
//		System.out.println("형변환" + value);
//		
//		
//        
//		List<String> result = encyclopedia(value);
//		req.setAttribute("encyList", result);
//		req.getRequestDispatcher("encyclopedia.jsp").forward(req, resp);
	}

	public List<String> encyclopedia(int pageNo) {
		if(pageNo < 0) {
			pageNo = 0;
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<String> result = new ArrayList<>();
		
		try {
			String url = "jdbc:mysql://192.168.0.81:3306/team3";
			String id = "Team3";
			String pw = "team3";

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);


			stmt = conn.prepareStatement("SELECT * FROM plant LIMIT ?, ?");
			stmt.setInt(1, pageNo);
			stmt.setInt(2, A);
			rs = stmt.executeQuery();

			while (rs.next()) {
				String plantNO = rs.getString("plantNO");
				String plantName = rs.getString("plantName");
				String plantOrigin = rs.getString("plantOrigin");
				String plantFamily = rs.getString("plantFamily");
				String plantGroup = rs.getString("plantGroup");
				String plantLuminous = rs.getString("plantLuminous");
				String plantWatering = rs.getString("plantWatering");
				String plantPoint = rs.getString("plantPoint");

				encyGetSet plant = new encyGetSet(plantNO, plantName, plantOrigin, plantFamily, plantGroup,
						plantLuminous, plantWatering, plantPoint);

				result.addAll(plant.getAll());

			}
			return result;

		} catch (SQLException e) {
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

	private byte[] getImage(int plantNo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		byte[] imgArr = null;
		try {
			String url = "jdbc:mysql://192.168.0.81:3306/team3";
			String id = "Team3";
			String pw = "team3";

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);

			stmt = conn.prepareStatement("SELECT plantImage FROM plant WHERE plantNo = ?");
			stmt.setInt(1, plantNo);
			rs = stmt.executeQuery();

			if (rs.next()) {
				Blob imgBlob = rs.getBlob("plantImage");
				if (imgBlob != null) {
					int imgLength = (int) imgBlob.length();
					imgArr = imgBlob.getBytes(1, imgLength);
					return imgArr;

				}
			}

		} catch (SQLException e) {
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
		return null;
	}

}
