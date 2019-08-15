package model.dao;

import java.util.List;

import org.junit.Test;

import model.vo.MeetingJDBCDAO;
import model.vo.MeetingVO;

public class MeetingDAOTest {
	@Test
	public void test() {
		MeetingJDBCDAO jdbcdao = new MeetingJDBCDAO();
		MeetingVO vo = new MeetingVO();
		vo.setName("테스트");
		vo.setMeetingDate("19-6-24");
		vo.setTitle("잘나오고있나요");
		jdbcdao.insert(vo);
		List<MeetingVO> list = jdbcdao.listAll();
		for(MeetingVO data : list) {
			System.out.println(data);
		}
		list=jdbcdao.search("오");
		for(MeetingVO data : list) {
			System.out.println(data);
		}
	}
}
