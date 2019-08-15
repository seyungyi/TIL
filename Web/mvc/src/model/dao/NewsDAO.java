package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.NewsVO;

public class NewsDAO {
	private Connection connectDB() {
		Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }        
		return conn;
	}
	private void close(Connection conn, Statement stmt, ResultSet rs) {
		try{
			if(stmt != null) {
				stmt.close();
			}
            if(rs != null) {
            	rs.close();
			}
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public boolean insert(NewsVO vo) {
		boolean result = true;
		Connection conn = connectDB();
		try(PreparedStatement pstmt = conn.prepareStatement
			("insert into news values(news_seq.nextval, ?, ?, ?, sysdate, ?)");) {			
			pstmt.setString(1, vo.getWriter());
            pstmt.setString(2, vo.getTitle());
            pstmt.setString(3, vo.getContent());
            pstmt.setInt(4, 0);
            pstmt.executeUpdate();
            close(conn, null, null);
		} catch(SQLException e) {
			result = false;
			e.printStackTrace(); 
		}
		return result;
	}
	public boolean update(NewsVO vo) {
		boolean result = true;
		Connection conn = connectDB();
		try(PreparedStatement pstmt = conn.prepareStatement
			("update news set writer=?, title=?, content=?, writedate=sysdate, cnt=? where id = ?");) {			
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
            pstmt.setInt(4, vo.getCnt()+1);
            pstmt.setInt(5, vo.getId());
			pstmt.executeUpdate();
			close(conn, null, null);
		} catch(SQLException e) {
			result = false;
			e.printStackTrace(); 
		}
		return result;
	}
	public boolean delete(int id) {
		boolean result = true;
		Connection conn = connectDB();
		try(PreparedStatement pstmt = conn.prepareStatement
			("delete from news where id = ?")) {
			pstmt.setInt(1, id);
			int deleteNum = pstmt.executeUpdate();
			if(deleteNum != 1)
				result = false;	
			close(conn, null, null);
		} catch(SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	public List<NewsVO> listAll() {
		Connection conn = connectDB();
		List<NewsVO> list = new ArrayList<>();
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery
			("select id, writer, title, content, to_char(writedate, 'yyyy-MM-dd'), cnt from news");) {
			NewsVO vo;
			while(rs.next()) {
				vo = new NewsVO();
				vo.setId(rs.getInt(1));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setWritedate(rs.getString(5));
				vo.setCnt(rs.getInt(6));
				list.add(vo);
			}
			close(conn, null, null);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public NewsVO listOne(int id) {
		Connection conn = connectDB();
		NewsVO vo=null;
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery
			("select id, writer, title, content, to_char(writedate, 'yyyy-mm-dd'), cnt from news where id="+id);) {
			while(rs.next()) {
				vo = new NewsVO();
				vo.setId(rs.getInt(1));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setWritedate(rs.getString(5));
				vo.setCnt(rs.getInt(6));
			}
			close(conn, null, null);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
	public List<NewsVO> listWriter(String writer) {
		Connection conn = connectDB();
		ArrayList<NewsVO> list = new ArrayList<NewsVO>();
		NewsVO vo;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select id, writer, title, content, to_char(writedate, 'yyyy-mm-dd'), cnt from news where writer like '%"
							+ writer + "%'");
			while (rs.next()) {
				vo = new NewsVO();
				vo.setId(rs.getInt(1));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setWritedate(rs.getString(5));
				vo.setCnt(rs.getInt(6));
				list.add(vo);
			}
			close(conn, stmt, rs);
		} catch (SQLException e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return list;
	}
	public List<NewsVO> search(String key, String searchType) {
		List<NewsVO> list = new ArrayList<>();
		Connection conn = connectDB();
		try(Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery
				("select id, title, writer, to_char(writedate, 'yyyy-mm-dd'), content, cnt from news where "
				+ searchType + " like '%" + key + "%'");) {
			NewsVO vo;
				while(rs.next()) {
					vo = new NewsVO();
					vo.setId(rs.getInt(1));
					vo.setTitle(rs.getString(2));
					vo.setWriter(rs.getString(3));
					vo.setWritedate(rs.getString(4));
					vo.setContent(rs.getString(5));
					vo.setCnt(rs.getInt(6));
					list.add(vo);
				}
				close(conn, stmt, rs);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return list;
	}
}
