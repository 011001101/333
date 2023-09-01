package join;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DButil.dbutil;

@WebServlet("/Joininfo") 
public class Joininfo extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("서블릿 진입하니?");
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		Join join = new Join();
		System.out.println(id);
		System.out.println(password);
		if (Join.validateId(id) && Join.validatePassword(password)) {
			if (join.duplication(id)) {
				join.joinst(id, password);
				session.setAttribute("true", "true");
				resp.sendRedirect("/333/insert.jsp");
			} else {
				session.setAttribute("fal", "이미 있는 아이디 입니다.");
				req.getRequestDispatcher("/join.jsp").forward(req, resp);
			}
		} else {
			session.setAttribute("fal2", "아이디와 비밀번호를 형식에 맞게 적으세요");
			req.getRequestDispatcher("/join.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/join.jsp").forward(req, resp);
	}
	
	public boolean test(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM team3.user where userid = ?;";
		try {
			conn = dbutil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbutil.close(rs);
			dbutil.close(stmt);
			dbutil.close(conn);
		}
		return true;
	}
	
	
	
}
