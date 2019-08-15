package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.vo.MemberVO;

@WebServlet("/memberservlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String id = request.getParameter("id");
		String passwd = request.getParameter("pwd");
	
		MemberVO vo = new MemberVO();
		if(!name.equals("")) 
			vo.setName(name);
		else {
			name="없음";
			vo.setName(name);
		}
		if(!phone.equals("")) {
			if (phone.length() == 8) 
				phone = phone.replaceFirst("^([0-9]{4})([0-9]{4})$", "$1-$2");
			else if (phone.length() == 12) 
				phone = phone.replaceFirst("(^[0-9]{4})([0-9]{4})([0-9]{4})$", "$1-$2-$3");
			else
				phone = phone.replaceFirst("(^02|[0-9]{3})([0-9]{3,4})([0-9]{4})$", "$1-$2-$3");
			vo.setPhone(phone);
		}
		else
			vo.setPhone("없음");
		if(!id.equals("")) 
			vo.setId(id);
		else
			vo.setId("없음");
		if(!passwd.equals("")) 
			vo.setPwd(passwd);
		else
			vo.setPwd("없음");
		request.setAttribute("data", vo);
		request.getRequestDispatcher("/jspexam/memberView.jsp").forward(request, response);
		
	}
}
