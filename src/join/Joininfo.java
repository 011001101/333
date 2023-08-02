package join;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/join")
public class Joininfo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/join.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = (String) req.getParameter("id");
		String password = (String) req.getParameter("pw");
		HttpSession session = req.getSession();
		Join join = new Join();
		if (Join.validateId(id) && Join.validatePassword(password)) {
			if (join.joinst(id, password)) {
				resp.setContentType("text/html; charset=utf-8");
				PrintWriter writer = resp.getWriter();
				writer.println(id + "님 회원가입되셨습니다.");
				writer.println("환영합니다.");
				writer.close();
				doGet(req, resp);
			} else {
				session.setAttribute("fal", "이미 있는 아이디 입니다.");
				System.out.println("실패2");
				req.getRequestDispatcher("/join.jsp").forward(req, resp);
			}
		} else {
			session.setAttribute("fal", "아이디와 비밀번호를 형식에 맞게 적으세요");
			System.out.println("실패1");
			req.getRequestDispatcher("/join.jsp").forward(req, resp);
		}
	}
}
