package core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/basket1")
public class BasketServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		String path = "C:/logtest"; 
		File folder = new File(path);
		if(!folder.exists()) {	 // 폴더가 없을경우
			try {
				folder.mkdir();
			} catch(Exception e) {
				e.printStackTrace();
			} 
		}
		Date today = new Date();	// 시간
		SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmm");	// 시간출력형식
		String text = time.format(today) + " " + pid;	// 텍스트정보
		String txtPath = path + "/mylog.txt";	// 텍스트파일 경로
		File txt = new File(txtPath);			// 텍스트파일 객체
		FileWriter fw = new FileWriter(txt, true);	// 파일 쓰기 객체(덮어쓰기)
		fw.write(text + "\r\n");	// 쓰기
		fw.flush();
		fw.close();
		response.setContentType("application/json; charset=utf-8");	// 응답 형식 text/json도 가능
		PrintWriter out = response.getWriter();
		String ret = "{ \"pid\" : \"" + pid + "\" }";
		out.print(ret);
		out.close();
//		System.out.println(ret); 
	}
}
