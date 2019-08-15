package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NewsDAO;
import model.vo.NewsVO;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		String key = request.getParameter("search");
		String searchType = request.getParameter("searchType");
		String listwriter = request.getParameter("listwriter");
		NewsDAO dao = new NewsDAO();
		if(action != null) {
			if(id != null && action.equals("delete")) {
				boolean result = dao.delete(Integer.parseInt(id));
				if(result) {
					request.setAttribute("msg", "글 삭제 성공");
				} else {
					request.setAttribute("msg", "글 삭제 실패");				
				}
				request.setAttribute("list", dao.listAll());
			} else if(action.equals("search")) {
					request.setAttribute("list", dao.search(key, searchType));
			} else if(action.equals("listwriter")) {
				request.setAttribute("list", dao.listWriter(listwriter));
			}
		} else {
			if(id != null)
				dao.update(dao.listOne(Integer.parseInt(id)));
			List<NewsVO> list = dao.listAll();
//			if(list.size() == 0)
//				request.setAttribute("msg", id+"값과 일치하는 글이 없음");
//			} else {
				request.setAttribute("list", list);
//			}
		}
		request.getRequestDispatcher("/jspexam/news.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		NewsDAO dao = new NewsDAO();
		NewsVO vo = new NewsVO();
		vo.setWriter(writer);
		vo.setTitle(title);
		vo.setContent(content);
		if(action.equals("insert")) {
			boolean result = dao.insert(vo);
			if(result) {
				request.setAttribute("msg", writer+"님 글 게시등록 성공");
			} else {
				request.setAttribute("msg", writer+"님 글 게시등록 실패");				
			}
		} else {
			vo.setId(Integer.parseInt(action));
			boolean result = dao.update(vo);
			if(result) {
				request.setAttribute("msg", writer+"님 게시글 수정 성공");
			} else {
				request.setAttribute("msg", writer+"님 게시글 수정 실패");				
			}
		}
		request.setAttribute("list", dao.listAll());
		request.getRequestDispatcher("/jspexam/news.jsp").forward(request, response);
	}
}
