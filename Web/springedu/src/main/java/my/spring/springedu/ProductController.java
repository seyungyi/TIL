package my.spring.springedu;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vo.ProductVO;

@Controller
// @SessionAttribute("product")
public class ProductController {
	
	@RequestMapping(value="/product")
	protected ModelAndView handle(String pid, HttpSession s) {		
		if(s.getAttribute("product") == null)
			s.setAttribute("product", new ProductVO());
		
		ModelAndView mav = new ModelAndView();
		ProductVO vo = (ProductVO) s.getAttribute("product");
		
		if(pid.equals("delete")) {
			s.removeAttribute("product");
		} else {
			if (pid.equals("p001")) {
				vo.setBananaNum(1);
			} else if (pid.equals("p002")) {
				vo.setAppleNum(1);
			} else if(pid.equals("p003")) {
				vo.setHanrabongNum(1);
			}
		}
		mav.addObject("product", vo);
		mav.setViewName("productView");
		return mav;
	}
}
