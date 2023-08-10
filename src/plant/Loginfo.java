package plant;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Loginfo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userId = req.getParameter("userId");
		String userPassword = req.getParameter("userPassword");
		HttpSession session = req.getSession();

		String jdbcUrl = "jdbc:mysql://localhost:3306/333";
		String dbUser = "Team3";
		String dbPassword = "team3";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

			String sql = "SELECT * FROM users WHERE userId = ? AND userPassword = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, userPassword);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				resp.getWriter().println("성공");
			} else {
				resp.getWriter().println("실패");
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			((Throwable) e).printStackTrace();
		}
	}


//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String id = (String) req.getParameter("id");
//		String password = (String) req.getParameter("password");
//		HttpSession session = req.getSession();
//		Login a = new Login();
//		if (a.loginst(id, password)) {
//			System.out.println("로그인제출 진입");
//			session.setAttribute("no", "no");
//			req.getRequestDispatcher("/login.jsp").forward(req, resp);
//		} else {
//			// 메인으로 이동
//			session.setAttribute("userid", id);
//			resp.sendRedirect("main");
//		}
//	}
}
