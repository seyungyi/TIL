package core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.vo.MyDataVO;


@WebServlet("/sharerequest")
public class ShareServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int[] nums = {10, 15, 20, 24, 5};
		request.setAttribute("data1", nums);
		request.setAttribute("data2", "오늘은 수요일!!");
		MyDataVO vo = new MyDataVO();
		vo.setName("듀크");
		vo.setNumber(100);
		vo.setAge(23);
		vo.setAddress("미국");
		request.setAttribute("data3", vo);
		request.getRequestDispatcher("/jspexam/share1.jsp").forward(request, response);
	}
}
