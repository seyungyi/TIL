package my.spring.springedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vo.MemberVO;

@Controller
public class MemberController {
	@RequestMapping(value="/membercontroller", method=RequestMethod.POST)
	public ModelAndView doPost(MemberVO vo) {	
		ModelAndView mav = new ModelAndView();
		String name = vo.getName();
		String phone = vo.getPhone();
		String id = vo.getId();
		String pwd = vo.getPwd();
		if(name.equals(""))
			vo.setName("없음");
		if(phone.equals("")) {
			vo.setPhone("없음");
		} else {
			if (phone.length() == 8) 
				phone = phone.replaceFirst("^([0-9]{4})([0-9]{4})$", "$1-$2");
			else if (phone.length() == 12) 
				phone = phone.replaceFirst("(^[0-9]{4})([0-9]{4})([0-9]{4})$", "$1-$2-$3");
			else
				phone = phone.replaceFirst("(^02|[0-9]{3})([0-9]{3,4})([0-9]{4})$", "$1-$2-$3");
			vo.setPhone(phone);
		}
		if(id.equals(""))
			vo.setId("없음");
		if(pwd.equals("")) 
			vo.setPwd("없음");
		mav.addObject("member", vo);
		mav.setViewName("memberView");
		return mav;
	}
}
