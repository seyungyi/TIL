package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({ "/sessiontest1" })
public class SessionTestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int member_v = 0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int local_v = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("data") == null)	// session의 data 속성이 없다면
			session.setAttribute("data", new int[1]);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		member_v += 10;
		local_v += 10;
		int[] data = (int[])session.getAttribute("data");
		data[0] += 10;
		out.print("<ul>");
		out.print("<li>member_v 변수 값 : " + member_v + "</li>");
		out.print("<li>local_v 변수 값 : " + local_v + "</li>");
		out.print("<li>data[0] 변수 값 : " + data[0] + "</li>");
		out.print("<ul>");		
		out.close();
	}

}
