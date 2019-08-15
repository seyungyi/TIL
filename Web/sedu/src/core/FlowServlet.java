package core;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/FlowServlet", "/flow" })
public class FlowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException { 
		System.out.println("init() 메서드 호출");	// 객체생성시 최초 생성됨(메모리에 할당되어 재사용됨)
	}

	public void destroy() {
		System.out.println("destory() 메서드 호출");		
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 메서드 호출");	// 새로고침마다 실행
	}

}
