package edu.spring.springnews;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.NewsDAO;
import vo.NewsVO;

@Controller
public class NewsController2 {
	@Autowired
	private NewsDAO dao;
	

	@RequestMapping(value = "/news2")
	public ModelAndView newsMain(NewsVO vo, String search, String action, String searchType) {
		ModelAndView mav = new ModelAndView();
		if (action != null) {
			if (action.equals("insert")) {
				boolean result = dao.insert(vo);
				if (result) {
					mav.addObject("msg", "성공적으로 저장되었어요.");
				} else {
					mav.addObject("msg", "작성을 실패했어요.");
				}
				mav.addObject("list", dao.listAll());
			} else if (action.equals("update")) {
				boolean result = dao.update(vo);
				if (result) {
					mav.addObject("msg", vo.getId() + "번 글이 수정되었습니다.");
				} else {
					mav.addObject("msg", vo.getId() + "번 글이 수정에 실패하였습니다.");
				}
				mav.addObject("list", dao.listAll());
			} else if (action.equals("delete")) {
				boolean result = dao.delete(vo.getId());
				if (result) {
					mav.addObject("msg", vo.getId() + "번 글이 삭제되었습니다.");
				} else {
					mav.addObject("msg", vo.getId() + "번 글이 존재하지 않습니다.");
				}
				mav.addObject("list", dao.listAll());
			} else if (action.equals("listwriter")) {
				List<NewsVO> list = dao.listWriter(vo.getWriter());
				mav.addObject("list", list);
			} else if (action.equals("search")) {
				List<NewsVO> list = dao.search(search, searchType);
				if (list.size() != 0) {
					mav.addObject("list", list);
				} else {
					mav.addObject("msg", "검색된 결과가 없습니다");
				}
			} else if(action.equals("select")) {
				NewsVO list = dao.listOne(vo.getId());
				mav.addObject("list", list);
			}
		} else {
			List<NewsVO> list = dao.listAll();
			if (vo.getId() != 0) {
				NewsVO one = dao.listOne(vo.getId());
				mav.addObject("listOne", one);

				list = dao.listAll();
				mav.addObject("list", list);
			}
			mav.addObject("list", list);
		}
		mav.setViewName("news");
		return mav;
	}
}
