package plant;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbutil.DBUtil;

@WebServlet("/game")
public class Game extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("userid");
		System.out.println(id);
		Map<String, List<String>> map = nowplant(id);
		if (map.size() > 0) {
			session.setAttribute("gamein", map);
		}
		req.getRequestDispatcher("/game.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String but = (String) req.getParameter("buttonId");
		System.out.println(but);
		HttpSession session = req.getSession();
		String userid = (String) session.getAttribute("userid");
//		newplant(userid, 2, but);
		resp.sendRedirect("/333/game");
	}

	public Map<String, List<String>> nowplant(String id) {
		LocalDateTime date = LocalDateTime.now();
		Map<String, List<String>> map = new HashMap<>();
		List<String> ok = new ArrayList<>();
		List<String> no = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select seat, herbtime from playlog where logId = ? and harvesting = 0";

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String seat = rs.getString("seat");
				LocalDateTime time = (LocalDateTime) rs.getObject("herbtime");
				if (date.isAfter(time)) {
					ok.add(seat);
				} else {
					no.add(seat);
				}
			}
			map.put("ok", ok);
			map.put("no", no);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return map;
	}

	public int newplant(String id, int logNo, String seat) {
		LocalDateTime date = LocalDateTime.now();
		LocalDateTime plustime = date.plusSeconds(50);
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO playlog (localdate, logId, logNo, seat, herbtime) VALUES (?, ?, ?, ?, ?);";

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setObject(1, date);
			stmt.setString(2, id);
			stmt.setInt(3, logNo);
			stmt.setString(4, seat);
			stmt.setObject(5, plustime);
			return stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return -1;
	}

	public List<Blob> item(String id) {
		List<Blob> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT plantImage FROM inventory as a inner join plant as b on a.no = b.plantNo where logId = ? and plantGroup link %씨앗주머니%";

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Blob shopNo = rs.getBlob("plantImage");
				list.add(shopNo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return list;
	}
}