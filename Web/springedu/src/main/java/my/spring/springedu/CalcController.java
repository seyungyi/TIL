package my.spring.springedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController {
	@RequestMapping("/calccontroller")
	protected ModelAndView doGet(@RequestParam("number1") int number1, @RequestParam("number2") int number2, 
			@RequestParam("operator") String operator) {
		ModelAndView mav = new ModelAndView();
		if(operator.equals("+"))
			mav.addObject("result", number1 + number2);
		else if(operator.equals("-"))
			mav.addObject("result", number1 - number2);
		else if(operator.equals("*"))
			mav.addObject("result", number1 * number2);
		else if(operator.equals("/")) {
			if(number2 != 0)
				mav.addObject("result", number1 / number2);
			else {
				mav.addObject("msg", "나눗셈 연산시 두 번째 숫자는 0일 수 없습니다.");
				mav.setViewName("errorResult");
				return mav;
			}
		}
		mav.setViewName("calcResult");
		return mav;
	}
}
