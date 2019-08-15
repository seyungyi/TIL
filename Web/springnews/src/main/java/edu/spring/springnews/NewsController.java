package edu.spring.springnews;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.NewsDAO;
import vo.NewsVO;

@Controller
public class NewsController {
	@Autowired
	private NewsDAO dao;

	@RequestMapping(value = "/news")
	public ModelAndView newsMain(NewsVO vo, String id, String search,
			String listwriter, String action, String searchType) {
		ModelAndView mav = new ModelAndView();
//		System.out.println(action);
		if (action != null) {
			if (id != null && action.equals("delete")) {
				boolean result = dao.delete(vo.getId());
				if (result) {
					mav.addObject("msg", "삭제완료");
				} else {
					mav.addObject("msg", "삭제실패");
				}
				mav.addObject("list", dao.listAll());
			} else if (action.equals("search")) {
//				System.out.println("search ok? " + search + " " + searchType);
				mav.addObject("list", dao.search(search, searchType));
			} else if (action.equals("listwriter")) {
//				System.out.println("ok? " + listwriter);
				mav.addObject("list", dao.listWriter(listwriter));
			} else if (action.equals("insert")) {
				boolean result = dao.insert(vo);
				if (result) {
					mav.addObject("msg", vo.getWriter() + "입력완료");
				} else {
					mav.addObject("msg", vo.getWriter() + "실패");
				}
				mav.addObject("list", dao.listAll());
			}
			else if(action.equals("select")) {
				NewsVO selectVO = dao.listOne(vo.getId());
				mav.addObject("vo", selectVO);
				if (id != null) {
					dao.update(dao.listOne(Integer.parseInt(id)));
				}
				mav.addObject("list", dao.listAll());
			}
		else {
				vo.setId(Integer.parseInt(action));
				boolean result = dao.update(vo);
				if (result) {
					mav.addObject("msg", "수정 성공");
				} else {
					mav.addObject("msg", "수정 실패");
				}
				mav.addObject("list", dao.listAll());
			}			
		} else {
			if (id != null) {
				dao.update(dao.listOne(Integer.parseInt(id)));
			}
			List<NewsVO> list = dao.listAll();
			if (list.size() == 0) {
				mav.addObject("msg", "뉴스가 엄서요");
			} else {
				mav.addObject("list", list);
			}
			
		}
		mav.setViewName("news");
		return mav;
	}
}
