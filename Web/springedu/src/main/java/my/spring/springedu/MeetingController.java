package my.spring.springedu;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.MeetingMyBatisDAO;
import vo.MeetingVO;
//@Controller
public class MeetingController  {
//	@Autowired
	MeetingMyBatisDAO dao;
	@RequestMapping("/meeting")
	protected ModelAndView select(MeetingVO vo, String keyword, String action) {
		ModelAndView mav = new ModelAndView();
		if (vo.getName() != null && vo.getMeetingDate() != null 
				     && vo.getTitle() != null) {
			if(action != null && action.equals("insert") || action == null) {
				boolean result = dao.insert(vo);
				if(result) {
					mav.addObject("msg", "성공적으로 저장되었어요.");
				} else {
					mav.addObject("msg", "작성을 실패했어요.");
				}				
			} else {
				vo.setId(Integer.parseInt(action));
				boolean result = dao.update(vo);
				if(result) {
					mav.addObject("msg", vo.getId() + "번 글이 수정되었습니다.");
				} else {
					System.out.println(vo.getId());
					mav.addObject("msg", vo.getId() + "번 글이 수정에 실패하였습니다.");
				}
			}
			mav.addObject("list", dao.listAll());				
		}else if (vo.getId() == 0 && keyword == null) {
			List<MeetingVO> list = dao.listAll();
			if(list.size() != 0) {
				mav.addObject("list", list);
			} else {
				mav.addObject("msg", "추출된 미팅 정보가 없습니다.");
			}
		} else if (vo.getId() != 0){
			boolean result = dao.delete(vo.getId());
			if(result) {
				mav.addObject("msg", vo.getId() + "번 글이 삭제되었습니다.");
			} else {
				mav.addObject("msg", vo.getId() + "번 글이 존재하지 않습니다.");
			}
			mav.addObject("list", dao.listAll());
		} else {
			List<MeetingVO> list = dao.search(keyword);
			if(list.size() != 0) {
				mav.addObject("list", list);
			} else {
				mav.addObject("msg", keyword + "로 검색된 미팅 정보가 없습니다.");
			}
		}
		mav.setViewName("meetingView2");
		return mav;    
	}
}
