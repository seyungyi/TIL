package my.spring.springedu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vo.StepVO;

@Controller
public class StepController {		
	@RequestMapping(value="/step",
			 method=RequestMethod.POST)
	public String memberHandle(@ModelAttribute("kkk") StepVO vo) {
		if(vo.getAge() < 18)
			return "redirect:/resources/stepForm.html";
		System.out.println("[ Information for the passed Command object ]");
		System.out.println(vo.getName());
		System.out.println(vo.getPhoneNumber());
		System.out.println(vo.getAge());
		return  "stepOutput";
	}
}
