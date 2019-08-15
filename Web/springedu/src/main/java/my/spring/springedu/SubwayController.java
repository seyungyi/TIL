package my.spring.springedu;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.SubwayDAO;
import vo.SubwayVO;
@Controller
public class SubwayController {
	@Autowired
	SubwayDAO dao;
	@RequestMapping("/subwayselect")
	ModelAndView selectData(SubwayVO vo) {
		ModelAndView mav = new ModelAndView();
		List<SubwayVO> list = dao.select(vo); 
		mav.addObject("list", list);
		mav.addObject("msg", "출력에 실패했습니다.");
		mav.setViewName("subwayView");
		return mav;	
	}
}
