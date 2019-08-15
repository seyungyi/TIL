package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/basket2")
public class BasketServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String productId = request.getParameter("pid");
		if(productId.equals("remove")) {
			session.invalidate();
//			session.removeAttribute("pid");
			out.print("<h2>상품이 모두 삭제되었습니다.</h2>");
			out.print("<a href='/sedu/html/productlog2.html'>상품 선택화면</a>&nbsp;&nbsp;");
			out.close();
		} else {
		int id = Integer.parseInt(productId.substring(2));
		if(session.getAttribute("cnt") == null)
			session.setAttribute("cnt", new int[10]);
		int[] count = (int[])session.getAttribute("cnt");
		
		count[id-1]++;  
		out.print("<h2>선택한 상품 리스트</h2><hr>");
		out.print("<ul>");
		for(int i=0; i<count.length; i++)
			out.print("<li>" + "p0" + (i+1) + " 상품 : "+count[i] + "개</li>");			
		out.print("</ul>");
		out.print("<a href='"+request.getHeader("referer")+"'>상품 선택화면</a>&nbsp;&nbsp;");
		out.print("<a href='/sedu/basket2?pid=remove'>상품비우기</a>");
		out.close();
		}
	}
}
