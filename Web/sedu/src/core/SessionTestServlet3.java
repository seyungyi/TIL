package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({ "/sessiontest3" })
public class SessionTestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		HttpSession session = null;
		String msg = "";
		if(action.equals("create")) {
			session = request.getSession();	// getSession(true)와 같은 의미 
			if(session.isNew())	// session객체의 메소드로 리턴받는 객체가 새로만들어진 객체인가
				msg = "세션 객체가 생성됨";
			else
				msg = "세션 객체는 이미 생성되어 있었음";
		} else if(action.equals("destory")) {
			session = request.getSession(false);	// 만들어지지 않았다면 null 리턴
			if(session != null)	{		// session은 추출만 하지 생성기능은 하지 못함
				session.invalidate();	// 강제로 session 삭제하는 메소드
				msg = "세션 객체가 삭제됨";
			} else
				msg = "삭제할 세션 객체가 없음";
		}
		out.print("<h2>" + msg + "</h2>");
		out.close();
	}
}
