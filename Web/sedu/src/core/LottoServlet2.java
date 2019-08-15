package core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.vo.LottoResultVO;

@WebServlet("/lotto2")
public class LottoServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("lottoNum"));
		int checkNum = (int)(Math.random()*6) + 1;
		System.out.println("전달된 값 : " + num + ", 추출된 값 : " + checkNum);
		
		String successMsg = "당첨!!! 추카추카";
		String failMsg = "아쉽아쉽......";
		String successUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3xO917RdxZ1kAOFdm6FaHXhi8idTWLx70GKag8LW-yzWumzuN3A";
		String failUrl = "http://2runzzal.com/media/SFprZ1pyMzJUeWhkcVJ0VG9ZVEdIdz09/thum.jpg";

		LottoResultVO vo = new LottoResultVO();
		if(num == checkNum) {
			vo.setMsg(successMsg);
			vo.setUrl(successUrl);
		} else {
			vo.setMsg(failMsg);
			vo.setUrl(failUrl);
//			vo.setButton("<a href='/sedu/html/lottoForm1.html'>재도전?</a>");
			vo.setButton("<form method='GET' action='/sedu/lotto2'>재도전?<input required type='number' name='lottoNum' min='1' max='6'><input type='image' width='30px' src='/sedu/images/clover.png'>	</form>");
		}
		request.setAttribute("data", vo);
		request.getRequestDispatcher("/jspexam/lottoResult.jsp").forward(request, response);
	}
}
