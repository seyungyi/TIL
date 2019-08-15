package controller;
/*
 * Spring MVC Mybatis를 이용한 구현방법 * 
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MeetingMyBatisDAO;
import model.vo.MeetingVO;

@WebServlet("/meeting")
public class MeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		String id = request.getParameter("id");
		String action = request.getParameter("action");
//		System.out.println(action + " " + id + " " + keyword);
		MeetingMyBatisDAO dao = new MeetingMyBatisDAO();
//		MeetingJDBCDAO dao = new MeetingJDBCDAO();
		if(keyword == null) {
//			if(keyword == null && action.equals("delete")) {
			if(action != null) {
				boolean result = dao.delete(Integer.parseInt(id));
				if(result) {
					request.setAttribute("msg",  "글 성공적 삭제");
				} else {
					request.setAttribute("msg", "글 삭제 실패");
				}
			}
			request.setAttribute("list", dao.listAll());
		} else {
			List<MeetingVO> list = dao.search(keyword);
			if(list.size() == 0) {
				request.setAttribute("msg", keyword+"를 입력");
			} else {
				request.setAttribute("list", list);
			}
		}
		request.getRequestDispatcher("/jspexam/meetingView_jstl.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String date = request.getParameter("meetingDate");
		MeetingMyBatisDAO dao = new MeetingMyBatisDAO();
		MeetingVO vo = new MeetingVO();
		vo.setName(name);
		vo.setTitle(title);
		vo.setMeetingDate(date);
		if(action!=null &&action.equals("insert")) {
			boolean result = dao.insert(vo);
			if(result) { 
				request.setAttribute("msg", name+"님의 글이 성공적으로 입력되었습니다.");
			} else {
				request.setAttribute("msg", name+"님의 글이 입력에 실패하였습니다.");
			}			
		} else {
			vo.setId(Integer.parseInt(action));
			boolean result = dao.update(vo);
			if(result) {
				request.setAttribute("msg", name+"님의 글이 성공적으로 수정되었습니다.");
			} else {
				request.setAttribute("msg", name+"님의 글이 수정에 실패하였습니다.");
			}
		}
		request.setAttribute("list", dao.listAll());
		request.getRequestDispatcher("/jspexam/meetingView_jstl.jsp").forward(request, response);
	}
}
