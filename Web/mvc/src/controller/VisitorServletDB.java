package controller;
/*
 * Spring MVC Mybatis를 이용한 구현방법 * 
 */
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.VisitorMybatisDAO;
import model.vo.VisitorVO;

@WebServlet("/visitor")
public class VisitorServletDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		String id = request.getParameter("id");
		VisitorMybatisDAO dao = new VisitorMybatisDAO();
		if(id != null) {
			boolean result = dao.delete(Integer.parseInt(id));
			if(result) {
				request.setAttribute("msg", "글이 성공적으로 삭제되었어요.");
			} else
				request.setAttribute("msg", "글 입력을 실패했어요!!.");
		} else if(keyword == null) {
			request.setAttribute("list", dao.listAll());
		} else {
			ArrayList<VisitorVO> list = (ArrayList<VisitorVO>) dao.search(keyword);
			if(list.size() == 0) {
				request.setAttribute("msg", keyword+"를 담고있는 글이 없습니다");
			} else {
				request.setAttribute("list", list);
			}
		}
		request.getRequestDispatcher("/jspexam/visitorView_jstl.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String memo = request.getParameter("opinion");
		VisitorMybatisDAO dao = new VisitorMybatisDAO();
		VisitorVO vo = new VisitorVO();
		vo.setName(name);
		vo.setMomo(memo);
		boolean result = dao.insert(vo);
		if(result) {
			request.setAttribute("msg", name+"님의 글이 성공적으로 입력되었습니다.");
		} else {
			request.setAttribute("msg", name+"님의 글이 입력에 실패하였습니다.");
		}
		request.getRequestDispatcher("/jspexam/visitorView_jstl.jsp").forward(request, response);
	}

}
