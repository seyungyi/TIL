package core;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lotto1")
public class LottoServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("lottoNum"));
		int checkNum = (int)(Math.random()*6) + 1;
		System.out.println("전달된 값 : " + num + ", 추출된 값 : " + checkNum);
		RequestDispatcher rd = null;
		if(num == checkNum) {
			rd = request.getRequestDispatcher("/jspexam/success.jsp");
		} else {
			rd = request.getRequestDispatcher("/jspexam/fail.jsp");
		}
		rd.forward(request, response);
	}

}
