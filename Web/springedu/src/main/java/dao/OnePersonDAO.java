package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import vo.OnePersonVO;

@Repository
public class OnePersonDAO {
	@Autowired
	@Qualifier("hiveDataSource")
	DataSource ds;

	public List<OnePersonVO> select(String district, String action) {
		List<OnePersonVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			if(action.equals("desc") && district == null) {
				sql = "select * from oneperson order by ophouse desc";
			} else if(action.equals("district")) {
				sql = "select district, sum(ophouse) as ophouse from oneperson group by district";
			} else if(action.equals("alldesc")) {
				sql = "select * from oneperson order by ophouse desc limit 1";
			} else if(action.equals("max")){
				sql = "select district, sum(ophouse) ophouse  from oneperson group by district order by ophouse desc limit 1";
			} else {
				sql = "select * from oneperson where district like '%" + district + "%'";
			}
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			OnePersonVO vo = null;
			while(rs.next()) {
				vo = new OnePersonVO();
				if(action.equals("desc") || action.equals("alldesc")) {
					vo.setDistrict(rs.getString(1));
					vo.setDong(rs.getString(2));
					vo.setOphouse(rs.getInt(3));					
				} else if(action.equals("district") || action.equals("max")) {
					vo.setDistrict(rs.getString(1));
					vo.setOphouse(rs.getInt(2));
				}
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
