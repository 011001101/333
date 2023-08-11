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

@WebServlet("/Joininfo") 
public class Joininfo extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		Join join = new Join();

		if (join.validateId(id) && join.validatePassword(password)) {
			if (!join.duplication(id)) { // 중복되지 않는 아이디일 경우
				if (join.joinst(id, password)) { // 회원 가입 성공 시
					resp.setContentType("text/html; charset=utf-8");
					PrintWriter writer = resp.getWriter();
					writer.println(id + "님 회원가입되셨습니다.");
					writer.println("환영합니다.");
					writer.close();
					doGet(req, resp);
				} else { // 회원 가입 실패 시
					session.setAttribute("fal", "회원 가입에 실패하였습니다.");
					req.getRequestDispatcher("/join.jsp").forward(req, resp);
				}
			} else { // 중복된 아이디인 경우
				session.setAttribute("fal", "이미 사용 중인 아이디입니다.");
				req.getRequestDispatcher("/join.jsp").forward(req, resp);
			}
		} else {
			session.setAttribute("fal", "아이디와 비밀번호를 형식에 맞게 입력하세요.");
			req.getRequestDispatcher("/join.jsp").forward(req, resp);
		}
	}
	
	// 실제 중복 확인 로직을 구현하는 메서드
    private boolean checkIfUserExists(String id, String password) {
        // 여기에 데이터베이스 조회 등의 로직을 작성해야 합니다.
        // 예를 들어, 이미 등록된 아이디인 경우 true를 반환하고,
        // 그렇지 않은 경우 false를 반환하는 식으로 구현합니다.
        // 실제로는 데이터베이스와 연동하여 확인하는 과정이 필요합니다.
        return true; // 가정으로 이미 있는 것으로 처리
    }

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.getRequestDispatcher("/join.jsp").forward(req, resp);
//
//	}

//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String id = (String) req.getParameter("id");
//		String password = (String) req.getParameter("pw");
//		HttpSession session = req.getSession();
//		Join join = new Join();
//		if (Join.validateId(id) && Join.validatePassword(password)) {
//			if (join.joinst(id, password)) {
//				resp.setContentType("text/html; charset=utf-8");
//				PrintWriter writer = resp.getWriter();
//				writer.println(id + "님 회원가입되셨습니다.");
//				writer.println("환영합니다.");
//				writer.close();
//				doGet(req, resp);
//			} else {
//				session.setAttribute("fal", "이미 있는 아이디 입니다.");
//				System.out.println("실패2");
//				req.getRequestDispatcher("/join.jsp").forward(req, resp);
//			}
//		} else {
//			session.setAttribute("fal", "아이디와 비밀번호를 형식에 맞게 적으세요");
//			System.out.println("실패1");
//			req.getRequestDispatcher("/join.jsp").forward(req, resp);
//		}
//	}
}
