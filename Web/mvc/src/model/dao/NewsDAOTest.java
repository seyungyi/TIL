package model.dao;

import java.util.List;

import org.junit.Test;

import model.vo.NewsVO;


public class NewsDAOTest {
	@Test
	public void test() {
		NewsDAO jdbcdao = new NewsDAO();
		NewsVO vo = new NewsVO();
		vo.setWritedate("테스트");
		vo.setTitle("테스트");
		vo.setWritedate("sysdate");
		vo.setContent("잘나오고있나요");
		vo.setCnt(0);
		jdbcdao.insert(vo);
		List<NewsVO> list = jdbcdao.listAll();
		for(NewsVO data : list) {
			System.out.println(data);
		}
		NewsVO list2 = jdbcdao.listOne(1);
		System.out.println(list2);
	}

}
