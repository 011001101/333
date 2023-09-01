package shop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import DButil.dbutil;
import plant.insert;

import java.util.Base64.Encoder;
import java.util.HashMap;

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
		HttpSession session = req.getSession();
		String invenclon = req.getParameter("invenclon");
		String invencltw = req.getParameter("invencltw");
		String id = (String) session.getAttribute("userId");
		int point = (int) session.getAttribute("point");
		if (invenclon != null) {
			System.out.println("작동됨?");
			String byitem = req.getParameter("invenclon");
			System.out.println(byitem);
			String lispoint = req.getParameter("pointnum");
			System.out.println(lispoint);
			String num1 = req.getParameter("num1");
			System.out.println(num1);
			int min = Integer.valueOf(byitem);
			int num = Integer.valueOf(num1);
			System.out.println(lispoint);
			session.setAttribute("point", point - min);
			updatepoint(id, point - min);// 포인트 감소
			String plunt = "씨앗주머니G";

			if (lispoint.equals("100")) {
				plunt = "씨앗주머니L";
			} else if (lispoint.equals("60")) {
				plunt = "씨앗주머니D";
			} else if (lispoint.equals("20")) {
				plunt = "씨앗주머니A";
			} else if (lispoint.equals("30")) {
				plunt = "씨앗주머니B";
			} else if (lispoint.equals("80")) {
				plunt = "씨앗주머니H";
			} else if (lispoint.equals("40")) {
				plunt = "씨앗주머니C";
			} else if (lispoint.equals("65")) {
				plunt = "씨앗주머니E";
			} else if (lispoint.equals("85")) {
				plunt = "씨앗주머니F";
			}
			System.out.println(plunt);
			List<Integer> itemlist = itemlist(plunt);
			System.out.println(itemlist.toString());
			int size = itemlist.size();
			System.out.println(size);
			for (int i = 0; i < num; i++) {
				int a = (int) (Math.random() * size);
				System.out.println(a);
				updateInven(id, itemlist.get(a));// 아이템 추가
			}
		} else {
			List<Integer> list = pointpluse(id);// 포인트 받아오고
			int inven = Integer.valueOf(invencltw);
			int a = list.get(inven);
			int s = updatepoint(id, point + a);// 포인트 증가
			System.out.println(s);
			int pointse = (int) session.getAttribute("point");
			session.setAttribute("point", pointse + a);
			int u = deletinv(no(id, a));// 아이템 삭제
			System.out.println(u);
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
		String sql = "SELECT itemImage FROM inventory AS a INNER JOIN shop AS b ON a.shopNo = b.no WHERE a.userId = ? ;";
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

	public int updatepoint(String id, int point) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "UPDATE user SET point = ? WHERE userId = ?;";
		try {
			conn = dbutil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, point);
			stmt.setString(2, id);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbutil.close(stmt);
			dbutil.close(conn);
		}
		return -1;
	}

	public List<Integer> itemlist(String name) {
		List<Integer> no = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM shop where itemGroup = ? AND itemName NOT LIKE '%.%';";
		try {
			conn = dbutil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int a = rs.getInt("no");
				no.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbutil.close(rs);
			dbutil.close(stmt);
			dbutil.close(conn);
		}
		return no;
	}

	public int updateInven(String id, int set) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO inventory (userId, shopNo) VALUES (?, ?);";
		try {
			conn = dbutil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setInt(2, set);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbutil.close(stmt);
			dbutil.close(conn);
		}
		return -1;
	}

	public List<Integer> pointpluse(String name) {
		List<Integer> map = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM inventory AS a INNER JOIN shop AS b ON a.shopNo = b.no WHERE a.userId = ?;";
		try {
			conn = dbutil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int point = rs.getInt("itemPoint");
				map.add(point);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbutil.close(rs);
			dbutil.close(stmt);
			dbutil.close(conn);
		}
		return map;
	}

	public int no(String name, int point) {
		int map = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM inventory AS a INNER JOIN shop AS b ON a.shopNo = b.no WHERE a.userId = ? and itemPoint = ?;";
		try {
			conn = dbutil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setInt(2, point);
			rs = stmt.executeQuery();
			while (rs.next()) {
				map = rs.getInt("a.no");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbutil.close(rs);
			dbutil.close(stmt);
			dbutil.close(conn);
		}
		return map;
	}

	public int deletinv(int no) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "DELETE FROM inventory WHERE (no = ?);";
		try {
			conn = dbutil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, no);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbutil.close(stmt);
			dbutil.close(conn);
		}
		return -1;
	}

}
