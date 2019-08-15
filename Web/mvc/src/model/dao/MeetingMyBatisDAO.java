package model.dao;

import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.vo.MeetingVO;

public class MeetingMyBatisDAO implements MeetingDAO{
	SqlSessionFactory sqlSessionFactory;
	public MeetingMyBatisDAO() {
		try {
			InputStream inputStream = 
				Resources.getResourceAsStream("resource/mybatis-config.xml");
			sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public List<MeetingVO> listAll(){
		List<MeetingVO> list=null;
		SqlSession session = sqlSessionFactory.openSession();	
		String statement = "resource.MeetingMapper.selectMeeting";
		list = session.selectList(statement);
	    session.close();
		return list;
	}
	
	public List<MeetingVO> search(String keyword){
		List<MeetingVO> list=null;
		SqlSession session = sqlSessionFactory.openSession();	
		String statement = "resource.MeetingMapper.searchMeeting";
		list = session.selectList(statement, keyword);
		session.close();
		return list;
	}
	
	public boolean insert(MeetingVO vo) {
		boolean result=true;
		SqlSession session = sqlSessionFactory.openSession(true);	
		String statement = "resource.MeetingMapper.insertMeeting";
		if(session.insert(statement, vo) != 1)
			result = false;
		session.close();
		return result;
	}
	
	public boolean delete(int id) {
		boolean result=true;
		SqlSession session = sqlSessionFactory.openSession(true);	
		String statement = "resource.MeetingMapper.deleteMeeting";
		if(session.delete(statement, id) != 1)
			result = false;
		session.close();
		return result;
	}
	public boolean update(MeetingVO vo) {
		boolean result=true;
		SqlSession session = sqlSessionFactory.openSession(true);	
		String statement = "resource.MeetingMapper.updateMeeting";
		if(session.update(statement, vo) != 1)
			result = false;
		session.close();
		return result;	
	}	
}
