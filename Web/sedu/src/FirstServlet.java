

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet({"/FirstServlet", "/first"})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	// 객체 직렬화 기능과 연관

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = request.getParameter("guest"); // 서블릿은 객체를 받아서 응답을 해야함
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>맛보기 서블릿</h1><hr>");
		out.print("<h3>당신의 이름은 "+name+"이네요...</h3>");
		out.close();	// 출력 스트림을 닫아줘야한다
	}
}
