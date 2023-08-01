package join;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter writer = resp.getWriter();
		writer.println(id + "님 회원가입되셨습니다.");
		writer.println("환영합니다.");
		writer.close();
		doGet(req, resp);
	}
}
