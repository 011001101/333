package encyData;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet("/ency")
public class encyServlet extends HttpServlet {
	private encyService service;
	private String json;
	
	@Override
	public void init() throws ServletException{
		service = new encyService(new encyRepository());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageStr = req.getParameter("page");
		System.out.println("서블릿의 파라미터 값 : " + pageStr);
		String rightBtn = req.getParameter("changePageNum");
		System.out.println("오른쪽 클릭했 을 때의 파람값 : " + rightBtn);
		try {
			if(pageStr == null) {
				pageStr = "0";
			}
			Integer page = Integer.valueOf(pageStr);
			List<ency> list = service.getEncyDocuments(page);
			json = objToJson(list);
			
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		
		
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Content-Type", "application/json;charset=utf-8");
		resp.getWriter().println(json);
	}
	
	private String objToJson(Object o) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(o);
		return json;
	}
	public static void main(String[] args) {
		encyServlet aa = new encyServlet();
	}

}
