package my.spring.springedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EduController {
	
	@RequestMapping(value = "/educontroller", method = RequestMethod.POST)
	public ModelAndView myPost(int avgScore) {
		ModelAndView mav = new ModelAndView();
		if(avgScore >= 90) {
			mav.setViewName("gradeA");
		} else if(avgScore >= 80) {
			mav.setViewName("gradeB");
		} else if(avgScore >= 70) {	
			mav.setViewName("gradeC");
		} else {
			mav.setViewName("gradeD");
		}		
		return mav;
	}
}
