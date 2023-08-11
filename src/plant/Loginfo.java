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

@WebServlet("/Loginfo")
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
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
            System.out.println("DB 연결 성공"); // DB 연결 성공 시 콘솔에 출력

            String sql = "SELECT * FROM user WHERE userId = ? AND userPassword = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, userPassword);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // 로그인 성공
                session.setAttribute("userId", userId);
                resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
                resp.setHeader("Pragma", "no-cache");
                resp.setHeader("Expires", "0");
                resp.getWriter().println("success");
            } else {
                // 로그인 실패
                resp.getWriter().println("fail");
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            resp.getWriter().println("error");
        }
    }
}
