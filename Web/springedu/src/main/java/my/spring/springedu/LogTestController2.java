package my.spring.springedu;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class LogTestController2 {	
	@RequestMapping("/log2")
	public ModelAndView xxx(HttpServletRequest req){
		String loggerName="case5";
		Logger log=LogManager.getLogger(loggerName);
		log.info(req.getRemoteAddr() +"로 부터 요청이 왔어요!");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("logView");
		mav.addObject("msg", "c:/logtest2/myLogA2.log에서 확인하세요!!");
		return mav;
	}
	
}
