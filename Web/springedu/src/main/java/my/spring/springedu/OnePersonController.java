package my.spring.springedu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.OnePersonDAO;
import vo.OnePersonVO;

@Controller
public class OnePersonController {
	@Autowired
	OnePersonDAO dao;
	@RequestMapping("/one")
	ModelAndView selectPerson(String district, String action) {
		ModelAndView mav = new ModelAndView();
		if(action != null) {
			List<OnePersonVO> list = dao.select(district, action);
			if(action.equals("desc")) {
				mav.addObject("list1", list);
			} else if(action.equals("district")) {
				mav.addObject("list2", list);
			} else if(action.equals("alldesc")) {
				mav.addObject("list3", list);							
			} else if(action.equals("max")) {				
				mav.addObject("list4", list);			
			}
		}
		mav.setViewName("OnePersonView");
		return mav;
	}
}
