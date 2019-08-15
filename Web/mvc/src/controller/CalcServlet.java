package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcservlet")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("number1"));
		int num2 = Integer.parseInt(request.getParameter("number2"));
		String oper = request.getParameter("oper");
		String url = "/jspexam/calcResult.jsp";
		int result = 0;
		if(oper.equals("+"))
			result = num1 + num2;
		else if(oper.equals("-"))
			result = num1 - num2;
		else if(oper.equals("*"))
			result = num1 * num2;
		else if(oper.equals("/")) {
			if(num2 != 0)
				result = num1 / num2;
			else {
				request.setAttribute("msg", "나눗셈 연산시 두 번째 숫자는 0일 수 없습니다.");
				url = "/jspexam/errorResult.jsp";
			}
		}
		request.setAttribute("result", result);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
