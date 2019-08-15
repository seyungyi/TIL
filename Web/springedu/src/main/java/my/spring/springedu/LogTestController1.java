package my.spring.springedu;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class LogTestController1 {	
	@RequestMapping("/log1")
	public ModelAndView xxx(HttpServletRequest req){
		String loggerName="case4";
		Logger log=LogManager.getLogger(loggerName);
		log.fatal("fatal-로그를 테스트합니다.");
		log.error("error-로그를 테스트합니다.");
		log.warn("warn-로그를 테스트합니다.");
		log.info("info-로그를 테스트합니다.");
		log.debug("debug-로그를 테스트합니다.");
		log.trace("trace-로그를 테스트합니다.");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("logView");
		mav.addObject("msg", "톰캣콘솔창과 c:/logtest1/myLogA1.log에서 확인하세요!!");
		return mav;
	}
	
}




