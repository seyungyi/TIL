package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.MeetingVO;
//@Repository
public class MeetingMyBatisDAO implements MeetingDAO{
//	@Autowired
	SqlSession session = null;	
	public List<MeetingVO> listAll(){
		List<MeetingVO> list=null;
		String statement = "resource.MeetingMapper.selectMeeting";
		list = session.selectList(statement);
		return list;
	}
	
	public List<MeetingVO> search(String keyword){
		List<MeetingVO> list=null;
		String statement = "resource.MeetingMapper.searchMeeting";
		list = session.selectList(statement, keyword);
        return list;
	}
	
	public boolean insert(MeetingVO vo) {
		boolean result=true;
		String statement = "resource.MeetingMapper.insertMeeting";
		if(session.insert(statement, vo) != 1)
			result = false;
		return result;
	}
	
	public boolean delete(int id) {
		boolean result=true;
		String statement = "resource.MeetingMapper.deleteMeeting";
		if(session.delete(statement, id) != 1)
			result = false;
		return result;
	}
	public boolean update(MeetingVO vo) {
		boolean result=true;
		String statement = "resource.MeetingMapper.updateMeeting";
		if(session.update(statement, vo) != 1)
			result = false;
		return result;	
	}	
}
