package plant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Loginfo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = (String) req.getParameter("id");
		String password = (String) req.getParameter("password");
		Login a = new Login();
		if (a.loginst(id, password)) {
			System.out.println("로그인제출 진입");
			HttpSession session = req.getSession();
			session.setAttribute("no", "no");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		} else {
			// 메인으로 이동
			resp.sendRedirect("main");
		}
	}
}
