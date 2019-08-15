package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visitor")
public class VisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		LocalDate currentDate = LocalDate.now();
		int year = currentDate.getYear();
		int month = currentDate.getMonthValue();
		int day = currentDate.getDayOfMonth(); 
		out.print("<h2>" + request.getParameter("name") + " 님이 "+ 
				year + "년 " + month + "월 " + day + "일에 남긴 글입니다.</h2>");
		out.print("<hr>");  
		out.print("<p>" + request.getParameter("opinion") + "</p><br>");
		//out.print("<a href='http://localhost:8000/sedu/html/visitorForm.html'>입력화면으로</a>");
		out.print("<button onclick=\"location.href='/sedu/html/visitorForm.html'\">입력화면으로</button>");
		out.close();
	}
}
