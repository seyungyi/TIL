package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/MyFirstServlet", "/myfirst" })
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		String name = request.getParameter("guest");
		PrintWriter out = response.getWriter();
		out.print("<h2>"+name+" 님 반가워요.. 오늘은 " + week() +"요일입니다!!</h2>");
		out.close();
	}
	static String week() {
		String dateKor=null;
		LocalDate currentDate = LocalDate.now();
		DayOfWeek date = currentDate.getDayOfWeek();
		switch(date) {
		case SUNDAY: dateKor="일"; break;
		case MONDAY: dateKor="월"; break;
		case TUESDAY: dateKor="화"; break;
		case WEDNESDAY: dateKor="수"; break;
		case THURSDAY: dateKor="목"; break;
		case FRIDAY: dateKor="금"; break;
		default : dateKor="토";
		}
		return dateKor;
	}
}
