package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getpost3")
public class GetPostServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Service는 get과 post를 구분하지 않고 사용한다는 의미. 자주 사용되지는 않음
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		out.print("<h2>요청 방식: " + request.getMethod() + "</h2>");
		out.print("<h2>Query 문자열 : " + request.getParameter("name") + "</h2>");
		out.close();
		System.out.println(request.getMethod() + " 방식 수행");
	}
}
