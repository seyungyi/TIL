package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.NewsVO;
@Repository
public class NewsDAO {
	@Autowired
	SqlSession session = null;	
	public List<NewsVO> listAll(){
		List<NewsVO> list=null;
		String statement = "resource.NewsMapper.selectNews";
		list = session.selectList(statement);
		return list;
	}
	
	public List<NewsVO> search(String search, String searchType){
		List<NewsVO> list=null;
		String statement = null;
		if(searchType.equals("id")) {
			statement = "resource.NewsMapper.searchId";
		} else if(searchType.equals("title")) {
			statement = "resource.NewsMapper.searchTitle";										
		} else if(searchType.equals("writer")) {
			statement = "resource.NewsMapper.searchWriter";													
		} else if(searchType.equals("cnt")){
			statement = "resource.NewsMapper.searchCnt";																
		} else {
			statement = "resource.NewsMapper.searchWriteDate";																			
		}
		list = session.selectList(statement, search);
        return list;
	}
	
	public boolean insert(NewsVO vo) {
		boolean result=true;
		String statement = "resource.NewsMapper.insertNews";
		if(session.insert(statement, vo) != 1)
			result = false;
		return result;
	}
	
	public boolean delete(int id) {
		boolean result=true;
		String statement = "resource.NewsMapper.deleteNews";
		if(session.delete(statement, id) != 1)
			result = false;
		return result;
	}
	public boolean update(NewsVO vo) {
		boolean result=true;
		String statement = "resource.NewsMapper.updateNews";
		if(session.update(statement, vo) != 1)
			result = false;
		return result;	
	}
	public NewsVO listOne(int id) {
		NewsVO vo=null;
		String statement = "resource.NewsMapper.selectNewsOne";
		vo = session.selectOne(statement, id);
		return vo;
	}
	public List<NewsVO> listWriter(String listwriter) {
		List<NewsVO> list=null;
		String statement = "resource.NewsMapper.selectNewsWriter";
		list = session.selectList(statement, listwriter);
		return list;
	}
}
