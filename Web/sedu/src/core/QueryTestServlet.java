package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/querytest")
public class QueryTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String pwd = request.getParameter("pwd");
		int age = Integer.parseInt(request.getParameter("age"));
		String gen = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobby");
		String color = request.getParameter("likeColor");
		String[] food = request.getParameterValues("likeFood");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h2>전달된 내용</h2><hr>");
		out.print("<ul><li>이름 : " + name + "</li>");
		out.print("<li>암호 : " + pwd + "</li>");
		out.print("<li>나이 : " + age + "</li>");
		out.print("<li>성별 : " + gen + "</li>");
		out.print("<li>취미 : ");
		if(hobby == null)
			out.print("없음</li>");
		else {
			for(String data : hobby)
				out.print(data + ", ");
			out.print("</li>");
		}		
		
		out.print("<li>좋아하는 색 : ");
		if(color.equals(""))
			out.print("없음</li>");
		else {
			out.print(color + "</li>");
		}
		
		out.print("<li>좋아하는 음식 : ");
		if(food == null)
			out.print("없음</li>");
		else {
			for(String data : food)
				out.print(data + ", ");
			out.print("</li>");
		}
		out.print("<li>의견 : " + request.getParameter("document") + "</li>");
		out.print("<li>비밀1 : " + request.getParameter("hid1") + "</li>");
		out.print("<li>비밀2 : " + request.getParameter("hid2") + "</li></ul>");
		out.print("<hr><a href='/sedu/html/queryForm.html'\">입력화면으로</a>");
		out.close();
	}
}
