package my.spring.springedu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import vo.CountVO;
@Controller
public class TestModelController2 {
	@ModelAttribute("data1")
	public int createModel1() {	
		System.out.println("createModel() call");
		return 100;
	}
	@ModelAttribute("data2")
	public int createModel2() {	
		System.out.println("createModel() call");
		return 200;
	}
	@RequestMapping(value="/testmodel2")
	public String handle(@ModelAttribute("data1") int vo1, 
			      @ModelAttribute("data2") int vo2) {
		System.out.println("handle() : "+vo1 + " - " + vo2);
		System.out.println("=============================");
		return "testmodel";
	}	
}
