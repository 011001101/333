package shop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import DButil.dbutil;

import java.util.Base64.Encoder;

@WebServlet("/shop")
public class shopInven extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Gson gson = new Gson();
		Encoder encode = Base64.getEncoder();
		List<byte[]> imglist = item(); // 이미지 byte 타입으로 가져오기
		List<String> imgEncode = new ArrayList<>();
		for (int j = 0; j < imglist.size(); j++) {
			String encodeStr = encode.encodeToString(imglist.get(j));
			imgEncode.add(encodeStr);
		}
		String imglistShop = gson.toJson(imgEncode);
		session.setAttribute("imglistShop", imglistShop);

		List<byte[]> invenimglist = invenitem((String) session.getAttribute("userId"));
		List<String> imgInven = new ArrayList<>();
		for (int j = 0; j < invenimglist.size(); j++) {
			String encodeStr = encode.encodeToString(invenimglist.get(j));
			imgInven.add(encodeStr);
		}
		String imglistInv = gson.toJson(imgInven);
		session.setAttribute("imglistInv", imglistInv);

		req.getRequestDispatcher("/ShopMain.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String invenclon = req.getParameter("invenclon");
		String invencltw = req.getParameter("invencltw");
		if (invenclon != null) {

		} else {

		}
	}

	public List<byte[]> item() {
		byte[] by = null;
		List<byte[]> img = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM shop where itemName NOT LIKE '%.%' group by itemGroup;";
		try {
			conn = dbutil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				by = rs.getBytes("itemImage");
				img.add(by);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbutil.close(rs);
			dbutil.close(stmt);
			dbutil.close(conn);
		}
		return img;
	}

	public List<byte[]> invenitem(String id) {
		byte[] by = null;
		List<byte[]> img = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT itemImage FROM inventory AS a INNER JOIN shop AS b ON a.shopNo = b.no WHERE a.userId = ? group by b.no;";
		try {
			conn = dbutil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				by = rs.getBytes("itemImage");
				img.add(by);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbutil.close(rs);
			dbutil.close(stmt);
			dbutil.close(conn);
		}
		return img;
	}

}
