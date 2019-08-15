package model.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.VisitorVO;

public class VisitorDAO {
	// 구조만 먼저 작성
	public ArrayList<VisitorVO> listAll() {
		ArrayList<VisitorVO> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try(Connection conn = DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select id, name, to_char(writedate, 'yyyy\"년\" mm\"월\" dd\"일\"'), momo from visitor");){
			VisitorVO vo;
			while(rs.next()) {
				vo = new VisitorVO();
				vo.setId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setWriteDate(rs.getString(3));
				vo.setMomo(rs.getString(4));
				list.add(vo);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return list; 
	}
	// 각각의 메소드마다 필요한 기능 작성
	public ArrayList<VisitorVO> search(String keyword) {
		ArrayList<VisitorVO> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try(Connection conn = DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select id, name, "
					+ "to_char(writedate, 'yyyy\"년\" mm\"월\" dd\"일\"'), momo from visitor "
					+ "where momo like '%" + keyword + "%'");){
			VisitorVO vo;
			while(rs.next()) {
				vo = new VisitorVO();
				vo.setId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setWriteDate(rs.getString(3));
				vo.setMomo(rs.getString(4));
				list.add(vo);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public boolean insert(VisitorVO vo) {
		boolean result = true;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try(Connection conn = DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
			PreparedStatement pstmt = conn.prepareStatement(
					"insert into visitor values(?, sysdate, ?, visitor_seq.nextval)");) {
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getMomo());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	public boolean delete(int id) {
		boolean result = true;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try(Connection conn = DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
			PreparedStatement pstmt = conn.prepareStatement(
					"delete from visitor where id = ?");) {
			pstmt.setInt(1, id);
			int deleteNum = pstmt.executeUpdate();
			if(deleteNum != 1)
				result = false;
		} catch(SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
}
