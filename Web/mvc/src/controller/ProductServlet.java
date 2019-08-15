package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.vo.ProductVO;

@WebServlet("/productservlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pid = request.getParameter("pid");
		HttpSession session = request.getSession();
		if (session.getAttribute("cnt") == null) {
			session.setAttribute("cnt", new ProductVO());
		} 
		if(pid == null) {
			session.invalidate();
			request.getRequestDispatcher("/jspexam/clearMsg.jsp").forward(request, response);
		} else {
			ProductVO vo = (ProductVO)session.getAttribute("cnt");
			if(vo == null) {
				vo = new ProductVO();
			} else {
			if (pid.equals("p001"))
				vo.setBananaNum();
			else if (pid.equals("p002"))
				vo.setAppleNum();
			else
				vo.setHanrabongNum();
			}
			request.getRequestDispatcher("/jspexam/productView.jsp").forward(request, response);
		}
	}
}
