package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/eduservlet")
public class EduServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		double avg = Double.parseDouble(request.getParameter("avgScore"));
		RequestDispatcher url = null;
		if(avg >= 90) {
			url = request.getRequestDispatcher("/jspexam/gradeA.jsp");
		} else if(avg >= 80) {
			url = request.getRequestDispatcher("/jspexam/gradeB.jsp");		
		} else if(avg >= 70) {	
			url = request.getRequestDispatcher("/jspexam/gradeC.jsp");
		} else {
			url = request.getRequestDispatcher("/jspexam/gradeD.jsp");
		}
//		System.out.println(avg); 
//		System.out.println(url);
		url.forward(request, response);
	}
}
